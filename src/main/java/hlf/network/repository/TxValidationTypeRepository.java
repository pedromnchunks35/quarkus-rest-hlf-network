package hlf.network.repository;

import hlf.network.entity.TxValidationType;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TxValidationTypeRepository implements PanacheRepositoryBase<TxValidationType, Integer> {
}
