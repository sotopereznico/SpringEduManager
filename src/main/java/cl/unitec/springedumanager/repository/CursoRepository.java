package cl.unitec.springedumanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.unitec.springedumanager.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}