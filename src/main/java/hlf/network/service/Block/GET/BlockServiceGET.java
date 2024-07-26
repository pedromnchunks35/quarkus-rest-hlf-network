package hlf.network.service.Block.GET;

import hlf.network.controller.Block.GET.BlockControllerGET;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/block")
public class BlockServiceGET {
    @Inject
    BlockControllerGET blockControllerGET;

    @GET
    @Path("/totalOfBlocks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalOfBlocks() {
        return blockControllerGET.getTotalOfBlocks();
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
    public Response getBlocksTree(@PathParam("page") int page, @PathParam("size") int size) {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("getBlocks/list/{page}/{size}")
    public Response getBlocksList(@PathParam("page") int page, @PathParam("size") int size) {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}
