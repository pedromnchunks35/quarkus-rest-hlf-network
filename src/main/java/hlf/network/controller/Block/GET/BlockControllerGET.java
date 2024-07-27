package hlf.network.controller.Block.GET;

import java.util.List;

import hlf.network.dto.BlockListDTO;
import hlf.network.dto.BlockTreeListDTO;
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
    public Response getBlocksTree(int page, int size) {
        if (page < 0 || size < 0) {
            return Response.ok("Please provide a valid page and size").status(Response.Status.BAD_REQUEST).build();
        }
        List<BlockTreeListDTO> result = blockRepository.getBlockTreeList(page, size);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getBlocksList(int page, int size) {
        if (page < 0 || size < 0) {
            return Response.ok("Please provide a valid page and size").status(Response.Status.BAD_REQUEST).build();
        }
        List<BlockListDTO> result = blockRepository.getBlockListDTO(page, size);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }

    @Override
    public Response getBlocksPerMinute(int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return Response.ok("Please provide a valid start and end").status(Response.Status.BAD_REQUEST).build();
        }
        Double result = blockRepository.getBlocksPerMinute(start, end);
        return Response.ok(result).status(Response.Status.ACCEPTED).build();
    }
}
