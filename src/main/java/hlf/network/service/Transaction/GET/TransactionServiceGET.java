package hlf.network.service.Transaction.GET;

import hlf.network.controller.Transaction.GET.TransactionControllerGET;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transaction")
public class TransactionServiceGET {
    @Inject
    TransactionControllerGET transactionControllerGET;

    @GET
    @Path("/numberOfTransactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberOfTransactions() {
        return transactionControllerGET.getNumberOfTransactions();
    }

    @GET
    @Path("/transactionsPerMinute/{start}/{end}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionsPerMinute(@PathParam("start") int start, @PathParam("end") int end) {
        return transactionControllerGET.getTransactionsPerMinute(start, end);
    }

    @GET
    @Path("transactionsPerOrganization")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionsPerOrganization() {
        return transactionControllerGET.getTransactionsPerOrganization();
    }

    @GET
    @Path("{size}/{page}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionsList(@PathParam("page") int page, @PathParam("size") int size) {
        return transactionControllerGET.getTransactionsList(page, size);
    }
}
