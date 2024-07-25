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
    date = "2024-07-25T15:49:21+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class BlockMapperImpl implements BlockMapper {

    @Override
    public Block toEntity(BlockDTO blockDTO) {
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

    @Override
    public BlockDTO toDto(Block block) {
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

    @Override
    public List<Block> toEntity(List<BlockDTO> blockDTOList) {
        if ( blockDTOList == null ) {
            return null;
        }

        List<Block> list = new ArrayList<Block>( blockDTOList.size() );
        for ( BlockDTO blockDTO : blockDTOList ) {
            list.add( toEntity( blockDTO ) );
        }

        return list;
    }

    @Override
    public List<BlockDTO> toDto(List<Block> blockList) {
        if ( blockList == null ) {
            return null;
        }

        List<BlockDTO> list = new ArrayList<BlockDTO>( blockList.size() );
        for ( Block block : blockList ) {
            list.add( toDto( block ) );
        }

        return list;
    }

    protected Channel channelDTOToChannel(ChannelDTO channelDTO) {
        if ( channelDTO == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( channelDTO.getId() );
        channel.setChannelName( channelDTO.getChannelName() );
        channel.setBlocks( toEntity( channelDTO.getBlocks() ) );

        return channel;
    }

    protected Network networkDTOToNetwork(NetworkDTO networkDTO) {
        if ( networkDTO == null ) {
            return null;
        }

        Network network = new Network();

        network.setId( networkDTO.getId() );
        network.setIp( networkDTO.getIp() );
        network.setBlocks( toEntity( networkDTO.getBlocks() ) );

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

    protected Chaincode chaincodeDTOToChaincode(ChaincodeDTO chaincodeDTO) {
        if ( chaincodeDTO == null ) {
            return null;
        }

        Chaincode chaincode = new Chaincode();

        chaincode.setId( chaincodeDTO.getId() );
        chaincode.setChaincodeID( chaincodeDTO.getChaincodeID() );

        return chaincode;
    }

    protected OperationArg operationArgDTOToOperationArg(OperationArgDTO operationArgDTO) {
        if ( operationArgDTO == null ) {
            return null;
        }

        OperationArg operationArg = new OperationArg();

        operationArg.setId( operationArgDTO.getId() );
        operationArg.setOperation( operationDTOToOperation( operationArgDTO.getOperation() ) );
        operationArg.setArgument( operationArgDTO.getArgument() );

        return operationArg;
    }

    protected List<OperationArg> operationArgDTOListToOperationArgList(List<OperationArgDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OperationArg> list1 = new ArrayList<OperationArg>( list.size() );
        for ( OperationArgDTO operationArgDTO : list ) {
            list1.add( operationArgDTOToOperationArg( operationArgDTO ) );
        }

        return list1;
    }

    protected Operation operationDTOToOperation(OperationDTO operationDTO) {
        if ( operationDTO == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( operationDTO.getId() );
        operation.setChaincode( chaincodeDTOToChaincode( operationDTO.getChaincode() ) );
        operation.setChaincodeType( operationDTO.getChaincodeType() );
        operation.setOperationArgs( operationArgDTOListToOperationArgList( operationDTO.getOperationArgs() ) );
        operation.setTransactions( transactionDTOListToTransactionList( operationDTO.getTransactions() ) );

        return operation;
    }

    protected Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setTxId( transactionDTO.getTxId() );
        transaction.setBlock( toEntity( transactionDTO.getBlock() ) );
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

    protected ChannelDTO channelToChannelDTO(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDTO channelDTO = new ChannelDTO();

        channelDTO.setId( channel.getId() );
        channelDTO.setChannelName( channel.getChannelName() );
        channelDTO.setBlocks( toDto( channel.getBlocks() ) );

        return channelDTO;
    }

    protected NetworkDTO networkToNetworkDTO(Network network) {
        if ( network == null ) {
            return null;
        }

        NetworkDTO networkDTO = new NetworkDTO();

        networkDTO.setId( network.getId() );
        networkDTO.setIp( network.getIp() );
        networkDTO.setBlocks( toDto( network.getBlocks() ) );

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

    protected ChaincodeDTO chaincodeToChaincodeDTO(Chaincode chaincode) {
        if ( chaincode == null ) {
            return null;
        }

        ChaincodeDTO chaincodeDTO = new ChaincodeDTO();

        chaincodeDTO.setId( chaincode.getId() );
        chaincodeDTO.setChaincodeID( chaincode.getChaincodeID() );

        return chaincodeDTO;
    }

    protected OperationArgDTO operationArgToOperationArgDTO(OperationArg operationArg) {
        if ( operationArg == null ) {
            return null;
        }

        OperationArgDTO operationArgDTO = new OperationArgDTO();

        operationArgDTO.setId( operationArg.getId() );
        operationArgDTO.setOperation( operationToOperationDTO( operationArg.getOperation() ) );
        operationArgDTO.setArgument( operationArg.getArgument() );

        return operationArgDTO;
    }

    protected List<OperationArgDTO> operationArgListToOperationArgDTOList(List<OperationArg> list) {
        if ( list == null ) {
            return null;
        }

        List<OperationArgDTO> list1 = new ArrayList<OperationArgDTO>( list.size() );
        for ( OperationArg operationArg : list ) {
            list1.add( operationArgToOperationArgDTO( operationArg ) );
        }

        return list1;
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
        operationDTO.setOperationArgs( operationArgListToOperationArgDTOList( operation.getOperationArgs() ) );

        return operationDTO;
    }

    protected TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setTxId( transaction.getTxId() );
        transactionDTO.setBlock( toDto( transaction.getBlock() ) );
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
}
