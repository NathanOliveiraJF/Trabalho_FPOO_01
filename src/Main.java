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

//        c.cadastraParticipante(new Participante("Breno"));
//        c.getParticipantes().get(0).setTime(c.getTime(4));
//        c.cadastraParticipante(new Participante("Nathan"));
//        c.getParticipantes().get(1).setTime(c.getTime(7));
//        c.cadastraParticipante(new Participante("Maria"));
//        c.getParticipantes().get(2).setTime(c.getTime(1));
//        c.cadastraParticipante(new Participante("Joana"));
//        c.getParticipantes().get(3).setTime(c.getTime(3));


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
                    System.out.println(c.getTabelaPartidas());
                    break;
                case 3:
                    iniciaCampeonato(c);
                    break;
                case 4:
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
        System.out.println("│ [2] Listas rodadas                            │");
        System.out.println("│ [3] Iniciar campeonato                        │");
        System.out.println("│ [4] Imprimir ranking                          │");
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
        if (c.getPartidas().size() == 0) c.geraTabelaPartidas();

        for (Partida p : c.getPartidas()) {
            System.out.println("Informe o resultado da partida");
            System.out.println(p.getParticipanteA().getNome() + " X " + p.getParticipanteB().getNome());

            System.out.print("Gols feitos por " + p.getParticipanteA().getNome() + ": ");
            int golsA = read.nextInt();
            read.nextLine();

            registraGolJogador(p.getParticipanteA().getTime(), golsA);

            System.out.print("Gols feitos por " + p.getParticipanteB().getNome() + ": ");
            int golsB = read.nextInt();
            read.nextLine();

            registraGolJogador(p.getParticipanteB().getTime(), golsB);

            registraPlacar(p, golsA, golsB);
            System.out.println();
        }
    }

    private static void imprimeRanking(Campeonato c) {
        System.out.println(c.geraRanking());
    }

    private static void registraPlacar(Partida p, int golsA, int golsB) {
        p.setGolsA(golsA);
        p.getParticipanteA().addGolFeito(golsA);
        p.getParticipanteA().addGolSofrido(golsB);

        p.setGolsB(golsB);
        p.getParticipanteB().addGolFeito(golsB);
        p.getParticipanteB().addGolSofrido(golsA);

        p.defineGanhador().addVitoria();
    }

    private static void registraGolJogador(Time t, int gols) {
        if (gols > 0) {
            Scanner read = new Scanner(System.in);

            System.out.println(t.listaJogador());

            for (int i = 0; i < gols; i++) {
                System.out.print("Jogador que marcou o gol " + (i + 1) + ": ");
                t.getJogador((read.nextInt() - 1)).addGol(1);
                read.nextLine();
            }
        }
    }
}
