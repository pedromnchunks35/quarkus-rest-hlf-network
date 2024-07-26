package hlf.network.repository;

import hlf.network.entity.ChaincodeEvent;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class ChaincodeEventRepository implements PanacheRepositoryBase<ChaincodeEvent, Integer> {}
