package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.TypeTransactionDTO;
import hlf.network.entity.TypeTransaction;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TypeTransactionMapper {
    TypeTransactionMapper INSTANCE = Mappers.getMapper(TypeTransactionMapper.class);

    TypeTransaction toEntity(TypeTransactionDTO TypeTransactionDTO);

    TypeTransactionDTO toDto(TypeTransaction TypeTransaction);

    List<TypeTransaction> toEntity(List<TypeTransactionDTO> TypeTransactionDTOList);

    List<TypeTransactionDTO> toDto(List<TypeTransaction> TypeTransactionList);
}
