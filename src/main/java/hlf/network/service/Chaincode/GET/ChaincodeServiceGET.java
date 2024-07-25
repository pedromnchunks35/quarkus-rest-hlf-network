package hlf.network.service.Chaincode.GET;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Chaincode")
public class ChaincodeServiceGET {
    @GET
    @Path("/numberOfChaincodes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response numberOfChaincodes() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChaincodesList(){
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}
