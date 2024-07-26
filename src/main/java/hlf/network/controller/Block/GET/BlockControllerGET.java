package hlf.network.controller.Block.GET;

import hlf.network.repository.BlockRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
@ApplicationScoped
public class BlockControllerGET implements BlockControllerInterfaceGET {
    @Inject
    BlockRepository blockRepository;

    public Response getTotalOfBlocks() {
        Long number_of_blocks = blockRepository.count();
        return Response.ok(number_of_blocks).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getBlocksPerMinute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlocksPerMinute'");
    }

    @Override
    public Response getBlocksTree(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlocksTree'");
    }

    @Override
    public Response getBlocksList(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlocksList'");
    }
}
