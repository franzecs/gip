package com.ikytus.gip.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column
    private String matricula;
    
    @Column
    @NotBlank(message="Favor informar o nome do Aluno")
    private String nome;
    
    @Column
    @NotBlank(message="Favor informar a Faculdade")
    private String faculdade;
    
    @Column
    @Email
    @NotBlank(message="Favor informar o E-mail")
    private String emailprincipal;
    
    @Column
    @Email
    private String emailsecundario;
    
    @Column
    @NotBlank(message="Favor informar o celular")
    private String celular;
   
    @Column
    private String fixo;
    
    @Column
    private String outro;
    
    @OneToMany(mappedBy = "aluno", cascade=CascadeType.ALL)
    private List<Estagio> estagio;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailprincipal() {
		return emailprincipal;
	}

	public void setEmailprincipal(String emailprincipal) {
		this.emailprincipal = emailprincipal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}
	

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public String getEmailsecundario() {
		return emailsecundario;
	}

	public void setEmailsecundario(String emailsecundario) {
		this.emailsecundario = emailsecundario;
	}

	public List<Estagio> getEstagio() {
		return estagio;
	}

	public void setEstagio(List<Estagio> estagio) {
		this.estagio = estagio;
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
		Aluno other = (Aluno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
