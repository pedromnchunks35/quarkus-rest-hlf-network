package hlf.network.controller.Network.GET;

import jakarta.ws.rs.core.Response;

public interface NetworkControllerInterfaceGET {
    public Response getNetworkComponentsList(int page, int size);

    public Response getPeerList(int page, int size);

    public Response getNumberOfNodes();
}
