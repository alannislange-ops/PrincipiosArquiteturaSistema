package at1;

public class Roteador extends Dispositivo {

    private int portas;
    private String velocidadeRede;

    public Roteador(String nome, String fabricante, String codigo,
            int portas, String velocidadeRede) {
        super(nome, fabricante, codigo);
        this.portas = portas;
        this.velocidadeRede = velocidadeRede;
    }

    @Override
    public void ligar() {
        if (isLigado()) {
            System.out.println("Já está ligado!");
            return;
        }
        setLigado(true);
        System.out.println("Ligando Roteador...");
    }

    @Override
    public void desligar() {
        if (!isLigado()) {
            System.out.println("Já está desligado!");
            return;
        }
        setLigado(false);
        System.out.println("Desligando Roteador...");
    }

    @Override
    public void exibirStatus() {
        System.out.println(isLigado() ? "Roteador ligado" : "Roteador desligado");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("================ROTEADOR================");
        System.out.println("Quantidade de portas: " + portas);
        System.out.println("Velocidade da rede: " + velocidadeRede);
        System.out.println("Nome: " + getNome());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Código: " + getCodigo());
        exibirStatus();
        System.out.println("========================================");
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public String getVelocidadeRede() {
        return velocidadeRede;
    }

    public void setVelocidadeRede(String velocidadeRede) {
        this.velocidadeRede = velocidadeRede;
    }

}
