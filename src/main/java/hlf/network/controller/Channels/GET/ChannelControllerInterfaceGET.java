package hlf.network.controller.Channels.GET;

import jakarta.ws.rs.core.Response;

public interface ChannelControllerInterfaceGET {
    public Response getChannelsList(int page, int size);
}
