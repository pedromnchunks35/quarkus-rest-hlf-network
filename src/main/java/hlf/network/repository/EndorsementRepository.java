package hlf.network.repository;

import hlf.network.entity.Endorsement;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EndorsementRepository implements PanacheRepositoryBase<Endorsement, Integer> {
}
