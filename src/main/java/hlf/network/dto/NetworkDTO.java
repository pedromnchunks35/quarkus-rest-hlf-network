package hlf.network.dto;

import java.util.List;

import lombok.Data;
@Data
public class NetworkDTO {
    private Integer id;
    private String ip;
    private List<BlockDTO> blocks;
}
