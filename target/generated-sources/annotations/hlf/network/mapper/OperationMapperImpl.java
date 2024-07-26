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
    date = "2024-07-26T14:20:21+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class OperationMapperImpl implements OperationMapper {

    @Override
    public Operation toEntity(OperationDTO OperationDTO) {
        if ( OperationDTO == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( OperationDTO.getId() );
        operation.setChaincode( chaincodeDTOToChaincode( OperationDTO.getChaincode() ) );
        operation.setChaincodeType( OperationDTO.getChaincodeType() );
        operation.setOperationArgs( operationArgDTOListToOperationArgList( OperationDTO.getOperationArgs() ) );
        operation.setTransactions( transactionDTOListToTransactionList( OperationDTO.getTransactions() ) );

        return operation;
    }

    @Override
    public OperationDTO toDto(Operation Operation) {
        if ( Operation == null ) {
            return null;
        }

        OperationDTO operationDTO = new OperationDTO();

        operationDTO.setId( Operation.getId() );
        operationDTO.setChaincode( chaincodeToChaincodeDTO( Operation.getChaincode() ) );
        operationDTO.setChaincodeType( Operation.getChaincodeType() );
        operationDTO.setTransactions( transactionListToTransactionDTOList( Operation.getTransactions() ) );
        operationDTO.setOperationArgs( operationArgListToOperationArgDTOList( Operation.getOperationArgs() ) );

        return operationDTO;
    }

    @Override
    public List<Operation> toEntity(List<OperationDTO> OperationDTOList) {
        if ( OperationDTOList == null ) {
            return null;
        }

        List<Operation> list = new ArrayList<Operation>( OperationDTOList.size() );
        for ( OperationDTO operationDTO : OperationDTOList ) {
            list.add( toEntity( operationDTO ) );
        }

        return list;
    }

    @Override
    public List<OperationDTO> toDto(List<Operation> OperationList) {
        if ( OperationList == null ) {
            return null;
        }

        List<OperationDTO> list = new ArrayList<OperationDTO>( OperationList.size() );
        for ( Operation operation : OperationList ) {
            list.add( toDto( operation ) );
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
        chaincode.setOperations( toEntity( chaincodeDTO.getOperations() ) );

        return chaincode;
    }

    protected OperationArg operationArgDTOToOperationArg(OperationArgDTO operationArgDTO) {
        if ( operationArgDTO == null ) {
            return null;
        }

        OperationArg operationArg = new OperationArg();

        operationArg.setId( operationArgDTO.getId() );
        operationArg.setOperation( toEntity( operationArgDTO.getOperation() ) );
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

    protected Endorsement endorsementDTOToEndorsement(EndorsementDTO endorsementDTO) {
        if ( endorsementDTO == null ) {
            return null;
        }

        Endorsement endorsement = new Endorsement();

        endorsement.setId( endorsementDTO.getId() );
        endorsement.setTransaction( transactionDTOToTransaction( endorsementDTO.getTransaction() ) );
        endorsement.setCreator( creatorDTOToCreator( endorsementDTO.getCreator() ) );

        return endorsement;
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
        creator.setEndorsements( endorsementDTOListToEndorsementList( creatorDTO.getEndorsements() ) );

        return creator;
    }

    protected ChaincodeEvent chaincodeEventDTOToChaincodeEvent(ChaincodeEventDTO chaincodeEventDTO) {
        if ( chaincodeEventDTO == null ) {
            return null;
        }

        ChaincodeEvent chaincodeEvent = new ChaincodeEvent();

        chaincodeEvent.setId( chaincodeEventDTO.getId() );
        chaincodeEvent.setTransaction( transactionDTOToTransaction( chaincodeEventDTO.getTransaction() ) );
        chaincodeEvent.setBlock( blockDTOToBlock( chaincodeEventDTO.getBlock() ) );
        chaincodeEvent.setChaincode( chaincodeDTOToChaincode( chaincodeEventDTO.getChaincode() ) );
        chaincodeEvent.setEventName( chaincodeEventDTO.getEventName() );
        byte[] content = chaincodeEventDTO.getContent();
        if ( content != null ) {
            chaincodeEvent.setContent( Arrays.copyOf( content, content.length ) );
        }

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
        transaction.setOperation( toEntity( transactionDTO.getOperation() ) );
        byte[] payload = transactionDTO.getPayload();
        if ( payload != null ) {
            transaction.setPayload( Arrays.copyOf( payload, payload.length ) );
        }
        transaction.setEndorsements( endorsementDTOListToEndorsementList( transactionDTO.getEndorsements() ) );
        transaction.setChaincodeEvents( chaincodeEventDTOListToChaincodeEventList( transactionDTO.getChaincodeEvents() ) );

        return transaction;
    }

    protected ChaincodeDTO chaincodeToChaincodeDTO(Chaincode chaincode) {
        if ( chaincode == null ) {
            return null;
        }

        ChaincodeDTO chaincodeDTO = new ChaincodeDTO();

        chaincodeDTO.setId( chaincode.getId() );
        chaincodeDTO.setChaincodeID( chaincode.getChaincodeID() );
        chaincodeDTO.setOperations( toDto( chaincode.getOperations() ) );

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

    protected EndorsementDTO endorsementToEndorsementDTO(Endorsement endorsement) {
        if ( endorsement == null ) {
            return null;
        }

        EndorsementDTO endorsementDTO = new EndorsementDTO();

        endorsementDTO.setId( endorsement.getId() );
        endorsementDTO.setTransaction( transactionToTransactionDTO( endorsement.getTransaction() ) );
        endorsementDTO.setCreator( creatorToCreatorDTO( endorsement.getCreator() ) );

        return endorsementDTO;
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
        creatorDTO.setEndorsements( endorsementListToEndorsementDTOList( creator.getEndorsements() ) );

        return creatorDTO;
    }

    protected ChaincodeEventDTO chaincodeEventToChaincodeEventDTO(ChaincodeEvent chaincodeEvent) {
        if ( chaincodeEvent == null ) {
            return null;
        }

        ChaincodeEventDTO chaincodeEventDTO = new ChaincodeEventDTO();

        chaincodeEventDTO.setId( chaincodeEvent.getId() );
        chaincodeEventDTO.setTransaction( transactionToTransactionDTO( chaincodeEvent.getTransaction() ) );
        chaincodeEventDTO.setBlock( blockToBlockDTO( chaincodeEvent.getBlock() ) );
        chaincodeEventDTO.setChaincode( chaincodeToChaincodeDTO( chaincodeEvent.getChaincode() ) );
        chaincodeEventDTO.setEventName( chaincodeEvent.getEventName() );
        byte[] content = chaincodeEvent.getContent();
        if ( content != null ) {
            chaincodeEventDTO.setContent( Arrays.copyOf( content, content.length ) );
        }

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
        transactionDTO.setOperation( toDto( transaction.getOperation() ) );
        byte[] payload = transaction.getPayload();
        if ( payload != null ) {
            transactionDTO.setPayload( Arrays.copyOf( payload, payload.length ) );
        }
        transactionDTO.setEndorsements( endorsementListToEndorsementDTOList( transaction.getEndorsements() ) );
        transactionDTO.setChaincodeEvents( chaincodeEventListToChaincodeEventDTOList( transaction.getChaincodeEvents() ) );

        return transactionDTO;
    }

    protected OperationArgDTO operationArgToOperationArgDTO(OperationArg operationArg) {
        if ( operationArg == null ) {
            return null;
        }

        OperationArgDTO operationArgDTO = new OperationArgDTO();

        operationArgDTO.setId( operationArg.getId() );
        operationArgDTO.setOperation( toDto( operationArg.getOperation() ) );
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
}
