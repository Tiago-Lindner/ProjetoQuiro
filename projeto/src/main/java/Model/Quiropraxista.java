package Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Quiropraxista extends Pessoa{
    
    //Atributos
	
	private String crm;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Quiro")
	private Set<Consulta> consultas;

	//Contrutores
	public Quiropraxista() {};
	public Quiropraxista(int codigo, String nome, String cpf, String email, String userLogin, String userSenha,
			String tipoLogin, Set<Telefone> telefones, Endereco endereco, String crm, Set<Consulta> consultas) {
		super(codigo, nome, cpf, email, userLogin, userSenha, tipoLogin, telefones, endereco);
		this.crm = crm;
		this.consultas = consultas;
	}
	
	//Getters e Setters
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
}
