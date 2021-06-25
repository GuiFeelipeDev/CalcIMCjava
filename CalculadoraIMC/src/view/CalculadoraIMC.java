package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class CalculadoraIMC extends JFrame {

	String nome;
	double altura, peso, peso_ideal;
	int sexo;
	
	private JPanel contentPane;
	private JTextField jTNome;
	private JTextField jTAltura;
	private JTextField jPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraIMC frame = new CalculadoraIMC();
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
	public CalculadoraIMC() {
		setTitle("Calculadora IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 385);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Calculadora IMC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTNome = new JTextField();
		jTNome.setBounds(91, 30, 198, 19);
		contentPane.add(jTNome);
		jTNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 28, 61, 21);
		contentPane.add(lblNewLabel);
		
		jTAltura = new JTextField();
		jTAltura.setColumns(10);
		jTAltura.setBounds(91, 63, 61, 19);
		contentPane.add(jTAltura);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltura.setBounds(34, 52, 61, 36);
		contentPane.add(lblAltura);
		
		JLabel lblCm = new JLabel("(cm)");
		lblCm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCm.setBounds(157, 54, 61, 32);
		contentPane.add(lblCm);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(34, 83, 61, 36);
		contentPane.add(lblPeso);
		
		jPeso = new JTextField();
		jPeso.setColumns(10);
		jPeso.setBounds(91, 94, 61, 19);
		contentPane.add(jPeso);
		
		JLabel lblkg = new JLabel("(Kg)");
		lblkg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblkg.setBounds(157, 85, 61, 32);
		contentPane.add(lblkg);
		
		JComboBox jTSexo = new JComboBox();
		jTSexo.setModel(new DefaultComboBoxModel(new String[] {"Masc", "Fem"}));
		jTSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTSexo.setBounds(91, 129, 61, 21);
		contentPane.add(jTSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(34, 121, 61, 36);
		contentPane.add(lblSexo);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 226, 349, 100);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel jTResult = new JLabel("");
		jTResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jTResult.setBounds(10, 10, 329, 30);
		panel.add(jTResult);
		
		JLabel jTResult_1 = new JLabel("");
		jTResult_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jTResult_1.setBounds(10, 39, 329, 30);
		panel.add(jTResult_1);
		
		JButton jTCalc = new JButton("Calcular");
		jTCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DecimalFormat limited = new DecimalFormat();
				limited.applyPattern("###,##0.00");
				
				nome = jTNome.getText();
				altura = Double.valueOf(jTAltura.getText());
				peso = Double.valueOf(jPeso.getText());
				sexo = jTSexo.getSelectedIndex();
				
				double alt = altura / 100;
				
				double imc = peso / Math.pow(alt, 2);
				
				double pesoIdealMin = 18.5 * Math.pow(alt, 2);
				double pesoIdealMax = 24.9 * Math.pow(alt, 2);
				
				if(imc < 18.5) {
					jTResult.setText("Olá "+nome+" você está abaixo do peso!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				else if(imc >= 18.5 && imc < 25) {
					jTResult.setText("Olá "+nome+" você está no peso ideal!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				else if(imc >= 25 && imc < 30) {
					jTResult.setText("Olá "+nome+" você está acima do peso!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				else if(imc >= 30 && imc < 35) {
					jTResult.setText("Olá "+nome+" você está com Obesidade de Grau I!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				else if(imc >= 35 && imc < 40) {
					jTResult.setText("Olá "+nome+" você está com Obesidade de Grau II!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				else {
					jTResult.setText("Olá "+nome+" você está com Obesidade Mórbida!");
					jTResult_1.setText("Seu Peso ideal é entre "+limited.format(pesoIdealMin)+"Kg e "+limited.format(pesoIdealMax)+"Kg!");
				}
				
			}
		});
		jTCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTCalc.setBounds(51, 182, 101, 32);
		contentPane.add(jTCalc);
		
		JButton jTClear = new JButton("Limpar Campos");
		jTClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTNome.setText("");
				jPeso.setText("");
				jTAltura.setText("");
				jTSexo.setSelectedIndex(0);
				jTResult.setText("");
				jTResult_1.setText("");
			}
		});
		jTClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTClear.setBounds(173, 182, 131, 32);
		contentPane.add(jTClear);
	}
}
