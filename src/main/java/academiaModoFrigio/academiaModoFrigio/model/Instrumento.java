package academiaModoFrigio.academiaModoFrigio.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="Instrumento")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Instrumento{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="nombre")
    @NotNull
    private String nombre;

    @Column(name="descripcion")
    @NotNull
    private String descripcion;

    @Column(name="tipo")
    @NotNull
    private String tipo;

    @Column(name="precio")
    @NotNull
    private int precio;

    @Column(name="cantidad")
    @NotNull
    private int cantidad;

    @Column(name="imagen")
    @NotNull
    private byte[] imagen;
}