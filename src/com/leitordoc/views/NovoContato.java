package com.leitordoc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

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
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class NovoContato extends JFrame implements ActionListener{

	public JPanel painel_esquerdo, painel_direito, painel_central;
	public JLabel icone, nome_usuario, titulo, nome, descricao, email;
	public JButton bt_documento, bt_contato, bt_consulta, bt_configuracao, bt_salvar, bt_excluir;
	public JTextField campo_nome, campo_descricao, campo_email;
	
	public NovoContato() throws ParseException {
		super("Leitor Doc - Novo Contato");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NovoContato.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		this.setSize(1024, 768);
		
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
		icone.setIcon(new ImageIcon(NovoContato.class.getResource("/com/leitordoc/views/icons/user.png")));
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
		bt_configuracao.setIcon(new ImageIcon(NovoContato.class.getResource("/com/leitordoc/views/icons/configuracoes.png")));
		bt_configuracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_configuracao.setBackground(new Color(128, 128, 128));
		bt_configuracao.addActionListener(this);
		
		painel_esquerdo.add(bt_configuracao, "3, 12");
		
		painel_direito = new JPanel();
		painel_direito.setBackground(new Color(192, 192, 192));
		FlowLayout fl_painel_direito = (FlowLayout) painel_direito.getLayout();
		fl_painel_direito.setHgap(20);
		getContentPane().add(painel_direito, BorderLayout.EAST);
		
		painel_central = new JPanel();
		painel_central.setBackground(new Color(192, 192, 192));
		getContentPane().add(painel_central, BorderLayout.CENTER);
		painel_central.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(142dlu;default)"),
				ColumnSpec.decode("max(57dlu;pref)"),
				ColumnSpec.decode("max(57dlu;default)"),
				ColumnSpec.decode("max(66dlu;default)"),
				ColumnSpec.decode("max(123dlu;min)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(44dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(31dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(13dlu;default)"),
				RowSpec.decode("max(29dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(67dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(199dlu;default)"),
				RowSpec.decode("max(51dlu;default)"),}));
		
		titulo = new JLabel("Novo Contato");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(titulo, "2, 3");
		
		nome = new JLabel("Nome");
		painel_central.add(nome, "2, 5");
		
		campo_nome = new JTextField();
		painel_central.add(campo_nome, "2, 6, 2, 1, fill, default");
		campo_nome.setColumns(15);
		
		email = new JLabel("Email");
		painel_central.add(email, "5, 5");
		
		campo_email = new JTextField();
		painel_central.add(campo_email, "5, 6, fill, default");
		campo_email.setColumns(10);
		
		descricao = new JLabel("Descrição");
		painel_central.add(descricao, "2, 8");
		
		campo_descricao = new JTextField();
		painel_central.add(campo_descricao, "2, 9, 2, 1, fill, default");
		campo_descricao.setColumns(15);
		
		
		bt_salvar = new JButton("Salvar");
		bt_salvar.setBackground(new Color(192, 192, 192));
		bt_salvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_salvar.setIcon(new ImageIcon(NovoContato.class.getResource("/com/leitordoc/views/icons/salvar.png")));
		bt_salvar.addActionListener(this);
		
		painel_central.add(bt_salvar, "2, 20, 2, 1");
		
		bt_excluir = new JButton("Excluir usuário");
		bt_excluir.setBackground(new Color(192, 192, 192));
		bt_excluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_excluir.setIcon(new ImageIcon(NovoContato.class.getResource("/com/leitordoc/views/icons/excluir.png")));
		bt_excluir.addActionListener(this);
		
		painel_central.add(bt_excluir, "5, 20");
		
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

	public JButton getBt_salvar() {
		return bt_salvar;
	}

	public void setBt_salvar(JButton bt_salvar) {
		this.bt_salvar = bt_salvar;
	}

	public JButton getBt_excluir() {
		return bt_excluir;
	}

	public void setBt_excluir(JButton bt_excluir) {
		this.bt_excluir = bt_excluir;
	}

	public JTextField getCampo_nome() {
		return campo_nome;
	}

	public void setCampo_nome(JTextField campo_nome) {
		this.campo_nome = campo_nome;
	}

	public JTextField getCampo_descricao() {
		return campo_descricao;
	}

	public void setCampo_descricao(JTextField campo_descricao) {
		this.campo_descricao = campo_descricao;
	}

	public JTextField getCampo_email() {
		return campo_email;
	}

	public void setCampo_email(JTextField campo_email) {
		this.campo_email = campo_email;
	}

	
}