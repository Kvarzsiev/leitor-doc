package com.leitordoc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

public class EnviarPDF extends JFrame implements ActionListener{

	public JPanel painel_esquerdo, painel_direito, painel_central;
	public JLabel icone, nome_usuario, enviar_corpo, enviar_para, formato;
	public JButton bt_documento, bt_contato, bt_consulta, bt_configuracao, bt_enviar, bt_cancelar;
	private JEditorPane corpo_email;
	private JComboBox comboBox;
	private JRadioButton tipo_xml,tipo_json;

	
	public EnviarPDF() {
		super("Leitor Doc - Enviar Arquivo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EnviarPDF.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		this.setSize(1280, 960);
		
		painel_esquerdo = new JPanel();
		painel_esquerdo.setBackground(new Color(128, 128, 128));
		getContentPane().add(painel_esquerdo, BorderLayout.WEST);
		painel_esquerdo.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(22dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(26dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(63dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(122dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(211dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		icone = new JLabel("");
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/user.png")));
		painel_esquerdo.add(icone, "3, 2");
		
		nome_usuario = new JLabel("Nome");
		nome_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nome_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		painel_esquerdo.add(nome_usuario, "3, 4");
		
		bt_documento = new JButton("Documento");
		bt_documento.setBackground(new Color(128, 128, 128));
		bt_documento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_documento.addActionListener(this);
		
		painel_esquerdo.add(bt_documento, "3, 6");
		
		bt_contato = new JButton("Contatos");
		bt_contato.setBackground(new Color(128, 128, 128));
		bt_contato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_contato.addActionListener(this);
		
		painel_esquerdo.add(bt_contato, "3, 8");
		
		bt_consulta = new JButton("Consulta");
		bt_consulta.setBackground(new Color(128, 128, 128));
		bt_consulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_consulta.addActionListener(this);
		
		painel_esquerdo.add(bt_consulta, "3, 10");
		
		bt_configuracao = new JButton("Configuração");
		bt_configuracao.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/configuracoes.png")));
		bt_configuracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_configuracao.setBackground(new Color(128, 128, 128));
		bt_configuracao.addActionListener(this);
		
		painel_esquerdo.add(bt_configuracao, "3, 12");
		
		painel_direito = new JPanel();
		FlowLayout flowLayout = (FlowLayout) painel_direito.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(300);
		getContentPane().add(painel_direito, BorderLayout.EAST);
		
		painel_central = new JPanel();
		painel_central.setBackground(new Color(192, 192, 192));
		getContentPane().add(painel_central, BorderLayout.CENTER);
		painel_central.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(50dlu;default)"),
				ColumnSpec.decode("max(168dlu;pref)"),},
			new RowSpec[] {
				RowSpec.decode("max(81dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(29dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(163dlu;pref)"),
				RowSpec.decode("max(45dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(79dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		enviar_para = new JLabel("Enviar para:");
		enviar_para.setHorizontalAlignment(SwingConstants.CENTER);
		enviar_para.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(enviar_para, "2, 2");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Contato 01", "Contato 02", "Contato 03", "Contato 04", "Contato 05", "Contato 06", "Contato 07", "Contato 08"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		painel_central.add(comboBox, "2, 3, fill, default");
		
		enviar_corpo = new JLabel("Corpo do email: ");
		enviar_corpo.setHorizontalAlignment(SwingConstants.CENTER);
		enviar_corpo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(enviar_corpo, "2, 4");
		
		corpo_email = new JEditorPane();
		painel_central.add(corpo_email, "2, 5, default, fill");
		
		formato = new JLabel("Formato do arquivo");
		formato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formato.setHorizontalAlignment(SwingConstants.CENTER);
		painel_central.add(formato, "2, 7");
		
		tipo_xml = new JRadioButton("XML  ");
		tipo_xml.setBackground(new Color(192, 192, 192));
		tipo_xml.setHorizontalAlignment(SwingConstants.CENTER);
		painel_central.add(tipo_xml, "2, 8");
		
		tipo_json = new JRadioButton("JSON");
		tipo_json.setBackground(new Color(192, 192, 192));
		tipo_json.setHorizontalAlignment(SwingConstants.CENTER);
		painel_central.add(tipo_json, "2, 9");
		
		bt_enviar = new JButton("Enviar o arquivo");
		bt_enviar.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/enviar.png")));
		bt_enviar.setBackground(new Color(192, 192, 192));
		bt_enviar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_enviar.addActionListener(this);
		
		painel_central.add(bt_enviar, "2, 11");
		
		bt_cancelar = new JButton("Cancelar o envio");
		bt_cancelar.setIcon(new ImageIcon(EnviarPDF.class.getResource("/com/leitordoc/views/icons/cancelar.png")));
		bt_cancelar.setBackground(new Color(192, 192, 192));
		bt_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_cancelar.addActionListener(this);
		
		painel_central.add(bt_cancelar, "2, 13");
		
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

	public JLabel getEnviar_corpo() {
		return enviar_corpo;
	}

	public void setEnviar_corpo(JLabel enviar_corpo) {
		this.enviar_corpo = enviar_corpo;
	}

	public JLabel getEnviar_para() {
		return enviar_para;
	}

	public void setEnviar_para(JLabel enviar_para) {
		this.enviar_para = enviar_para;
	}

	public JButton getBt_documento() {
		return bt_documento;
	}

	public void setBt_documento(JButton bt_documento) {
		this.bt_documento = bt_documento;
	}

	public JButton getBt_contato() {
		return bt_contato;
	}

	public void setBt_contato(JButton bt_contato) {
		this.bt_contato = bt_contato;
	}

	public JButton getBt_consulta() {
		return bt_consulta;
	}

	public void setBt_consulta(JButton bt_consulta) {
		this.bt_consulta = bt_consulta;
	}

	public JButton getBt_configuracao() {
		return bt_configuracao;
	}

	public void setBt_configuracao(JButton bt_configuracao) {
		this.bt_configuracao = bt_configuracao;
	}

	public JButton getBt_enviar() {
		return bt_enviar;
	}

	public void setBt_enviar(JButton bt_enviar) {
		this.bt_enviar = bt_enviar;
	}

	public JButton getBt_cancelar() {
		return bt_cancelar;
	}

	public void setBt_cancelar(JButton bt_cancelar) {
		this.bt_cancelar = bt_cancelar;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JRadioButton getTipo_xml() {
		return tipo_xml;
	}

	public void setTipo_xml(JRadioButton tipo_xml) {
		this.tipo_xml = tipo_xml;
	}

	public JRadioButton getTipo_json() {
		return tipo_json;
	}

	public void setTipo_json(JRadioButton tipo_json) {
		this.tipo_json = tipo_json;
	}

	
}
