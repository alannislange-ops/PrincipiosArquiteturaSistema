package at1;

public class Computador extends Dispositivo {

    private String quantidadeRam;
    private String sistemaOperacional;

    public Computador(String nome, String fabricante, String codigo,
            String quantidadeRam, String sistemaOperacional) {
        super(nome, fabricante, codigo);
        this.quantidadeRam = quantidadeRam;
        this.sistemaOperacional = sistemaOperacional;
    }

    @Override 
    public void exibirDetalhes() {
        System.out.println("===============COMPUTADOR===============");
        super.exibirDetalhes();
        System.out.println("Quantidade de memória RAM: " + quantidadeRam);
        System.out.println("Sistema operacional: " + sistemaOperacional);
    }

    public String getQuantidadeRam() {
        return quantidadeRam;
    }

    public void setQuantidadeRam(String quantidadeRam) {
        this.quantidadeRam = quantidadeRam;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }


}
