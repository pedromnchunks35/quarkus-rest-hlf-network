package hlf.network.controller.Chaincode.GET;

import java.util.List;

import hlf.network.dto.ChaincodeListDTO;
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
        if (page < 0 || size < 0) {
            return Response.ok("Please provide a valid page and size").status(Response.Status.BAD_REQUEST).build();
        }
        List<ChaincodeListDTO> result = chaincodeRepository.getChaincodeList(page, size);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }
}
