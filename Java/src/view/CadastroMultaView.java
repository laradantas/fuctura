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

import controller.MultaModelController;

public class CadastroMultaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtIdVeiculo;
	private JLabel lblModelo;
	private JTextField txtValor;
	private JLabel lblPlaca;
	private JTextField txtPontuacao;
	private JLabel lblChassi;
	private JButton btCadastrarVeiculo;
	private JTextField txtIdMulta;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMultaView frame = new CadastroMultaView();
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
					CadastroMultaView frame = new CadastroMultaView();
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
	public CadastroMultaView() {
		//Alterar o parâmetro do setDefaultCloseOperation
		//Trocar EXIT_ON_CLOSE por DISPOSE_ON_CLOSE - Quando fechar essa janela, não fecha a tela principal
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeVeculos = new JLabel("Cadastro de Multa");
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
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(109, 216, 200, 28);
		contentPane.add(txtValor);
		
		lblPlaca = new JLabel("Valor");
		lblPlaca.setBounds(10, 206, 72, 50);
		contentPane.add(lblPlaca);
		
		txtPontuacao = new JTextField();
		txtPontuacao.setColumns(10);
		txtPontuacao.setBounds(109, 273, 200, 28);
		contentPane.add(txtPontuacao);
		
		lblChassi = new JLabel("Pontua'c~ao");
		lblChassi.setBounds(10, 263, 72, 50);
		contentPane.add(lblChassi);
		
		btCadastrarVeiculo = new JButton("Cadastrar");
		btCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultaModelController multaModelController = new MultaModelController();
				
				int id = Integer.parseInt(txtIdMulta.getText().toString());
				int idCliente = Integer.parseInt(txtIdCliente.getText().toString());
				int idVeiculo = Integer.parseInt(txtIdVeiculo.getText().toString());
				double valor = Double.parseDouble(txtValor.getText().toString()); 
				int pontuacao = Integer.parseInt(txtPontuacao.getText().toString()); 
				
				boolean resultadoCadastro = multaModelController.cadastrar(id,idCliente, idVeiculo, valor, pontuacao);
				
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
		btCadastrarVeiculo.setBounds(109, 351, 200, 50);
		contentPane.add(btCadastrarVeiculo);
		
		txtIdMulta = new JTextField();
		txtIdMulta.setColumns(10);
		txtIdMulta.setBounds(108, 60, 200, 28);
		contentPane.add(txtIdMulta);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 50, 72, 50);
		contentPane.add(lblId);
	}
}
