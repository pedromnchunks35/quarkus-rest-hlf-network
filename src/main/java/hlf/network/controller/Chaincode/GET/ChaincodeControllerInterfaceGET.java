package hlf.network.controller.Chaincode.GET;

import jakarta.ws.rs.core.Response;

public interface ChaincodeControllerInterfaceGET {
    public Response numberOfChaincodes();

    public Response getChaincodesList(int page, int size);
}
