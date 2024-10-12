package DatosAbiertos.datosAbiertos.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class NitRespnse {

    private String mensaje;
    List<NitResponseDto> nitResponseDtos;

    public NitRespnse(String mensaje){

        this.mensaje = mensaje;
    }
}
