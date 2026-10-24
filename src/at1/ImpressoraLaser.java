package at1;

public class ImpressoraLaser extends Impressora{

    private String tipoLaser = "Laser";
    public ImpressoraLaser(String nome, String fabricante, String codigo, String velocidadeImpressao, String tipo) {
        super(nome, fabricante, codigo, velocidadeImpressao);
        tipo = tipoLaser;
    }
    public String getTipoLaser() {
        return tipoLaser;
    }
    public void setTipoLaser(String tipoLaser) {
        this.tipoLaser = tipoLaser;
    }
    
}
