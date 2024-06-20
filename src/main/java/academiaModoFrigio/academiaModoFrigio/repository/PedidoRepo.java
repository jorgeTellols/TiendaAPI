package academiaModoFrigio.academiaModoFrigio.repository;

import academiaModoFrigio.academiaModoFrigio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, UUID> {
}
