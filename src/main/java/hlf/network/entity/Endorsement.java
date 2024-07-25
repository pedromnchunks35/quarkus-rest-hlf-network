package hlf.network.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ENDORSEMENT", schema = "HLF_NETWORK")
@Data
public class Endorsement {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TX_ID")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "ID_CREATOR")
    private Creator creator;
}
