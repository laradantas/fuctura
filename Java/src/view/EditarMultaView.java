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

import model.MultaModel;
import model.VeiculoModel;
import controller.MultaModelController;

public class EditarMultaView extends JFrame {

	private JPanel contentPane;
	private static MultaModel multa;
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
					EditarMultaView frame = new EditarMultaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(MultaModel veiculoModel){
		multa = veiculoModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarMultaView frame = new EditarMultaView();
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
	public EditarMultaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblPontuacao = new JLabel("Pontua'c~ao");
		lblPontuacao.setBounds(10, 266, 72, 50);
		contentPane.add(lblPontuacao);
		
		txtPontuacao = new JTextField();
		txtPontuacao.setColumns(10);
		txtPontuacao.setBounds(109, 276, 200, 28);
		contentPane.add(txtPontuacao);
		
		JLabel lblIdMulta = new JLabel("");
		lblIdMulta.setBounds(108, 55, 200, 50);
		contentPane.add(lblIdMulta);
		
		lblIdMulta.setText(String.valueOf(multa.getId()));
		txtIdCliente.setText(String.valueOf(multa.getIdCliente()));
		txtIdVeiculo.setText(String.valueOf(multa.getIdVeiculo()));
		txtValor.setText(String.valueOf(multa.getValor()));
		txtPontuacao.setText(String.valueOf(multa.getPontuacao()));
		
		
		
		
		JLabel lblNewLabel = new JLabel("Alterar o cadastro de multa");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
		
		JButton btSalvarVeiculo = new JButton("Salvar");
		btSalvarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultaModelController multaModelController = new MultaModelController();
				
				int id = Integer.parseInt(lblIdMulta.getText().toString());
				int idCliente = Integer.parseInt(txtIdCliente.getText().toString());
				int idVeiculo = Integer.parseInt(txtIdVeiculo.getText().toString());
				double valor = Double.parseDouble(txtValor.getText().toString()); 
				int pontuacao = Integer.parseInt(txtPontuacao.getText().toString()); 
				
				boolean resultadoEdicao = multaModelController.editar(id,idCliente, idVeiculo, valor, pontuacao);
				
				if(resultadoEdicao){
					//Exibir Alert de sucesso
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					
				}
				else{
					//Exibir Alert de erro
					JOptionPane.showMessageDialog(null, "Edição não realizada!");
				}
			}
		});
		btSalvarVeiculo.setBounds(159, 373, 117, 29);
		contentPane.add(btSalvarVeiculo);
		
		
	}

}
