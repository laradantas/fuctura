package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ClienteModel;
import model.VeiculoModel;

public class LerClienteView extends JFrame {

	private JPanel contentPane;
	private static ClienteModel cliente;
	private JTextField txtIdCliente;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtIdade;
	private JTextField txtNumeroCNH;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerClienteView frame = new LerClienteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(ClienteModel clienteModel){
		cliente = clienteModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerClienteView frame = new LerClienteView();
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
	public LerClienteView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(108, 65, 200, 28);
		contentPane.add(txtIdCliente);
		
		JLabel label = new JLabel("Id");
		label.setBounds(10, 55, 72, 50);
		contentPane.add(label);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 99, 72, 50);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(108, 109, 200, 28);
		contentPane.add(txtNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(10, 160, 72, 50);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(109, 170, 200, 28);
		contentPane.add(txtSobrenome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 216, 72, 50);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(109, 226, 200, 28);
		contentPane.add(txtIdade);
		
		JLabel lblNumeroCnh = new JLabel("Numero CNH");
		lblNumeroCnh.setBounds(10, 266, 72, 50);
		contentPane.add(lblNumeroCnh);
		
		txtNumeroCNH = new JTextField();
		txtNumeroCNH.setColumns(10);
		txtNumeroCNH.setBounds(109, 276, 200, 28);
		contentPane.add(txtNumeroCNH);
		
		JLabel lblCnh = new JLabel("CPF");
		lblCnh.setBounds(10, 312, 72, 50);
		contentPane.add(lblCnh);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(109, 322, 200, 28);
		contentPane.add(txtCPF);
		
		txtIdCliente.setText(String.valueOf(cliente.getId()));
		txtNome.setText(String.valueOf(cliente.getNome()));
		txtSobrenome.setText(String.valueOf(cliente.getSobrenome()));
		txtIdade.setText(String.valueOf(cliente.getIdade()));
		txtNumeroCNH.setText(String.valueOf(cliente.getNumeroCNH()));
		txtCPF.setText(String.valueOf(cliente.getCpf()));
		
		
		
		
		JLabel lblNewLabel = new JLabel("Dados do cadastro de cliente");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
	}

}
