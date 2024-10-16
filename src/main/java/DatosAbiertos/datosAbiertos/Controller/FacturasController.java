package DatosAbiertos.datosAbiertos.Controller;

import DatosAbiertos.datosAbiertos.Dto.FacturasResponse;
import DatosAbiertos.datosAbiertos.Service.IFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/data/")

public class FacturasController {
    @Autowired
    private IFacturasService iFacturasService;

    @GetMapping("facturas/{ano}/{mes}/{dia}")
    public ResponseEntity<FacturasResponse> findByFacturasDia(@PathVariable String ano,
                                                              @PathVariable String mes, @PathVariable String dia){
        FacturasResponse response = iFacturasService.findByFacturasDia(ano, mes, dia);
        return ResponseEntity.ok(response);
    }

    @GetMapping("facturas/{ano}/{mes}")
    public ResponseEntity<FacturasResponse> findByFacturasMes(@PathVariable String ano, @PathVariable String mes){
        FacturasResponse response = iFacturasService.findByFacturasMes(ano, mes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("facturas/{ano}")
    public ResponseEntity<FacturasResponse> findByFacturasMes(@PathVariable String ano){
        FacturasResponse response = iFacturasService.findByFacturasAno(ano);
        return ResponseEntity.ok(response);
    }


}
