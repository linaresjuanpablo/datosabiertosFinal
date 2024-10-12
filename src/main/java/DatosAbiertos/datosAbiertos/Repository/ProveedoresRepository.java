package DatosAbiertos.datosAbiertos.Repository;

import DatosAbiertos.datosAbiertos.Dto.DepartamentoResponseDto;
import DatosAbiertos.datosAbiertos.Model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {

    @Query(value = "SELECT new DatosAbiertos.datosAbiertos.Dto.DepartamentoResponseDto(p.nombre, p.codigo, p.municipio) " +
            "FROM Proveedores p WHERE p.departamento = :departamento")
    List<DepartamentoResponseDto> findByDepartamento(@Param("departamento") String departamento);

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    List<Proveedores>findByNit(@Param("nit")String nit);
}
