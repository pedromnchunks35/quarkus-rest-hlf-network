package hlf.network.service.Block.GET;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/block")
public class BlockServiceGET {
    @GET
    @Path("/totalOfBlocks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalOfBlocks() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/blocksPerMinute")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocksPerMinute() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("getBlocks/tree/{page}/{size}")
    public Response getBlocksTree() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("getBlocks/list/{page}/{size}")
    public Response getBlocksList() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}
