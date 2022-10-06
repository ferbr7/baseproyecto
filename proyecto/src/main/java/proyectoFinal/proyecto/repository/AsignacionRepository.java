package proyectoFinal.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectoFinal.proyecto.entity.Asignacion;

@Repository("asignacionRepository")
public interface AsignacionRepository extends JpaRepository<Asignacion,Serializable>{

}
