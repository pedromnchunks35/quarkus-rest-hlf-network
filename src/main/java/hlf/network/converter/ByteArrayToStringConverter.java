package hlf.network.converter;

import java.util.Base64;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ByteArrayToStringConverter implements AttributeConverter<String, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        return Base64.getDecoder().decode(attribute);
    }

    @Override
    public String convertToEntityAttribute(byte[] dbData) {
        if (dbData == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(dbData);
    }
}
