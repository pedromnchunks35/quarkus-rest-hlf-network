package hlf.network.repository;

import java.util.List;

import hlf.network.dto.BlockTreeListDTO;
import hlf.network.entity.Block;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class BlockRepository implements PanacheRepositoryBase<Block, Integer> {
    @PersistenceContext
    EntityManager entityManager;

    /**
     * @param start, timestamp in integer form start of range
     * @param end,   timestamp in integer form end of range
     * @return
     */
    public Double getBlocksPerMinute(int start, int end) {
        String query = "SELECT COUNT(DISTINCT t.block.blockNumber) / ((MAX(t.timestampTx) - MIN(t.timestampTx)) / 60.0) "
                +
                "FROM Transaction t " +
                "WHERE t.timestampTx BETWEEN :start AND :end";
        try {
            Double result = entityManager.createQuery(query, Double.class)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getSingleResult();
            return result == null ? 0.0 : result;
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * @param page, the page number
     * @param size, the size that the page must have
     * @return
     */
    public List<BlockTreeListDTO> getBlockTreeList(int page, int size) {
        String query = "SELECT new hlf.network.entity.Block(T.block.blockNumber, C.channelName, T.block.nextHash, T.timestampTx) "
                +
                "FROM Transaction T " +
                "JOIN T.block B " +
                "JOIN B.channel C " +
                "WHERE T.timestampTx = (" +
                "   SELECT MIN(T2.timestampTx) " +
                "   FROM Transaction T2 " +
                "   WHERE T2.block.blockNumber = T.block.blockNumber" +
                ")";
        List<BlockTreeListDTO> result = entityManager.createQuery(query, BlockTreeListDTO.class)
                .setFirstResult((page - 1) * size).setMaxResults(size).getResultList();
        return result;
    }
}
