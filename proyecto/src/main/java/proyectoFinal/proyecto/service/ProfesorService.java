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

import proyectoFinal.proyecto.entity.Curso;
import proyectoFinal.proyecto.entity.Profesor;
import proyectoFinal.proyecto.repository.CursoRepository;
import proyectoFinal.proyecto.repository.ProfesorRepository;

@RestController
@RequestMapping("/profesor")
@CrossOrigin

public class ProfesorService {

	@Autowired
	ProfesorRepository profesorRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping(path ="/buscar")
	public List<Profesor> buscar(){	
		return profesorRepository.findAll();
	}
	@PostMapping(path ="/guardar")
	public Profesor guardar(@RequestBody Profesor profesor) {
		List<Curso> curso = profesor.getCursoList();
		profesor.setCursoList(null);
		profesorRepository.save(profesor);
		for(Curso curs: curso) {
			curs.setProfesorUsuario(profesor.getUsuario());
		}
		cursoRepository.saveAll(curso);
		profesor.setCursoList(curso);
		return profesor;
	}
	@DeleteMapping(path ="/eliminar/{usuario}")
	public void eliminar(@PathVariable ("usuario") Integer usuario) {
		
		Optional<Profesor> profesor = profesorRepository.findById(usuario);
		if(profesor.isPresent()) {
			cursoRepository.deleteAll(profesor.get().getCursoList());
			profesorRepository.delete(profesor.get());
		}
	}
	
	@GetMapping(path ="/buscar/por/{nombre}/{apellido}")
	public List<Profesor> buscarPorNombreYApellido(@PathVariable String nombre, @PathVariable String apellido){
		return profesorRepository.findByNombreAndApellido(nombre, apellido);
	}
	
	@PostMapping(path = "/login")
	public List <Profesor> login(@RequestBody Profesor profesor){
		return profesorRepository.findByUsuarioAndContrasenia(profesor.getUsuario(), profesor.getContrasenia());
	}
	@PostMapping(path ="/editar/{usuario}")
	public void editar (@PathVariable ("usuario") Integer usuario) {
		Optional<Profesor> profesor = profesorRepository.findById(usuario);
		if(profesor.isPresent()) {
			profesorRepository.save(profesor.get());
		}
	}
	
}
