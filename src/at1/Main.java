package at1;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarComputador();
                    break;
                case 2:
                    cadastrarImpressora();
                    break;
                case 3:
                    cadastrarRoteador();
                    break;
                case 4:
                    listarDispositivos();
                    break;
                case 5:
                    executarPorCodigo(Dispositivo::ligar);
                    break;
                case 6:
                    executarPorCodigo(Dispositivo::desligar);
                    break;
                case 7:
                    executarPorCodigo(Dispositivo::exibirDetalhes);
                    break;
                case 9:
                    exibirRelatorio();
                    break;
                default:
                    break;
            }
        } while (opcao != 8);
    }

    private static void exibirMenu() {
        System.out.println("");
        System.out.println("==================MENU===================");
        System.out.println("1 - Cadastrar Computador");
        System.out.println("2 - Cadastrar Impressora");
        System.out.println("3 - Cadastrar Roteador");
        System.out.println("4 - Listar Dispositivos");
        System.out.println("5 - Ligar Dispositivo");
        System.out.println("6 - Desligar Dispositivo");
        System.out.println("7 - Exibir Detalhes de um Dispositivo");
        System.out.println("8 - Sair");
        System.out.println("9 - Relatório geral");
        System.out.println("==========================================");
        System.out.println("");
    }

    private static String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return sc.next();
    }

    private static void cadastrarComputador() {
        System.out.println("");
        System.out.println("==========================================");
        String nome = lerTexto("Nome: ");
        String fabricante = lerTexto("Fabricante: ");
        String codigo = lerTexto("Código: ");
        String quantidadeRam = lerTexto("Memória RAM: ");
        String sistemaOperacional = lerTexto("Sistema operacional: ");
        System.out.println("==========================================");
        System.out.println("");

        listaDispositivos.add(new Computador(nome, fabricante, codigo, quantidadeRam, sistemaOperacional));
    }

    private static void cadastrarImpressora() {
        System.out.println("");
        System.out.println("==========================================");
        String nome = lerTexto("Nome: ");
        String fabricante = lerTexto("Fabricante: ");
        String codigo = lerTexto("Código: ");
        String tipo = lerTexto("Tipo de impressão: (jato ou laser) ");
        String velocidadeImpressao = lerTexto("Velocidade de impressão: ");
        System.out.println("==========================================");
        System.out.println("");

        listaDispositivos.add(new Impressora(nome, fabricante, codigo, velocidadeImpressao, tipo));
    }

    private static void cadastrarRoteador() {
        System.out.println("");
        System.out.println("==========================================");
        String nome = lerTexto("Nome: ");
        String fabricante = lerTexto("Fabricante: ");
        String codigo = lerTexto("Código: ");

        System.out.println("Quantidade de portas: ");
        int portas = sc.nextInt();

        if (portas < 0) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("Este roteador não será cadastrado pois porta não pode ser negativa!");
            System.out.println("Tente novamente com valor positivo!");
            System.out.println("==========================================");
            System.out.println("");
            return;
        }

        String velocidadeRede = lerTexto("Velocidade da rede: ");
        System.out.println("==========================================");
        System.out.println("");

        listaDispositivos.add(new Roteador(nome, fabricante, codigo, portas, velocidadeRede));
    }

    private static void listarDispositivos() {
        for (Dispositivo dispositivo : listaDispositivos) {
            dispositivo.exibirDetalhes();
        }
    }

    private static void executarPorCodigo(Consumer<Dispositivo> acao) {
        System.out.println("");
        System.out.println("==========================================");
        String busca = lerTexto("Informe o código do Dispositivo: ");
        boolean encontrou = false;

        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getCodigo().contains(busca)) {
                acao.accept(dispositivo);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("Objeto não encontrado.");
            System.out.println("==========================================");
            System.out.println("");
        }
    }

    private static void exibirRelatorio() {
        int totalDispositivos = listaDispositivos.size();
        int computadores = 0;
        int impressoras = 0;
        int roteadores = 0;

        if (totalDispositivos == 0) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("Nenhum dispositivo cadastrado.");
            System.out.println("==========================================");
            System.out.println("");
            return;
        }

        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof Computador) {
                computadores++;
            }
            if (dispositivo instanceof Impressora) {
                impressoras++;
            }
            if (dispositivo instanceof Roteador) {
                roteadores++;
            }
        }

        double percentualComputadores = computadores * 100.0 / totalDispositivos;
        double percentualImpressoras = impressoras * 100.0 / totalDispositivos;
        double percentualRoteadores = roteadores * 100.0 / totalDispositivos;

        System.out.println("");
        System.out.println("================RELATÓRIO================");
        System.out.println("Total de dispositivos cadastrados: " + totalDispositivos);
        System.out.println("Total de computadores cadastrados: " + computadores);
        System.out.println("Total de impressoras cadastradas: " + impressoras);
        System.out.println("Total de roteadores cadastrados: " + roteadores);
        System.out.println("==========================================");
        System.out.println("Percentual que cada categoria representa do total");
        System.out.printf("Computador: % ", percentualComputadores);
        System.out.printf("Impressora: % ", percentualImpressoras);
        System.out.printf("Roteador: % ", percentualRoteadores);
        System.out.println("==========================================");
        System.out.println("");
    }

}
