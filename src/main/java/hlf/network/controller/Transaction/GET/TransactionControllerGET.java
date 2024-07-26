package hlf.network.controller.Transaction.GET;

import hlf.network.repository.TransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TransactionControllerGET implements TransactionControllerInterfaceGET {
    @Inject
    TransactionRepository transactionRepository;

    public Response getNumberOfTransactionsController() {
        Long result = transactionRepository.count();
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getNumberOfTransactions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfTransactions'");
    }

    @Override
    public Response getTransactionsPerMinute(int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return Response.ok("Please provide a valid start and end").status(Response.Status.BAD_REQUEST).build();
        }
        Double result = transactionRepository.getTransactionsPerMinute(start, end);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getTransactionsPerOrganization() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactionsPerOrganization'");
    }

    @Override
    public Response getTransactionsList(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactionsList'");
    }
}
