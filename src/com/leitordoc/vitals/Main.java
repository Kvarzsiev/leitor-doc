package com.leitordoc.vitals;


import java.text.ParseException;

import com.leitordoc.views.Cadastro;
import com.leitordoc.views.EditarPerfil;
import com.leitordoc.views.EnviarPDF;
import com.leitordoc.views.EnvioContato;
import com.leitordoc.views.Home;
import com.leitordoc.views.ListarArquivos;
import com.leitordoc.views.ListarContato;
import com.leitordoc.views.ListarLogs;
import com.leitordoc.views.Login;
import com.leitordoc.views.NovoContato;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		new Login();
		new Cadastro();
		new Home();
		new EnviarPDF();
		new EditarPerfil();
		new NovoContato();
		new ListarArquivos();
		new ListarLogs();
		new ListarContato();
		new EnvioContato();
	}

}