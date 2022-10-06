package proyectoFinal.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectoFinal.proyecto.entity.Asignacion;
import proyectoFinal.proyecto.repository.AsignacionRepository;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin

public class AsignacionService {
	@Autowired
	AsignacionRepository asignacionRepository;

	@GetMapping(path = "/buscar")
	public List<Asignacion> buscar() {
		return asignacionRepository.findAll();
	}

	@PostMapping(path = "/guardar")

	public Asignacion guardar(@RequestBody Asignacion asignacion) {

		asignacionRepository.save(asignacion);
		return asignacion;
	}
}
