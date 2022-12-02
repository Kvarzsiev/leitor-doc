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
import java.io.IOException;

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
import com.leitordoc.controllers.BoletoToJsonController;
import com.leitordoc.controllers.IrToJsonController;

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
		
		tabela = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
	            return false;               
			}
		};
		barraRolagem = new JScrollPane(tabela);
		painel_central.add(barraRolagem, "2, 4, fill, fill");
		
		janelaErro = new JScrollPane();
		painel_central.add(janelaErro, "4, 4, fill, fill");
		
		tabelaErro = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
	            return false;               
			}
		};
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
//		Observa quando uma linha da tabela é cliacada
		tabela.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tabela.rowAtPoint(evt.getPoint());
		        int col = tabela.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	String selectedFile = (String) tabela.getValueAt(row, col);
//		        	System.out.println(selectedFile);
		        	File folder;
		        	File[] files;
		        	try {
		        		if(comboBox.getSelectedIndex()==0) {
		    				folder = new File(getClass().getClassLoader().getResource("json/boleto").getFile());
		    			} else {
		    				folder = new File(getClass().getClassLoader().getResource("json/ir").getFile());
		    			}
//		    			Cria array com todos arquivos do diretório
		    			for (File fileEntry : folder.listFiles()) {
		    				if(fileEntry.isDirectory()) {
		    					continue;
		    				} else if(fileEntry.getName().equals(selectedFile)) {
//		    					System.out.println(fileEntry.getAbsolutePath());
		    					String path = fileEntry.getAbsolutePath();
		    					path.replace("\\", "\\\\");
		    					Runtime.getRuntime().exec("notepad "+path);
		    				}
//		    				System.out.println(fileEntry.getName());
		    			}
//						
					} catch (Exception e) {
						System.out.println("Erro ao buscar arquivos em pasta");
//						e.printStackTrace();
					}

		        }
		    }
		});
		tabelaErro.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tabelaErro.rowAtPoint(evt.getPoint());
		        int col = tabelaErro.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	String selectedFile = (String) tabelaErro.getValueAt(row, col);
//		        	System.out.println(selectedFile);
		        	File folder;
		        	File[] files;
		        	try {
		        		if(comboBox.getSelectedIndex()==0) {
		    				folder = new File(getClass().getClassLoader().getResource("json/boleto/falha").getFile());
		    			} else {
		    				folder = new File(getClass().getClassLoader().getResource("json/ir/falha").getFile());
		    			}
//		    			Cria array com todos arquivos do diretório
		    			for (File fileEntry : folder.listFiles()) {
		    				if(fileEntry.isDirectory()) {
		    					continue;
		    				} else if(fileEntry.getName().equals(selectedFile)) {
//		    					System.out.println(fileEntry.getAbsolutePath());
		    					String path = fileEntry.getAbsolutePath();
		    					path.replace("\\", "\\\\");
		    					Runtime.getRuntime().exec("notepad "+path);
		    				}
//		    				System.out.println(fileEntry.getName());
		    			}
//						
					} catch (Exception e) {
						System.out.println("Erro ao buscar arquivos em pasta");
//						e.printStackTrace();
					}

		        }
		    }
		});
		
		this.setVisible(true);
		getArquivosProcessados();
		getArquivosProcessadosComFalha();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_carregar) {
			carregarArquivo();
		}
		else if(e.getSource()==bt_excluir) {
			excluirArquivo();
		}
		else if(e.getSource()==comboBox) {
//			Lista na tabela o nome de todos arquivos do diretório com base no item selecionado no combobox
			getArquivosProcessados();
			getArquivosProcessadosComFalha();
		}
		
	}
	
	public void getArquivosProcessados() {
//		Cria objeto model para acessar propriedades da tabela
		DefaultTableModel table = (DefaultTableModel)tabela.getModel();
		table.setColumnIdentifiers(new String[] {"Nome"});
		File folder;
		File[] files;
		try {
//			Verifica qual opção esta selecionada no combobox para definir o diretório de arquivos a ser buscado os arquivos
			if(comboBox.getSelectedIndex()==0) {
				folder = new File(getClass().getClassLoader().getResource("json/boleto").getFile());
			} else {
				folder = new File(getClass().getClassLoader().getResource("json/ir").getFile());
			}
//			Cria array com todos arquivos do diretório
			files = folder.listFiles();
//			Remove todas linhas da tabela1
			int numLinhas = table.getRowCount();
			for(int i=0;i<numLinhas;i++) {
				table.removeRow(0);
			}
//			Adiciona as linhas com nomes dos arquivos do diretorio especifico na tabela
			Object[] row = new Object[1];
			for(int i=0;i<files.length;i++) {
				if(files[i].isDirectory()) {
					continue;
				}
				row[0] = files[i].getName();
			table.addRow(row);
			}
		} catch(NullPointerException e) {
//			Remove todas linhas da tabela
			int numLinhas = table.getRowCount();
			for(int i=0;i<numLinhas;i++) {
				table.removeRow(0);
			}
		}

	}
	
	public void getArquivosProcessadosComFalha() {
//		Cria objeto model para acessar propriedades da tabela
		DefaultTableModel table = (DefaultTableModel)tabelaErro.getModel();
		table.setColumnIdentifiers(new String[] {"Nome"});
		File folder;
		File[] files;
		try {
//			Verifica qual opção esta selecionada no combobox para definir o diretório de arquivos a ser buscado os arquivos
			if(comboBox.getSelectedIndex()==0) {
				folder = new File(getClass().getClassLoader().getResource("json/boleto/falha").getFile());
			} else {
//				file = new File(getClass().getResource("/com.leitordoc.arquivos/irs").getFile());
				folder = new File(getClass().getClassLoader().getResource("json/ir/falha").getFile());
			}
//			Cria array com todos arquivos do diretório
			files = folder.listFiles();
//			Remove todas linhas da tabela1
			int numLinhas = table.getRowCount();
			for(int i=0;i<numLinhas;i++) {
				table.removeRow(0);
			}
//			Adiciona as linhas com nomes dos arquivos do diretorio especifico na tabela
			Object[] row = new Object[1];
			for(int i=0;i<files.length;i++) {
				if(files[i].isDirectory()) {
					continue;
				}
				row[0] = files[i].getName();
			table.addRow(row);
			}
		} catch(NullPointerException e) {
//			Remove todas linhas da tabela
			int numLinhas = table.getRowCount();
			for(int i=0;i<numLinhas;i++) {
				table.removeRow(0);
			}
		}

	}
	
	public void carregarArquivo() {
		comboBox.setEnabled(false);
//		Instancia do escolhedor de arquivos
		JFileChooser escolhedor = new JFileChooser();
//		Seta o escolhedor de arquivos para apensa permitir selecionar diretórios
		escolhedor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		armazena em opcao a escolha do usuário (qual botão ele apertou na janela do escolhedor (abrir ou cancelar))
		int opcao = escolhedor.showOpenDialog(null);
//		Verifica se opção escolhida na janela do escolhedor de arquivos foi de confirmar a escolha
		if(opcao==JFileChooser.APPROVE_OPTION) {
//			obtem objeto da pasta escolhida 
			File folder = escolhedor.getSelectedFile();
//			loop que chama o controllador para cada arquivo da pasta
			for (File fileEntry : folder.listFiles()) {
//				Se existir outras pastas dentro da pasta a iteração do loop eh pulada para proxima
		        if (fileEntry.isDirectory()) {
		            continue;
		        }
		        String filePath = fileEntry.getPath().replace("\\", "\\\\");
		        System.out.println("filepath:" + filePath);
		        try {
			        if(comboBox.getSelectedIndex()==0) {
						BoletoToJsonController.convert(filePath);
					} else {
						IrToJsonController.convert(filePath);
					}
		        } 
		        catch(Exception e ) {
//		        	System.out.println("a");
		        	e.printStackTrace();
		        	System.out.println("Exception: " + e.getLocalizedMessage());
		        	comboBox.setEnabled(true);
		        }
		    }
		}
//		getArquivosProcessados();
//		getArquivosProcessadosComFalha();
		comboBox.setEnabled(true);
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
