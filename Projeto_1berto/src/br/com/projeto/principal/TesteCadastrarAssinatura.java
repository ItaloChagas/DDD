package br.com.projeto.principal;

import br.com.fiap.entrada.Magica;
import br.com.projeto.beans.Assinatura;
import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.AssinaturaDAO;

public class TesteCadastrarAssinatura {

	public static void main(String[] args) {
		AssinaturaDAO dao = null;
		try {
			dao = new AssinaturaDAO();
			Assinatura a = new Assinatura();
			a.setCodigo(Magica.i("Código: "));
			a.setData(Magica.t("Data: "));
			a.setTipo(Magica.t("Tipo: "));
			a.setValor(Magica.d("Valor: "));
			Usuario u = new Usuario();
			u.setCodigo(Magica.i("Código: "));
			u.setNome(Magica.t("Login: "));
			u.setSenha(Magica.t("Senha: "));
			a.setUsuario(u);
			if (dao.addAssinatura(a)==0) {
				System.out.println("Não Gravou!");
			}else {
				System.out.println("Gravado com sucesso!");
			}
			
			if (dao.addAssinatura(new Assinatura(
					Magica.i("Código"), 
					Magica.t("Tipo"), 
					Magica.d("Valor"), 
					Magica.t("Data"), 
					new Usuario(
							Magica.i("Código Usuário:"),
							Magica.t("Login: "),
							Magica.t("Senha: ")
							)
					))==0) {
				System.out.println("Não gravou");
			}else {
				System.out.println("Gravou");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
