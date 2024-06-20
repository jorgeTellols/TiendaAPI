package academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO;

import academiaModoFrigio.academiaModoFrigio.service.DTOs.InstrumentoDTO;
import academiaModoFrigio.academiaModoFrigio.model.Instrumento;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InstrumentoMapper {
    @Mappings({
    @Mapping(source="id", target="id"),
    @Mapping(source="nombre", target="nombre"),
    @Mapping(source="descripcion", target="descripcion"),
    @Mapping(source="tipo", target="tipo"),
    @Mapping(source="precio", target="precio"),
    @Mapping(source="cantidad", target="cantidad"),
    @Mapping(source="imagen", target="imagen"),
    })
    InstrumentoDTO toInstrumentoDTO(Instrumento instrumento);

    @InheritInverseConfiguration
    Instrumento toInstrumento(InstrumentoDTO instrumentoDTO);
}
