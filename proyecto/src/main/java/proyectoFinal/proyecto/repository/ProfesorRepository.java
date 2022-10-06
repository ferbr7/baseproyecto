package proyectoFinal.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectoFinal.proyecto.entity.Profesor;

@Repository("profesorRepository")
public interface ProfesorRepository extends JpaRepository<Profesor,Serializable>{

	public List<Profesor> findByNombreAndApellido(String nombre, String apellido);
	
	public List<Profesor> findByUsuarioAndContrasenia(Integer usuario, String contrasenia);
}
