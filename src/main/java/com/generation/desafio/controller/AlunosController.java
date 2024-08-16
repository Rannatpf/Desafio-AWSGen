package com.generation.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.desafio.model.Alunos;
import com.generation.desafio.repository.AlunosRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunosController {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	 @GetMapping
	    public ResponseEntity<List<Alunos>> getAll() {
	        return ResponseEntity.ok(alunosRepository.findAll());
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Alunos> getById(@PathVariable Long id) {
	        return alunosRepository.findById(id)
	                .map(resposta -> ResponseEntity.ok(resposta))
	                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	 @PostMapping
	    public ResponseEntity<Alunos> postAluno(@Validated @RequestBody Alunos aluno) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(alunosRepository.save(aluno));
	    }
	 
	 @PutMapping
	    public ResponseEntity<Alunos> putAluno(@Validated @RequestBody Alunos aluno) {
	        if (aluno.getId() == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	        return alunosRepository.findById(aluno.getId())
	                .map(resposta -> ResponseEntity.ok(alunosRepository.save(aluno)))
	                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
	     Optional<Alunos> aluno = alunosRepository.findById(id);
	     if (aluno.isPresent()) {
	         alunosRepository.deleteById(id);
	         return ResponseEntity.noContent().build();
	     } else {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }

	 }
}
