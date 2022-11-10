package distribuidos.crud.repository;

import distribuidos.crud.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
