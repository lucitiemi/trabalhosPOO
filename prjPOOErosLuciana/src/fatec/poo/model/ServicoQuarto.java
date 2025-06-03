package fatec.poo.model;

/**
 *
 * @author ltshi
 */
public class ServicoQuarto {
    private int codigo;
    private String descricao;
    private double valor;

    public ServicoQuarto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    
    
}
