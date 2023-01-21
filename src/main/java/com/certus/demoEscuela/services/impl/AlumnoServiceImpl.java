package com.certus.demoEscuela.services.impl;

import com.certus.demoEscuela.entities.Alumno;
import com.certus.demoEscuela.respositories.AlumnoRepository;
import com.certus.demoEscuela.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() throws Exception {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno save(Alumno alumno) throws Exception {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) throws Exception {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Optional<Alumno> findById(Long id) throws Exception {
        return alumnoRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) throws Exception {
        return alumnoRepository.existsById(id);
    }
}
