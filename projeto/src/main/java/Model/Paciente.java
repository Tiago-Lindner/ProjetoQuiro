package Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Paciente extends Pessoa{
    
    //Atributos
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Pac")
	private Set<Consulta> consultas;

	//Contrutores
	public Paciente() {};
	public Paciente(String nome, String cpf, String email, String userLogin, String userSenha,
			String tipoLogin, Endereco endereco) {
		super(nome, cpf, email, userLogin, userSenha, tipoLogin, endereco);
	}
	
	public Paciente(int codigo, String nome, String cpf, String email, String userLogin, String userSenha,
			String tipoLogin, Set<Telefone> telefones, Endereco endereco) {
		super(codigo, nome, cpf, email, userLogin, userSenha, tipoLogin, telefones, endereco);
	}
	
	public Paciente(int codigo, String nome, String cpf, String email, String userLogin, String userSenha,
			String tipoLogin, Set<Telefone> telefones, Endereco endereco, Set<Consulta> consultas) {
		super(codigo, nome, cpf, email, userLogin, userSenha, tipoLogin, telefones, endereco);
		this.consultas = consultas;
	}
	
	//getters e setters
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}

}
