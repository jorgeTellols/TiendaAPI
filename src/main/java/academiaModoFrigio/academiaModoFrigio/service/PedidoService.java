package academiaModoFrigio.academiaModoFrigio.service;

import academiaModoFrigio.academiaModoFrigio.model.Pedido;
import academiaModoFrigio.academiaModoFrigio.repository.PedidoRepo;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.PedidoDTO;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepo repositorio;

    @Autowired
    private PedidoMapper pedidoMapper;


    //Método con el que se hará el POST (CREATE)
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO)
    {
        Pedido pedidoConvertido = pedidoMapper.toPedido(pedidoDTO);
        Pedido pedidoDTOParaGuardar = repositorio.save(pedidoConvertido);

        return pedidoMapper.toPedidoDTO(pedidoDTOParaGuardar);
    }

    //Método con el que se hará el PUT (UPDATE)
    public Pedido actualizarPedido(UUID id, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoData = repositorio.findById(id);

        PedidoDTO _pedido = pedidoMapper.toPedidoDTO(pedidoData.get());
        if (pedidoData.isPresent()){
            _pedido.setPrecio(pedidoDTO.getPrecio());
            _pedido.setDireccion(pedidoDTO.getDireccion());
            _pedido.setFechaHora(pedidoDTO.getFechaHora());
            _pedido.setIdCliente(pedidoDTO.getIdCliente());
            _pedido.setListaProductos(pedidoDTO.getListaProductos());
        }
        return repositorio.save(pedidoMapper.toPedido(_pedido));
    }

    //Método con el que se hará el GET (READ)
    public List<Pedido> listaPedidos()
    {
        return repositorio.findAll();
    }

    //Método con el que se borrará un Pedido por su ID
    public void eliminarPedidoPorId(UUID id)
    {
        repositorio.deleteById(id);
    }

    //Método con el que se hará el GET a partir del ID
    public Optional<Pedido> listaPedidosPorId(UUID id)
    {
        return repositorio.findById(id);
    }
}
