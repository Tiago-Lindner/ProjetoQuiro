package model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Consulta extends PanacheEntity {

    //Atributos
	private int codigo;
	private double data;
	private double inicioHora;
	private double fimHora;
	private String situacao; //alterar no diagrama// fazer enum com marcada/confirmada/realizada/cancelada
	
	private Paciente paciente;
	private Quiropraxista quiro;
	
	//Contrutores
	public Consulta() {};
	public Consulta(int codigo, double inicioHora, double fimHora, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.codigo = codigo;
		this.inicioHora = inicioHora;
		this.fimHora = fimHora;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	public Consulta(int codigo, double data, double inicioHora, double fimHora, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.codigo = codigo;
		this.data = data;
		this.inicioHora = inicioHora;
		this.fimHora = fimHora;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	//Getters e Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	
	public double getInicioHora() {
		return inicioHora;
	}
	public void setInicioHora(double inicioHora) {
		this.inicioHora = inicioHora;
	}
	
	public double getFimHora() {
		return fimHora;
	}
	public void setFimHora(double fimHora) {
		this.fimHora = fimHora;
	}
	
	public String getConfirma() {
		return situacao;
	}
	public void setConfirma(String confirma) {
		this.situacao = confirma;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Quiropraxista getQuiro() {
		return quiro;
	}
	public void setQuiro(Quiropraxista quiro) {
		this.quiro = quiro;
	}
}
