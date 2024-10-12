package DatosAbiertos.datosAbiertos.Service.Impl;

import DatosAbiertos.datosAbiertos.Dto.ProponenteResponse;
import DatosAbiertos.datosAbiertos.Dto.ProponenteResponseDto;
import DatosAbiertos.datosAbiertos.Message.Message;
import DatosAbiertos.datosAbiertos.Model.Proponentes;
import DatosAbiertos.datosAbiertos.Repository.ProponentesRepository;
import DatosAbiertos.datosAbiertos.Service.IProponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProponenteServiceImpl implements IProponentesService {

    @Autowired
    private ProponentesRepository proponentesRepository;

    @Override
    public ProponenteResponse findByNitPro(String nitPro) {
        ProponenteResponse proponenteResponse = new ProponenteResponse("");
        List<ProponenteResponseDto> proponenteResponseDtos = new ArrayList<>();
        List<Proponentes> list = proponentesRepository.findByNitPro(nitPro);
        if (list == null || list.isEmpty()){
            //System.out.println("no hay datos");
            proponenteResponse.setMensaje(Message.PROPONENTEVACIO);
        }

        for (Proponentes dto: list){
            ProponenteResponseDto responseDto = new ProponenteResponseDto("","","",
                    "","","","","","");
            responseDto.setId_procedimiento(dto.getId_procedimiento());
            responseDto.setFecha_publicacion(dto.getFecha_publicacion());
            responseDto.setNombre_procedimiento(dto.getNombre_procedimiento());
            responseDto.setNit_entidad(dto.getNit_entidad());
            responseDto.setCodigo_entidad(dto.getCodigo_entidad());
            responseDto.setEntidad_compradora(dto.getEntidad_compradora());
            responseDto.setProveedor(dto.getProveedor());
            responseDto.setNit_proveedor(dto.getNit_proveedor());
            responseDto.setCodigo_proveedor(dto.getCodigo_proveedor());

            proponenteResponseDtos.add(responseDto);
        }
        proponenteResponse.setProponenteResponseDtos(proponenteResponseDtos);

        return proponenteResponse;
    }
}
