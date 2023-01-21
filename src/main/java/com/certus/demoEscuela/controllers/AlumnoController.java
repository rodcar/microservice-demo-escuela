package com.certus.demoEscuela.controllers;

import com.certus.demoEscuela.entities.Alumno;
import com.certus.demoEscuela.entities.Curso;
import com.certus.demoEscuela.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> findAll() {
        try {
            List<Alumno> alumnos = alumnoService.findAll();
            return (alumnos.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> findById(@PathVariable("id") Long id){
        try {
            Optional<Alumno> alumno = alumnoService.findById(id);
            return (alumno.isPresent()) ? ResponseEntity.ok(alumno.get()) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> save(@Valid @RequestBody Alumno alumno) {
        try {
            Alumno alumnoRegistrado = alumnoService.save(alumno);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alumnoRegistrado.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Alumno> update(@PathVariable("id") Long id, @Valid @RequestBody Alumno alumno) {
        try {
            alumno.setId(id);
            Alumno alumnoActualizado = alumnoService.update(alumno);
            return ResponseEntity.ok(alumnoActualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable("id") Long id) {
        try {
            alumnoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
