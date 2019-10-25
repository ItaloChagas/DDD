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
			a.setCodigo(Magica.i("C�digo: "));
			a.setData(Magica.t("Data: "));
			a.setTipo(Magica.t("Tipo: "));
			a.setValor(Magica.d("Valor: "));
			Usuario u = new Usuario();
			u.setCodigo(Magica.i("C�digo: "));
			u.setNome(Magica.t("Login: "));
			u.setSenha(Magica.t("Senha: "));
			a.setUsuario(u);
			if (dao.addAssinatura(a)==0) {
				System.out.println("N�o Gravou!");
			}else {
				System.out.println("Gravado com sucesso!");
			}
			
			if (dao.addAssinatura(new Assinatura(
					Magica.i("C�digo"), 
					Magica.t("Tipo"), 
					Magica.d("Valor"), 
					Magica.t("Data"), 
					new Usuario(
							Magica.i("C�digo Usu�rio:"),
							Magica.t("Login: "),
							Magica.t("Senha: ")
							)
					))==0) {
				System.out.println("N�o gravou");
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
