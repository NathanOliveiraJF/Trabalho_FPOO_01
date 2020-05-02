import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Campeonato c = new Campeonato();
        Scanner read = new Scanner(System.in);

        System.out.println("╭───────────────────────────────────────────────╮");
        System.out.println("│              Campeonato de Fifa               │");
        System.out.println("╰───────────────────────────────────────────────╯");

        printMenu();
        askForOption();

        int option = read.nextInt();
        read.nextLine();

        switch (option) {
            case 1:
                cadastraParticipante(c);
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                System.exit(0);
                break;
        }

        Participante breno = new Participante("Breno");
        breno.setTime(c.getTime(0));
        c.cadastraParticipante(breno);

        c.cadastraParticipante(new Participante("Nathan"));
        c.cadastraParticipante(new Participante("Jorge"));
        c.cadastraParticipante(new Participante("Gustavo"));
        c.cadastraParticipante(new Participante("Maria"));
        c.cadastraParticipante(new Participante("Betânia"));

        System.out.println("Gerando a tabela de partidas...");
        c.geraTabelaPartidas();

        System.out.println("Imprimindo a tabela de partidas...");
        System.out.print(c.getTabelaPartidas());

        System.out.println("\n===== Lista de times disponíveis ======");
        System.out.println(c.listTimesDisponiveis());

	    // Chama o metodo que popula a lista de times.
    }

    private static void printMenu() {
        System.out.println("╭───────────────────────────────────────────────╮");
        System.out.println("│ [1] Cadastrar participantes                   │");
        System.out.println("│ [2] Iniciar campeonato                        │");
        System.out.println("│ [3] Imprimir ranking                          │");
        System.out.println("│ [0] Sair do programa                          │");
        System.out.println("╰───────────────────────────────────────────────╯");
    }

    private static void askForOption() {
        System.out.print("Escolha: ");
    }

    private static void cadastraParticipante(Campeonato c) {
        c.cadastraParticipante(new Participante("Breno"));
    }
}
