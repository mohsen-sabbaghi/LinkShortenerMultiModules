package ir.bki.endpoints;

import ir.bki.dto.LinkDto;
import ir.bki.entities.Links;
import ir.bki.services.LinksServices;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("link")
public class ShortenerEndPoint {
    @Inject
    private LinksServices linksServices;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String maintenance() {
        System.err.println("#linksServices: " + linksServices.sayHello());
        return "CreateEndPoint...";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response creteLink(
            @FormParam("longUrl") String longUrl,
            @FormParam("expired-date") String expiredDate,
            @FormParam("desire_link") String desirelink,
            @Context UriInfo uriInfo) {
        longUrl = longUrl.trim();
        expiredDate = expiredDate.trim();

        if (longUrl.length() > 0 && expiredDate.length() > 0) {
            LinkDto dto = new LinkDto();
            dto.setLongLink(longUrl);
            dto.setExpiresDate(expiredDate);

            Links links;

            if (desirelink.length() > 0) {
                desirelink = desirelink.trim();
                dto.setDesirelink(desirelink);
                links = linksServices.shortUrlAlreadyExist(desirelink);
                if (links != null) {
                    URI shortAddress = URI.create(uriInfo.getBaseUri().getScheme()
                            + "://" +
                            uriInfo.getBaseUri().getAuthority() +
                            "/" + links.getShortLink());
                    links.setShortLink(String.valueOf(shortAddress));
                    return Response.created(shortAddress).entity(links).build();
                }
            }

            links = linksServices.longUrlAlreadyExist(longUrl);

            if (links == null)
                links = linksServices.createLink(dto);

            URI shortAddress = URI.create(uriInfo.getBaseUri().getScheme()
                    + "://" +
                    uriInfo.getBaseUri().getAuthority() +
                    "/" + links.getShortLink());
            links.setShortLink(String.valueOf(shortAddress));
            return Response.created(shortAddress).entity(links).build();

        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }


}