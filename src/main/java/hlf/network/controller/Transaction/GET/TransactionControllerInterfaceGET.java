package hlf.network.controller.Transaction.GET;

import jakarta.ws.rs.core.Response;

public interface TransactionControllerInterfaceGET {
    public Response getNumberOfTransactions();

    public Response getTransactionsPerMinute(int start, int end);

    public Response getTransactionsPerOrganization();

    public Response getTransactionsList(int page, int size);
}
