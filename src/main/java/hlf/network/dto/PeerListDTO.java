package hlf.network.dto;

import lombok.Data;

@Data
public class PeerListDTO {
    private String name;
    private String ipAddress;
    private boolean isAlive;
}
