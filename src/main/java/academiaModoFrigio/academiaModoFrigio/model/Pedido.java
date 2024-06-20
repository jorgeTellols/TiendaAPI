package academiaModoFrigio.academiaModoFrigio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Pedido")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Pedido{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cliente")
    @NotNull
    private Usuario idCliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TablaJoinPedidoInstrumento",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_instrumento")
    )
    @NotNull
    private List<Instrumento> listaProductos;

    @Column(name="direccion")
    @NotNull
    private String direccion;

    @Column(name="fecha_hora")
    @NotNull
    private Date fechaHora;

    @Column(name="precio")
    @NotNull
    private int precio;

}
