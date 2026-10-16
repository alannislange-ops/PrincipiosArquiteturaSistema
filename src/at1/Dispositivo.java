package at1;

public abstract class Dispositivo implements interfaceOperavel {

    private String nome;
    private String fabricante;
    private String codigo;
    private boolean ligado = false;

    public Dispositivo(String nome, String fabricante, String codigo) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.codigo = codigo;
    }

    public abstract void exibirDetalhes();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isLigado() {
        return ligado;
    }

    protected void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

}
