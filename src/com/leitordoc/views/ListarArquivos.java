package com.leitordoc.views;

 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class ListarArquivos extends JFrame implements ActionListener{

	public JPanel  painelFundo, painel_central;
	public JLabel icone, nome_usuario, titulo;
	public JButton bt_documento, bt_contato, bt_consulta, bt_configuracao, bt_filtro, bt_carregar, bt_excluir, bt_refresh;
	public JTable tabela;
	public JScrollPane barraRolagem;
	private JScrollPane janelaErro;
	private JTable tabelaErro;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	
	public ListarArquivos() {
		super("Leitor Doc - Listar Arquivos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarArquivos.class.getResource("/com/leitordoc/views/icons/leitor_doc.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		this.setSize(1024, 768);
		
		painelFundo = new JPanel();
		FlowLayout fl_painel_direito = (FlowLayout) painelFundo.getLayout();
		fl_painel_direito.setHgap(20);
		painelFundo.setBackground(new Color(192, 192, 192));
		getContentPane().add(painelFundo, BorderLayout.EAST);
		
		painel_central = new JPanel();
		painel_central.setBackground(new Color(192, 192, 192));
		getContentPane().add(painel_central, BorderLayout.CENTER);
		painel_central.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(103dlu;default)"),
				ColumnSpec.decode("max(166dlu;min)"),
				ColumnSpec.decode("max(86dlu;default)"),
				ColumnSpec.decode("max(166dlu;min)"),},
			new RowSpec[] {
				RowSpec.decode("max(44dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(247dlu;default):grow"),
				RowSpec.decode("max(99dlu;default)"),}));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boleto Bancário", "Declaração de IR"}));
		comboBox.addActionListener(this);
		painel_central.add(comboBox, "2, 1, fill, default");
		
		titulo = new JLabel("Arquivos");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(titulo, "2, 2");

		bt_carregar = new JButton("Carregar arquivo");
		bt_carregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_carregar.setIcon(new ImageIcon(ListarArquivos.class.getResource("/com/leitordoc/views/icons/enviar.png")));
		bt_carregar.setBackground(new Color(255, 255, 255));
		bt_carregar.addActionListener(this);
		
		lblNewLabel = new JLabel("Arquivos com erro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		painel_central.add(lblNewLabel, "4, 2");
		
		tabela = new JTable();
		barraRolagem = new JScrollPane(tabela);
		painel_central.add(barraRolagem, "2, 4, fill, fill");
		
		janelaErro = new JScrollPane();
		painel_central.add(janelaErro, "4, 4, fill, fill");
		
		tabelaErro = new JTable();
		janelaErro.setViewportView(tabelaErro);
		
		painel_central.add(bt_carregar, "2, 5");
		
		bt_excluir = new JButton("Excluir arquivos");
		bt_excluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_excluir.setIcon(new ImageIcon(ListarArquivos.class.getResource("/com/leitordoc/views/icons/excluir.png")));
		bt_excluir.setBackground(new Color(255, 255, 255));
		bt_excluir.addActionListener(this);
		
		painel_central.add(bt_excluir, "4, 5");
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);
		getArquivosProcessados();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_carregar) {
//			carregarArquivo();
			System.out.println();
		}
		else if(e.getSource()==bt_excluir) {
			excluirArquivo();
		}
		else if(e.getSource()==comboBox) {
			getArquivosProcessados();
		}
		
	}
	
	public void getArquivosProcessados() {
//		Lista na tabela o nome de todos arquivos do diretório com base no item selecionado no combobox
		File file;
//		Verifica qual opção esta selecionada no combobox para definir o diretório de arquivos a ser buscado os arquivos
		if(comboBox.getSelectedIndex()==0) {
			file = new File(getClass().getResource("/com.leitordoc.arquivos/boletos").getFile());
		} else {
			file = new File(getClass().getResource("/com.leitordoc.arquivos/irs").getFile());
		}
//		Cria array com todos arquivos do diretório
		File[] files = file.listFiles();
//		Cria objeto model para acessar propriedades da tabela
		DefaultTableModel tableModel = (DefaultTableModel)tabela.getModel();
		tableModel.setColumnIdentifiers(new String[] {"Nome"});
//		Remove todas linhas da tabela
		int numLinhas = tableModel.getRowCount();
		for(int i=0;i<numLinhas;i++) {
			tableModel.removeRow(0);
		}
//		Adiciona as linhas com nomes dos arquivos do diretorio especifico na tabela
		Object[] row = new Object[1];
		for(int i=0;i<files.length;i++) {
			row[0] = files[i].getName();
		tableModel.addRow(row);
		}
	}
	
	public void carregarArquivo() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			File arquivo = fc.getSelectedFile();
			System.out.println("Abrindo: " + arquivo.getName());
		}
	}
	
	public void excluirArquivo() {
		try {
			System.out.println(tabela.getValueAt(tabela.getSelectedRow(), 0));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Nehum arquivo selecionado.");
//			System.out.println(e); 
		}
		
	}
}
