package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.MultaModel;

public class LerMultaView extends JFrame {

	private JPanel contentPane;
	private static MultaModel multa;
	private JTextField txtIdMulta;
	private JTextField txtIdCliente;
	private JTextField txtIdVeiculo;
	private JTextField txtValor;
	private JTextField txtPontuacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerMultaView frame = new LerMultaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(MultaModel multaModel){
		multa = multaModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LerMultaView frame = new LerMultaView();
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
	public LerMultaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdMulta = new JTextField();
		txtIdMulta.setColumns(10);
		txtIdMulta.setBounds(108, 65, 200, 28);
		contentPane.add(txtIdMulta);
		
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
		
		JLabel lblIdveiculos = new JLabel("idVeiculo");
		lblIdveiculos.setBounds(10, 160, 72, 50);
		contentPane.add(lblIdveiculos);
		
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
		
		JLabel lblPontuacaoMulta = new JLabel("Pontua'c~ao");
		lblPontuacaoMulta.setBounds(10, 266, 72, 50);
		contentPane.add(lblPontuacaoMulta);
		
		txtPontuacao = new JTextField();
		txtPontuacao.setColumns(10);
		txtPontuacao.setBounds(109, 276, 200, 28);
		contentPane.add(txtPontuacao);
		
		txtIdMulta.setText(String.valueOf(multa.getId()));
		txtIdCliente.setText(String.valueOf(multa.getIdCliente()));
		txtIdVeiculo.setText(String.valueOf(multa.getIdVeiculo()));
		txtValor.setText(String.valueOf(multa.getValor()));
		txtPontuacao.setText(String.valueOf(multa.getPontuacao()));
		
		JLabel lblNewLabel = new JLabel("Dados do cadastro de multa");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
	}

}
