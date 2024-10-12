package DatosAbiertos.datosAbiertos.Repository;

import DatosAbiertos.datosAbiertos.Model.Proponentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProponentesRepository extends JpaRepository<Proponentes, Long> {

    @Query(value = "SELECT * FROM proponentes WHERE nit_proveedor = :nitPro", nativeQuery = true)
    List<Proponentes> findByNitPro(@Param("nitPro")String nitPro);

}
