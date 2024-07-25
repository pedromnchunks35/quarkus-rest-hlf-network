package hlf.network.service.Transaction.GET;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transaction")
public class TransactionServiceGET {
    @GET
    @Path("/numberOfTransactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberOfTransactions() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/transactionsPerMinute")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionsPerMinute() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("transactionsPerOrganization")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionsPerOrganization() {
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @GET
    public Response getTransactionsList(){
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}
