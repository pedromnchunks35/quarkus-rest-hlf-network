package hlf.network.dto;

import lombok.Data;

@Data
public class BlockTreeListDTO {
    private Integer blockNumber;
    private String channelName;
    private byte[] dataHash;
    private Integer txNumber;
    private Integer timestamp;
}
