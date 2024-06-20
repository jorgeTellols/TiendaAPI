package academiaModoFrigio.academiaModoFrigio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="nombre")
    @NotNull
    private String nombre;

    @Column(name="apellidos")
    @NotNull
    private String apellidos;

    @Column(name = "\"user\"")
    @NotNull
    private String user;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="direccion")
    private String direccion;

    @Column(name="email")
    private String email;

    @Column(name="es_profesor")
    @NotNull
    private boolean esProfesor = false;

    @OneToMany(mappedBy = "remitente", fetch = FetchType.LAZY)
    private List<Mensaje> mensajesEnviados = new ArrayList<>();

    @OneToMany(mappedBy = "receptor", fetch = FetchType.LAZY)
    private List<Mensaje> mensajesRecibidos = new ArrayList<>();

    @OneToMany(mappedBy = "idCliente", fetch = FetchType.LAZY)
    private List<Pedido> historialPedidos;
}
