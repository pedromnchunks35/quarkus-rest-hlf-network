package hlf.network.controller.Transaction.GET;

import java.util.List;

import hlf.network.dto.TransactionByOrgDTO;
import hlf.network.dto.TransactionListDTO;
import hlf.network.repository.TransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TransactionControllerGET implements TransactionControllerInterfaceGET {
    @Inject
    TransactionRepository transactionRepository;

    @Override
    public Response getNumberOfTransactions() {
        Long result = transactionRepository.count();
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
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
        List<TransactionByOrgDTO> transactionByOrgDTO = transactionRepository.getTransactionByOrgPerc();
        return Response.ok(transactionByOrgDTO).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getTransactionsList(int page, int size) {
        if (page < 0 || size < 0) {
            return Response.ok("Please provide a valid page and size").status(Response.Status.BAD_REQUEST).build();
        }
        List<TransactionListDTO> result = transactionRepository.getTransactionList(page, size);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }
}
