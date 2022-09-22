package com.leitordoc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame implements ActionListener{
	
	public JPanel contentPane, PainelSuperior, PainelCentral, PainelInferior;
	public JButton documentos, contatos, consulta, configuracao, start;
	public JLabel user;
	public Box verticalBox;
	public JTextPane texto1, texto2, texto3;

	public Home() {
		super("Leitor Doc - Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		this.setSize(1280, 960);
		
		PainelSuperior = new JPanel();
		FlowLayout fl_PainelSuperior = (FlowLayout) PainelSuperior.getLayout();
		fl_PainelSuperior.setVgap(40);
		fl_PainelSuperior.setHgap(50);
		PainelSuperior.setBackground(new Color(128, 128, 128));
		getContentPane().add(PainelSuperior, BorderLayout.NORTH);
		
		user = new JLabel("Nome");
		user.setIcon(new ImageIcon(Home.class.getResource("/com/leitordoc/views/icons/user.png")));
		PainelSuperior.add(user);
		
		documentos = new JButton("Documentos");
		documentos.addActionListener(this);
		documentos.setBackground(new Color(128, 128, 128));
		PainelSuperior.add(documentos);
		
		contatos = new JButton("Contatos");
		contatos.addActionListener(this);
		contatos.setBackground(new Color(128, 128, 128));
		PainelSuperior.add(contatos);
		
		consulta = new JButton("Consulta");
		consulta.addActionListener(this);
		consulta.setBackground(new Color(128, 128, 128));
		PainelSuperior.add(consulta);
		
		configuracao = new JButton("Configurações");
		configuracao.setIcon(new ImageIcon(Home.class.getResource("/com/leitordoc/views/icons/configuracoes.png")));
		configuracao.addActionListener(this);
		configuracao.setBackground(new Color(128, 128, 128));
		PainelSuperior.add(configuracao);
		
		PainelCentral = new JPanel();
		PainelCentral.setBackground(new Color(192, 192, 192));
		PainelCentral.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(PainelCentral, BorderLayout.CENTER);
		FlowLayout fl_PainelCentral = new FlowLayout(FlowLayout.CENTER, 1000, 150);
		fl_PainelCentral.setAlignOnBaseline(true);
		PainelCentral.setLayout(fl_PainelCentral);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		verticalBox.setBorder(null);
		PainelCentral.add(verticalBox);
		
		texto1 = new JTextPane();
		texto1.setBackground(new Color(192, 192, 192));
		texto1.setEditable(false);
		texto1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 35));
		texto1.setText("Processe seus boletos.");
		verticalBox.add(texto1);
		
		texto2 = new JTextPane();
		texto2.setBackground(new Color(192, 192, 192));
		texto2.setEditable(false);
		texto2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 35));
		texto2.setText("Categorize e organize seus documentos.");
		verticalBox.add(texto2);
		
		texto3 = new JTextPane();
		texto3.setBackground(new Color(192, 192, 192));
		texto3.setEditable(false);
		texto3.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 35));
		texto3.setText("Envie os dados por email.");
		verticalBox.add(texto3);
		
		PainelInferior = new JPanel();
		PainelInferior.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout = (FlowLayout) PainelInferior.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setHgap(50);
		flowLayout.setAlignOnBaseline(true);
		getContentPane().add(PainelInferior, BorderLayout.SOUTH);
		
		start = new JButton("Comece aqui!");
		start.addActionListener(this);
		start.setFont(new Font("Tahoma", Font.PLAIN, 20));
		start.setBackground(new Color(192, 192, 192));
		PainelInferior.add(start);
		
		
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
		if (e.getSource() == documentos) {
			this.acaoDocumentos();
		} else {
			if (e.getSource() == consulta) {
				this.acaoConsulta();
			} else {
				if (e.getSource() == contatos) {
					this.acaoContatos();
				} else {
					if (e.getSource() == configuracao) {
						this.acaoConfiguracao();
					} else {
						if (e.getSource() == start) {
							this.acaoStart();
						}
					}
				}
			}
		}
	}
	
	// Ação dos botões
	public void acaoDocumentos() {
		System.out.println("documentos");
	}
	public void acaoConsulta() {
		System.out.println("consulta");
	}
	public void acaoContatos() {
		System.out.println("contatos");
	}
	public void acaoConfiguracao() {
		System.out.println("configuracao");
	}
	public void acaoStart() {
		System.out.println("start");
	}

}