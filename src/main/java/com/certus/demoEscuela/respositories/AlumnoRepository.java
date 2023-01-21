package com.certus.demoEscuela.respositories;

import com.certus.demoEscuela.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
