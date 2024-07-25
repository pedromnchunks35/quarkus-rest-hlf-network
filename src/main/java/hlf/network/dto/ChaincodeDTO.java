package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChaincodeDTO {
    private Integer id;
    private String chaincodeID;
    private List<OperationDTO> operations;
}
