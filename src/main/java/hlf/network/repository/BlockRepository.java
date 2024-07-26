package hlf.network.repository;

import java.util.Optional;

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
}
