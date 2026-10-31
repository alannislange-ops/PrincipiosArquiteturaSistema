package at1;

import java.util.List;

public class ExibirRelatorio {
    public static void exibirRelatorio(List<Dispositivo> listaDispositivos) {
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
        System.out.println("Computador: % "+ percentualComputadores);
        System.out.println("Impressora: % "+ percentualImpressoras);
        System.out.println("Roteador: % "+ percentualRoteadores);
        System.out.println("==========================================");
        System.out.println("");
    }
}
