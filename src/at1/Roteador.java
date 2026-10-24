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

    public void exibirDetalhes() {
        System.out.println("================ROTEADOR================");
        super.exibirDetalhes();
        System.out.println("Quantidade de portas: " + portas);
        System.out.println("Velocidade da rede: " + velocidadeRede);
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
