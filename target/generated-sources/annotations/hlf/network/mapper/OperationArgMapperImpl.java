package hlf.network.mapper;

import hlf.network.dto.BlockDTO;
import hlf.network.dto.ChaincodeDTO;
import hlf.network.dto.ChannelDTO;
import hlf.network.dto.CreatorDTO;
import hlf.network.dto.NetworkDTO;
import hlf.network.dto.OperationArgDTO;
import hlf.network.dto.OperationDTO;
import hlf.network.dto.TransactionDTO;
import hlf.network.dto.TxValidationTypeDTO;
import hlf.network.dto.TypeTransactionDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Chaincode;
import hlf.network.entity.Channel;
import hlf.network.entity.Creator;
import hlf.network.entity.Network;
import hlf.network.entity.Operation;
import hlf.network.entity.OperationArg;
import hlf.network.entity.Transaction;
import hlf.network.entity.TxValidationType;
import hlf.network.entity.TypeTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-25T16:55:09+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class OperationArgMapperImpl implements OperationArgMapper {

    @Override
    public OperationArg toEntity(OperationArgDTO OperationArgDTO) {
        if ( OperationArgDTO == null ) {
            return null;
        }

        OperationArg operationArg = new OperationArg();

        operationArg.setId( OperationArgDTO.getId() );
        operationArg.setOperation( operationDTOToOperation( OperationArgDTO.getOperation() ) );
        operationArg.setArgument( OperationArgDTO.getArgument() );

        return operationArg;
    }

    @Override
    public OperationArgDTO toDto(OperationArg OperationArg) {
        if ( OperationArg == null ) {
            return null;
        }

        OperationArgDTO operationArgDTO = new OperationArgDTO();

        operationArgDTO.setId( OperationArg.getId() );
        operationArgDTO.setOperation( operationToOperationDTO( OperationArg.getOperation() ) );
        operationArgDTO.setArgument( OperationArg.getArgument() );

        return operationArgDTO;
    }

    @Override
    public List<OperationArg> toEntity(List<OperationArgDTO> OperationArgDTOList) {
        if ( OperationArgDTOList == null ) {
            return null;
        }

        List<OperationArg> list = new ArrayList<OperationArg>( OperationArgDTOList.size() );
        for ( OperationArgDTO operationArgDTO : OperationArgDTOList ) {
            list.add( toEntity( operationArgDTO ) );
        }

        return list;
    }

    @Override
    public List<OperationArgDTO> toDto(List<OperationArg> OperationArgList) {
        if ( OperationArgList == null ) {
            return null;
        }

        List<OperationArgDTO> list = new ArrayList<OperationArgDTO>( OperationArgList.size() );
        for ( OperationArg operationArg : OperationArgList ) {
            list.add( toDto( operationArg ) );
        }

        return list;
    }

    protected Chaincode chaincodeDTOToChaincode(ChaincodeDTO chaincodeDTO) {
        if ( chaincodeDTO == null ) {
            return null;
        }

        Chaincode chaincode = new Chaincode();

        chaincode.setId( chaincodeDTO.getId() );
        chaincode.setChaincodeID( chaincodeDTO.getChaincodeID() );

        return chaincode;
    }

    protected List<Block> blockDTOListToBlockList(List<BlockDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Block> list1 = new ArrayList<Block>( list.size() );
        for ( BlockDTO blockDTO : list ) {
            list1.add( blockDTOToBlock( blockDTO ) );
        }

        return list1;
    }

    protected Channel channelDTOToChannel(ChannelDTO channelDTO) {
        if ( channelDTO == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( channelDTO.getId() );
        channel.setChannelName( channelDTO.getChannelName() );
        channel.setBlocks( blockDTOListToBlockList( channelDTO.getBlocks() ) );

        return channel;
    }

    protected Network networkDTOToNetwork(NetworkDTO networkDTO) {
        if ( networkDTO == null ) {
            return null;
        }

        Network network = new Network();

        network.setId( networkDTO.getId() );
        network.setIp( networkDTO.getIp() );
        network.setBlocks( blockDTOListToBlockList( networkDTO.getBlocks() ) );

        return network;
    }

    protected List<Transaction> transactionDTOListToTransactionList(List<TransactionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Transaction> list1 = new ArrayList<Transaction>( list.size() );
        for ( TransactionDTO transactionDTO : list ) {
            list1.add( transactionDTOToTransaction( transactionDTO ) );
        }

        return list1;
    }

    protected Block blockDTOToBlock(BlockDTO blockDTO) {
        if ( blockDTO == null ) {
            return null;
        }

        Block block = new Block();

        block.setBlockNumber( blockDTO.getBlockNumber() );
        block.setChannel( channelDTOToChannel( blockDTO.getChannel() ) );
        block.setNetwork( networkDTOToNetwork( blockDTO.getNetwork() ) );
        byte[] prevHash = blockDTO.getPrevHash();
        if ( prevHash != null ) {
            block.setPrevHash( Arrays.copyOf( prevHash, prevHash.length ) );
        }
        byte[] nextHash = blockDTO.getNextHash();
        if ( nextHash != null ) {
            block.setNextHash( Arrays.copyOf( nextHash, nextHash.length ) );
        }
        byte[] data = blockDTO.getData();
        if ( data != null ) {
            block.setData( Arrays.copyOf( data, data.length ) );
        }
        block.setTransactions( transactionDTOListToTransactionList( blockDTO.getTransactions() ) );

        return block;
    }

    protected TypeTransaction typeTransactionDTOToTypeTransaction(TypeTransactionDTO typeTransactionDTO) {
        if ( typeTransactionDTO == null ) {
            return null;
        }

        TypeTransaction typeTransaction = new TypeTransaction();

        typeTransaction.setId( typeTransactionDTO.getId() );
        typeTransaction.setDescriptionType( typeTransactionDTO.getDescriptionType() );
        typeTransaction.setTransactions( transactionDTOListToTransactionList( typeTransactionDTO.getTransactions() ) );

        return typeTransaction;
    }

    protected TxValidationType txValidationTypeDTOToTxValidationType(TxValidationTypeDTO txValidationTypeDTO) {
        if ( txValidationTypeDTO == null ) {
            return null;
        }

        TxValidationType txValidationType = new TxValidationType();

        txValidationType.setId( txValidationTypeDTO.getId() );
        txValidationType.setDescriptionType( txValidationTypeDTO.getDescriptionType() );
        txValidationType.setTransactions( transactionDTOListToTransactionList( txValidationTypeDTO.getTransactions() ) );

        return txValidationType;
    }

    protected Creator creatorDTOToCreator(CreatorDTO creatorDTO) {
        if ( creatorDTO == null ) {
            return null;
        }

        Creator creator = new Creator();

        creator.setId( creatorDTO.getId() );
        creator.setMspId( creatorDTO.getMspId() );
        byte[] idBytes = creatorDTO.getIdBytes();
        if ( idBytes != null ) {
            creator.setIdBytes( Arrays.copyOf( idBytes, idBytes.length ) );
        }
        creator.setTransactions( transactionDTOListToTransactionList( creatorDTO.getTransactions() ) );

        return creator;
    }

    protected Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setTxId( transactionDTO.getTxId() );
        transaction.setBlock( blockDTOToBlock( transactionDTO.getBlock() ) );
        transaction.setTimestampTx( transactionDTO.getTimestampTx() );
        transaction.setTypeTransaction( typeTransactionDTOToTypeTransaction( transactionDTO.getTypeTransaction() ) );
        transaction.setTxValidationType( txValidationTypeDTOToTxValidationType( transactionDTO.getTxValidationType() ) );
        transaction.setCreator( creatorDTOToCreator( transactionDTO.getCreator() ) );
        transaction.setOperation( operationDTOToOperation( transactionDTO.getOperation() ) );
        byte[] payload = transactionDTO.getPayload();
        if ( payload != null ) {
            transaction.setPayload( Arrays.copyOf( payload, payload.length ) );
        }

        return transaction;
    }

    protected Operation operationDTOToOperation(OperationDTO operationDTO) {
        if ( operationDTO == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( operationDTO.getId() );
        operation.setChaincode( chaincodeDTOToChaincode( operationDTO.getChaincode() ) );
        operation.setChaincodeType( operationDTO.getChaincodeType() );
        operation.setOperationArgs( toEntity( operationDTO.getOperationArgs() ) );
        operation.setTransactions( transactionDTOListToTransactionList( operationDTO.getTransactions() ) );

        return operation;
    }

    protected ChaincodeDTO chaincodeToChaincodeDTO(Chaincode chaincode) {
        if ( chaincode == null ) {
            return null;
        }

        ChaincodeDTO chaincodeDTO = new ChaincodeDTO();

        chaincodeDTO.setId( chaincode.getId() );
        chaincodeDTO.setChaincodeID( chaincode.getChaincodeID() );

        return chaincodeDTO;
    }

    protected List<BlockDTO> blockListToBlockDTOList(List<Block> list) {
        if ( list == null ) {
            return null;
        }

        List<BlockDTO> list1 = new ArrayList<BlockDTO>( list.size() );
        for ( Block block : list ) {
            list1.add( blockToBlockDTO( block ) );
        }

        return list1;
    }

    protected ChannelDTO channelToChannelDTO(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDTO channelDTO = new ChannelDTO();

        channelDTO.setId( channel.getId() );
        channelDTO.setChannelName( channel.getChannelName() );
        channelDTO.setBlocks( blockListToBlockDTOList( channel.getBlocks() ) );

        return channelDTO;
    }

    protected NetworkDTO networkToNetworkDTO(Network network) {
        if ( network == null ) {
            return null;
        }

        NetworkDTO networkDTO = new NetworkDTO();

        networkDTO.setId( network.getId() );
        networkDTO.setIp( network.getIp() );
        networkDTO.setBlocks( blockListToBlockDTOList( network.getBlocks() ) );

        return networkDTO;
    }

    protected List<TransactionDTO> transactionListToTransactionDTOList(List<Transaction> list) {
        if ( list == null ) {
            return null;
        }

        List<TransactionDTO> list1 = new ArrayList<TransactionDTO>( list.size() );
        for ( Transaction transaction : list ) {
            list1.add( transactionToTransactionDTO( transaction ) );
        }

        return list1;
    }

    protected BlockDTO blockToBlockDTO(Block block) {
        if ( block == null ) {
            return null;
        }

        BlockDTO blockDTO = new BlockDTO();

        blockDTO.setBlockNumber( block.getBlockNumber() );
        blockDTO.setChannel( channelToChannelDTO( block.getChannel() ) );
        blockDTO.setNetwork( networkToNetworkDTO( block.getNetwork() ) );
        byte[] prevHash = block.getPrevHash();
        if ( prevHash != null ) {
            blockDTO.setPrevHash( Arrays.copyOf( prevHash, prevHash.length ) );
        }
        byte[] nextHash = block.getNextHash();
        if ( nextHash != null ) {
            blockDTO.setNextHash( Arrays.copyOf( nextHash, nextHash.length ) );
        }
        byte[] data = block.getData();
        if ( data != null ) {
            blockDTO.setData( Arrays.copyOf( data, data.length ) );
        }
        blockDTO.setTransactions( transactionListToTransactionDTOList( block.getTransactions() ) );

        return blockDTO;
    }

    protected TypeTransactionDTO typeTransactionToTypeTransactionDTO(TypeTransaction typeTransaction) {
        if ( typeTransaction == null ) {
            return null;
        }

        TypeTransactionDTO typeTransactionDTO = new TypeTransactionDTO();

        typeTransactionDTO.setId( typeTransaction.getId() );
        typeTransactionDTO.setDescriptionType( typeTransaction.getDescriptionType() );
        typeTransactionDTO.setTransactions( transactionListToTransactionDTOList( typeTransaction.getTransactions() ) );

        return typeTransactionDTO;
    }

    protected TxValidationTypeDTO txValidationTypeToTxValidationTypeDTO(TxValidationType txValidationType) {
        if ( txValidationType == null ) {
            return null;
        }

        TxValidationTypeDTO txValidationTypeDTO = new TxValidationTypeDTO();

        txValidationTypeDTO.setId( txValidationType.getId() );
        txValidationTypeDTO.setDescriptionType( txValidationType.getDescriptionType() );
        txValidationTypeDTO.setTransactions( transactionListToTransactionDTOList( txValidationType.getTransactions() ) );

        return txValidationTypeDTO;
    }

    protected CreatorDTO creatorToCreatorDTO(Creator creator) {
        if ( creator == null ) {
            return null;
        }

        CreatorDTO creatorDTO = new CreatorDTO();

        creatorDTO.setId( creator.getId() );
        creatorDTO.setMspId( creator.getMspId() );
        byte[] idBytes = creator.getIdBytes();
        if ( idBytes != null ) {
            creatorDTO.setIdBytes( Arrays.copyOf( idBytes, idBytes.length ) );
        }
        creatorDTO.setTransactions( transactionListToTransactionDTOList( creator.getTransactions() ) );

        return creatorDTO;
    }

    protected TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setTxId( transaction.getTxId() );
        transactionDTO.setBlock( blockToBlockDTO( transaction.getBlock() ) );
        transactionDTO.setTimestampTx( transaction.getTimestampTx() );
        transactionDTO.setTypeTransaction( typeTransactionToTypeTransactionDTO( transaction.getTypeTransaction() ) );
        transactionDTO.setTxValidationType( txValidationTypeToTxValidationTypeDTO( transaction.getTxValidationType() ) );
        transactionDTO.setCreator( creatorToCreatorDTO( transaction.getCreator() ) );
        transactionDTO.setOperation( operationToOperationDTO( transaction.getOperation() ) );
        byte[] payload = transaction.getPayload();
        if ( payload != null ) {
            transactionDTO.setPayload( Arrays.copyOf( payload, payload.length ) );
        }

        return transactionDTO;
    }

    protected OperationDTO operationToOperationDTO(Operation operation) {
        if ( operation == null ) {
            return null;
        }

        OperationDTO operationDTO = new OperationDTO();

        operationDTO.setId( operation.getId() );
        operationDTO.setChaincode( chaincodeToChaincodeDTO( operation.getChaincode() ) );
        operationDTO.setChaincodeType( operation.getChaincodeType() );
        operationDTO.setTransactions( transactionListToTransactionDTOList( operation.getTransactions() ) );
        operationDTO.setOperationArgs( toDto( operation.getOperationArgs() ) );

        return operationDTO;
    }
}