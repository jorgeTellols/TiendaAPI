package academiaModoFrigio.academiaModoFrigio.service;

import academiaModoFrigio.academiaModoFrigio.model.Mensaje;
import academiaModoFrigio.academiaModoFrigio.repository.MensajeRepo;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.MensajeDTO;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO.MensajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MensajeService {

    @Autowired
    private MensajeRepo repositorio;

    @Autowired
    private MensajeMapper mensajeMapper;


    //Método con el que se hará el POST (CREATE)
    public MensajeDTO guardarMensaje(MensajeDTO mensajeDTO)
    {
        Mensaje mensajeConvertida = mensajeMapper.toMensaje(mensajeDTO);
        Mensaje mensajeDTOParaGuardar = repositorio.save(mensajeConvertida);

        return mensajeMapper.toMensajeDTO(mensajeDTOParaGuardar);
    }

    //Método con el que se hará el PUT (UPDATE)
    public Mensaje actualizarMensaje(UUID id, MensajeDTO mensajeDTO) {
        Optional<Mensaje> mensajeData = repositorio.findById(id);

        MensajeDTO _mensaje = mensajeMapper.toMensajeDTO(mensajeData.get());
        if (mensajeData.isPresent()){
            _mensaje.setCuerpoMensaje(mensajeDTO.getCuerpoMensaje());
            _mensaje.setFechaHora(mensajeDTO.getFechaHora());
            _mensaje.setId_receptor(mensajeDTO.getId_receptor());
            _mensaje.setId_remitente(mensajeDTO.getId_remitente());
        }
        return repositorio.save(mensajeMapper.toMensaje(_mensaje));
    }


    //Método con el que se hará el GET (READ)
    public List<Mensaje> listaMensajes()
    {
        return repositorio.findAll();
    }

    //Método con el que se borrará una Mensaje por su ID
    public void eliminarMensajePorId(UUID id)
    {
        repositorio.deleteById(id);
    }

    //Método con el que se hará el GET a partir del ID
    public Optional<Mensaje> listaMensajesPorId(UUID id)
    {
        return repositorio.findById(id);
    }
}
