package conversor;

import javax.swing.JOptionPane;

public class Temperaturas implements TiposDeConversao{

	@Override
	public String[] getOpcoes() {
		String[] opcoes = { "De Celsius para Kelvin", 
					"De Celsius para Fahrenheit",
					"De Kelvin para Celsius",
					"De Kelvin para Fahrenheit",
					"De Fahrenheit para Celsius",
					"De Fahrenheit para Kelvin",
				};
		return opcoes;
	}

	@Override
	public void tiposDeConversao() {
		String comoConverter = (String) JOptionPane.showInputDialog(null, "Para qual moeda deseja converter?", "",
				JOptionPane.QUESTION_MESSAGE, null, getOpcoes(), getOpcoes()[0]);

		if (comoConverter == null) {
			System.exit(0);
		}

		double valor = getValor();

		switch (comoConverter) {
		case "De Celsius para Kelvin":
			mostraConversaoCelsiusParaKelvin(valor);
			break;
		case "De Celsius para Fahrenheit":
			mostraConversaoCelsiusParaFahrenheit(valor);
			break;
		case "De Kelvin para Celsius":
			mostraConversaoKelvinParaCelsius(valor);
			break;
		case "De Kelvin para Fahrenheit":
			mostraConversaoKelvinParaFahrenheit(valor);
			break;
		case "De Fahrenheit para Celsius":
			mostraConversaoFahrenheitParaCelsius(valor);
			break;
		case "De Fahrenheit para Kelvin":
			mostraConversaoFahrenheitParaKelvin(valor);
			break;
		default:
			break;
		}
		
	}
	
	@Override
	public boolean validaEntrada(String valor) {
		if (valor.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo Valor não pode ser vazio.", "Erro de preenchimento", 0);
			return false;
		}

		try {
			Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O campo Valor deve ser preenchido com um número.",
					"Erro de preenchimento", 0);
			return false;
		}

		return true;
	}

	@Override
	public String telaGetValor() {
		return (String) JOptionPane.showInputDialog(null, "Qual o valor deseja converter?", "",
				JOptionPane.QUESTION_MESSAGE, null, null, "");
	}

	@Override
	public double getValor() {
		String valorParaConverter = telaGetValor();

		if (valorParaConverter == null) {
			System.exit(0);
		}

		if (!validaEntrada(valorParaConverter)) {
			System.exit(0);
		}

		return Double.parseDouble(valorParaConverter);
	}

	private double realizaConversaoFahrenheitParaKelvin(double valor) {
		return (valor + 459.67) * 5/9;
		
	}

	private double realizaConversaoFahrenheitParaCelsius(double valor) {
		return (valor - 32) / 1.8;
		
	}

	private double realizaConversaoKelvinParaFahrenheit(double valor) {
		return (valor * 9/5) - 459.67;
		
	}

	private double realizaConversaoKelvinParaCelsius(double valor) {
		return valor - 273.15;
		
	}

	private double realizaConversaoCelsiusParaFahrenheit(double valor) {
		return (valor * 1.8) + 32;
		
	}

	private double realizaConversaoCelsiusParaKelvin(double valor) {
		return valor + 273.15;
		
	}
	
	
	private void mostraConversaoFahrenheitParaKelvin(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoFahrenheitParaKelvin(valor));
		
	}

	private void mostraConversaoFahrenheitParaCelsius(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoFahrenheitParaCelsius(valor) + "°C");
		
	}

	private void mostraConversaoKelvinParaFahrenheit(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoKelvinParaFahrenheit(valor) + "°F");
		
	}

	private void mostraConversaoKelvinParaCelsius(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoKelvinParaCelsius(valor) + "°C");
		
	}

	private void mostraConversaoCelsiusParaFahrenheit(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoCelsiusParaFahrenheit(valor) + "°F");
		
	}

	private void mostraConversaoCelsiusParaKelvin(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: " + realizaConversaoCelsiusParaKelvin(valor));
		
	}

}
