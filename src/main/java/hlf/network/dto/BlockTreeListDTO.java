package hlf.network.dto;

import lombok.Data;

@Data
public class BlockTreeListDTO {
    public BlockTreeListDTO(Integer blockNumber, String channelName, byte[] dataHash, Integer timestamp) {
        this.blockNumber = blockNumber;
        this.channelName = channelName;
        this.dataHash = dataHash;
        this.timestamp = timestamp;
    }

    private Integer blockNumber;
    private String channelName;
    private byte[] dataHash;
    private Integer timestamp;
}
