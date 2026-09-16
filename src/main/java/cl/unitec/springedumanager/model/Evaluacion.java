package cl.unitec.springedumanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Evaluacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Double nota;
	private LocalDate fecha;
	private Integer ponderacion;


	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;


	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Evaluacion() {
	}

	public Evaluacion(String titulo, Double nota, Estudiante estudiante, Curso curso) {
		this.titulo = titulo;
		this.nota = nota;
		this.estudiante = estudiante;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}

	
}