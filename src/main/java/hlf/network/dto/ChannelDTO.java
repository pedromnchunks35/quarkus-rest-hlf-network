package hlf.network.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChannelDTO {
    private Integer id;
    private String channelName;
    private List<BlockDTO> blocks;
}
