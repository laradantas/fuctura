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

import model.AluguelModel;
import model.VeiculoModel;
import controller.AluguelModelController;

public class EditarAluguelView extends JFrame {

	private JPanel contentPane;
	private static AluguelModel veiculo;
	private JTextField txtIdCliente;
	private JTextField txtIdVeiculo;
	private JTextField txtValorAluguel;
	private JTextField txtDataInicio;
	private JTextField txtDataDevolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarAluguelView frame = new EditarAluguelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(AluguelModel aluguelModel){
		veiculo = aluguelModel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarAluguelView frame = new EditarAluguelView();
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
	public EditarAluguelView() {
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
		
		JLabel lblValorAlug = new JLabel("Valor Alug");
		lblValorAlug.setBounds(10, 216, 72, 50);
		contentPane.add(lblValorAlug);
		
		txtValorAluguel = new JTextField();
		txtValorAluguel.setColumns(10);
		txtValorAluguel.setBounds(109, 226, 200, 28);
		contentPane.add(txtValorAluguel);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(10, 266, 72, 50);
		contentPane.add(lblDataInicio);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		txtDataInicio.setBounds(109, 276, 200, 28);
		contentPane.add(txtDataInicio);
		
		JLabel lblDataDevolucao = new JLabel("Data Devolucao");
		lblDataDevolucao.setBounds(10, 312, 72, 50);
		contentPane.add(lblDataDevolucao);
		
		JLabel lblIdAluguel = new JLabel("");
		lblIdAluguel.setBounds(108, 55, 200, 50);
		contentPane.add(lblIdAluguel);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setColumns(10);
		txtDataDevolucao.setBounds(109, 322, 200, 28);
		contentPane.add(txtDataDevolucao);
		
		lblIdAluguel.setText(String.valueOf(veiculo.getId()));
		txtIdCliente.setText(String.valueOf(veiculo.getIdCliente()));
		txtIdVeiculo.setText(String.valueOf(veiculo.getIdVeiculo()));
		txtValorAluguel.setText(String.valueOf(veiculo.getValorAluguel()));
		txtDataInicio.setText(String.valueOf(veiculo.getDataInicio()));
		txtDataDevolucao.setText(String.valueOf(veiculo.getDataDevolucao()));
		
		
		
		
		JLabel lblNewLabel = new JLabel("Alterar o cadastro de aluguel");
		lblNewLabel.setBounds(122, 9, 200, 50);
		contentPane.add(lblNewLabel);
		
		JButton btSalvarVeiculo = new JButton("Salvar");
		btSalvarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelModelController aluguelModelController = new AluguelModelController();
				
				int id = Integer.parseInt(lblIdAluguel.getText().toString());
				int idCliente = Integer.parseInt(txtIdCliente.getText().toString());
				int idVeiculo = Integer.parseInt(txtIdVeiculo.getText().toString());
				double valorAluguel = Double.parseDouble(txtValorAluguel.getText().toString()); 
				String dataInicio = txtDataInicio.getText().toString(); 
				String dataDevolucao = txtDataDevolucao.getText().toString(); 
				
				boolean resultadoEdicao = aluguelModelController.editar(id,idCliente, idVeiculo, valorAluguel, dataInicio, dataDevolucao);
				
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
