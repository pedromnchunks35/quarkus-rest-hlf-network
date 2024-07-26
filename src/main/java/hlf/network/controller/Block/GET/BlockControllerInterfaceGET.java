package hlf.network.controller.Block.GET;

import jakarta.ws.rs.core.Response;

public interface BlockControllerInterfaceGET {
    public Response getTotalOfBlocks();

    public Response getBlocksPerMinute();

    public Response getBlocksTree(int page, int size);

    public Response getBlocksList(int page, int size);
}
