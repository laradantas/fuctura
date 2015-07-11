package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AluguelModelController;

public class CadastroAluguelView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtIdVeiculo;
	private JLabel lblModelo;
	private JTextField txtValorAluguel;
	private JLabel lblPlaca;
	private JTextField txtDataInicio;
	private JLabel lblChassi;
	private JTextField txtDataDevolucao;
	private JLabel lblAno;
	private JButton btCadastrarAluguel;
	private JTextField txtIdAluguel;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluguelView frame = new CadastroAluguelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Criar esse método open (cópia do método main) para ser chamado na tela MainView
	//Possibilita que o JFrame desta tela seja exibido
	
	public static void open(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluguelView frame = new CadastroAluguelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroAluguelView() {
		//Alterar o parâmetro do setDefaultCloseOperation
		//Trocar EXIT_ON_CLOSE por DISPOSE_ON_CLOSE - Quando fechar essa janela, não fecha a tela principal
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeVeculos = new JLabel("Cadastro de Aluguel");
		lblCadastroDeVeculos.setBounds(133, 6, 200, 50);
		contentPane.add(lblCadastroDeVeculos);
		
		JLabel lblNewLabel = new JLabel("idCliente");
		lblNewLabel.setBounds(10, 89, 72, 50);
		contentPane.add(lblNewLabel);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(108, 99, 200, 28);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtIdVeiculo = new JTextField();
		txtIdVeiculo.setColumns(10);
		txtIdVeiculo.setBounds(109, 160, 200, 28);
		contentPane.add(txtIdVeiculo);
		
		lblModelo = new JLabel("idVeiculo");
		lblModelo.setBounds(10, 150, 72, 50);
		contentPane.add(lblModelo);
		
		txtValorAluguel = new JTextField();
		txtValorAluguel.setColumns(10);
		txtValorAluguel.setBounds(109, 216, 200, 28);
		contentPane.add(txtValorAluguel);
		
		lblPlaca = new JLabel("Valor Alug.");
		lblPlaca.setBounds(10, 206, 72, 50);
		contentPane.add(lblPlaca);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		txtDataInicio.setBounds(109, 273, 200, 28);
		contentPane.add(txtDataInicio);
		
		lblChassi = new JLabel("Data Inicio");
		lblChassi.setBounds(10, 263, 72, 50);
		contentPane.add(lblChassi);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setColumns(10);
		txtDataDevolucao.setBounds(109, 319, 200, 28);
		contentPane.add(txtDataDevolucao);
		
		lblAno = new JLabel("Data devolucao");
		lblAno.setBounds(10, 309, 72, 50);
		contentPane.add(lblAno);
		
		btCadastrarAluguel = new JButton("Cadastrar");
		btCadastrarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelModelController aluguelModelController = new AluguelModelController();
				
				int id = Integer.parseInt(txtIdAluguel.getText().toString());
				int idCliente = Integer.parseInt(txtIdCliente.getText().toString());
				int idVeiculo = Integer.parseInt(txtIdVeiculo.getText().toString());
				double valorAluguel = Double.parseDouble(txtValorAluguel.getText().toString()); 
				String dataInicio = txtDataInicio.getText().toString(); 
				String dataDevolucao = txtDataDevolucao.getText().toString(); 
				
				boolean resultadoCadastro = aluguelModelController.cadastrar(id,idCliente, idVeiculo, valorAluguel, dataInicio, dataDevolucao);
				
				if(resultadoCadastro){
					//Exibir Alert de sucesso
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					/*
					System.out.println(BancoMentira.veiculoModelRepositorio.keySet());
					if(BancoMentira.veiculoModelRepositorio.containsKey(5)){
						System.out.println(BancoMentira.veiculoModelRepositorio.get(5).getModelo());
					}
					*/
				}
				else{
					//Exibir Alert de erro
					JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
				}
			}
		});
		btCadastrarAluguel.setBounds(109, 351, 200, 50);
		contentPane.add(btCadastrarAluguel);
		
		txtIdAluguel = new JTextField();
		txtIdAluguel.setColumns(10);
		txtIdAluguel.setBounds(108, 60, 200, 28);
		contentPane.add(txtIdAluguel);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 50, 72, 50);
		contentPane.add(lblId);
	}
}
