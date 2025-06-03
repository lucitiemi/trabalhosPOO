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
    
    public static boolean validarCPF(String cpf){
        // verifica se tem 11 digitos
        if(cpf.length() != 11) {
            return false;
        }
        
        // verifica se todos sao iguais
        if(cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        // convertendo pra array de inteiros
        int digitos[] = new int[11];
        for (int i=0; i<11; i++) {
            digitos[i] = cpf.charAt(i) - '0'; // (converte implicito)
        }
        
        // calculo do 1o digito
        int soma1 = 0;
        for (int i=0; i<9; i++) {
            soma1 += digitos[i] * (i+1);
        }
        int resto1 = soma1 % 11;
        int digVer1 = (resto1 == 10)? 0 : resto1; // operador ternario
        if (digVer1 != digitos[9]) {
            return false;
        }
        
        // calculo do 2o digito
        int soma2 = 0;
        for (int i=0; i<10; i++) {
            soma2 += digitos[i] * (11-i);
        }
        int resto2 = (soma2*10) % 11;
        int digVer2 = (resto2 == 10)? 0 : resto2; // operador ternario
        if (digVer2 != digitos[10]) {
            return false;
        }
        return true;
        
        // poderia trocar o ultimo if por:
        // return digitos[10] == digVer2;
    };
}
