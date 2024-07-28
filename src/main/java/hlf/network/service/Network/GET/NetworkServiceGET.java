package hlf.network.service.Network.GET;

import hlf.network.controller.Network.GET.NetworkControllerGET;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/network")
public class NetworkServiceGET {
    @Inject
    NetworkControllerGET networkControllerGET;

    @GET
    @Path("/{page}/{size}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNetworkComponentsList(@PathParam("page") int page, @PathParam("size") int size) {
        return networkControllerGET.getNetworkComponentsList(page, size);
    }

    @GET
    @Path("peerComps/{page}/{size}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeerList(@PathParam("page") int page, @PathParam("size") int size) {
        return networkControllerGET.getPeerList(page, size);
    }

    @GET
    @Path("/nodes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNodesNumber() {
        return networkControllerGET.getNumberOfNodes();
    }
}
