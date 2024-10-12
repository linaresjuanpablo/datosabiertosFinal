package DatosAbiertos.datosAbiertos.Service;

import DatosAbiertos.datosAbiertos.Dto.ProponenteResponse;

public interface IProponentesService {

    ProponenteResponse findByNitPro (String nitPro);
}
