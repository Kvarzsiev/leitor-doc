package com.leitordoc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class EnviarPDF extends JFrame implements ActionListener{

	public JPanel contentPane, PainelSuperior;
	public JLabel user;
	public JButton documentos, contatos, consulta, configuracao;
	private JPanel PainelEsquerdo;
	private JLabel formato;
	private JCheckBox check_json;
	private JCheckBox check_xml;
	private JPanel PainelInferior;
	private JButton cancelar_envio;
	private JButton enviar_arquivo;
	private JPanel PainelDireito;
	private JLabel enviar_para;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JPanel PainelCentral;

	public EnviarPDF() {
		super("Leitor Doc - Enviar Arquivo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EnviarPDF.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		this.setSize(1280, 960);
		
		PainelSuperior = new JPanel();
		FlowLayout fl_PainelSuperior = (FlowLayout) PainelSuperior.getLayout();
		fl_PainelSuperior.setVgap(40);
		fl_PainelSuperior.setHgap(50);
		PainelSuperior.setBackground(new Color(128, 128, 128));
		getContentPane().add(PainelSuperior, BorderLayout.NORTH);
		
		user = new JLabel("Nome");
		user.setBackground(new Color(192, 192, 192));
		user.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/user.png")));
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
		
		PainelEsquerdo = new JPanel();
		PainelEsquerdo.setBackground(new Color(192, 192, 192));
		getContentPane().add(PainelEsquerdo, BorderLayout.WEST);
		PainelEsquerdo.setLayout(new BoxLayout(PainelEsquerdo, BoxLayout.X_AXIS));
		
		formato = new JLabel("Formato");
		formato.setBackground(new Color(192, 192, 192));
		formato.setFont(new Font("Tahoma", Font.PLAIN, 30));
		formato.setAlignmentX(90.0f);
		formato.setAlignmentY(20.0f);
		formato.setHorizontalAlignment(SwingConstants.RIGHT);
		PainelEsquerdo.add(formato);
		
		check_xml = new JCheckBox("XML");
		check_xml.setAlignmentY(0.0f);
		check_xml.setBackground(new Color(192, 192, 192));
		check_xml.setFont(new Font("Tahoma", Font.PLAIN, 17));
		check_xml.setHorizontalAlignment(SwingConstants.CENTER);
		PainelEsquerdo.add(check_xml);
		
		check_json = new JCheckBox("JSON");
		check_json.setAlignmentY(0.0f);
		check_json.setBackground(new Color(192, 192, 192));
		check_json.setFont(new Font("Tahoma", Font.PLAIN, 17));
		check_json.setHorizontalAlignment(SwingConstants.CENTER);
		PainelEsquerdo.add(check_json);
		
		PainelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PainelInferior.getLayout();
		flowLayout.setVgap(80);
		flowLayout.setHgap(50);
		PainelInferior.setBackground(new Color(192, 192, 192));
		getContentPane().add(PainelInferior, BorderLayout.SOUTH);
		
		enviar_arquivo = new JButton("Enviar o arquivo");
		enviar_arquivo.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/enviar.png")));
		enviar_arquivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enviar_arquivo.setBackground(new Color(192, 192, 192));
		PainelInferior.add(enviar_arquivo);
		
		cancelar_envio = new JButton("Cancelar o envio");
		cancelar_envio.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/cancelar.png")));
		cancelar_envio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelar_envio.setBackground(new Color(192, 192, 192));
		PainelInferior.add(cancelar_envio);
		
		GridLayout gl_PainelDireito = new GridLayout(3, 1);
		gl_PainelDireito.setVgap(110);
		gl_PainelDireito.setHgap(50);
		PainelDireito = new JPanel(gl_PainelDireito);
		PainelDireito.setBackground(new Color(192, 192, 192));
		getContentPane().add(PainelDireito, BorderLayout.EAST);
		
		enviar_para = new JLabel("Enviar para:               ");
		enviar_para.setHorizontalAlignment(SwingConstants.LEFT);
		enviar_para.setBackground(new Color(192, 192, 192));
		enviar_para.setFont(new Font("Tahoma", Font.PLAIN, 24));
		PainelDireito.add(enviar_para);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "contato 01", "contato 02", "contato 03", "contato 04", "contato 05", "contato 06", "contato 07", "contato 08"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setMaximumRowCount(100);
		PainelDireito.add(comboBox);
		
		textArea = new JTextArea();
		textArea.setRows(50);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textArea.setTabSize(4);
		PainelDireito.add(textArea);
		
		PainelCentral = new JPanel();
		PainelCentral.setBackground(new Color(192, 192, 192));
		getContentPane().add(PainelCentral, BorderLayout.CENTER);
		
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
		// TODO Auto-generated method stub
		
	}

}
