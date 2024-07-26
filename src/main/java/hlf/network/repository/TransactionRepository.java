package hlf.network.repository;

import java.util.List;

import hlf.network.dto.TransactionByOrgDTO;
import hlf.network.entity.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer> {
    @PersistenceContext
    EntityManager entityManager;

    /**
     * @param start, timestamp in integer form start of range
     * @param end,   timestamp in integer form end of range
     * @return transactions per minute in a given range
     */
    public Double getTransactionsPerMinute(int start, int end) {
        String query = "SELECT COUNT(DISTINCT t.txId) / ((MAX(t.timestampTx) - MIN(t.timestampTx)) / 60.0) "
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
     * @return Transactions percentage per org
     */
    public List<TransactionByOrgDTO> getTransactionByOrgPerc() {
        String query = "SELECT new hlf.network.dto.TransactionByOrgDTO(t.creator.mspId, " +
                "(COUNT(t) * 100.0 / (SELECT COUNT(t2) FROM Transaction t2))) " +
                "FROM Transaction t " +
                "GROUP BY t.creator.mspId";
        List<TransactionByOrgDTO> result = entityManager.createQuery(query, TransactionByOrgDTO.class)
                .getResultList();
        return result;
    }
}
