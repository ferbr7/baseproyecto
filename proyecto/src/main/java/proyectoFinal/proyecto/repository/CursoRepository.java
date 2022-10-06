package proyectoFinal.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectoFinal.proyecto.entity.Curso;

@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso,Serializable>{

	public List<Curso> findByNombreAndSeccion(String nombre, String seccion);
}
