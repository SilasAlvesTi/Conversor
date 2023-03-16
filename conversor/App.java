package conversor;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		OpcoesDeConversao opcoesDeConversao = new OpcoesDeConversao();

		String opcaoEscolhida = opcoesDeConversao(opcoesDeConversao);

		if (opcaoEscolhida == null) {
			System.exit(0);
		}

		while (true) {
			switch (opcaoEscolhida) {
			case "Conversor de moedas":
				Moedas moedas = new Moedas();
				moedas.tiposDeConversao();
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcaoEscolhida);
			}

			int continuar = JOptionPane.showConfirmDialog(null, "Deseja Continuar?");
			if (continuar == 1) {
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			} else if (continuar == 2) {
				JOptionPane.showMessageDialog(null, "Programa concluído");
				break;
			}

			opcaoEscolhida = opcoesDeConversao(opcoesDeConversao);
		}

	}

	public static String opcoesDeConversao(OpcoesDeConversao opcoesDeConversao) {
		return (String) JOptionPane.showInputDialog(null, "Qual tipo de converção você deseja?", "",
				JOptionPane.QUESTION_MESSAGE, null, opcoesDeConversao.getOpcoesDisponiveis(),
				opcoesDeConversao.getOpcoesDisponiveis()[0]);
	}
}
