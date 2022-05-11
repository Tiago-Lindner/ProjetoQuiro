package Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity{
    
    //private static final long serialVersionUID = 1L;
	
	//Atributos
	/*
    @Id
	@Column(name="IdPessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	*/
	private String nome;
	private int codigo;
	private String cpf;
	private String email;
	private String userLogin;
	private String userSenha;
	private String tipoLogin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Telefones_Pessoa")
	private Set<Telefone> telefones;
	@OneToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Endereco endereco;
	
	
	//Contrutores
	//ver o construtor sem parametros
	public Pessoa() {};
	public Pessoa(String nome) {
		this.nome = nome;
	};
	
	public Pessoa(String nome, String cpf, String email, String userLogin, String userSenha, String tipoLogin, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
		this.tipoLogin = tipoLogin;
	}
	
	public Pessoa(int codigo, String nome, String cpf, String email, String userLogin, String userSenha, String tipoLogin, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
		this.tipoLogin = tipoLogin;
	}
	
	public Pessoa(int codigo, String nome, String cpf, String email, String userLogin, String userSenha, String tipoLogin,
			Set<Telefone> telefones, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.telefones = telefones;
		this.endereco = endereco;
		this.tipoLogin = tipoLogin;
	}
	
	
	//Getters e Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
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
	
	public Set<Telefone> getTelefone() {
		return telefones;
	}
	public void setTelefones(Set<Telefone> telefone) {
		this.telefones = telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}
    
}
