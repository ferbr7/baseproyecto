package proyectoFinal.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectoFinal.proyecto.entity.Asignacion;
import proyectoFinal.proyecto.entity.Curso;
import proyectoFinal.proyecto.repository.AsignacionRepository;
import proyectoFinal.proyecto.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
@CrossOrigin

public class CursoService {

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	AsignacionRepository asignacionRepository;
	
	@GetMapping(path ="/buscar")
	public List<Curso> buscar(){	
		return cursoRepository.findAll();
	}
	
	@PostMapping(path ="/guardar")
	public Curso guardar(@RequestBody Curso curso) {
		List<Asignacion> asignacion = curso.getAsignacionList();
		curso.setAsignacionList(null);
		cursoRepository.save(curso);
		for(Asignacion asig: asignacion) {
			asig.setCursoIdcurso(curso.getIdcurso());
		}
		asignacionRepository.saveAll(asignacion);
		curso.setAsignacionList(asignacion);
		return curso;
	}
	
	@DeleteMapping(path ="/eliminar/{idcurso}")
	public void eliminar(@PathVariable ("idcurso") Integer idcurso) {
		
		Optional<Curso> curso = cursoRepository.findById(idcurso);
		if(curso.isPresent()) {
			asignacionRepository.deleteAll(curso.get().getAsignacionList());
			cursoRepository.delete(curso.get());
		}
	}
	@GetMapping(path ="/buscar/por/{nombre}/{seccion}")
	public List<Curso> buscarPorNombreYSeccion(@PathVariable String nombre, @PathVariable String seccion){
		return cursoRepository.findByNombreAndSeccion(nombre, seccion);
	}
}
