package academiaModoFrigio.academiaModoFrigio.rest;

import academiaModoFrigio.academiaModoFrigio.model.Mensaje;
import academiaModoFrigio.academiaModoFrigio.service.MensajeService;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.MensajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

@RestController
public class MensajeREST {

    @Autowired
    private MensajeService servicioMensaje;

    @PostMapping("/mensajes")
    public ResponseEntity<MensajeDTO> subirMensaje(@RequestBody MensajeDTO mensajeDTO)
    {
        try
        {
            return new ResponseEntity<>(servicioMensaje.guardarMensaje(mensajeDTO), HttpStatus.CREATED);
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/mensajes/{id}")
    public ResponseEntity<Mensaje> actualizarMensaje(@PathVariable UUID id, @RequestBody MensajeDTO mensajeDTO)
    {
        try
        {
            return ResponseEntity.ok(servicioMensaje.actualizarMensaje(id, mensajeDTO));
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/mensajes")
    public ResponseEntity<List<Mensaje>> mostrarTodosMensajes()
    {
        return ResponseEntity.ok(servicioMensaje.listaMensajes());
    }

    @GetMapping(value = "/mensajes/{id}")
    public ResponseEntity<Optional<Mensaje>> mostrarMensajesPorId(@PathVariable UUID id)
    {
        return ResponseEntity.ok(servicioMensaje.listaMensajesPorId(id));
    }

    @DeleteMapping("/mensajes/{id}")
    public ResponseEntity<Void> eliminarMensajesPorId(@PathVariable UUID id)
    {
        servicioMensaje.eliminarMensajePorId(id);
        return ResponseEntity.ok().build();
    }
}
