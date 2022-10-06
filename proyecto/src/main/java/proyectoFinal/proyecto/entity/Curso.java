package proyectoFinal.proyecto.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6120125315863000334L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcurso")
	private Integer idcurso;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "seccion")
	private String seccion;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "dia")
	private Date dia;
	
	@Column(name = "hora_inicio")
	private Time horaInicio;
	
	@Column(name = "hora_fin")
	private Time horaFin;
	
	@Column(name = "profesor_usuario")
	private Integer profesorUsuario;
	
	@OneToMany(mappedBy = "cursoIdcurso")
	private List<Asignacion> asignacionList;

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Integer getProfesorUsuario() {
		return profesorUsuario;
	}

	public void setProfesorUsuario(Integer profesorUsuario) {
		this.profesorUsuario = profesorUsuario;
	}

	public List<Asignacion> getAsignacionList() {
		return asignacionList;
	}

	public void setAsignacionList(List<Asignacion> asignacionList) {
		this.asignacionList = asignacionList;
	}
	
	
}
