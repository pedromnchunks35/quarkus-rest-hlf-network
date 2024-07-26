package hlf.network.repository;

import hlf.network.entity.OperationArg;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperationArgRepository implements PanacheRepositoryBase<OperationArg, Integer> {
}
