package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.dto.BlockListDTO;
import hlf.network.dto.BlockTreeListDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Channel;
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
    @Inject
    ChannelRepository channelRepository;

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
    public void blocksPerMinuteTest() {
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

    @Test
    public void blocksTreeListTest() {
        List<BlockTreeListDTO> blockTreeListDTO = blockRepository.getBlockTreeList(0, 10);
        assertEquals(blockTreeListDTO.size(), 0);

        // ? Create atleast one
        Channel channel = new Channel();
        channel.setChannelName("channel1");
        channel.setId(1);
        channelRepository.persist(channel);

        Block block = new Block();
        block.setBlockNumber(1);
        block.setChannel(channel);
        block.setData(new byte[] { 111, 00, 11, 00 });
        block.setNextHash(new byte[] { 111, 00, 11, 00 });
        block.setPrevHash(new byte[] { 110, 00, 11, 001 });
        blockRepository.persist(block);

        Transaction transaction = new Transaction();
        transaction.setBlock(block);
        transaction.setPayload(new byte[] { 11, 00, 11, 101 });
        transaction.setTimestampTx(1000);
        transaction.setTxId("dinaiojpoiajsopijopia");
        transactionRepository.persist(transaction);

        Transaction transacion2 = new Transaction();
        transacion2.setBlock(block);
        transacion2.setPayload(new byte[] { 11, 111, 00 });
        transacion2.setTimestampTx(3000);
        transacion2.setTxId("askjhaishj");
        transactionRepository.persist(transacion2);

        blockTreeListDTO = blockRepository.getBlockTreeList(0, 10);
        assertEquals(blockTreeListDTO.size(), 1);
        assertEquals(blockTreeListDTO.get(0).getTimestamp(), 1000);
        assertEquals(blockTreeListDTO.get(0).getDataHash()[0], block.getNextHash()[0]);
        assertEquals(blockTreeListDTO.get(0).getBlockNumber(), block.getBlockNumber());
        assertEquals(blockTreeListDTO.get(0).getChannelName(), channel.getChannelName());

        Block block2 = new Block();
        block2.setBlockNumber(2);
        block2.setChannel(channel);
        block2.setData(new byte[] { 110, 00, 11, 00 });
        block2.setNextHash(new byte[] { 011, 00, 11, 00 });
        block2.setPrevHash(new byte[] { 010, 00, 11, 001 });
        blockRepository.persist(block2);

        Transaction transaction2 = new Transaction();
        transaction2.setBlock(block2);
        transaction2.setPayload(new byte[] { 01, 00, 11, 101 });
        transaction2.setTimestampTx(1000);
        transaction2.setTxId("dinaiojpoiajsopijopiasffs");
        transactionRepository.persist(transaction2);

        Transaction transacion3 = new Transaction();
        transacion3.setBlock(block2);
        transacion3.setPayload(new byte[] { 110, 111, 00 });
        transacion3.setTimestampTx(100);
        transacion3.setTxId("askjhaishjfwfdsf");
        transactionRepository.persist(transacion3);

        blockTreeListDTO = blockRepository.getBlockTreeList(0, 10);
        assertEquals(blockTreeListDTO.size(), 2);
        assertEquals(blockTreeListDTO.get(1).getTimestamp(), 100);
        assertEquals(blockTreeListDTO.get(1).getDataHash()[0], block2.getNextHash()[0]);
        assertEquals(blockTreeListDTO.get(1).getBlockNumber(), block2.getBlockNumber());
        assertEquals(blockTreeListDTO.get(1).getChannelName(), channel.getChannelName());
    }

    @Test
    public void blocksListTest() {
        List<BlockListDTO> result = blockRepository.getBlockListDTO(0, 10);
        assertEquals(result.size(), 0);
        // ? Create atleast one
        Channel channel = new Channel();
        channel.setChannelName("channel1");
        channel.setId(1);
        channelRepository.persist(channel);

        Block block = new Block();
        block.setBlockNumber(1);
        block.setChannel(channel);
        block.setData(new byte[] { 111, 00, 11, 00 });
        block.setNextHash(new byte[] { 111, 00, 11, 00 });
        block.setPrevHash(new byte[] { 110, 00, 11, 001 });
        blockRepository.persist(block);

        Transaction transaction2 = new Transaction();
        transaction2.setBlock(block);
        transaction2.setPayload(new byte[] { 01, 00, 11, 101 });
        transaction2.setTimestampTx(1000);
        transaction2.setTxId("dinaiojpoiajsopijopiasffs");
        transactionRepository.persist(transaction2);

        Transaction transacion3 = new Transaction();
        transacion3.setBlock(block);
        transacion3.setPayload(new byte[] { 110, 111, 00 });
        transacion3.setTimestampTx(100);
        transacion3.setTxId("askjhaishjfwfdsf");
        transactionRepository.persist(transacion3);

        result = blockRepository.getBlockListDTO(0, 10);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getBlockHash()[0], block.getNextHash()[0]);
        assertEquals(result.get(0).getChannelName(), block.getChannel().getChannelName());
        assertEquals(result.get(0).getDataHash()[0], block.getData()[0]);
        assertEquals(result.get(0).getNumberOfTransactions(), 2);
        assertEquals(result.get(0).getSize(), block.getData().length);
    }
}
