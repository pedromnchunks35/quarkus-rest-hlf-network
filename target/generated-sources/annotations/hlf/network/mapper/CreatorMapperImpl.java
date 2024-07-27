package hlf.network.mapper;

import hlf.network.dto.BlockDTO;
import hlf.network.dto.ChaincodeDTO;
import hlf.network.dto.ChaincodeEventDTO;
import hlf.network.dto.ChannelDTO;
import hlf.network.dto.CreatorDTO;
import hlf.network.dto.EndorsementDTO;
import hlf.network.dto.NetworkDTO;
import hlf.network.dto.OperationArgDTO;
import hlf.network.dto.OperationDTO;
import hlf.network.dto.TransactionDTO;
import hlf.network.dto.TxValidationTypeDTO;
import hlf.network.dto.TypeTransactionDTO;
import hlf.network.entity.Block;
import hlf.network.entity.Chaincode;
import hlf.network.entity.ChaincodeEvent;
import hlf.network.entity.Channel;
import hlf.network.entity.Creator;
import hlf.network.entity.Endorsement;
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
    date = "2024-07-27T15:45:07+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class CreatorMapperImpl implements CreatorMapper {

    @Override
    public Creator toEntity(CreatorDTO CreatorDTO) {
        if ( CreatorDTO == null ) {
            return null;
        }

        Creator creator = new Creator();

        creator.setEndorsements( endorsementDTOListToEndorsementList( CreatorDTO.getEndorsements() ) );
        creator.setId( CreatorDTO.getId() );
        byte[] idBytes = CreatorDTO.getIdBytes();
        if ( idBytes != null ) {
            creator.setIdBytes( Arrays.copyOf( idBytes, idBytes.length ) );
        }
        creator.setMspId( CreatorDTO.getMspId() );
        creator.setTransactions( transactionDTOListToTransactionList( CreatorDTO.getTransactions() ) );

        return creator;
    }

    @Override
    public CreatorDTO toDto(Creator Creator) {
        if ( Creator == null ) {
            return null;
        }

        CreatorDTO creatorDTO = new CreatorDTO();

        creatorDTO.setEndorsements( endorsementListToEndorsementDTOList( Creator.getEndorsements() ) );
        creatorDTO.setId( Creator.getId() );
        byte[] idBytes = Creator.getIdBytes();
        if ( idBytes != null ) {
            creatorDTO.setIdBytes( Arrays.copyOf( idBytes, idBytes.length ) );
        }
        creatorDTO.setMspId( Creator.getMspId() );
        creatorDTO.setTransactions( transactionListToTransactionDTOList( Creator.getTransactions() ) );

        return creatorDTO;
    }

    @Override
    public List<Creator> toEntity(List<CreatorDTO> CreatorDTOList) {
        if ( CreatorDTOList == null ) {
            return null;
        }

        List<Creator> list = new ArrayList<Creator>( CreatorDTOList.size() );
        for ( CreatorDTO creatorDTO : CreatorDTOList ) {
            list.add( toEntity( creatorDTO ) );
        }

        return list;
    }

    @Override
    public List<CreatorDTO> toDto(List<Creator> CreatorList) {
        if ( CreatorList == null ) {
            return null;
        }

        List<CreatorDTO> list = new ArrayList<CreatorDTO>( CreatorList.size() );
        for ( Creator creator : CreatorList ) {
            list.add( toDto( creator ) );
        }

        return list;
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

        channel.setBlocks( blockDTOListToBlockList( channelDTO.getBlocks() ) );
        channel.setChannelName( channelDTO.getChannelName() );
        channel.setId( channelDTO.getId() );

        return channel;
    }

    protected Network networkDTOToNetwork(NetworkDTO networkDTO) {
        if ( networkDTO == null ) {
            return null;
        }

        Network network = new Network();

        network.setBlocks( blockDTOListToBlockList( networkDTO.getBlocks() ) );
        network.setId( networkDTO.getId() );
        network.setIp( networkDTO.getIp() );

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
        byte[] data = blockDTO.getData();
        if ( data != null ) {
            block.setData( Arrays.copyOf( data, data.length ) );
        }
        block.setNetwork( networkDTOToNetwork( blockDTO.getNetwork() ) );
        byte[] nextHash = blockDTO.getNextHash();
        if ( nextHash != null ) {
            block.setNextHash( Arrays.copyOf( nextHash, nextHash.length ) );
        }
        byte[] prevHash = blockDTO.getPrevHash();
        if ( prevHash != null ) {
            block.setPrevHash( Arrays.copyOf( prevHash, prevHash.length ) );
        }
        block.setTransactions( transactionDTOListToTransactionList( blockDTO.getTransactions() ) );

        return block;
    }

    protected OperationArg operationArgDTOToOperationArg(OperationArgDTO operationArgDTO) {
        if ( operationArgDTO == null ) {
            return null;
        }

        OperationArg operationArg = new OperationArg();

        operationArg.setArgument( operationArgDTO.getArgument() );
        operationArg.setId( operationArgDTO.getId() );
        operationArg.setOperation( operationDTOToOperation( operationArgDTO.getOperation() ) );

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

        operation.setChaincode( chaincodeDTOToChaincode( operationDTO.getChaincode() ) );
        operation.setChaincodeType( operationDTO.getChaincodeType() );
        operation.setId( operationDTO.getId() );
        operation.setOperationArgs( operationArgDTOListToOperationArgList( operationDTO.getOperationArgs() ) );
        operation.setTransactions( transactionDTOListToTransactionList( operationDTO.getTransactions() ) );

        return operation;
    }

    protected List<Operation> operationDTOListToOperationList(List<OperationDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Operation> list1 = new ArrayList<Operation>( list.size() );
        for ( OperationDTO operationDTO : list ) {
            list1.add( operationDTOToOperation( operationDTO ) );
        }

        return list1;
    }

    protected Chaincode chaincodeDTOToChaincode(ChaincodeDTO chaincodeDTO) {
        if ( chaincodeDTO == null ) {
            return null;
        }

        Chaincode chaincode = new Chaincode();

        chaincode.setChaincodeID( chaincodeDTO.getChaincodeID() );
        chaincode.setId( chaincodeDTO.getId() );
        chaincode.setOperations( operationDTOListToOperationList( chaincodeDTO.getOperations() ) );

        return chaincode;
    }

    protected ChaincodeEvent chaincodeEventDTOToChaincodeEvent(ChaincodeEventDTO chaincodeEventDTO) {
        if ( chaincodeEventDTO == null ) {
            return null;
        }

        ChaincodeEvent chaincodeEvent = new ChaincodeEvent();

        chaincodeEvent.setBlock( blockDTOToBlock( chaincodeEventDTO.getBlock() ) );
        chaincodeEvent.setChaincode( chaincodeDTOToChaincode( chaincodeEventDTO.getChaincode() ) );
        byte[] content = chaincodeEventDTO.getContent();
        if ( content != null ) {
            chaincodeEvent.setContent( Arrays.copyOf( content, content.length ) );
        }
        chaincodeEvent.setEventName( chaincodeEventDTO.getEventName() );
        chaincodeEvent.setId( chaincodeEventDTO.getId() );
        chaincodeEvent.setTransaction( transactionDTOToTransaction( chaincodeEventDTO.getTransaction() ) );

        return chaincodeEvent;
    }

    protected List<ChaincodeEvent> chaincodeEventDTOListToChaincodeEventList(List<ChaincodeEventDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ChaincodeEvent> list1 = new ArrayList<ChaincodeEvent>( list.size() );
        for ( ChaincodeEventDTO chaincodeEventDTO : list ) {
            list1.add( chaincodeEventDTOToChaincodeEvent( chaincodeEventDTO ) );
        }

        return list1;
    }

    protected List<Endorsement> endorsementDTOListToEndorsementList(List<EndorsementDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Endorsement> list1 = new ArrayList<Endorsement>( list.size() );
        for ( EndorsementDTO endorsementDTO : list ) {
            list1.add( endorsementDTOToEndorsement( endorsementDTO ) );
        }

        return list1;
    }

    protected TxValidationType txValidationTypeDTOToTxValidationType(TxValidationTypeDTO txValidationTypeDTO) {
        if ( txValidationTypeDTO == null ) {
            return null;
        }

        TxValidationType txValidationType = new TxValidationType();

        txValidationType.setDescriptionType( txValidationTypeDTO.getDescriptionType() );
        txValidationType.setId( txValidationTypeDTO.getId() );
        txValidationType.setTransactions( transactionDTOListToTransactionList( txValidationTypeDTO.getTransactions() ) );

        return txValidationType;
    }

    protected TypeTransaction typeTransactionDTOToTypeTransaction(TypeTransactionDTO typeTransactionDTO) {
        if ( typeTransactionDTO == null ) {
            return null;
        }

        TypeTransaction typeTransaction = new TypeTransaction();

        typeTransaction.setDescriptionType( typeTransactionDTO.getDescriptionType() );
        typeTransaction.setId( typeTransactionDTO.getId() );
        typeTransaction.setTransactions( transactionDTOListToTransactionList( typeTransactionDTO.getTransactions() ) );

        return typeTransaction;
    }

    protected Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setBlock( blockDTOToBlock( transactionDTO.getBlock() ) );
        transaction.setChaincodeEvents( chaincodeEventDTOListToChaincodeEventList( transactionDTO.getChaincodeEvents() ) );
        transaction.setCreator( toEntity( transactionDTO.getCreator() ) );
        transaction.setEndorsements( endorsementDTOListToEndorsementList( transactionDTO.getEndorsements() ) );
        transaction.setOperation( operationDTOToOperation( transactionDTO.getOperation() ) );
        byte[] payload = transactionDTO.getPayload();
        if ( payload != null ) {
            transaction.setPayload( Arrays.copyOf( payload, payload.length ) );
        }
        transaction.setTimestampTx( transactionDTO.getTimestampTx() );
        transaction.setTxId( transactionDTO.getTxId() );
        transaction.setTxValidationType( txValidationTypeDTOToTxValidationType( transactionDTO.getTxValidationType() ) );
        transaction.setTypeTransaction( typeTransactionDTOToTypeTransaction( transactionDTO.getTypeTransaction() ) );

        return transaction;
    }

    protected Endorsement endorsementDTOToEndorsement(EndorsementDTO endorsementDTO) {
        if ( endorsementDTO == null ) {
            return null;
        }

        Endorsement endorsement = new Endorsement();

        endorsement.setCreator( toEntity( endorsementDTO.getCreator() ) );
        endorsement.setId( endorsementDTO.getId() );
        endorsement.setTransaction( transactionDTOToTransaction( endorsementDTO.getTransaction() ) );

        return endorsement;
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

        channelDTO.setBlocks( blockListToBlockDTOList( channel.getBlocks() ) );
        channelDTO.setChannelName( channel.getChannelName() );
        channelDTO.setId( channel.getId() );

        return channelDTO;
    }

    protected NetworkDTO networkToNetworkDTO(Network network) {
        if ( network == null ) {
            return null;
        }

        NetworkDTO networkDTO = new NetworkDTO();

        networkDTO.setBlocks( blockListToBlockDTOList( network.getBlocks() ) );
        networkDTO.setId( network.getId() );
        networkDTO.setIp( network.getIp() );

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
        byte[] data = block.getData();
        if ( data != null ) {
            blockDTO.setData( Arrays.copyOf( data, data.length ) );
        }
        blockDTO.setNetwork( networkToNetworkDTO( block.getNetwork() ) );
        byte[] nextHash = block.getNextHash();
        if ( nextHash != null ) {
            blockDTO.setNextHash( Arrays.copyOf( nextHash, nextHash.length ) );
        }
        byte[] prevHash = block.getPrevHash();
        if ( prevHash != null ) {
            blockDTO.setPrevHash( Arrays.copyOf( prevHash, prevHash.length ) );
        }
        blockDTO.setTransactions( transactionListToTransactionDTOList( block.getTransactions() ) );

        return blockDTO;
    }

    protected OperationArgDTO operationArgToOperationArgDTO(OperationArg operationArg) {
        if ( operationArg == null ) {
            return null;
        }

        OperationArgDTO operationArgDTO = new OperationArgDTO();

        operationArgDTO.setArgument( operationArg.getArgument() );
        operationArgDTO.setId( operationArg.getId() );
        operationArgDTO.setOperation( operationToOperationDTO( operationArg.getOperation() ) );

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

        operationDTO.setChaincode( chaincodeToChaincodeDTO( operation.getChaincode() ) );
        operationDTO.setChaincodeType( operation.getChaincodeType() );
        operationDTO.setId( operation.getId() );
        operationDTO.setOperationArgs( operationArgListToOperationArgDTOList( operation.getOperationArgs() ) );
        operationDTO.setTransactions( transactionListToTransactionDTOList( operation.getTransactions() ) );

        return operationDTO;
    }

    protected List<OperationDTO> operationListToOperationDTOList(List<Operation> list) {
        if ( list == null ) {
            return null;
        }

        List<OperationDTO> list1 = new ArrayList<OperationDTO>( list.size() );
        for ( Operation operation : list ) {
            list1.add( operationToOperationDTO( operation ) );
        }

        return list1;
    }

    protected ChaincodeDTO chaincodeToChaincodeDTO(Chaincode chaincode) {
        if ( chaincode == null ) {
            return null;
        }

        ChaincodeDTO chaincodeDTO = new ChaincodeDTO();

        chaincodeDTO.setChaincodeID( chaincode.getChaincodeID() );
        chaincodeDTO.setId( chaincode.getId() );
        chaincodeDTO.setOperations( operationListToOperationDTOList( chaincode.getOperations() ) );

        return chaincodeDTO;
    }

    protected ChaincodeEventDTO chaincodeEventToChaincodeEventDTO(ChaincodeEvent chaincodeEvent) {
        if ( chaincodeEvent == null ) {
            return null;
        }

        ChaincodeEventDTO chaincodeEventDTO = new ChaincodeEventDTO();

        chaincodeEventDTO.setBlock( blockToBlockDTO( chaincodeEvent.getBlock() ) );
        chaincodeEventDTO.setChaincode( chaincodeToChaincodeDTO( chaincodeEvent.getChaincode() ) );
        byte[] content = chaincodeEvent.getContent();
        if ( content != null ) {
            chaincodeEventDTO.setContent( Arrays.copyOf( content, content.length ) );
        }
        chaincodeEventDTO.setEventName( chaincodeEvent.getEventName() );
        chaincodeEventDTO.setId( chaincodeEvent.getId() );
        chaincodeEventDTO.setTransaction( transactionToTransactionDTO( chaincodeEvent.getTransaction() ) );

        return chaincodeEventDTO;
    }

    protected List<ChaincodeEventDTO> chaincodeEventListToChaincodeEventDTOList(List<ChaincodeEvent> list) {
        if ( list == null ) {
            return null;
        }

        List<ChaincodeEventDTO> list1 = new ArrayList<ChaincodeEventDTO>( list.size() );
        for ( ChaincodeEvent chaincodeEvent : list ) {
            list1.add( chaincodeEventToChaincodeEventDTO( chaincodeEvent ) );
        }

        return list1;
    }

    protected List<EndorsementDTO> endorsementListToEndorsementDTOList(List<Endorsement> list) {
        if ( list == null ) {
            return null;
        }

        List<EndorsementDTO> list1 = new ArrayList<EndorsementDTO>( list.size() );
        for ( Endorsement endorsement : list ) {
            list1.add( endorsementToEndorsementDTO( endorsement ) );
        }

        return list1;
    }

    protected TxValidationTypeDTO txValidationTypeToTxValidationTypeDTO(TxValidationType txValidationType) {
        if ( txValidationType == null ) {
            return null;
        }

        TxValidationTypeDTO txValidationTypeDTO = new TxValidationTypeDTO();

        txValidationTypeDTO.setDescriptionType( txValidationType.getDescriptionType() );
        txValidationTypeDTO.setId( txValidationType.getId() );
        txValidationTypeDTO.setTransactions( transactionListToTransactionDTOList( txValidationType.getTransactions() ) );

        return txValidationTypeDTO;
    }

    protected TypeTransactionDTO typeTransactionToTypeTransactionDTO(TypeTransaction typeTransaction) {
        if ( typeTransaction == null ) {
            return null;
        }

        TypeTransactionDTO typeTransactionDTO = new TypeTransactionDTO();

        typeTransactionDTO.setDescriptionType( typeTransaction.getDescriptionType() );
        typeTransactionDTO.setId( typeTransaction.getId() );
        typeTransactionDTO.setTransactions( transactionListToTransactionDTOList( typeTransaction.getTransactions() ) );

        return typeTransactionDTO;
    }

    protected TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setBlock( blockToBlockDTO( transaction.getBlock() ) );
        transactionDTO.setChaincodeEvents( chaincodeEventListToChaincodeEventDTOList( transaction.getChaincodeEvents() ) );
        transactionDTO.setCreator( toDto( transaction.getCreator() ) );
        transactionDTO.setEndorsements( endorsementListToEndorsementDTOList( transaction.getEndorsements() ) );
        transactionDTO.setOperation( operationToOperationDTO( transaction.getOperation() ) );
        byte[] payload = transaction.getPayload();
        if ( payload != null ) {
            transactionDTO.setPayload( Arrays.copyOf( payload, payload.length ) );
        }
        transactionDTO.setTimestampTx( transaction.getTimestampTx() );
        transactionDTO.setTxId( transaction.getTxId() );
        transactionDTO.setTxValidationType( txValidationTypeToTxValidationTypeDTO( transaction.getTxValidationType() ) );
        transactionDTO.setTypeTransaction( typeTransactionToTypeTransactionDTO( transaction.getTypeTransaction() ) );

        return transactionDTO;
    }

    protected EndorsementDTO endorsementToEndorsementDTO(Endorsement endorsement) {
        if ( endorsement == null ) {
            return null;
        }

        EndorsementDTO endorsementDTO = new EndorsementDTO();

        endorsementDTO.setCreator( toDto( endorsement.getCreator() ) );
        endorsementDTO.setId( endorsement.getId() );
        endorsementDTO.setTransaction( transactionToTransactionDTO( endorsement.getTransaction() ) );

        return endorsementDTO;
    }
}
