package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.ChaincodeEventDTO;
import hlf.network.entity.ChaincodeEvent;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChaincodeEventEventMapper {
    ChaincodeEventEventMapper INSTANCE = Mappers.getMapper(ChaincodeEventEventMapper.class);

    ChaincodeEvent toEntity(ChaincodeEventDTO ChaincodeEventDTO);

    ChaincodeEventDTO toDto(ChaincodeEvent ChaincodeEvent);

    List<ChaincodeEvent> toEntity(List<ChaincodeEventDTO> ChaincodeEventDTOList);

    List<ChaincodeEventDTO> toDto(List<ChaincodeEvent> ChaincodeEventList);
}

