package hlf.network.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hlf.network.dto.TransactionByOrgDTO;
import hlf.network.dto.TransactionListDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Chaincode;
import hlf.network.entity.Channel;
import hlf.network.entity.Creator;
import hlf.network.entity.Operation;
import hlf.network.entity.Transaction;
import hlf.network.entity.TypeTransaction;
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
    ChannelRepository channelRepository;
    @Inject
    TypeTransactionRepository typeTransactionRepository;
    @Inject
    ChaincodeRepository chaincodeRepository;
    @Inject
    OperationRepository operationRepository;
    @Inject
    BlockRepository blockRepository;
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
    public void transactionsPerMinuteTest() {
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
    public void transactionsPerOrgPercTest() {
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

    @Test
    public void transactionsListTest() {
        List<TransactionListDTO> result = transactionRepository.getTransactionList(0, 10);
        assertEquals(result.size(), 0);
        // ? Add data
        Creator creator = new Creator();
        creator.setId(1);
        creator.setMspId("orgx");
        creatorRepository.persist(creator);
        Channel channel = new Channel();
        channel.setId(1);
        channel.setChannelName("channel1");
        channelRepository.persist(channel);
        TypeTransaction typeTransaction = new TypeTransaction();
        typeTransaction.setId(1);
        typeTransaction.setDescriptionType("Endorsement");
        typeTransactionRepository.persist(typeTransaction);
        Chaincode chaincode = new Chaincode();
        chaincode.setId(1);
        chaincode.setChaincodeID("basic");
        chaincodeRepository.persist(chaincode);
        Operation operation = new Operation();
        operation.setId(1);
        operation.setChaincode(chaincode);
        operationRepository.persist(operation);
        Block block = new Block();
        block.setBlockNumber(1);
        block.setChannel(channel);
        blockRepository.persist(block);
        Transaction transaction = new Transaction();
        transaction.setBlock(block);
        transaction.setCreator(creator);
        transaction.setOperation(operation);
        transaction.setTxId("daniohdioahdihjop");
        transaction.setTypeTransaction(typeTransaction);
        transaction.setTimestampTx(10000);
        transactionRepository.persist(transaction);
        result = transactionRepository.getTransactionList(0, 10);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getChaincodeName(), chaincode.getChaincodeID());
        assertEquals(result.get(0).getChannelName(), channel.getChannelName());
        assertEquals(result.get(0).getCreator(), creator.getMspId());
        assertEquals(result.get(0).getTimestamp(), transaction.getTimestampTx());
        assertEquals(result.get(0).getTxId(), transaction.getTxId());
        assertEquals(result.get(0).getType(), typeTransaction.getDescriptionType());
    }
}
