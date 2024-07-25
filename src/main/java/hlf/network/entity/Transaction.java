package hlf.network.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "TRANSACTION", schema = "HLF_NETWORK")
@Entity
public class Transaction {

    @Id
    @Column(name = "TX_ID", unique = true)
    private String txId;

    @ManyToOne
    @JoinColumn(name = "BLOCK_NUMBER")
    private Block block;

    @Column(name = "TIMESTAMP_TX")
    private Integer timestampTx;

    @ManyToOne
    @JoinColumn(name = "ID_TYPE_TRANSACTION")
    private TypeTransaction typeTransaction;

    @ManyToOne
    @JoinColumn(name = "ID_TX_VALIDATION")
    private TxValidationType txValidationType;

    @ManyToOne
    @JoinColumn(name = "ID_CREATOR")
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "ID_OPERATION")
    private Operation operation;

    @Column(name = "PAYLOAD")
    private byte[] payload;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endorsement> endorsements;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChaincodeEvent> chaincodeEvents;
}
