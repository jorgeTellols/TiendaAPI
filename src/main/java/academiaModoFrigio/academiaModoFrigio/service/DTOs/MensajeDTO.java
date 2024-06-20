package academiaModoFrigio.academiaModoFrigio.service.DTOs;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

@Getter
@Setter
public class MensajeDTO {

    private UUID id;
    private Usuario id_remitente;
    private Usuario id_receptor;
    private String cuerpoMensaje;
    private Date fechaHora;
    private List<Usuario> listaUsuario;
}
