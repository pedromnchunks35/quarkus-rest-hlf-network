package hlf.network.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import hlf.network.dto.BlockDTO;
import hlf.network.entity.Block;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BlockMapperTest {
    @Test
    public void mappingTest() {
        Block block = new Block();
        block.setBlockNumber(1);
        block.setChannel(null);
        block.setData(new byte[] { 111, 000, 110, 11 });
        block.setNetwork(null);
        block.setNextHash(new byte[] { 11, 110, 110, 111, 000 });
        block.setPrevHash(new byte[] { 11, 110, 000, 010 });
        block.setTransactions(null);
        BlockDTO blockDTO = BlockMapper.INSTANCE.toDto(block);
        assertEquals(block.getBlockNumber(), blockDTO.getBlockNumber());
    }
}
