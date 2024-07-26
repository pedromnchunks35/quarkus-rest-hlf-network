package hlf.network.dto;

import lombok.Data;

@Data
public class NetworkComponentsListDTO {
    private String name;
    private String ipAddress;
    private String typeComponent;
    private String msp;
    private Integer numberOfTransactions;
    private Integer numberOfChaincodes;
    private boolean isAlive;
}
