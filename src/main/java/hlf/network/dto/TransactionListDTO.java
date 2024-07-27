package hlf.network.dto;

import lombok.Data;

@Data
public class TransactionListDTO {
    public TransactionListDTO(
        String creator,
        String channelName,
        String txId,
        String type,
        String chaincodeName,
        Integer timestamp
    ){
        this.creator=creator;
        this.channelName=channelName;
        this.txId=txId;
        this.type=type;
        this.chaincodeName=chaincodeName;
        this.timestamp=timestamp;
    }
    private String creator;
    private String channelName;
    private String txId;
    private String type;
    private String chaincodeName;
    private Integer timestamp;
}
