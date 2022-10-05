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
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class ListarContato extends JFrame implements ActionListener{

	public JPanel painel_esquerdo, painel_central;
	public JLabel icone, nome_usuario, titulo;
	public JButton bt_documento, bt_contato, bt_consulta, bt_configuracao, bt_procurar, bt_excluir, bt_adicionar;
	private JTable table;
	
	public ListarContato() {
		super("Leitor Doc - Listar Contato");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarContato.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
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
				RowSpec.decode("max(42dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(57dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(127dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		icone = new JLabel("");
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setIcon(new ImageIcon(ListarContato.class.getResource("/com/leitordoc/views/icons/user.png")));
		painel_esquerdo.add(icone, "3, 2");
		
		nome_usuario = new JLabel("Nome");
		nome_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nome_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		painel_esquerdo.add(nome_usuario, "3, 4");
		
		bt_documento = new JButton("Documento");
		bt_documento.setBackground(new Color(255, 255, 255));
		bt_documento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_documento.addActionListener(this);
		
		painel_esquerdo.add(bt_documento, "3, 6");
		
		bt_contato = new JButton("Contatos");
		bt_contato.setBackground(new Color(255, 255, 255));
		bt_contato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_contato.addActionListener(this);
		
		painel_esquerdo.add(bt_contato, "3, 8");
		
		bt_consulta = new JButton("Consulta");
		bt_consulta.setBackground(new Color(255, 255, 255));
		bt_consulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_consulta.addActionListener(this);
		
		painel_esquerdo.add(bt_consulta, "3, 10");
		
		bt_configuracao = new JButton("Configuração");
		bt_configuracao.setIcon(new ImageIcon(ListarContato.class.getResource("/com/leitordoc/views/icons/configuracoes.png")));
		bt_configuracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bt_configuracao.setBackground(new Color(255, 255, 255));
		bt_configuracao.addActionListener(this);
		
		painel_esquerdo.add(bt_configuracao, "3, 12");
		
		painel_central = new JPanel();
		painel_central.setBackground(new Color(192, 192, 192));
		getContentPane().add(painel_central, BorderLayout.CENTER);
		painel_central.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(37dlu;default)"),
				ColumnSpec.decode("max(60dlu;pref):grow"),
				ColumnSpec.decode("max(50dlu;default)"),
				ColumnSpec.decode("max(80dlu;default)"),
				FormSpecs.BUTTON_COLSPEC,
				ColumnSpec.decode("max(60dlu;pref)"),},
			new RowSpec[] {
				RowSpec.decode("max(44dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(250dlu;pref)"),
				RowSpec.decode("max(42dlu;default)"),
				RowSpec.decode("max(28dlu;default)"),}));
		
		titulo = new JLabel("Contatos");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(titulo, "2, 2");
		
		bt_procurar = new JButton("Procurar Contato");
		bt_procurar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_procurar.setIcon(new ImageIcon(ListarContato.class.getResource("/com/leitordoc/views/icons/pesquisar.png")));
		bt_procurar.setBackground(new Color(255, 255, 255));
		bt_procurar.addActionListener(this);
		
		table = new JTable();
		painel_central.add(table, "2, 4, 5, 1, fill, fill");
		
		painel_central.add(bt_procurar, "2, 6");
		
		bt_adicionar = new JButton("Adicionar contato");
		bt_adicionar.setIcon(new ImageIcon(ListarContato.class.getResource("/com/leitordoc/views/icons/add_contato.png")));
		bt_adicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_adicionar.setBackground(new Color(255, 255, 255));
		bt_adicionar.addActionListener(this);
		
		painel_central.add(bt_adicionar, "4, 6");
		
		bt_excluir = new JButton("Excluir Contato");
		bt_excluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_excluir.setIcon(new ImageIcon(ListarContato.class.getResource("/com/leitordoc/views/icons/excluir.png")));
		bt_excluir.setBackground(new Color(255, 255, 255));
		bt_excluir.addActionListener(this);
		
		painel_central.add(bt_excluir, "6, 6");
		
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

	public JButton getBt_procurar() {
		return bt_procurar;
	}

	public void setBt_procurar(JButton bt_procurar) {
		this.bt_procurar = bt_procurar;
	}

	public JButton getBt_excluir() {
		return bt_excluir;
	}

	public void setBt_excluir(JButton bt_excluir) {
		this.bt_excluir = bt_excluir;
	}

	public JButton getBt_adicionar() {
		return bt_adicionar;
	}

	public void setBt_adicionar(JButton bt_adicionar) {
		this.bt_adicionar = bt_adicionar;
	}
	
}
