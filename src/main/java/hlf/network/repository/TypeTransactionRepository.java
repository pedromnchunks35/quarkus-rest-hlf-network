package hlf.network.repository;

import hlf.network.entity.TypeTransaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TypeTransactionRepository implements PanacheRepositoryBase<TypeTransaction, Integer> {
}
