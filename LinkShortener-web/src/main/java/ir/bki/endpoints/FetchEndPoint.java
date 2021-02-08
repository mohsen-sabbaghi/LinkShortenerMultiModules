package ir.bki.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/{url}")
public class FetchEndPoint {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response fetchUrl(@PathParam("url") String url) {
        System.err.println("##URL: "+url);
        return Response.ok("URL: " + url).build();
    }
}
