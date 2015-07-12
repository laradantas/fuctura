package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.AluguelModel;

public class LerAluguelView extends JFrame {

	private JPanel contentPane;
	private static AluguelModel aluguel;
	private JTextField txtIdAluguel;
	private JTextField txtIdCliente;
	private JTextField txtIdVeiculo;
	private JTextField txtValor;
	private JTextField txtDataInicio;
	private JTextField txtDataDevolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerAluguelView frame = new LerAluguelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(AluguelModel aluguelModel){
		aluguel = aluguelModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerAluguelView frame = new LerAluguelView();
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
	public LerAluguelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdAluguel = new JTextField();
		txtIdAluguel.setColumns(10);
		txtIdAluguel.setBounds(108, 65, 200, 28);
		contentPane.add(txtIdAluguel);
		
		JLabel label = new JLabel("Id");
		label.setBounds(10, 55, 72, 50);
		contentPane.add(label);
		
		JLabel lblIdcliente = new JLabel("idCliente");
		lblIdcliente.setBounds(10, 99, 72, 50);
		contentPane.add(lblIdcliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(108, 109, 200, 28);
		contentPane.add(txtIdCliente);
		
		JLabel lblIdveiculo = new JLabel("idVeiculo");
		lblIdveiculo.setBounds(10, 160, 72, 50);
		contentPane.add(lblIdveiculo);
		
		txtIdVeiculo = new JTextField();
		txtIdVeiculo.setColumns(10);
		txtIdVeiculo.setBounds(109, 170, 200, 28);
		contentPane.add(txtIdVeiculo);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 216, 72, 50);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(109, 226, 200, 28);
		contentPane.add(txtValor);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(10, 266, 72, 50);
		contentPane.add(lblDataInicio);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		txtDataInicio.setBounds(109, 276, 200, 28);
		contentPane.add(txtDataInicio);
		
		JLabel lblDataDevolucao = new JLabel("Data devolucao");
		lblDataDevolucao.setBounds(10, 312, 72, 50);
		contentPane.add(lblDataDevolucao);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setColumns(10);
		txtDataDevolucao.setBounds(109, 322, 200, 28);
		contentPane.add(txtDataDevolucao);
		
		txtIdAluguel.setText(String.valueOf(aluguel.getId()));
		txtIdCliente.setText(String.valueOf(aluguel.getIdCliente()));
		txtIdVeiculo.setText(String.valueOf(aluguel.getIdVeiculo()));
		txtValor.setText(String.valueOf(aluguel.getValorAluguel()));
		txtDataInicio.setText(String.valueOf(aluguel.getDataInicio()));
		txtDataDevolucao.setText(String.valueOf(aluguel.getDataDevolucao()));
		
		JLabel lblNewLabel = new JLabel("Dados do cadastro de aluguel");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
	}

}
