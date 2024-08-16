package com.generation.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_alunos")
public class Alunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!)")
	@Size(min = 2, max = 150, message = "O atributo nome não pode ser nulo")
	private String nome;

    @NotNull(message = "O atributo idade é obrigatório.")
     private Integer idade;

    @NotNull(message = "A nota do 1º semestre é obrigatória.")
    @Min(value = 0, message = "A nota mínima é 0.")
    @Max(value = 10, message = "A nota máxima é 10.")
    private Double nota1Semestre;

    @NotNull(message = "A nota do 2º semestre é obrigatória.")
    @Min(value = 0, message = "A nota mínima é 0.")
    @Max(value = 10, message = "A nota máxima é 10.")
    private Double nota2Semestre;

    @NotBlank(message = "O nome do professor é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome do professor deve ter entre 2 e 100 caracteres.")
    private String nomeProfessor;

    @NotNull(message = "O número da sala é obrigatório.")
    @Min(value = 1, message = "O número da sala deve ser no mínimo 1.")
    @Max(value = 999, message = "O número da sala deve ser no máximo 999.")
    private Integer numeroSala;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getNota1Semestre() {
		return nota1Semestre;
	}

	public void setNota1Semestre(Double nota1Semestre) {
		this.nota1Semestre = nota1Semestre;
	}

	public Double getNota2Semestre() {
		return nota2Semestre;
	}

	public void setNota2Semestre(Double nota2Semestre) {
		this.nota2Semestre = nota2Semestre;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Integer getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(Integer numeroSala) {
		this.numeroSala = numeroSala;
	}
	
	
	
	

}
