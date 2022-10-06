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

import proyectoFinal.proyecto.entity.Alumno;
import proyectoFinal.proyecto.entity.Asignacion;
import proyectoFinal.proyecto.repository.AlumnoRepository;
import proyectoFinal.proyecto.repository.AsignacionRepository;

@RestController
@RequestMapping("/alumno")
@CrossOrigin

public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	AsignacionRepository asignacionRepository;
	
	@GetMapping(path ="/buscar")
	public List<Alumno> buscar(){	
		return alumnoRepository.findAll();
	}
	
	@PostMapping(path ="/guardar")
	
	public Alumno guardar(@RequestBody Alumno alumno) {
		
		List<Asignacion> asignacion = alumno.getAsignacionList();
		alumno.setAsignacionList(null);
		alumnoRepository.save(alumno);
		
		for(Asignacion asig: asignacion) {
			asig.setAlumnoCarne(alumno.getCarne());
		}
		asignacionRepository.saveAll(asignacion);
		alumno.setAsignacionList(asignacion);
		return alumno;
	}
	
	@DeleteMapping(path ="/eliminar/{carne}")
	public void eliminar(@PathVariable ("carne") Integer carne) {
		
		Optional<Alumno> alumno = alumnoRepository.findById(carne);
		if(alumno.isPresent()) {
			asignacionRepository.deleteAll(alumno.get().getAsignacionList());
			alumnoRepository.delete(alumno.get());
		}
	}
	@GetMapping(path ="/buscar/por/{nombre}/{apellido}")
	public List<Alumno> buscarPorNombreYApellido(@PathVariable String nombre, @PathVariable String apellido){
		return alumnoRepository.findByNombreAndApellido(nombre, apellido);
	}
	@PostMapping(path = "/login")
	public List <Alumno> login(@RequestBody Alumno alumno){
		return alumnoRepository.findByCarneAndContrasenia(alumno.getCarne(),alumno.getContrasenia());
	}
}
