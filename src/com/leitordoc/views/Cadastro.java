package com.leitordoc.views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Cadastro extends JFrame implements ActionListener{
	
	public JPanel contentPane, PainelSuperior, PainelCentral, PainelInferior, PainelEsquerdo, PainelDireito;
	public JLabel user, nome, email, senha;
	public JTextField campoNome, campoEmail;
	public JPasswordField campoSenha;
	public JButton cancelar, salvar;
	
	public Cadastro() {
		super("Leitor Doc - Cadastro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		this.setSize(1280, 960);
		
		PainelSuperior = new JPanel();
		FlowLayout fl_PainelSuperior = (FlowLayout) PainelSuperior.getLayout();
		fl_PainelSuperior.setVgap(40);
		fl_PainelSuperior.setHgap(50);
		PainelSuperior.setBackground(new Color(128, 128, 128));
		getContentPane().add(PainelSuperior, BorderLayout.NORTH);
		
		user = new JLabel("");
		user.setIcon(new ImageIcon(Cadastro.class.getResource("/com/leitordoc/views/icons/user.png")));
		PainelSuperior.add(user);
		
		PainelCentral = new JPanel(new GridLayout(6, 1));
		PainelCentral.setBackground(new Color(192, 192, 192));
		PainelCentral.setBorder(null);
		getContentPane().add(PainelCentral, BorderLayout.CENTER);
		
		nome = new JLabel("Nome");
		nome.setBackground(new Color(192, 192, 192));
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		PainelCentral.add(nome);
		
		campoNome = new JTextField();
		campoNome.setHorizontalAlignment(SwingConstants.CENTER);
		campoNome.setColumns(15);
		PainelCentral.add(campoNome);
		
		email = new JLabel("Email");
		email.setBackground(new Color(192, 192, 192));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		PainelCentral.add(email);
		
		campoEmail = new JTextField();
		campoEmail.setHorizontalAlignment(SwingConstants.CENTER);
		campoEmail.setColumns(15);
		PainelCentral.add(campoEmail);
		
		senha = new JLabel("Senha");
		senha.setBackground(new Color(192, 192, 192));
		senha.setHorizontalAlignment(SwingConstants.CENTER);
		PainelCentral.add(senha);
		
		campoSenha = new JPasswordField();
		campoSenha.setHorizontalAlignment(SwingConstants.CENTER);
		campoSenha.setColumns(15);
		PainelCentral.add(campoSenha);
		
		PainelInferior = new JPanel();
		PainelInferior.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout = (FlowLayout) PainelInferior.getLayout();
		flowLayout.setVgap(150);
		getContentPane().add(PainelInferior, BorderLayout.SOUTH);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(192, 192, 192));
		cancelar.addActionListener(this);
		cancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelar.setHorizontalAlignment(SwingConstants.RIGHT);
		PainelInferior.add(cancelar);
		
		salvar = new JButton("Salvar");
		salvar.setBackground(new Color(192, 192, 192));
		salvar.addActionListener(this);
		salvar.setVerticalAlignment(SwingConstants.BOTTOM);
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salvar.setHorizontalAlignment(SwingConstants.RIGHT);
		PainelInferior.add(salvar);
		
		// Painel inseridos apenas para estética do programa
		PainelEsquerdo = new JPanel();
		PainelEsquerdo.setBackground(new Color(192, 192, 192));
		FlowLayout fl_PainelEsquerdo = (FlowLayout) PainelEsquerdo.getLayout();
		fl_PainelEsquerdo.setHgap(100);
		fl_PainelEsquerdo.setVgap(50);
		getContentPane().add(PainelEsquerdo, BorderLayout.WEST);
		
		// Painel inseridos apenas para estética do programa
		PainelDireito = new JPanel();
		PainelDireito.setBackground(new Color(192, 192, 192));
		FlowLayout fl_PainelDireito = (FlowLayout) PainelDireito.getLayout();
		fl_PainelDireito.setHgap(100);
		getContentPane().add(PainelDireito, BorderLayout.EAST);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelar) {
			this.acaoCancelar();
		} else {
			if (e.getSource() == salvar) {
				this.acaoSalvar();
			}
		}
	}

	public void acaoCancelar() {
		System.out.println("cancelar");
	}
	public void acaoSalvar() {
		System.out.println("salvar");
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}
	
	
}