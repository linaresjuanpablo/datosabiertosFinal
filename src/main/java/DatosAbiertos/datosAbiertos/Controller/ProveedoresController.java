package DatosAbiertos.datosAbiertos.Controller;

import DatosAbiertos.datosAbiertos.Dto.DepartamentoResponse;
import DatosAbiertos.datosAbiertos.Dto.NitRespnse;
import DatosAbiertos.datosAbiertos.Service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/data/proveedor")

public class ProveedoresController {

    @Autowired
    private IProveedoresService iProveedoresService;

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<DepartamentoResponse> findByDepartamento(@PathVariable String departamento){
        DepartamentoResponse response = iProveedoresService.findByDepartamento(departamento);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nit/{nit}")
    public ResponseEntity<NitRespnse> findByNit(@PathVariable String nit){
        NitRespnse response = iProveedoresService.findByNit(nit);
        return ResponseEntity.ok(response);
    }


}
