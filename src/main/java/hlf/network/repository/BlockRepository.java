package hlf.network.repository;

import hlf.network.entity.Block;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class BlockRepository implements PanacheRepositoryBase<Block, Integer> {}
