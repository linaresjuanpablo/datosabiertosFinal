package DatosAbiertos.datosAbiertos.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class ProponenteResponse {

    private String mensaje;

    List<ProponenteResponseDto> proponenteResponseDtos;
    public ProponenteResponse(String mensaje){
        this.mensaje = mensaje;
    }
}
