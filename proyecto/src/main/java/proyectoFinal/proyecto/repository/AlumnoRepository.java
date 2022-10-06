package proyectoFinal.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectoFinal.proyecto.entity.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno,Serializable> {

	public List<Alumno> findByNombreAndApellido(String nombre, String apellido);
	
	public List<Alumno> findByCarneAndContrasenia(Integer carne, String contrasenia);
}
