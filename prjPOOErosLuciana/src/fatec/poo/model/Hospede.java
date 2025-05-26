package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author ltshi
 */
public class Hospede extends Pessoa{
    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros;

    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
        registros = new ArrayList<Registro>();
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
    
    public void addRegistro (Registro r){
        registros.add(r);
        r.setHospede(this);
    }
}
