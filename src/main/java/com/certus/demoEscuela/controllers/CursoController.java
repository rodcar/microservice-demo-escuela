package com.certus.demoEscuela.controllers;

import com.certus.demoEscuela.entities.Alumno;
import com.certus.demoEscuela.entities.Curso;
import com.certus.demoEscuela.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Curso>> findAll() {
        try {
            List<Curso> cursos = cursoService.findAll();
            return (cursos.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(cursos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> findById(@PathVariable("id") Long id){
        try {
            Optional<Curso> curso = cursoService.findById(id);
            return (curso.isPresent()) ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> save(@Valid @RequestBody Curso curso) {
        try {
            Curso cursoRegistrado = cursoService.save(curso);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoRegistrado.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Curso> update(@PathVariable("id") Long id, @Valid @RequestBody Curso curso) {
        try {
            curso.setId(id);
            Curso cursoActualizado = cursoService.update(curso);
            return ResponseEntity.ok(cursoActualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Curso> delete(@PathVariable("id") Long id) {
        try {
            cursoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
