package at1;

import java.util.ArrayList;
import java.util.Scanner;

import at1.Controller.DispositivoController;

public class Main {

    public static void main(String[] args) throws DispositivoNull, AcaoDuplicadaExeption {
        
        int opcao;

        do {
            ExibirMenu.exibirMenu();

            switch (opcao) {
                case 1:
                    DispositivoController.cadastrarComputador();
                    break;
                case 2:
                    DispositivoController.cadastrarImpressora();
                    break;
                case 3:
                    DispositivoController.cadastrarRoteador();
                    break;
                case 4:
                    DispositivoController.listarDispositivos();
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

}
