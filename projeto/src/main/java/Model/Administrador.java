package Model;

import java.util.Set;

public class Administrador extends Pessoa{

    //Contrutores
	public Administrador() {};
	//Precisa de um construtor se tudo é igual?
	public Administrador(int codigo, String nome, String cpf, String email, String userLogin, String userSenha,
			String tipoLogin, Set<Telefone> telefones, Endereco endereco) {
		super(codigo, nome, cpf, email, userLogin, userSenha, tipoLogin, telefones, endereco);
	}

    //funções
    
}