package hlf.network.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CHANNEL", schema = "HLF_NETWORK")
@Data
public class Channel {
    
    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "CHANNEL_NAME", unique = true, length = 200)
    private String channelName;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks;
}
