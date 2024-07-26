package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.dto.TransactionByOrgDTO;
import hlf.network.entity.Creator;
import hlf.network.entity.Transaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;

@QuarkusTest
public class TransactionRepositoryTest {
    @Inject
    TransactionRepository transactionRepository;
    @Inject
    UserTransaction userTransaction;
    @Inject
    CreatorRepository creatorRepository;

    @BeforeEach
    public void setup() throws Exception {
        userTransaction.begin();
    }

    @AfterEach
    public void clear() throws Exception {
        userTransaction.rollback();
    }

    @Test
    public void transactionsPerMinute() {
        Double result = transactionRepository.getTransactionsPerMinute(0, 1000);
        assertEquals(result != null, true);
        Transaction transaction = new Transaction();
        transaction.setTxId("daoidnahnidhioahdio");
        transaction.setTimestampTx(10000);
        transactionRepository.persist(transaction);
        Transaction transaction2 = new Transaction();
        transaction2.setTxId("dsidoihsidiosio");
        transaction2.setTimestampTx(12000);
        transactionRepository.persist(transaction2);
        Double result2 = transactionRepository.getTransactionsPerMinute(9000, 22000);
        assertEquals(result2 > 0.0, true);
    }

    @Test
    public void transactionsPerOrgPerc() {
        List<TransactionByOrgDTO> result = transactionRepository.getTransactionByOrgPerc();
        assertEquals(result != null, true);
        assertEquals(result.size(), 0);
        Creator creator = new Creator();
        creator.setId(1);
        creator.setIdBytes(new byte[] { 111, 000, 101, 010 });
        creator.setMspId("orgx");
        creatorRepository.persist(creator);
        Transaction transaction = new Transaction();
        transaction.setTxId("daoidnahnidhioahdio");
        transaction.setTimestampTx(10000);
        transaction.setCreator(creator);
        transactionRepository.persist(transaction);
        result = transactionRepository.getTransactionByOrgPerc();
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getOrgName(), "orgx");
        assertEquals(result.get(0).getPercentage(), 100.0);
    }

}
