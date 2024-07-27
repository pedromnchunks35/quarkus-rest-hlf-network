package hlf.network.dto;

import lombok.Data;

@Data
public class ChannelListDTO {
    public ChannelListDTO(
            String chaincodeName,
            String channel,
            Long numberOfTransactions,
            Integer timestamp) {
        this.chaincodeName = chaincodeName;
        this.channel = channel;
        this.numberOfTransactions = numberOfTransactions.intValue();
        this.timestamp = timestamp;
    }

    String chaincodeName;
    String channel;
    Integer numberOfTransactions;
    String version;
    Integer timestamp;
}
