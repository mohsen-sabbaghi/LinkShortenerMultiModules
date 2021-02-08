package ir.bki.endpoints;

import ir.bki.entities.Links;
import ir.bki.services.LinksServices;
import ir.bki.util.BaseConversion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/{url}")
public class FetchEndPoint {

    @Inject
    private LinksServices linksServices;
    @Inject
    private BaseConversion baseConversion;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response fetchUrl(@PathParam("url") String url) {
        Links linksToRedirect = linksServices.retrieveOne(baseConversion.decode(url));
        if (linksToRedirect == null) {
            linksToRedirect = linksServices.shortUrlAlreadyExist(url);
        }
        if (linksToRedirect == null) {

            return Response.status(404).entity("URL Not Found").build();
        }
        return Response.seeOther(URI.create(linksToRedirect.getRedirectLink())).build();
    }
}
