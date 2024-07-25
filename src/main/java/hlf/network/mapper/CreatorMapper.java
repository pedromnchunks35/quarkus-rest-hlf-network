package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.CreatorDTO;
import hlf.network.entity.Creator;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CreatorMapper {
    CreatorMapper INSTANCE = Mappers.getMapper(CreatorMapper.class);

    Creator toEntity(CreatorDTO CreatorDTO);

    CreatorDTO toDto(Creator Creator);

    List<Creator> toEntity(List<CreatorDTO> CreatorDTOList);

    List<CreatorDTO> toDto(List<Creator> CreatorList);
}
