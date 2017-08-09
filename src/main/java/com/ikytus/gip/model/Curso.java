package com.ikytus.gip.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="curso")
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message="Favor informar o nome do Curso")
	private String nome;
	
	private String coordenador;
	
	@NotNull(message="Favor informar a situação junto ao MEC")
	private String mec;
	
	private String horarioseg;
	private String horarioter;
	private String horarioqua;
	private String horarioqui;
	private String horariosex;
			
	@NotNull(message="Favor informar a IES")
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "ies")
	private Ies ies;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_professor", 
    			joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "codigo"), 
    			inverseJoinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "codigo"))
    private List<Professor> professores;
	
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

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getMec() {
		return mec;
	}

	public void setMec(String mec) {
		this.mec = mec;
	}

	public Ies getIes() {
		return ies;
	}

	public void setIes(Ies ies) {
		this.ies = ies;
	}
	

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public String getHorarioseg() {
		return horarioseg;
	}

	public void setHorarioseg(String horarioseg) {
		this.horarioseg = horarioseg;
	}

	public String getHorarioter() {
		return horarioter;
	}

	public void setHorarioter(String horarioter) {
		this.horarioter = horarioter;
	}

	public String getHorarioqua() {
		return horarioqua;
	}

	public void setHorarioqua(String horarioqua) {
		this.horarioqua = horarioqua;
	}

	public String getHorarioqui() {
		return horarioqui;
	}

	public void setHorarioqui(String horarioqui) {
		this.horarioqui = horarioqui;
	}

	public String getHorariosex() {
		return horariosex;
	}

	public void setHorariosex(String horariosex) {
		this.horariosex = horariosex;
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
