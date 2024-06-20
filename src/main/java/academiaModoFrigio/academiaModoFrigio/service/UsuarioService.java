package academiaModoFrigio.academiaModoFrigio.service;

import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import academiaModoFrigio.academiaModoFrigio.repository.UsuarioRepo;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.UsuarioDTO;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repositorio;

    @Autowired
    private UsuarioMapper usuarioMapper;

    //REGISTRO

    //Método para impedir que se registren dos usuarios con el mismo mail
    public boolean existeCorreoElectronico(String email) {
        return repositorio.findByEmail(email).isPresent();
    }

    //Método para impedir que se registren dos usuarios con el mismo nombre usuario
    public boolean existeNombreUser(String user) {
        return repositorio.findByNombre(user).isPresent();
    }

    //LOGIN

    //Método para manejar el login
    public boolean validarCredenciales(String user, String clave) {
        Optional<Usuario> usuarioEncontrado = repositorio.findByNombre(user);
        if(!(usuarioEncontrado.isPresent()))
        {
            return false;
        }
        return usuarioEncontrado.map(usuario -> clave.equals(usuario.getPassword())).orElse(false);
    }

    //CRUD

    // Método con el que se hará el POST (CREATE)
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO)
    {
        Usuario usuarioConvertido = usuarioMapper.toUsuario(usuarioDTO);
        Usuario usuarioDTOParaGuardar = repositorio.save(usuarioConvertido);

        return usuarioMapper.toUsuarioDTO(usuarioDTOParaGuardar);
    }


    // Método con el que se hará el PUT (UPDATE)
    public Usuario actualizarUsuario(UUID id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioData = repositorio.findById(id);

        UsuarioDTO _usuario = usuarioMapper.toUsuarioDTO(usuarioData.get());
        if (usuarioData.isPresent()){
            _usuario.setNombre(usuarioDTO.getNombre());
            _usuario.setApellidos(usuarioDTO.getApellidos());
            _usuario.setUser(usuarioDTO.getUser());
            _usuario.setPassword(usuarioDTO.getPassword());
            _usuario.setDireccion(usuarioDTO.getDireccion());
            _usuario.setEsProfesor(usuarioDTO.isEsProfesor());
        }
        return repositorio.save(usuarioMapper.toUsuario(_usuario));
    }

    // Método con el que se hará el GET (READ)
    public List<Usuario> listaUsuarios()
    {
        return repositorio.findAll();
    }

     // Método con el que se borrará un Usuario por su ID
    public void eliminarUsuarioPorId(UUID id)
    {
        repositorio.deleteById(id);
    }
}
