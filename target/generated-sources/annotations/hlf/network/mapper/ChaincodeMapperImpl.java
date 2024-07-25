package hlf.network.mapper;

import hlf.network.dto.ChaincodeDTO;
import hlf.network.entity.Chaincode;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-25T16:50:08+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class ChaincodeMapperImpl implements ChaincodeMapper {

    @Override
    public Chaincode toEntity(ChaincodeDTO ChaincodeDTO) {
        if ( ChaincodeDTO == null ) {
            return null;
        }

        Chaincode chaincode = new Chaincode();

        chaincode.setId( ChaincodeDTO.getId() );
        chaincode.setChaincodeID( ChaincodeDTO.getChaincodeID() );

        return chaincode;
    }

    @Override
    public ChaincodeDTO toDto(Chaincode Chaincode) {
        if ( Chaincode == null ) {
            return null;
        }

        ChaincodeDTO chaincodeDTO = new ChaincodeDTO();

        chaincodeDTO.setId( Chaincode.getId() );
        chaincodeDTO.setChaincodeID( Chaincode.getChaincodeID() );

        return chaincodeDTO;
    }

    @Override
    public List<Chaincode> toEntity(List<ChaincodeDTO> ChaincodeDTOList) {
        if ( ChaincodeDTOList == null ) {
            return null;
        }

        List<Chaincode> list = new ArrayList<Chaincode>( ChaincodeDTOList.size() );
        for ( ChaincodeDTO chaincodeDTO : ChaincodeDTOList ) {
            list.add( toEntity( chaincodeDTO ) );
        }

        return list;
    }

    @Override
    public List<ChaincodeDTO> toDto(List<Chaincode> ChaincodeList) {
        if ( ChaincodeList == null ) {
            return null;
        }

        List<ChaincodeDTO> list = new ArrayList<ChaincodeDTO>( ChaincodeList.size() );
        for ( Chaincode chaincode : ChaincodeList ) {
            list.add( toDto( chaincode ) );
        }

        return list;
    }
}
