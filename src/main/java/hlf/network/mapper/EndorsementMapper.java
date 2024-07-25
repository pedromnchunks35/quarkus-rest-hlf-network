package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.EndorsementDTO;
import hlf.network.entity.Endorsement;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EndorsementMapper {
    EndorsementMapper INSTANCE = Mappers.getMapper(EndorsementMapper.class);

    Endorsement toEntity(EndorsementDTO EndorsementDTO);

    EndorsementDTO toDto(Endorsement Endorsement);

    List<Endorsement> toEntity(List<EndorsementDTO> EndorsementDTOList);

    List<EndorsementDTO> toDto(List<Endorsement> EndorsementList);
}
