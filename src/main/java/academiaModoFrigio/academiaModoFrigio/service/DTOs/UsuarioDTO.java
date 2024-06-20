package academiaModoFrigio.academiaModoFrigio.service.DTOs;

import academiaModoFrigio.academiaModoFrigio.model.Mensaje;
import academiaModoFrigio.academiaModoFrigio.model.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class UsuarioDTO {

    private UUID id;
    private String nombre;
    private String apellidos;
    private String user;
    private String password;
    private String direccion;
    private String email;
    private boolean esProfesor;
    private List<Pedido> historialPedidos;
    private List<Mensaje> historialMensajesRecibidos;
    private List<Mensaje> historialMensajesEnviados;
}
