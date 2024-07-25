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
@Table(name = "TX_VALIDATION_TYPE", schema = "HLF_NETWORK")
public class TxValidationType {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "DESCRIPTION_TYPE", length = 50)
    private String descriptionType;

    @OneToMany(mappedBy = "txValidationType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
