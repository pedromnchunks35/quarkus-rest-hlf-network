package hlf.network.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import hlf.network.dto.TransactionDTO;
import hlf.network.entity.Transaction;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toEntity(TransactionDTO TransactionDTO);

    TransactionDTO toDto(Transaction Transaction);

    List<Transaction> toEntity(List<TransactionDTO> TransactionDTOList);

    List<TransactionDTO> toDto(List<Transaction> TransactionList);
}
