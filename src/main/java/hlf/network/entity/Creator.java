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
@Table(name = "CREATOR", schema = "HLF_NETWORK")
@Data
public class Creator {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "MSP_ID", length = 20)
    private String mspId;

    @Column(name = "ID_BYTES")
    private byte[] idBytes;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endorsement> endorsements;
}
