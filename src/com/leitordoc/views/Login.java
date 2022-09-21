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


public class Login extends JFrame implements ActionListener{
	
	public JPanel contentPane, PainelSuperior, PainelCentral, PainelInferior, PainelEsquerdo, PainelDireito;
	public JLabel user, nome, senha;
	public JTextField campoNome, campoEmail;
	public JButton cadastrar, entrar;
	public JPasswordField campoSenha;
	
	public Login() {
		super("Leitor Doc - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		this.setSize(1280, 960);
		
		PainelSuperior = new JPanel();
		FlowLayout fl_PainelSuperior = (FlowLayout) PainelSuperior.getLayout();
		fl_PainelSuperior.setVgap(40);
		fl_PainelSuperior.setHgap(50);
		PainelSuperior.setBackground(new Color(128, 128, 128));
		getContentPane().add(PainelSuperior, BorderLayout.NORTH);
		
		user = new JLabel("");
		user.setIcon(new ImageIcon(Login.class.getResource("/com/leitordoc/views/icons/user.png")));
		PainelSuperior.add(user);
		
		GridLayout gl_PainelCentral = new GridLayout(4, 1);
		PainelCentral = new JPanel(gl_PainelCentral);
		PainelCentral.setBackground(new Color(192, 192, 192));
		PainelCentral.setBorder(null);
		getContentPane().add(PainelCentral, BorderLayout.CENTER);
		
		nome = new JLabel("Nome / Email");
		nome.setBackground(new Color(192, 192, 192));
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		PainelCentral.add(nome);
		
		campoNome = new JTextField();
		campoNome.setHorizontalAlignment(SwingConstants.CENTER);
		campoNome.setColumns(15);
		PainelCentral.add(campoNome);
		
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
		flowLayout.setVgap(200);
		getContentPane().add(PainelInferior, BorderLayout.SOUTH);
		
		cadastrar = new JButton("cadastrar");
		cadastrar.setBackground(new Color(192, 192, 192));
		cadastrar.addActionListener(this);
		cadastrar.setVerticalAlignment(SwingConstants.BOTTOM);
		cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cadastrar.setHorizontalAlignment(SwingConstants.RIGHT);
		PainelInferior.add(cadastrar);
		
		entrar = new JButton("entrar");
		entrar.setBackground(new Color(192, 192, 192));
		entrar.addActionListener(this);
		entrar.setVerticalAlignment(SwingConstants.BOTTOM);
		entrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		entrar.setHorizontalAlignment(SwingConstants.RIGHT);
		PainelInferior.add(entrar);
		
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
		if (e.getSource() == cadastrar) {
			this.acaoCadastrar();
		} else {
			if (e.getSource() == entrar) {
				this.acaoEntrar();
			}
		}
	}

	public void acaoCadastrar() {
		System.out.println("cadastrar");
	}
	public void acaoEntrar() {
		System.out.println("entrar");
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}
	
	
}