package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.dto.ChaincodeListDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Chaincode;
import hlf.network.entity.Channel;
import hlf.network.entity.Operation;
import hlf.network.entity.Transaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;

@QuarkusTest
public class ChaincodeRepositoryTest {
    @Inject
    UserTransaction userTransaction;
    @Inject
    ChaincodeRepository chaincodeRepository;
    @Inject
    ChannelRepository channelRepository;
    @Inject
    BlockRepository blockRepository;
    @Inject
    TransactionRepository transactionRepository;
    @Inject
    OperationRepository operationRepository;

    @BeforeEach
    public void setup() throws Exception {
        userTransaction.begin();
    }

    @AfterEach
    public void clear() throws Exception {
        userTransaction.rollback();
    }

    @Test
    public void getChaincodeListTest() {
        List<ChaincodeListDTO> result = chaincodeRepository.getChaincodeList(0, 10);
        assertEquals(result.size(), 0);
        Chaincode chaincode = new Chaincode();
        chaincode.setId(1);
        chaincode.setChaincodeID("basic");
        chaincodeRepository.persist(chaincode);
        Channel channel = new Channel();
        channel.setChannelName("channel1");
        channel.setId(1);
        channelRepository.persist(channel);
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
        transaction.setTxId("anbsoahoisjhapiojh");
        transactionRepository.persist(transaction);
        result = chaincodeRepository.getChaincodeList(0, 10);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getChaincodeName(), chaincode.getChaincodeID());
        assertEquals(result.get(0).getChannelName(), channel.getChannelName());
        assertEquals(result.get(0).getNumberOfTransactions(), 1);
        assertEquals(result.get(0).getVersion(), null);
    }
}
