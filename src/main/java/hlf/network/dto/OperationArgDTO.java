package hlf.network.dto;

import lombok.Data;

@Data
public class OperationArgDTO {
    private Integer id;
    private OperationDTO operation;
    private String argument;
}
