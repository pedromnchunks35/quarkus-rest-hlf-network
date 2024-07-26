package hlf.network.controller.Chaincode.GET;

import hlf.network.repository.ChaincodeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
@ApplicationScoped
public class ChaincodeControllerGET implements ChaincodeControllerInterfaceGET {
    @Inject
    ChaincodeRepository chaincodeRepository;

    public Response numberOfChaincodes() {
        Long result = chaincodeRepository.count();
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getChaincodesList(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChaincodesList'");
    }
}
