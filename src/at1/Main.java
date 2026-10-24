package at1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

    public static void main(String[] args) throws DispositivoNull, AcaoDuplicadaExeption {
        
        int opcao;

        do {
            ExibirMenu.exibirMenu();
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
                    try {
                        Dispositivo dispositivo = buscarObjeto(listaDispositivos);

                        if(dispositivo.isLigado()){
                            throw new AcaoDuplicadaExeption("Dispositivo já estava ligado");
                        }

                        dispositivo.ligar();
                    } catch (NullPointerException e) {
                        System.out.println("Erro: Dispositivo não encontrado");
                    } catch (AcaoDuplicadaExeption e){
                        System.out.println(e);
                    }
                    break;

                case 6:
                    try {
                        Dispositivo dispositivo = buscarObjeto(listaDispositivos);

                        if(dispositivo.isLigado() == false){
                            throw new AcaoDuplicadaExeption("Dispositivo já estava desligado");
                        }

                        dispositivo.desligar();
                    } catch (NullPointerException e) {
                        System.out.println("Erro: Dispositivo não encontrado");
                    } catch (AcaoDuplicadaExeption e){
                        System.out.println(e);
                    }
                    break;

                case 7:
                    try {
                        Dispositivo dispositivo = buscarObjeto(listaDispositivos);
                        dispositivo.exibirDetalhes();
                    } catch (NullPointerException e) {
                        System.out.println("Erro: Dispositivo não encontrado");
                    }
                    break;
                case 8:
                    ExibirRelatorio.exibirRelatorio(listaDispositivos);

                    break;
            }
        } while (opcao < 8);
    }

    public static Dispositivo buscarObjeto(ArrayList<Dispositivo> listaDispositivos) {
        String codigoBusca = lerTexto("Informe o código do Dispositivo: ");

        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getCodigo().equals(codigoBusca)) {
                return dispositivo;
            }
        }
        return null;
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
        String tipoImpressora = lerTexto("Tipo de impressão: \n1 = jato ou 2 = laser) ");
        String velocidadeImpressao = lerTexto("Velocidade de impressão: ");
        System.out.println("==========================================");
        System.out.println("");

        if(tipoImpressora == "1"){
            listaDispositivos.add(new ImpressoraJato(nome, fabricante, codigo, velocidadeImpressao,tipoImpressora));

        }else if(tipoImpressora == "2"){
            listaDispositivos.add(new ImpressoraLaser(nome, fabricante, codigo, velocidadeImpressao, tipoImpressora));
        }

        
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

}
