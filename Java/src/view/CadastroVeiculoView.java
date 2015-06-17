package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import banco.BancoMentira;
import controller.VeiculoModelController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroVeiculoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtModeloVeiculo;
	private JTextField txtFabricanteVeiculo;
	private JLabel lblModelo;
	private JTextField txtPlacaVeiculo;
	private JLabel lblPlaca;
	private JTextField txtChassiVeiculo;
	private JLabel lblChassi;
	private JTextField txtAnoVeiculo;
	private JLabel lblAno;
	private JButton btCadastrarVeiculo;
	private JTextField txtIdVeiculo;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculoView frame = new CadastroVeiculoView();
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
					CadastroVeiculoView frame = new CadastroVeiculoView();
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
	public CadastroVeiculoView() {
		//Alterar o parâmetro do setDefaultCloseOperation
		//Trocar EXIT_ON_CLOSE por DISPOSE_ON_CLOSE - Quando fechar essa janela, não fecha a tela principal
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeVeculos = new JLabel("Cadastro de Veículos");
		lblCadastroDeVeculos.setBounds(133, 6, 200, 50);
		contentPane.add(lblCadastroDeVeculos);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 89, 72, 50);
		contentPane.add(lblNewLabel);
		
		txtModeloVeiculo = new JTextField();
		txtModeloVeiculo.setBounds(108, 99, 200, 28);
		contentPane.add(txtModeloVeiculo);
		txtModeloVeiculo.setColumns(10);
		
		txtFabricanteVeiculo = new JTextField();
		txtFabricanteVeiculo.setColumns(10);
		txtFabricanteVeiculo.setBounds(109, 160, 200, 28);
		contentPane.add(txtFabricanteVeiculo);
		
		lblModelo = new JLabel("Fabricante");
		lblModelo.setBounds(10, 150, 72, 50);
		contentPane.add(lblModelo);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setBounds(109, 216, 200, 28);
		contentPane.add(txtPlacaVeiculo);
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 206, 72, 50);
		contentPane.add(lblPlaca);
		
		txtChassiVeiculo = new JTextField();
		txtChassiVeiculo.setColumns(10);
		txtChassiVeiculo.setBounds(109, 273, 200, 28);
		contentPane.add(txtChassiVeiculo);
		
		lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(10, 263, 72, 50);
		contentPane.add(lblChassi);
		
		txtAnoVeiculo = new JTextField();
		txtAnoVeiculo.setColumns(10);
		txtAnoVeiculo.setBounds(109, 319, 200, 28);
		contentPane.add(txtAnoVeiculo);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 309, 72, 50);
		contentPane.add(lblAno);
		
		btCadastrarVeiculo = new JButton("Cadastrar");
		btCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoModelController veiculoModelController = new VeiculoModelController();
				
				int id = Integer.parseInt(txtIdVeiculo.getText().toString());
				String modelo = txtModeloVeiculo.getText().toString();
				String fabricante = txtFabricanteVeiculo.getText().toString();
				String placa = txtPlacaVeiculo.getText().toString(); 
				String chassi = txtChassiVeiculo.getText().toString(); 
				String ano = txtAnoVeiculo.getText().toString(); 
				
				boolean resultadoCadastro = veiculoModelController.cadastrar(id,modelo, fabricante, placa, chassi, ano);
				
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
		
		txtIdVeiculo = new JTextField();
		txtIdVeiculo.setColumns(10);
		txtIdVeiculo.setBounds(108, 60, 200, 28);
		contentPane.add(txtIdVeiculo);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 50, 72, 50);
		contentPane.add(lblId);
	}
}
