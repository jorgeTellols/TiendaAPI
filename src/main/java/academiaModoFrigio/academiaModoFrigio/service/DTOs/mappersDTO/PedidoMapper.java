package academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.PedidoDTO;
import academiaModoFrigio.academiaModoFrigio.model.Pedido;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {


    @Mappings({
    @Mapping(source="id", target="id"),
    @Mapping(source="idCliente", target="idCliente"),
    @Mapping(source="listaProductos", target="listaProductos"),
    @Mapping(source="direccion", target="direccion"),
    @Mapping(source="fechaHora", target="fechaHora"),
    @Mapping(source="precio", target="precio"),
    })
    PedidoDTO toPedidoDTO(Pedido pedido);

    @InheritInverseConfiguration
    Pedido toPedido(PedidoDTO pedidoDTO);
}
