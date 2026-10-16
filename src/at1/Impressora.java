package at1;

public class Impressora extends Dispositivo {

    private String tipo;
    private String velocidadeImpressao;

    public Impressora(String nome, String fabricante, String codigo, String velocidadeImpressao, String tipo) {
        super(nome, fabricante, codigo);
        this.velocidadeImpressao = velocidadeImpressao;
        validarTipo(tipo);
    }

    private void validarTipo(String tipo) {
        String tipoMinusculo = tipo.toLowerCase();

        if (tipoMinusculo.contains("laser")) {
            this.tipo = tipo;
            System.out.println("Tipo Laser verificado.");
            System.out.println("Tipo de impressão coerente!");
        } else if (tipoMinusculo.contains("jato")) {
            this.tipo = tipo;
            System.out.println("Tipo Jato de tinta verificado.");
            System.out.println("Tipo de impressão coerente!");
        } else {
            System.out.println("Tipo de impressão não é coerente!");
        }
    }

    @Override
    public void ligar() {
        if (isLigado()) {
            System.out.println("Já está ligada!");
            return;
        }
        setLigado(true);
        System.out.println("Ligando Impressora...");
    }

    @Override
    public void desligar() {
        if (!isLigado()) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("Já está desligada!");
            System.out.println("==========================================");
            System.out.println("");
            return;
        }
        setLigado(false);
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("Desligando Impressora...");
        System.out.println("==========================================");
        System.out.println("");
    }

    @Override
    public void exibirStatus() {
        System.out.println(isLigado() ? "Impressora ligada" : "Impressora desligada");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("===============IMPRESSORA===============");
        System.out.println("Tipo de impressão: " + tipo);
        System.out.println("Velocidade da impressão: " + velocidadeImpressao);
        System.out.println("Nome: " + getNome());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Código: " + getCodigo());
        exibirStatus();
        System.out.println("=========================================");
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
