package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.entity.Block;
import hlf.network.entity.Transaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;

@QuarkusTest
public class BlockRepositoryTest {
    @Inject
    BlockRepository blockRepository;
    @Inject
    UserTransaction userTransaction;
    @Inject
    TransactionRepository transactionRepository;

    @BeforeEach
    public void setup() throws Exception {
        userTransaction.begin();
    }

    @AfterEach
    public void clear() throws Exception {
        userTransaction.rollback();
    }

    @Test
    public void countBlocksTest() {
        Long result = blockRepository.count();
        assertEquals(result != null, true);
        Block block = new Block();
        block.setBlockNumber(10000);
        block.setData(new byte[] { 111, 00, 11, 010, 111, 111, 111 });
        block.setNextHash(new byte[] { 111, 010, 011, 10, 111, 111 });
        block.setPrevHash(new byte[] { 111, 010, 111, 10, 111, 111 });
        blockRepository.persist(block);
        Long result2 = blockRepository.count();
        assertEquals(result2, result + 1);
    }

    @Test
    public void blocksPerMinute() {
        Double result = blockRepository.getBlocksPerMinute(1000, 1200);
        assertEquals(result != null, true);

        // ? Trying to insert a block
        Block block = new Block();
        block.setBlockNumber(10000);
        block.setData(new byte[] { 111, 00, 11, 010, 111, 111, 111 });
        block.setNextHash(new byte[] { 111, 010, 011, 10, 111, 111 });
        block.setPrevHash(new byte[] { 111, 010, 111, 10, 111, 111 });
        blockRepository.persist(block);
        Transaction transaction = new Transaction();
        transaction.setTxId("daoidnahnidhioahdio");
        transaction.setBlock(block);
        transaction.setTimestampTx(10000);
        transactionRepository.persist(transaction);
        // ? Inserting another different block
        Block block2 = new Block();
        block2.setBlockNumber(20000);
        block2.setData(new byte[] { 111, 00, 11, 010, 111, 111, 111, 11 });
        block2.setNextHash(new byte[] { 111, 010, 011, 10, 111, 111, 11, });
        block2.setPrevHash(new byte[] { 111, 010, 111, 10, 111, 111, 11 });
        blockRepository.persist(block2);
        Transaction transaction2 = new Transaction();
        transaction2.setTxId("dsidoihsidiosio");
        transaction2.setBlock(block2);
        transaction2.setTimestampTx(12000);
        transactionRepository.persist(transaction2);

        Double result2 = blockRepository.getBlocksPerMinute(10000, 21000);
        assertEquals(result2 != null, true);
        assertEquals(result2 > 0.0, true);
    }
}
