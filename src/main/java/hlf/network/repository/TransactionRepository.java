package hlf.network.repository;

import hlf.network.entity.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer> {}
