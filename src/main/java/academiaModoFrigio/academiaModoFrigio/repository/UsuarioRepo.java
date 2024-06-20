package academiaModoFrigio.academiaModoFrigio.repository;

import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByEmail(String email);

}
