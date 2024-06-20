package academiaModoFrigio.academiaModoFrigio.repository;

import academiaModoFrigio.academiaModoFrigio.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, UUID> {
}
