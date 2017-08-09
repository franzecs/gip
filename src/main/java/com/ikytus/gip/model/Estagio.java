package com.ikytus.gip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "estagio")
public class Estagio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "aluno")
	private Aluno aluno;

	@Column
	private String periodo;
	
	@Column	
	@NotBlank(message = "Favor informar o semestre atual do aluno")
	private String semestreatual;

	@Column
	@NotBlank(message = "Favor informar o tipo do estágio")
	private String tipoestagio;

	@Column
	@NotBlank(message = "Favor informar o dia do estágio")
	private String diaestagio;

	@Column
	@NotBlank(message = "Favor informar o horário do estágio")
	private String horario;

	@Column
	private String observacao;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datainscricao;

	@Column
	private boolean dp;

	@Column
	private String cargahoraria;

	@Column
	private String professor;

	@Column
	private double nota;

	@Column
	private String situacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSemestreatual() {
		return semestreatual;
	}

	public void setSemestreatual(String semestreatual) {
		this.semestreatual = semestreatual;
	}

	public String getTipoestagio() {
		return tipoestagio;
	}

	public void setTipoestagio(String tipoestagio) {
		this.tipoestagio = tipoestagio;
	}

	public String getDiaestagio() {
		return diaestagio;
	}

	public void setDiaestagio(String diaestagio) {
		this.diaestagio = diaestagio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDatainscricao() {
		return datainscricao;
	}

	public void setDatainscricao(Date datainscricao) {
		this.datainscricao = datainscricao;
	}

	public boolean isDp() {
		return dp;
	}

	public void setDp(boolean dp) {
		this.dp = dp;
	}

	public String getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
		Estagio other = (Estagio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
