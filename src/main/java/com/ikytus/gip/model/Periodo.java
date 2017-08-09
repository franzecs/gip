package com.ikytus.gip.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="periodo")
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message="Favor informar o período (ex: AA2P01)")
	private String nome;
	
	private int alunos_sem_ant;
	
	private int alunos_sem_atual;
	
	private boolean calouros;
	
	@NotNull(message="Favor informar a turma")
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "turma")
	private Turma turma;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAlunos_sem_ant() {
		return alunos_sem_ant;
	}

	public void setAlunos_sem_ant(int alunos_sem_ant) {
		this.alunos_sem_ant = alunos_sem_ant;
	}

	public int getAlunos_sem_atual() {
		return alunos_sem_atual;
	}

	public void setAlunos_sem_atual(int alunos_sem_atual) {
		this.alunos_sem_atual = alunos_sem_atual;
	}

	public boolean isCalouros() {
		return calouros;
	}

	public void setCalouros(boolean calouros) {
		this.calouros = calouros;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodo other = (Periodo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
