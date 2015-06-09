package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		frame.setBounds(100, 100, 450, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btCadastrarVeiculo = new JButton("Cadastrar");
		btCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Abrir a tela de cadastro de veículo
				CadastroVeiculoView.open();
				
			}
		});
		btCadastrarVeiculo.setBounds(10, 52, 200, 50);
		frame.getContentPane().add(btCadastrarVeiculo);
		
		JButton btRemoverVeiculo = new JButton("Remover");
		btRemoverVeiculo.setBounds(10, 119, 200, 50);
		frame.getContentPane().add(btRemoverVeiculo);
		
		JLabel lblVevulo = new JLabel("Veículo");
		lblVevulo.setBounds(10, -10, 200, 50);
		frame.getContentPane().add(lblVevulo);
		
		JButton btAlterarVeiculo = new JButton("Alterar");
		btAlterarVeiculo.setBounds(222, 52, 200, 50);
		frame.getContentPane().add(btAlterarVeiculo);
		
		JButton btConsultarVeiculo = new JButton("Consultar");
		btConsultarVeiculo.setBounds(222, 119, 200, 50);
		frame.getContentPane().add(btConsultarVeiculo);
	}
}
