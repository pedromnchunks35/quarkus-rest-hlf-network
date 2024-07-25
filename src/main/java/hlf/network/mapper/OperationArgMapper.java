package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.OperationArgDTO;
import hlf.network.entity.OperationArg;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OperationArgMapper {
    OperationArgMapper INSTANCE = Mappers.getMapper(OperationArgMapper.class);

    OperationArg toEntity(OperationArgDTO OperationArgDTO);

    OperationArgDTO toDto(OperationArg OperationArg);

    List<OperationArg> toEntity(List<OperationArgDTO> OperationArgDTOList);

    List<OperationArgDTO> toDto(List<OperationArg> OperationArgList);
}
