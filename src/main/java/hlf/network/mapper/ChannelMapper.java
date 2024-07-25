package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.ChannelDTO;
import hlf.network.entity.Channel;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel toEntity(ChannelDTO ChannelDTO);

    ChannelDTO toDto(Channel Channel);

    List<Channel> toEntity(List<ChannelDTO> ChannelDTOList);

    List<ChannelDTO> toDto(List<Channel> ChannelList);
}

