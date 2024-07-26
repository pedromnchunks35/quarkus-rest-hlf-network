package hlf.network.dto;

import lombok.Data;

@Data
public class ChaincodeListDTO {
    private String chaincodeName;
    private String channelName;
    private Integer numberOfTransactions;
    private String version;
}
