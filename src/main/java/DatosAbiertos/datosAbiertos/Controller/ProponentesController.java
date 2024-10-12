package DatosAbiertos.datosAbiertos.Controller;

import DatosAbiertos.datosAbiertos.Dto.ProponenteResponse;
import DatosAbiertos.datosAbiertos.Service.IProponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/data")

public class ProponentesController {
    @Autowired
    private IProponentesService iProponentesService;


    @GetMapping("/proponentes/{nitPro}")
    public ResponseEntity<ProponenteResponse> findByNitPro(@PathVariable String nitPro) {
        ProponenteResponse response = iProponentesService.findByNitPro(nitPro);
        return ResponseEntity.ok(response);
    }
}
