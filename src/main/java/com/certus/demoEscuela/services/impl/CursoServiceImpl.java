package com.certus.demoEscuela.services.impl;

import com.certus.demoEscuela.entities.Curso;
import com.certus.demoEscuela.respositories.CursoRepository;
import com.certus.demoEscuela.services.CrudService;
import com.certus.demoEscuela.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() throws Exception {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) throws Exception {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) throws Exception {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        cursoRepository.deleteById(id);
    }

    @Override
    public Optional<Curso> findById(Long id) throws Exception {
        return cursoRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) throws Exception {
        return cursoRepository.existsById(id);
    }
}
