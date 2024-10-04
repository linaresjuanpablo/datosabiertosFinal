package DatosAbiertos.datosAbiertos.Service;

import DatosAbiertos.datosAbiertos.Dto.FacturasResponse;

public interface IFacturasService {

    //FacturasResponse findByFacturasDia(String ano, String mes, String dia);

    FacturasResponse findByFacturasDia(String ano, String mes, String dia);

    FacturasResponse findByFacturasMes(String ano, String mes);

    FacturasResponse findByFacturasAno(String ano);
}
