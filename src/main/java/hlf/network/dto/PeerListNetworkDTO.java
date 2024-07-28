package hlf.network.dto;

import lombok.Data;

@Data
public class PeerListNetworkDTO {
    public PeerListNetworkDTO(
            Long numberOfTransactions,
            Long numberOfChaincodes) {
        this.numberOfTransactions = numberOfTransactions.intValue();
        this.numberOfChaincodes = numberOfChaincodes.intValue();
    }

    private String name;
    private String ipAddress;
    private String typeComponent;
    private String msp;
    private Integer numberOfTransactions;
    private Integer numberOfChaincodes;
    private boolean isAlive;
}
