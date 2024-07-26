package hlf.network.repository;

import hlf.network.entity.Operation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperationRepository implements PanacheRepositoryBase<Operation, Integer> {
}