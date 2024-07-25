package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.TxValidationTypeDTO;
import hlf.network.entity.TxValidationType;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TxValidationTypeMapper {
    TxValidationTypeMapper INSTANCE = Mappers.getMapper(TxValidationTypeMapper.class);

    TxValidationType toEntity(TxValidationTypeDTO TxValidationTypeDTO);

    TxValidationTypeDTO toDto(TxValidationType TxValidationType);

    List<TxValidationType> toEntity(List<TxValidationTypeDTO> TxValidationTypeDTOList);

    List<TxValidationTypeDTO> toDto(List<TxValidationType> TxValidationTypeList);
}
