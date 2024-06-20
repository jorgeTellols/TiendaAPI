package academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO;

import academiaModoFrigio.academiaModoFrigio.service.DTOs.UsuarioDTO;
import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    @Mappings({
    @Mapping(source="id", target="id"),
    @Mapping(source="nombre", target="nombre"),
    @Mapping(source="apellidos", target="apellidos"),
    @Mapping(source="user", target="user"),
    @Mapping(source="password", target="password"),
    @Mapping(source="direccion", target="direccion"),
    @Mapping(source="email", target="email"),
    @Mapping(source="esProfesor", target="esProfesor"),
    @Mapping(source="historialPedidos", target="historialPedidos"),
    @Mapping(source="mensajesEnviados", target="historialMensajesEnviados"),
    @Mapping(source="mensajesRecibidos", target="historialMensajesRecibidos")
    })
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(UsuarioDTO usuarioDTO);
}
