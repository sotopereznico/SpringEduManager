package cl.unitec.springedumanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;


    public Curso() {
    }

    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    @ManyToMany(mappedBy = "cursos")
    private java.util.List<Estudiante> estudiantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public java.util.List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(java.util.List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


}