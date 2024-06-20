package academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO;

import academiaModoFrigio.academiaModoFrigio.service.DTOs.MensajeDTO;
import academiaModoFrigio.academiaModoFrigio.model.Mensaje;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MensajeMapper {


    @Mappings({
    @Mapping(source="id", target="id"),
    @Mapping(source="remitente", target="id_remitente"),
    @Mapping(source="receptor", target="id_receptor"),
    @Mapping(source="cuerpoMensaje", target="cuerpoMensaje"),
    @Mapping(source="fechaHora", target="fechaHora"),
    @Mapping(source="listaUsuario", target="listaUsuario")
    })
    MensajeDTO toMensajeDTO(Mensaje mensaje);

    @InheritInverseConfiguration
    Mensaje toMensaje(MensajeDTO mensajeDTO);
}
