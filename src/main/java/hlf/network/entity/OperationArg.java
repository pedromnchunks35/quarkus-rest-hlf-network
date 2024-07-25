package hlf.network.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "OPERATION_ARG", schema = "HLF_NETWORK")
@Entity
@Data
public class OperationArg {

    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_OPERATION")
    private Operation operation;

    @Column(name = "ARGUMENT", length = 20000)
    private String argument;

}
