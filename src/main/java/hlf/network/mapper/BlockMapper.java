package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.BlockDTO;
import hlf.network.entity.Block;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BlockMapper {
    BlockMapper INSTANCE = Mappers.getMapper(BlockMapper.class);

    Block toEntity(BlockDTO blockDTO);

    BlockDTO toDto(Block block);

    List<Block> toEntity(List<BlockDTO> blockDTOList);

    List<BlockDTO> toDto(List<Block> blockList);
}
