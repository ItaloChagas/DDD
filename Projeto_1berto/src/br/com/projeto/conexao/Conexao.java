package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection queroConectar() throws Exception {
		return DriverManager.getConnection
		("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","pf0709","fiap19");
	}
}
