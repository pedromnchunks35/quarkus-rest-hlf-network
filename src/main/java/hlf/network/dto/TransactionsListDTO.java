package hlf.network.dto;

import lombok.Data;

@Data
public class TransactionsListDTO {
    private String creator;
    private String channelName;
    private String txId;
    private String type;
    private String chaincodeName;
    private Integer timestamp;
}
