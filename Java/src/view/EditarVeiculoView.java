package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.VeiculoModel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import controller.VeiculoModelController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarVeiculoView extends JFrame {

	private JPanel contentPane;
	private static VeiculoModel veiculo;
	private JTextField txtModeloVeiculo;
	private JTextField txtFabricanteVeiculo;
	private JTextField txtPlacaVeiculo;
	private JTextField txtChassiVeiculo;
	private JTextField txtAnoVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarVeiculoView frame = new EditarVeiculoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(VeiculoModel veiculoModel){
		veiculo = veiculoModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarVeiculoView frame = new EditarVeiculoView();
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
	public EditarVeiculoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Id");
		label.setBounds(10, 55, 72, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Modelo");
		label_1.setBounds(10, 99, 72, 50);
		contentPane.add(label_1);
		
		txtModeloVeiculo = new JTextField();
		txtModeloVeiculo.setColumns(10);
		txtModeloVeiculo.setBounds(108, 109, 200, 28);
		contentPane.add(txtModeloVeiculo);
		
		JLabel label_2 = new JLabel("Fabricante");
		label_2.setBounds(10, 160, 72, 50);
		contentPane.add(label_2);
		
		txtFabricanteVeiculo = new JTextField();
		txtFabricanteVeiculo.setColumns(10);
		txtFabricanteVeiculo.setBounds(109, 170, 200, 28);
		contentPane.add(txtFabricanteVeiculo);
		
		JLabel label_3 = new JLabel("Placa");
		label_3.setBounds(10, 216, 72, 50);
		contentPane.add(label_3);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setBounds(109, 226, 200, 28);
		contentPane.add(txtPlacaVeiculo);
		
		JLabel label_4 = new JLabel("Chassi");
		label_4.setBounds(10, 266, 72, 50);
		contentPane.add(label_4);
		
		txtChassiVeiculo = new JTextField();
		txtChassiVeiculo.setColumns(10);
		txtChassiVeiculo.setBounds(109, 276, 200, 28);
		contentPane.add(txtChassiVeiculo);
		
		JLabel label_5 = new JLabel("Ano");
		label_5.setBounds(10, 312, 72, 50);
		contentPane.add(label_5);
		
		JLabel lblIdVeiculo = new JLabel("");
		lblIdVeiculo.setBounds(108, 55, 200, 50);
		contentPane.add(lblIdVeiculo);
		
		txtAnoVeiculo = new JTextField();
		txtAnoVeiculo.setColumns(10);
		txtAnoVeiculo.setBounds(109, 322, 200, 28);
		contentPane.add(txtAnoVeiculo);
		
		lblIdVeiculo.setText(String.valueOf(veiculo.getId()));
		txtModeloVeiculo.setText(String.valueOf(veiculo.getModelo()));
		txtFabricanteVeiculo.setText(String.valueOf(veiculo.getFabricante()));
		txtPlacaVeiculo.setText(String.valueOf(veiculo.getPlaca()));
		txtChassiVeiculo.setText(String.valueOf(veiculo.getChassi()));
		txtAnoVeiculo.setText(String.valueOf(veiculo.getAno()));
		
		
		
		
		JLabel lblNewLabel = new JLabel("Alterar o cadastro de veículo");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
		
		JButton btSalvarVeiculo = new JButton("Salvar");
		btSalvarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoModelController veiculoModelController = new VeiculoModelController();
				
				int id = Integer.parseInt(lblIdVeiculo.getText().toString());
				String modelo = txtModeloVeiculo.getText().toString();
				String fabricante = txtFabricanteVeiculo.getText().toString();
				String placa = txtPlacaVeiculo.getText().toString(); 
				String chassi = txtChassiVeiculo.getText().toString(); 
				String ano = txtAnoVeiculo.getText().toString(); 
				
				boolean resultadoEdicao = veiculoModelController.editar(id,modelo, fabricante, placa, chassi, ano);
				
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
