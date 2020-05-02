import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continuar = true;
        Campeonato c = new Campeonato();
        Scanner read = new Scanner(System.in);

        System.out.println("╭───────────────────────────────────────────────╮");
        System.out.println("│              Campeonato de Fifa               │");
        System.out.println("╰───────────────────────────────────────────────╯");

        c.cadastraParticipante(new Participante("Breno"));
        c.cadastraParticipante(new Participante("Maria"));
        c.cadastraParticipante(new Participante("Joana"));
        c.cadastraParticipante(new Participante("Nathan"));

        while (continuar) {
            printMenu();
            askForOption();

            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    cadastraParticipante(c);
                    break;
                case 2:
                    iniciaCampeonato(c);
                    break;
                case 3:
                    imprimeRanking(c);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
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
        Scanner read = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Nome do participante: ");
            Participante novoParticipante = new Participante(read.nextLine());

            listaTimesDisponiveis(c);
            System.out.print("Escolha o seu time: ");
            int time = read.nextInt();
            read.nextLine();

            novoParticipante.setTime(c.getTime(time - 1));
            c.cadastraParticipante(novoParticipante);

            System.out.print("Cadastra um novo participante? [s/n] ");
            continuar = read.nextLine().toLowerCase().equals("s");
        }
    }

    private static void listaTimesDisponiveis(Campeonato c) {
        System.out.println("╭───────────────────────────────────────────────╮");
        System.out.println("│           Lista de times disponíveis          │");
        System.out.println("╰───────────────────────────────────────────────╯");
        System.out.println(c.listTimesDisponiveis());
    }

    private static void iniciaCampeonato(Campeonato c) {
        Scanner read = new Scanner(System.in);
        System.out.println(c.getTabelaPartidas());

        for (Partida p : c.getPartidas()) {
            System.out.println("Informe o resultado da partida");
            System.out.println(p.getParticipanteA().getNome() + " X " + p.getParticipanteB().getNome());

            System.out.print("Gols feitos por " + p.getParticipanteA().getNome() + ": ");
            p.setGolsA(read.nextInt());
            read.nextLine();
            p.getParticipanteA().addGolFeito(p.getGolsA());
            p.getParticipanteB().addGolSofrido(p.getGolsA());
            // Perguntar quem foi o jogador que fez cada um dos gols.

            System.out.print("Gols feitos por " + p.getParticipanteB().getNome() + ": ");
            p.setGolsB(read.nextInt());
            read.nextLine();
            p.getParticipanteB().addGolFeito(p.getGolsB());
            p.getParticipanteA().addGolSofrido(p.getGolsB());
            // Perguntar quem foi o jogador que fez cada um dos gols.

            p.defineGanhador().addVitoria();
            System.out.println();
        }
    }

    private static void imprimeRanking(Campeonato c) {
        System.out.println(c.geraRanking());
    }
}
