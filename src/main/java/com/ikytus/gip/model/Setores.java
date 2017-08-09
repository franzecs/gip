package com.ikytus.gip.model;

public enum Setores {

	ATENDIMENTO_ACADÊMICO("Atendimento Acadêmico"),
	BIBLIOTECA("Biblioteca"), 
	COORDENAÇÃO_CURSO("Coordenação de Curso"),
	COORDENAÇÃO_PEDAGÓGICA("Coordenação Pedagógica"), 
	DIREÇÃO("Direção"),
	DP("Departamento Pessoal"),
	FINANCEIRO("Financeiro"), 
	GERENCIA_UNIDADE("Gerencia de Unidade"),
	LABORATÓRIOS("Laboratórios"), 
	NPJ("Núcleo de Prática Jurídica");

	private String descricao;
	
	Setores(String descricao){
		this.descricao=descricao;
	}
		
	public String getDescricao() {
		return descricao;
	}
}
