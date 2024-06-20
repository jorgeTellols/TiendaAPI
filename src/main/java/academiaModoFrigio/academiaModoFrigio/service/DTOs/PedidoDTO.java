package academiaModoFrigio.academiaModoFrigio.service.DTOs;

import academiaModoFrigio.academiaModoFrigio.model.Instrumento;
import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PedidoDTO {
    private UUID id;
    private Usuario idCliente;
    private List<Instrumento> listaProductos;
    private String direccion;
    private Date fechaHora;
    private int precio;


}
