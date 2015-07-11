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

import controller.AluguelModelController;

public class RemoverAluguelView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdAluguel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverAluguelView frame = new RemoverAluguelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverAluguelView frame = new RemoverAluguelView();
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
	public RemoverAluguelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remover Aluguel");
		lblNewLabel.setBounds(175, 6, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel label1 = new JLabel("ID");
		label1.setBounds(10, 63, 200, 50);
		contentPane.add(label1);
		
		txtIdAluguel = new JTextField();
		txtIdAluguel.setBounds(47, 63, 200, 50);
		contentPane.add(txtIdAluguel);
		txtIdAluguel.setColumns(10);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelModelController aluguelModelController = new AluguelModelController();
				
				int id = Integer.parseInt(txtIdAluguel.getText().toString());
				
				boolean resultadoRemocao = aluguelModelController.remover(id);
				
				if(resultadoRemocao){
					JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso");
				}else{
					JOptionPane.showMessageDialog(null, "Remoção não realizada");
				}
			}
		});
		btnNewButton.setBounds(121, 150, 117, 29);
		contentPane.add(btnNewButton);
	}

}
