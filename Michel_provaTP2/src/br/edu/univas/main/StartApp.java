package br.edu.univas.main;

import java.util.Scanner;
import br.edu.univas.vo.Conta;

public class StartApp {
	static Scanner l = new Scanner(System.in);

	public static void main(String[] args) {
		Conta[] contas = new Conta[100];
		String op;
		do {
			menu();
			op = l.nextLine();
			if (op.equals("1")) {
				cadastrarConta(contas);
			} else if (op.equals("2")) {
				verSaldo(contas);
			} else if (op.equals("3")) {
				break;
			} else {

			}
		} while (true);
		l.close();
		System.out.println("FIM!");
	}

	public static void cadastrarConta(Conta[] contas) {
		int i = 0;
		do {
			if (contas[i] == null) {
				Conta conta = new Conta();
				System.out.println("\n Cadastro de Conta: ");
				System.out.println("Digite uma breve descrição da conta: ");
				conta.desc = l.nextLine();
				System.out.println("Digite o valor da conta: ");
				conta.valor = l.nextFloat();
				l.nextLine();
				System.out.println("Digite a data de vencimento da conta: ");
				conta.data = l.nextLine();
				System.out.println("Digite o tipo de conta: Despesa ou Receita.");
				conta.tipo = l.nextLine();
				contas[i] = conta;
				break;
			}
			i++;
		} while (true);
	}

	public static void verSaldo(Conta[] contas) {
		float receita = 0;
		float despesa = 0;
		for (int i = 0; i < 100; i++) {
			if (contas[i] != null) {
				Conta conta = contas[i];
				if (conta.tipo.equals("Despesa")) {
					despesa = conta.valor + despesa;
				} else if (conta.tipo.equals("Receita")) {
					receita = conta.valor + receita;
				} else {

				}
			}
		}
		float saldo = receita - despesa;
		if (saldo > 0) {
			System.out.printf("\n Saldo Positivo: %.2f %n", saldo);
		} else if (saldo < 0) {
			System.out.printf("\n Saldo Negativo: %.2f %n", saldo);
		} else {
			System.out.println("\n Saldo Zerado!");
		}
	}

	public static void menu() {
		System.out.println("- MENU - \n");
		System.out.println("1 - Cadastro de conta");
		System.out.println("2 - Ver Saldo ");
		System.out.println("3 - Sair");
	}
}
