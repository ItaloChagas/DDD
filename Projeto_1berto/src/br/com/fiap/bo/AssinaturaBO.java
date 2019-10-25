package br.com.fiap.bo;

import br.com.projeto.beans.Assinatura;
import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.AssinaturaDAO;
import br.com.projeto.dao.UsuarioDAO;

public class AssinaturaBO {

	public static String novaAssinatura(Assinatura objeto) throws Exception{
		//Regra de Negocio
		if (objeto.getCodigo()<=0) {
			return "Código inválido!";
		}
		if (objeto.getValor()<0) {
			return "Valor não pode ser negativo";
		}
		// Requisito Funcional
		if (objeto.getTipo().length()>15) {
			return "Tipo excedeu qtde de caracteres";
		}
		
		// verificando se a FK existe
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario objUsuario = 
				usuDao.getUser(objeto.getUsuario().getCodigo());
		usuDao.encerrar();
		if (objUsuario.getCodigo()==0) {
			return "Usuário não existe";
		}
		
		// verificar se PK não existe
		
		AssinaturaDAO assDao = new AssinaturaDAO();
		Assinatura objAssinatura = 
				assDao.getAssinatura(objeto.getCodigo());
		
		if (objAssinatura.getCodigo()>0) {
			return "Código da Assinatura já existe!!!";
		}
		
		// Padronização
		objeto.setTipo(objeto.getTipo().toUpperCase());
		
		// Finalmente....
		int x = assDao.addAssinatura(objeto);
		assDao.encerrar();
		if (x==0) {
			return "Assinatura não cadastrada";
		}else {
			return "Assinatura cadastrada";
		}
		
	}
	
}
