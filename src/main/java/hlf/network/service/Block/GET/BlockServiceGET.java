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
    @Path("/blocksPerMinute/{start}/{end}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocksPerMinute(@PathParam("start") int start, @PathParam("end") int end) {
        return blockControllerGET.getBlocksPerMinute(start, end);
    }

    @GET
    @Path("getBlocks/tree/{page}/{size}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocksTree(@PathParam("page") int page, @PathParam("size") int size) {
        return blockControllerGET.getBlocksTree(page, size);
    }

    @GET
    @Path("getBlocks/list/{page}/{size}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocksList(@PathParam("page") int page, @PathParam("size") int size) {
        return blockControllerGET.getBlocksList(page, size);
    }
}
