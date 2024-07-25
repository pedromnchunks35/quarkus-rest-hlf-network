package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreatorDTO {
    private Integer id;
    private String mspId;
    private byte[] idBytes;
    private List<TransactionDTO> transactions;
    private List<EndorsementDTO> endorsements;
}
