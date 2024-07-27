package hlf.network.repository;

import hlf.network.entity.Chaincode;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import hlf.network.dto.ChaincodeListDTO;;

@ApplicationScoped
public class ChaincodeRepository implements PanacheRepositoryBase<Chaincode, Integer> {
    @Inject
    EntityManager entityManager;

    /**
     * @param page, the number of the page/slot of the pagination
     * @param size, the size of the page in the pagination
     * @return
     */
    public List<ChaincodeListDTO> getChaincodeList(int page, int size) {
        String query = "SELECT new hlf.network.dto.ChaincodeListDTO(CH.chaincodeID,C.channelName,COUNT(T))" +
                "FROM Transaction T " +
                "LEFT JOIN T.block B " +
                "LEFT JOIN B.channel C " +
                "LEFT JOIN T.operation O " +
                "LEFT JOIN O.chaincode CH " +
                "GROUP BY CH.chaincodeID,C.channelName";
        List<ChaincodeListDTO> result = entityManager.createQuery(query, ChaincodeListDTO.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
        return result;
    }
}
