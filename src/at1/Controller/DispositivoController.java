package at1.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import at1.Computador;
import at1.Dispositivo;
import at1.ImpressoraJato;
import at1.ImpressoraLaser;
import at1.Roteador;

public class DispositivoController {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

    private static String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return sc.next();
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

    public static void listarDispositivos() {
        for (Dispositivo dispositivo : listaDispositivos) {
            dispositivo.exibirDetalhes();
        }

    }

    public static void cadastrarComputador() {
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

    public static void cadastrarImpressora() {
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

    public static void cadastrarRoteador() {
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
}
