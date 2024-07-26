package hlf.network.repository;

import hlf.network.entity.Channel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChannelRepository implements PanacheRepositoryBase<Channel, Integer> {
}
