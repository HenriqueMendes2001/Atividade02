package test;

import javax.swing.JOptionPane;

import model.Pais;
import service.PaisService;

public class PaisTeste {

	public static void main(String[] args) {
		int menu;

		String menuTxt = "MENU\n" +
						 "1- Adicionar país;\n" +
						 "2- Remover país;\n" +
						 "3- Carregar país\n" +
						 "4- Alterar país\n" +
						 "5- Carregar paÃ­s com a maior população\n" +
						 "6- Carregar paÃ­s com a menor Área\n" +
						 "7- Carregar 3 países\n" +
						 "8- Sair";

		PaisService ps = new PaisService();

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog(menuTxt));

			if (menu == 0) {}
			else if (menu == 1) {
				Pais pais = new Pais(
							0,
							JOptionPane.showInputDialog("Digite o nome do país"),
							Long.parseLong(JOptionPane.showInputDialog("Digite a população do país")),
							Double.parseDouble(JOptionPane.showInputDialog("Digite a Ã¡rea do país"))
						);
				ps.incluir(pais);
			}
			else if (menu == 2) {
				ps.excluir(Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do país para excluir")));
			}
			else if (menu == 3) {
				JOptionPane.showMessageDialog(null, ps.carregar(Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do paÃ­s para carregar"))));
			}
			else if (menu == 4) {
				Pais pais = new Pais(
						Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do país que deseja atualizar os dados")),
						JOptionPane.showInputDialog("Digite o nome do país"),
						Long.parseLong(JOptionPane.showInputDialog("Digite a população do país")),
						Double.parseDouble(JOptionPane.showInputDialog("Digite a Área do país"))
					);
			ps.atualizar(pais);
			}
			else if (menu == 5) {
				JOptionPane.showMessageDialog(null, ps.carregarMaiorPopulacao());
			}
			else if (menu == 6) {
				JOptionPane.showMessageDialog(null, ps.carregarMenorArea());
			}
			else if (menu == 7) {
				String concatenador = "";
				Pais[] paises = ps.carrega3paises();
				for (int i = 0; i < paises.length; i++) {
					concatenador += paises[i] + "\n";
				}
				JOptionPane.showMessageDialog(null, concatenador);
			}

		} while (menu != 8);
	}
}
