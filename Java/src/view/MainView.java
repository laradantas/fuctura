package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.VeiculoModel;
import controller.VeiculoModelController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btCadastrarVeiculo = new JButton("Cadastrar");
		btCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Abrir a tela de cadastro de veículo
				CadastroVeiculoView.open();
				
			}
		});
		btCadastrarVeiculo.setBounds(20, 36, 200, 50);
		frame.getContentPane().add(btCadastrarVeiculo);
		
		JButton btRemoverVeiculo = new JButton("Remover");
		btRemoverVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverVeiculoView.open();
			}
		});
		btRemoverVeiculo.setBounds(20, 87, 200, 50);
		frame.getContentPane().add(btRemoverVeiculo);
		
		JLabel lblVevulo = new JLabel("Veículo");
		lblVevulo.setBounds(10, -10, 200, 50);
		frame.getContentPane().add(lblVevulo);
		
		JButton btAlterarVeiculo = new JButton("Alterar");
		btAlterarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString = JOptionPane.showInputDialog("Digite o id do veículo");
				int idVeiculo = Integer.parseInt(idString);
				VeiculoModelController veiculoModelController = new VeiculoModelController();
				VeiculoModel veiculo = veiculoModelController.ler(idVeiculo);
				if(veiculo == null){
					JOptionPane.showMessageDialog(null, "O elemento não está cadastrado");
				}else{
					EditarVeiculoView.open(veiculo);
				}
			}
		});
		btAlterarVeiculo.setBounds(232, 36, 200, 50);
		frame.getContentPane().add(btAlterarVeiculo);
		
		JButton btConsultarVeiculo = new JButton("Consultar");
		btConsultarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString = JOptionPane.showInputDialog("Digite o id do veículo");
				int idVeiculo = Integer.parseInt(idString);
				VeiculoModelController veiculoModelController = new VeiculoModelController();
				VeiculoModel veiculo = veiculoModelController.ler(idVeiculo);
				if(veiculo == null){
					JOptionPane.showMessageDialog(null, "O elemento não está cadastrado");
				}else{
					LerVeiculoView.open(veiculo);
				}
			}
		});
		btConsultarVeiculo.setBounds(232, 87, 200, 50);
		frame.getContentPane().add(btConsultarVeiculo);
		
		JButton btCadastrarCliente = new JButton("Cadastrar");
		btCadastrarCliente.setBounds(20, 176, 200, 50);
		frame.getContentPane().add(btCadastrarCliente);
		
		JButton btAlterarCliente = new JButton("Alterar");
		btAlterarCliente.setBounds(232, 176, 200, 50);
		frame.getContentPane().add(btAlterarCliente);
		
		JButton btConsultarCliente = new JButton("Consultar");
		btConsultarCliente.setBounds(232, 226, 200, 50);
		frame.getContentPane().add(btConsultarCliente);
		
		JButton btRemoverCliente = new JButton("Remover");
		btRemoverCliente.setBounds(20, 226, 200, 50);
		frame.getContentPane().add(btRemoverCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 130, 200, 50);
		frame.getContentPane().add(lblCliente);
		
		JButton btCadastrarMulta = new JButton("Cadastrar");
		btCadastrarMulta.setBounds(20, 313, 200, 50);
		frame.getContentPane().add(btCadastrarMulta);
		
		JButton btAlterarMulta = new JButton("Alterar");
		btAlterarMulta.setBounds(232, 313, 200, 50);
		frame.getContentPane().add(btAlterarMulta);
		
		JButton btConsultarMulta = new JButton("Consultar");
		btConsultarMulta.setBounds(232, 362, 200, 50);
		frame.getContentPane().add(btConsultarMulta);
		
		JButton btRemoverMulta = new JButton("Remover");
		btRemoverMulta.setBounds(20, 362, 200, 50);
		frame.getContentPane().add(btRemoverMulta);
		
		JLabel lblMulta = new JLabel("Multa");
		lblMulta.setBounds(10, 267, 200, 50);
		frame.getContentPane().add(lblMulta);
		
		JLabel lblAluguel = new JLabel("Aluguel");
		lblAluguel.setBounds(10, 403, 200, 50);
		frame.getContentPane().add(lblAluguel);
		
		JButton btCadastrarAluguel = new JButton("Cadastrar");
		btCadastrarAluguel.setBounds(20, 449, 200, 50);
		frame.getContentPane().add(btCadastrarAluguel);
		
		JButton btRemoverAluguel = new JButton("Remover");
		btRemoverAluguel.setBounds(20, 498, 200, 50);
		frame.getContentPane().add(btRemoverAluguel);
		
		JButton btConsultarAluguel = new JButton("Consultar");
		btConsultarAluguel.setBounds(232, 498, 200, 50);
		frame.getContentPane().add(btConsultarAluguel);
		
		JButton btAlterarAluguel = new JButton("Alterar");
		btAlterarAluguel.setBounds(232, 449, 200, 50);
		frame.getContentPane().add(btAlterarAluguel);
	}
}
