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
@Data
@Table(schema = "HLF_NETWORK", name = "NETWORK")
public class Network {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "IP", length = 200, unique = true)
    private String ip;

    @OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks;
}
