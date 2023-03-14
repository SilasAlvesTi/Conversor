package conversor;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		OpcoesDeConversao opcoesDeConversao = new OpcoesDeConversao();
		
		String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, "Qual tipo de converção você deseja?", "",
				JOptionPane.QUESTION_MESSAGE, null, opcoesDeConversao.getOpcoesDisponiveis(), opcoesDeConversao.getOpcoesDisponiveis()[0]);
		
		switch (opcaoEscolhida) {
			case "Conversor de moedas":
				Moedas moedas = new Moedas();
				moedas.tiposDeConversao();
				break;
	
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcaoEscolhida);
		}
	}
}
