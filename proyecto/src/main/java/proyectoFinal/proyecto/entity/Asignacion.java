package proyectoFinal.proyecto.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignacion")
public class Asignacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1524758660314300659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idasignacion")
	private Integer idasignacion;
	
	@Column(name = "nota_alumno")
	private Integer notaAlumno;
	
	@Column(name = "curso_idcurso")
	private Integer cursoIdcurso;
	
	@Column(name = "alumno_carne")
	private Integer alumnoCarne;

	public Integer getIdasignacion() {
		return idasignacion;
	}

	public void setIdasignacion(Integer idasignacion) {
		this.idasignacion = idasignacion;
	}

	public Integer getNotaAlumno() {
		return notaAlumno;
	}

	public void setNotaAlumno(Integer notaAlumno) {
		this.notaAlumno = notaAlumno;
	}

	public Integer getCursoIdcurso() {
		return cursoIdcurso;
	}

	public void setCursoIdcurso(Integer cursoIdcurso) {
		this.cursoIdcurso = cursoIdcurso;
	}

	public Integer getAlumnoCarne() {
		return alumnoCarne;
	}

	public void setAlumnoCarne(Integer alumnoCarne) {
		this.alumnoCarne = alumnoCarne;
	}
	
	
}
