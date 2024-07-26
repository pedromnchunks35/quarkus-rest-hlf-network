package hlf.network.dto;

import lombok.Data;

@Data
public class BlockListDTO {
    private Integer blockNumber;
    private String channelName;
    private byte[] dataHash;
    private byte[] blockHash;
    private Integer numberOfTransactions;
    private Integer size;
}
