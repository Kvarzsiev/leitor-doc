package com.leitordoc.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	//Auto-Generated serialVersionUID
	private static final long serialVersionUID = 7100093916797224393L;
	
	public JPanel bordas, campos, botoes;
	public JButton cadastrar, entrar;
	public JLabel nome, senha;
	public JTextField campoNome;
	public JPasswordField campoSenha;
	
	public Login() {
		super("Leitor Doc - Tela Incial");
		this.setSize(900, 450);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		entrar = new JButton("Entrar");
		entrar.addActionListener(this);
		
		bordas = new JPanel(new BorderLayout());
		botoes = new JPanel(new FlowLayout());
		
		nome = new JLabel("Nome / E-mail");
		senha = new JLabel("Senha");
		
		campoNome = new JTextField();
		campoSenha = new JPasswordField(30);

		
		campos = new JPanel(new GridLayout(4, 1));
		campos.add(nome);
		campos.add(campoNome);
		campos.add(senha);
		campos.add(campoSenha);
		
		botoes.add(cadastrar);
		botoes.add(entrar);
		
		bordas.add(campos, BorderLayout.CENTER);
		bordas.add(botoes, BorderLayout.SOUTH);
		
		this.getContentPane().add(bordas);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);
	}
	
	public void acaoCadastrar() {
		System.out.println("Cadastrar");
	}
	
	public void acaoEntrar() {
		System.out.println("Entrar");
	}
	
	public void alturaCampo() {
		int altura = 10;
		
		JTextField alturacampo = new JTextField();
		alturacampo.setBounds(10, 10, 10, altura);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			this.acaoCadastrar();
		} else {
			if (e.getSource() == entrar) {
				this.acaoEntrar();
			}
		}
	}
	
}
