package hlf.network.repository;

import hlf.network.entity.Channel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import hlf.network.dto.ChannelListDTO;

@ApplicationScoped
public class ChannelRepository implements PanacheRepositoryBase<Channel, Integer> {
    @Inject
    EntityManager entityManager;

    public List<ChannelListDTO> getChannelList(int page, int size) {
        String query = "SELECT new hlf.network.dto.ChannelListDTO(CH.chaincodeID,C.channelName,COUNT(T),MAX(T.timestampTx)) "
                +
                "FROM Transaction T " +
                "LEFT JOIN T.block B " +
                "LEFT JOIN B.channel C " +
                "LEFT JOIN T.operation O " +
                "LEFT JOIN O.chaincode CH " +
                "GROUP BY CH.chaincodeID,C.channelName";
        List<ChannelListDTO> result = entityManager.createQuery(query, ChannelListDTO.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
        return result;
    }
}
