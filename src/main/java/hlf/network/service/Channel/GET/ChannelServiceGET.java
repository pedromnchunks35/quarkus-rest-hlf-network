package hlf.network.service.Channel.GET;

import hlf.network.controller.Channel.GET.ChannelControllerGET;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/channel")
public class ChannelServiceGET {
    @Inject
    ChannelControllerGET channelControllerGET;

    @GET
    @Path("/{page}/{size}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChannelsList(int page, int size) {
        return channelControllerGET.getChannelsList(page, size);
    }
}
