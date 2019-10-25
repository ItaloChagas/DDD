package br.com.projeto.principal;

import javax.swing.JOptionPane;

import br.com.projeto.dao.UsuarioDAO;

public class TesteApagarUsuario {

	public static void main(String[] args) {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			int codigo = Integer.parseInt
					(JOptionPane.showInputDialog
					("Digite o c�digo: "));
			int resultado = dao.killUser(codigo);
			if (resultado==0) {
				System.out.println("Usu�rio n�o encontrado");
			}else {
				System.out.println("Killed...");
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
