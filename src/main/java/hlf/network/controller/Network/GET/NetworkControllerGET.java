package hlf.network.controller.Network.GET;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NetworkControllerGET implements NetworkControllerInterfaceGET {

    @Override
    public Response getNetworkComponentsList(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNetworkComponentsList'");
    }

    @Override
    public Response getPeerList(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPeerList'");
    }

    @Override
    public Response getNumberOfNodes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfNodes'");
    }

}
