package hlf.network.dto;

import lombok.Data;

@Data
public class BlockListDTO {
    public BlockListDTO(Integer blockNumber, String channelName, byte[] dataHash, byte[] blockHash,
            Long numberOfTransactions) {
        this.blockNumber = blockNumber;
        this.channelName = channelName;
        this.dataHash = dataHash;
        this.blockHash = blockHash;
        this.numberOfTransactions = numberOfTransactions.intValue();
        this.size = dataHash.length;
    }

    private Integer blockNumber;
    private String channelName;
    private byte[] dataHash;
    private byte[] blockHash;
    private Integer numberOfTransactions;
    private Integer size;
}
