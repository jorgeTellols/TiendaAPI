package academiaModoFrigio.academiaModoFrigio.rest;

import academiaModoFrigio.academiaModoFrigio.model.Instrumento;
import academiaModoFrigio.academiaModoFrigio.service.InstrumentoService;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.InstrumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.Optional;


@RestController
public class InstrumentoREST {

    @Autowired
    private InstrumentoService servicioInstrumento;

    @PostMapping("/instrumentos")
    public ResponseEntity<InstrumentoDTO> subirInstrumento(@RequestBody InstrumentoDTO instrumentoDTO) {
        try {
            return new ResponseEntity<>(servicioInstrumento.guardarInstrumento(instrumentoDTO), HttpStatus.CREATED);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/instrumentos/{id}")
    public ResponseEntity<Instrumento> actualizarInstrumento(@PathVariable UUID id, @RequestBody InstrumentoDTO instrumentoDTO)
    {
        try
        {
            return ResponseEntity.ok(servicioInstrumento.actualizarInstrumento(id, instrumentoDTO));
        }
        catch(Exception error)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/instrumentos")
    public ResponseEntity<List<Instrumento>> mostrarTodosInstrumentos()
    {
        return ResponseEntity.ok(servicioInstrumento.listaInstrumentos());
    }

    @GetMapping(value = "/instrumentos/{id}")
    public ResponseEntity<Optional<Instrumento>> mostrarInstrumentosPorId(@PathVariable UUID id)
    {
        return ResponseEntity.ok(servicioInstrumento.listaInstrumentosPorId(id));
    }

    @DeleteMapping("/instrumentos/{id}")
    public ResponseEntity<Void> eliminarInstrumentosPorId(@PathVariable UUID id)
    {
        servicioInstrumento.eliminarInstrumentoPorId(id);
        return ResponseEntity.ok().build();
    }
}
