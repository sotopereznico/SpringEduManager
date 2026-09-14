package cl.unitec.springedumanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private Double nota;

    // Relación: Muchas evaluaciones pertenecen a un estudiante
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    // Relación: Muchas evaluaciones pertenecen a un curso
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

    // --- HAZ CLIC DERECHO AQUÍ -> Source -> Generate Getters and Setters... ---
}