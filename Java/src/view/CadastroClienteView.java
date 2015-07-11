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

import controller.ClienteModelController;

public class CadastroClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JLabel lblModelo;
	private JTextField txtIdade;
	private JLabel lblPlaca;
	private JTextField txtNumeroCNH;
	private JLabel lblChassi;
	private JTextField txtCPF;
	private JLabel lblAno;
	private JButton btCadastrarCliente;
	private JTextField txtIdCliente;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteView frame = new CadastroClienteView();
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
					CadastroClienteView frame = new CadastroClienteView();
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
	public CadastroClienteView() {
		//Alterar o parâmetro do setDefaultCloseOperation
		//Trocar EXIT_ON_CLOSE por DISPOSE_ON_CLOSE - Quando fechar essa janela, não fecha a tela principal
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeVeculos = new JLabel("Cadastro de Cliente");
		lblCadastroDeVeculos.setBounds(133, 6, 200, 50);
		contentPane.add(lblCadastroDeVeculos);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 89, 72, 50);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(108, 99, 200, 28);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(109, 160, 200, 28);
		contentPane.add(txtSobrenome);
		
		lblModelo = new JLabel("Sobrenome");
		lblModelo.setBounds(10, 150, 72, 50);
		contentPane.add(lblModelo);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(109, 216, 200, 28);
		contentPane.add(txtIdade);
		
		lblPlaca = new JLabel("Idade");
		lblPlaca.setBounds(10, 206, 72, 50);
		contentPane.add(lblPlaca);
		
		txtNumeroCNH = new JTextField();
		txtNumeroCNH.setColumns(10);
		txtNumeroCNH.setBounds(109, 273, 200, 28);
		contentPane.add(txtNumeroCNH);
		
		lblChassi = new JLabel("Numero CNH");
		lblChassi.setBounds(10, 263, 72, 50);
		contentPane.add(lblChassi);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(109, 319, 200, 28);
		contentPane.add(txtCPF);
		
		lblAno = new JLabel("CPF");
		lblAno.setBounds(10, 309, 72, 50);
		contentPane.add(lblAno);
		
		btCadastrarCliente = new JButton("Cadastrar");
		btCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteModelController clienteModelController = new ClienteModelController();
				
				int id = Integer.parseInt(txtIdCliente.getText().toString());
				String nome = txtNome.getText().toString();
				String sobrenome = txtSobrenome.getText().toString();
				String idade = txtIdade.getText().toString(); 
				String numeroCNH = txtNumeroCNH.getText().toString(); 
				String cpf = txtCPF.getText().toString(); 
				
				boolean resultadoCadastro = clienteModelController.cadastrar(id,nome, sobrenome, idade, numeroCNH, cpf);
				
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
		btCadastrarCliente.setBounds(109, 351, 200, 50);
		contentPane.add(btCadastrarCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(108, 60, 200, 28);
		contentPane.add(txtIdCliente);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 50, 72, 50);
		contentPane.add(lblId);
	}
}
