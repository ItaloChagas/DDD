package br.com.projeto.principal;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entrada.Magica;
import br.com.projeto.beans.Usuario;

public class TesteNovoUsuario {

	public static void main(String[] args) {
		try {
			UsuarioBO bo = new UsuarioBO();
			Usuario u = new Usuario();
			u.setCodigo(Magica.i("Código"));
			u.setNome(Magica.t("Nome"));
			u.setSenha(Magica.t("Senha"));
			if (bo.novoUsuario(u)==1) {
			//if (bo.novoUsuario(new Usuario()){
				System.out.println("Cadastrado com sucesso");
			}else {
				System.out.println("Não cadastrado");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
