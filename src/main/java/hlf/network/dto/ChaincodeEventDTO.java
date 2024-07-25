package hlf.network.dto;

import lombok.Data;

@Data
public class ChaincodeEventDTO {
    private Integer id;
    private TransactionDTO transaction;
    private BlockDTO block;
    private ChaincodeDTO chaincode;
    private String eventName;
    private byte[] content;
}
