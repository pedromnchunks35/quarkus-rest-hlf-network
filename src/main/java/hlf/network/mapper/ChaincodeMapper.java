package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.ChaincodeDTO;
import hlf.network.entity.Chaincode;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChaincodeMapper {
    ChaincodeMapper INSTANCE = Mappers.getMapper(ChaincodeMapper.class);

    Chaincode toEntity(ChaincodeDTO ChaincodeDTO);

    ChaincodeDTO toDto(Chaincode Chaincode);

    List<Chaincode> toEntity(List<ChaincodeDTO> ChaincodeDTOList);

    List<ChaincodeDTO> toDto(List<Chaincode> ChaincodeList);
}
