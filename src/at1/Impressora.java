package at1;

public abstract class Impressora extends Dispositivo {

    private String tipo;
    private String velocidadeImpressao;

    public Impressora(String nome, String fabricante, String codigo, String velocidadeImpressao) {
        super(nome, fabricante, codigo);
        this.velocidadeImpressao = velocidadeImpressao;
    }

    @Override 
    public void exibirDetalhes() {
        System.out.println("===============IMPRESSORA===============");
        super.exibirDetalhes();
        System.out.println("Tipo de impressão: " + tipo);
        System.out.println("Velocidade da impressão: " + velocidadeImpressao);

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVelocidadeImpressao() {
        return velocidadeImpressao;
    }

    public void setVelocidadeImpressao(String velocidadeImpressao) {
        this.velocidadeImpressao = velocidadeImpressao;
    }

}
