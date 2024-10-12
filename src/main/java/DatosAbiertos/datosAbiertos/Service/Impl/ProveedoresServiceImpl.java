package DatosAbiertos.datosAbiertos.Service.Impl;

import DatosAbiertos.datosAbiertos.Dto.DepartamentoResponse;
import DatosAbiertos.datosAbiertos.Dto.DepartamentoResponseDto;
import DatosAbiertos.datosAbiertos.Dto.NitRespnse;
import DatosAbiertos.datosAbiertos.Dto.NitResponseDto;
import DatosAbiertos.datosAbiertos.Message.Message;
import DatosAbiertos.datosAbiertos.Model.Proveedores;
import DatosAbiertos.datosAbiertos.Repository.ProveedoresRepository;
import DatosAbiertos.datosAbiertos.Service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProveedoresServiceImpl implements IProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    //servicio de consulta de proveedores por departamento
    @Override
    public DepartamentoResponse findByDepartamento(String departamento) {
        DepartamentoResponse departamentoResponse = new DepartamentoResponse();
        List<DepartamentoResponseDto> departamentoResponseDto = new ArrayList<>();
        List<DepartamentoResponseDto> list = proveedoresRepository.findByDepartamento(departamento);
        if (list == null || list.isEmpty()){
            System.out.println("no hay datos");
        }

        for (DepartamentoResponseDto dto: list){
            DepartamentoResponseDto responseDto = new DepartamentoResponseDto("","","");
            responseDto.setNombre(dto.getNombre());
            responseDto.setCodigo(dto.getCodigo());
            responseDto.setMunicipio(dto.getMunicipio());

            departamentoResponseDto.add(responseDto);
        }
        departamentoResponse.setDepartamentoResponseDto(departamentoResponseDto);
        return departamentoResponse;
    }

    @Override
    public NitRespnse findByNit(String nit) {
        NitRespnse nitResponse = new NitRespnse("");
        List<NitResponseDto> nitResponseDtos = new ArrayList<>();
        List<Proveedores> list = proveedoresRepository.findByNit(nit);
        if (list == null || list.isEmpty()){
            //System.out.println(Message.VACIOEMPRESA + "La empresa no esta registrada");
            //throw new IllegalArgumentException("La empresa PROVEEDORA no se encuentra registrada");
            //return Message.VACIOEMPRESA;
            nitResponse.setMensaje(Message.VACIOEMPRESAPROVEEDORA);

            return nitResponse;
        }

        NitResponseDto responseDto = new NitResponseDto("","","","","");
        for (Proveedores dto: list){
            responseDto.setNombre(dto.getNombre());
            responseDto.setDepartamento(dto.getMunicipio());
            responseDto.setDepartamento(dto.getDepartamento());
            responseDto.setTipo_empresa(dto.getTipo_empresa());
            responseDto.setNombre_representante_legal(dto.getNombre_representante_legal());

            nitResponseDtos.add(responseDto);
        }
        nitResponse.setNitResponseDtos(nitResponseDtos);
        return nitResponse;
    }
}
