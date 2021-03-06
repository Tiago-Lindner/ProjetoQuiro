package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Paciente extends PanacheEntity{
    
    //private static final long serialVersionUID = 1L;
	
	// ver jwt

	//Atributos
	/*
    @Id
	@Column(name="IdPessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	*/
	private String nome;
	private String cpf;
	private String email;
	private String userLogin;
	private String userSenha;
	//private String tipoLogin;
	private String telefone;
	@OneToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	private String endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Pac")
	private Set<Consulta> consultas;

	
	//Contrutores
	//ver o construtor sem parametros
	public Paciente() {};
	public Paciente(String nome) {
		this.nome = nome;
	};
	
	public Paciente(String nome, String cpf, String email, String userLogin, String userSenha, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
	}
	
	public Paciente(String nome, String cpf, String email, String userLogin, String userSenha, String endereco, Set<Consulta> consultas) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
		this.consultas = consultas;
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public String getUserSenha() {
		return userSenha;
	}
	public void setUserSenha(String userSenha) {
		this.userSenha = userSenha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefones(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public void addConsulta(Consulta consulta) {
	}


// funcoes
/*
login

criar usuario
marcar consulta
checar agenda



*/ 

    
}
