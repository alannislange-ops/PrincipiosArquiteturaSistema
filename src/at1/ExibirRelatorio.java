package at1;

import java.util.ArrayList;

public class ExibirRelatorio {
    public static void exibirRelatorio(ArrayList<Dispositivo> listaDispositivos) {
        int totalDispositivos = listaDispositivos.size();
        int computadores = 0;
        int impressoras = 0;
        int roteadores = 0;

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
