package academiaModoFrigio.academiaModoFrigio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Mensaje")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class Mensaje{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_remitente")
    @NotNull
    private Usuario remitente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TablaJoinMensajeUsuario",
            joinColumns = @JoinColumn(name = "id_mensaje"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    @NotNull
    private List<Usuario> listaUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_receptor")
    @NotNull
    private Usuario receptor;

    @Column(name="cuerpo_mensaje")
    @NotNull
    private String cuerpoMensaje;

    @Column(name="fecha_hora")
    @NotNull
    private Date fechaHora;
}
