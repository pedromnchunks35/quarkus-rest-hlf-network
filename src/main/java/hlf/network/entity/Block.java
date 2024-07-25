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

@Table(name = "BLOCK", schema = "HLF_NETWORK")
@Entity
@Data
public class Block {

    @Id
    @Column(name = "BLOCK_NUMBER", unique = true)
    private Integer blockNumber;

    @ManyToOne
    @JoinColumn(name = "ID_CHANNEL")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "ID_NETWORK")
    private Network network;

    @Column(name = "PREV_HASH", unique = true)
    private byte[] prevHash;

    @Column(name = "NEXT_HASH", unique = true)
    private byte[] nextHash;

    @Column(name = "DATA")
    private byte[] data;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
