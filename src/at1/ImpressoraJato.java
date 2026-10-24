package at1;

public class ImpressoraJato extends Impressora{

    private String tipoJato = "Jato";
    public ImpressoraJato(String nome, String fabricante, String codigo, String velocidadeImpressao, String tipo) {
        super(nome, fabricante, codigo, velocidadeImpressao);
        tipo = tipoJato;
    }
    public String getTipoJato() {
        return tipoJato;
    }
    public void setTipoJato(String tipoJato) {
        this.tipoJato = tipoJato;
    }
    
}
