package hlf.network.repository;

import hlf.network.entity.Creator;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreatorRepository implements PanacheRepositoryBase<Creator, Integer> {
}
