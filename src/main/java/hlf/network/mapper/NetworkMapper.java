package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.NetworkDTO;
import hlf.network.entity.Network;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NetworkMapper {
    NetworkMapper INSTANCE = Mappers.getMapper(NetworkMapper.class);

    Network toEntity(NetworkDTO NetworkDTO);

    NetworkDTO toDto(Network Network);

    List<Network> toEntity(List<NetworkDTO> NetworkDTOList);

    List<NetworkDTO> toDto(List<Network> NetworkList);
}
