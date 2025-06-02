package fatec.poo.model;

/**
 *
 * @author ltshi
 */
public class Quarto {
    private int numero;
    private String tipo;
    private boolean situacao;
    private double valorDiaria;
    private double totalFaturado;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }
    
    
    
    public void reservar() {
        situacao = true;
    }
    
    public double liberar(long qtdDias) {
        situacao = false;
        double valorHosp = qtdDias*valorDiaria;
        totalFaturado += valorHosp;
        return valorHosp;
    }
}
