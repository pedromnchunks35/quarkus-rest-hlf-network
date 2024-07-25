package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class OperationDTO {
    private Integer id;
    private ChaincodeDTO chaincode;
    private String chaincodeType;
    private List<TransactionDTO> transactions;
    private List<OperationArgDTO> operationArgs;
}
