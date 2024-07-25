package hlf.network.dto;

import lombok.Data;

@Data
public class EndorsementDTO {
    private Integer id;
    private TransactionDTO transaction;
    private CreatorDTO creator;
}
