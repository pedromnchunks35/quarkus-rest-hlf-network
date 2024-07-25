package hlf.network.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CHAINCODE_EVENT", schema = "HLF_NETWORK")
@Data
public class ChaincodeEvent {
    
    @Id
    @Column(name = "ID", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TX_ID")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "BLOCK_NUMBER")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "ID_CHAINCODE")
    private Chaincode chaincode;

    @Column(name = "EVENT_NAME", length = 8000)
    private String eventName;

    @Column(name = "CONTENT")
    private byte[] content;

}
