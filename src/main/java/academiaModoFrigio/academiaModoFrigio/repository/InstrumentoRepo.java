package academiaModoFrigio.academiaModoFrigio.repository;

import academiaModoFrigio.academiaModoFrigio.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstrumentoRepo extends JpaRepository<Instrumento, UUID> {
}
