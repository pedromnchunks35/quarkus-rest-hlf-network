package hlf.network.dto;

import lombok.Data;

@Data
public class ChaincodeListDTO {
    public ChaincodeListDTO(
            String chaincodeName,
            String channelName,
            Long numberOfTransactions) {
        this.chaincodeName = chaincodeName;
        this.channelName = channelName;
        this.numberOfTransactions = numberOfTransactions.intValue();
    }

    private String chaincodeName;
    private String channelName;
    private Integer numberOfTransactions;
    private String version;
}
