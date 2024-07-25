package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class TxValidationTypeDTO {
    private Integer id;
    private String descriptionType;
    private List<TransactionDTO> transactions;
}
