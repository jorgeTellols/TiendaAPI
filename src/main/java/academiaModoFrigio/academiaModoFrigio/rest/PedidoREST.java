package academiaModoFrigio.academiaModoFrigio.rest;

import academiaModoFrigio.academiaModoFrigio.model.Pedido;
import academiaModoFrigio.academiaModoFrigio.service.PedidoService;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoREST {

    @Autowired
    private PedidoService servicioPedido;

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoDTO> subirPedido(@RequestBody PedidoDTO pedidoDTO)
    {
        try
        {
            return new ResponseEntity<>(servicioPedido.guardarPedido(pedidoDTO), HttpStatus.CREATED);
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable UUID id, @RequestBody PedidoDTO pedidoDTO)
    {
        try
        {
            return ResponseEntity.ok(servicioPedido.actualizarPedido(id, pedidoDTO));
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> mostrarTodosPedidos()
    {
        return ResponseEntity.ok(servicioPedido.listaPedidos());
    }

    @GetMapping(value = "/pedidos/{id}")
    public ResponseEntity<Optional<Pedido>> mostrarPedidosPorId(@PathVariable UUID id)
    {
        return ResponseEntity.ok(servicioPedido.listaPedidosPorId(id));
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Void> eliminarPedidosPorId(@PathVariable UUID id)
    {
        servicioPedido.eliminarPedidoPorId(id);
        return ResponseEntity.ok().build();
    }
}
