package conversor;

import javax.swing.JOptionPane;

public class Moedas implements TiposDeConversao{

	@Override
	public String[] getOpcoes() {
		String[] opcoes = { "De real para dolar", "De dolar para real" };
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
		case "De real para dolar":
			mostraOValorConvertidoParaDolar(valor);
			break;
		case "De dolar para real":
			mostraOValorConvertidoParaReal(valor);
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

		double valorConvertido = Double.parseDouble(valor);
		if (valorConvertido <= 0) {
			JOptionPane.showMessageDialog(null, "O campo Valor deve ser um número positivo.", "Erro de preenchimento",
					0);
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

	private double realizaConversaoParaDolar(double valor) {
		return valor / 5;
	}

	private double realizaConversaoParaReal(double valor) {
		return valor * 5;
	}

	private void mostraOValorConvertidoParaDolar(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: $" + realizaConversaoParaDolar(valor));
	}

	private void mostraOValorConvertidoParaReal(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: R$" + realizaConversaoParaReal(valor));
	}

}
