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

@Table(name = "OPERATION", schema = "HLF_NETWORK")
@Entity
@Data
public class Operation {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CHAINCODE")
    private Chaincode chaincode;

    @Column(name = "CHAINCODE_TYPE", length = 50)
    private String chaincodeType;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OperationArg> operationArgs;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
