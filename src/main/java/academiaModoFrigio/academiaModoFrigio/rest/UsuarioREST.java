package academiaModoFrigio.academiaModoFrigio.rest;

import academiaModoFrigio.academiaModoFrigio.model.Usuario;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.LoginRequest;
import academiaModoFrigio.academiaModoFrigio.service.UsuarioService;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
public class UsuarioREST {

    @Autowired
    private UsuarioService servicioUsuario;

    //Método para registrarse y validar que no se registren dos usuarios con el mismo nombre
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioDTO> subirUsuario(@RequestBody UsuarioDTO usuarioDTO)
    {
        if (servicioUsuario.existeCorreoElectronico(usuarioDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (servicioUsuario.existeNombreUser(usuarioDTO.getUser())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try
        {
            return new ResponseEntity<>(servicioUsuario.guardarUsuario(usuarioDTO), HttpStatus.CREATED);
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //Método para hacer login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuario) {
        System.out.println(usuario.getUser());
        System.out.println(usuario.getPassword());
        if (servicioUsuario.validarCredenciales(usuario.getUser(), usuario.getPassword())) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña inválidos");
        }
    }


    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO)
    {
        try
        {
            return ResponseEntity.ok(servicioUsuario.actualizarUsuario(id, usuarioDTO));
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> mostrarTodosUsuarios()
    {
        return ResponseEntity.ok(servicioUsuario.listaUsuarios());
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuariosPorId(@PathVariable UUID id)
    {
        servicioUsuario.eliminarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }
}
