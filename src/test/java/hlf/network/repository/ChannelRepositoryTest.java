package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.dto.ChannelListDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Chaincode;
import hlf.network.entity.Channel;
import hlf.network.entity.Operation;
import hlf.network.entity.Transaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;

@QuarkusTest
public class ChannelRepositoryTest {
    @Inject
    ChannelRepository channelRepository;
    @Inject
    UserTransaction userTransaction;
    @Inject
    ChaincodeRepository chaincodeRepository;
    @Inject
    BlockRepository blockRepository;
    @Inject
    OperationRepository operationRepository;
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
    public void getChannelListTest() {
        List<ChannelListDTO> result = channelRepository.getChannelList(0, 10);
        assertEquals(result.size(), 0);
        Channel channel = new Channel();
        channel.setId(1);
        channel.setChannelName("channel1");
        channelRepository.persist(channel);
        Chaincode chaincode = new Chaincode();
        chaincode.setChaincodeID("basic");
        chaincode.setId(1);
        chaincodeRepository.persist(chaincode);
        Block block = new Block();
        block.setBlockNumber(1);
        block.setChannel(channel);
        blockRepository.persist(block);
        Operation operation = new Operation();
        operation.setChaincode(chaincode);
        operation.setId(1);
        operationRepository.persist(operation);
        Transaction transaction = new Transaction();
        transaction.setBlock(block);
        transaction.setOperation(operation);
        transaction.setTimestampTx(10000);
        transaction.setTxId("dnoiajhodjdoipa");
        transactionRepository.persist(transaction);
        result = channelRepository.getChannelList(0, 10);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getChaincodeName(), chaincode.getChaincodeID());
        assertEquals(result.get(0).getChannel(), channel.getChannelName());
        assertEquals(result.get(0).getNumberOfTransactions(), 1);
        assertEquals(result.get(0).getTimestamp(), 10000);
    }
}
