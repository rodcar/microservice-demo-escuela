package com.certus.demoEscuela.respositories;

import com.certus.demoEscuela.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
