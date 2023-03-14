package conversor;

import javax.swing.JOptionPane;

public class Moedas {

	public String[] getOpcoes() {
		String[] opcoes = { "De real para dolar", "De dolar para real" };
		return opcoes;
	}

	public void tiposDeConversao() {
		String comoConverter = (String) JOptionPane.showInputDialog(null, "Para qual moeda deseja converter?", "",
				JOptionPane.QUESTION_MESSAGE, null, getOpcoes(), getOpcoes()[0]);	
		
		double valor = getValor();
		
		switch (comoConverter) {
		case "De real para dolar":
			realizaConversaoParaDolar(valor);
			break;
		case "De dolar para real":
			realizaConversaoParaReal(valor);
			break;

		default:
			break;
		}
	}
	
	private boolean validaEntrada(String valor) {
		if (valor.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "O campo Valor não pode ser vazio.", "Erro de preenchimento", 0);
	        return false; 
	    }

	    try {
	        Double.parseDouble(valor);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "O campo Valor deve ser preenchido com um número.", "Erro de preenchimento", 0);
	        return false; 
	    }
	    
	    
        double valorConvertido = Double.parseDouble(valor);
        if (valorConvertido <= 0) {
        	JOptionPane.showMessageDialog(null, "O campo Valor deve ser um número positivo.", "Erro de preenchimento", 0);
        	return false;
		}
	    
	    
		return true;
	}

	private double getValor() {
		String valorParaConverter = "";

		valorParaConverter = (String) JOptionPane.showInputDialog(null, "Qual tipo de converção você deseja?",
				"", JOptionPane.QUESTION_MESSAGE, null, null, "");
		
		if (!validaEntrada(valorParaConverter)) {
			throw new NumberFormatException();
		}
		
		
		return Double.parseDouble(valorParaConverter);
	}
	
	private void realizaConversaoParaDolar(double valor) {
		mostraOValorConvertidoParaDolar(valor / 5);
	}
	
	private void realizaConversaoParaReal(double valor) {
		mostraOValorConvertidoParaReal(valor * 5);
	}
	
	private void mostraOValorConvertidoParaDolar(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: $" + valor);
	}
	
	private void mostraOValorConvertidoParaReal(double valor) {
		JOptionPane.showMessageDialog(null, "O valor convertido é: R$" + valor);
	}

}
