package academiaModoFrigio.academiaModoFrigio.service;

import academiaModoFrigio.academiaModoFrigio.model.Instrumento;
import academiaModoFrigio.academiaModoFrigio.repository.InstrumentoRepo;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.InstrumentoDTO;
import academiaModoFrigio.academiaModoFrigio.service.DTOs.mappersDTO.InstrumentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepo repositorio;
    @Autowired
    private InstrumentoMapper instrumentoMapper;


    //Método con el que se hará el POST (CREATE)
    public InstrumentoDTO guardarInstrumento(InstrumentoDTO InstrumentoDTO)
    {
        Instrumento InstrumentoConvertida = instrumentoMapper.toInstrumento(InstrumentoDTO);
        Instrumento InstrumentoDTOParaGuardar = repositorio.save(InstrumentoConvertida);

        return instrumentoMapper.toInstrumentoDTO(InstrumentoDTOParaGuardar);
    }

    //Método con el que se hará el PUT (UPDATE)
    public Instrumento actualizarInstrumento(UUID id, InstrumentoDTO InstrumentoDTO) {
        Optional<Instrumento> InstrumentoData = repositorio.findById(id);

        InstrumentoDTO _Instrumento = instrumentoMapper.toInstrumentoDTO(InstrumentoData.get());
        if (InstrumentoData.isPresent()){
            _Instrumento.setCantidad(InstrumentoDTO.getCantidad());
            _Instrumento.setPrecio(InstrumentoDTO.getPrecio());
            _Instrumento.setNombre(InstrumentoDTO.getNombre());
            _Instrumento.setDescripcion(InstrumentoDTO.getDescripcion());
            _Instrumento.setTipo(InstrumentoDTO.getTipo());
            _Instrumento.setImagen(InstrumentoDTO.getImagen());
        }
        return repositorio.save(instrumentoMapper.toInstrumento(_Instrumento));
    }

    //Método con el que se hará el GET (READ)
    public List<Instrumento> listaInstrumentos()
    {
        return repositorio.findAll();
    }

    //Método con el que se borrará una Instrumento por su ID
    public void eliminarInstrumentoPorId(UUID id)
    {
        repositorio.deleteById(id);
    }

    //Método con el que se hará el GET a partir del ID
    public Optional<Instrumento> listaInstrumentosPorId(UUID id)
    {
        return repositorio.findById(id);
    }
}
