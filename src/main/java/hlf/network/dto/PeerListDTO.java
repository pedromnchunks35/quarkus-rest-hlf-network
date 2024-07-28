package hlf.network.dto;

import lombok.Data;

@Data
public class PeerListDTO {
    public PeerListDTO(String name, String ipAddress, boolean isAlive) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.isAlive = isAlive;
    }

    private String name;
    private String ipAddress;
    private boolean isAlive;
}
