package hlf.network.repository;

import java.util.List;

import hlf.network.dto.TransactionByOrgDTO;
import hlf.network.dto.TransactionListDTO;
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

    /**
     * @param page, the number of the page/slot of the pagination
     * @param size, the size of the page in the pagination
     * @return
     */
    public List<TransactionListDTO> getTransactionList(int page, int size) {
        String query = "SELECT new hlf.network.dto.TransactionListDTO(CR.mspId, C.channelName, T.txId, TY.descriptionType, CH.chaincodeID, T.timestampTx) "
                + "FROM Transaction T "
                + "LEFT JOIN T.block B "
                + "LEFT JOIN T.creator CR "
                + "LEFT JOIN T.operation O "
                + "LEFT JOIN O.chaincode CH "
                + "LEFT JOIN B.channel C "
                + "LEFT JOIN T.typeTransaction TY";
        List<TransactionListDTO> result = entityManager.createQuery(query, TransactionListDTO.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
        return result;
    }
}
