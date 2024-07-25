package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class BlockDTO {
    private Integer blockNumber;
    private ChannelDTO channel;
    private NetworkDTO network;
    private byte[] prevHash;
    private byte[] nextHash;
    private byte[] data;
    private List<TransactionDTO> transactions;
}
