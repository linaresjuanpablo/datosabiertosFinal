package DatosAbiertos.datosAbiertos.Service;

import DatosAbiertos.datosAbiertos.Dto.DepartamentoResponse;
import DatosAbiertos.datosAbiertos.Dto.NitRespnse;

public interface IProveedoresService {

    DepartamentoResponse findByDepartamento(String departamento);
    NitRespnse findByNit(String nit);
}
