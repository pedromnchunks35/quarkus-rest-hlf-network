package hlf.network.service.Chaincode.GET;

import hlf.network.controller.Chaincode.GET.ChaincodeControllerGET;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Chaincode")
public class ChaincodeServiceGET {
    @Inject
    ChaincodeControllerGET chaincodeControllerGET;

    @GET
    @Path("/numberOfChaincodes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response numberOfChaincodes() {
        return chaincodeControllerGET.numberOfChaincodes();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChaincodesList(@PathParam("page") int page, @PathParam("size") int size) {
        return chaincodeControllerGET.getChaincodesList(page, size);
    }
}
