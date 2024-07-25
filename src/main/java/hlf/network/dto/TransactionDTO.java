package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class TransactionDTO {
    private String txId;
    private BlockDTO block;
    private Integer timestampTx;
    private TypeTransactionDTO typeTransaction;
    private TxValidationTypeDTO txValidationType;
    private CreatorDTO creator;
    private OperationDTO operation;
    private byte[] payload;
    private List<EndorsementDTO> endorsements;
    private List<ChaincodeEventDTO> chaincodeEvents;
}
