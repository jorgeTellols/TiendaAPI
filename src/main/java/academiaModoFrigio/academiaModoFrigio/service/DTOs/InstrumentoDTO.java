package academiaModoFrigio.academiaModoFrigio.service.DTOs;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class InstrumentoDTO {

    private UUID id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int precio;
    private int cantidad;
    private byte[] imagen;
}
