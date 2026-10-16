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
    public void ligar() {
        if (isLigado()) {
            System.out.println("Já está ligado!");
            return;
        }
        setLigado(true);
        System.out.println("Ligando Computador...");
    }

    @Override
    public void desligar() {
        if (!isLigado()) {
            System.out.println("Já está desligado!");
            return;
        }
        setLigado(false);
        System.out.println("Desligando Computador...");
    }

    @Override
    public void exibirStatus() {
        System.out.println(isLigado() ? "Computador ligado" : "Computador desligado");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===============COMPUTADOR===============");
        System.out.println("Quantidade de memória RAM: " + quantidadeRam);
        System.out.println("Sistema operacional: " + sistemaOperacional);
        System.out.println("Nome: " + getNome());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Código: " + getCodigo());
        exibirStatus();
        System.out.println("========================================");
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
