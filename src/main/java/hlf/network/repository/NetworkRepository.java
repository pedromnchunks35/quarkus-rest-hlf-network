package hlf.network.repository;

import hlf.network.entity.Network;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class NetworkRepository implements PanacheRepositoryBase<Network, Integer> {}
