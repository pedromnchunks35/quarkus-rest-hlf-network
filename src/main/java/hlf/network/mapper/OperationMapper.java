package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.OperationDTO;
import hlf.network.entity.Operation;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OperationMapper {
    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    Operation toEntity(OperationDTO OperationDTO);

    OperationDTO toDto(Operation Operation);

    List<Operation> toEntity(List<OperationDTO> OperationDTOList);

    List<OperationDTO> toDto(List<Operation> OperationList);
}
