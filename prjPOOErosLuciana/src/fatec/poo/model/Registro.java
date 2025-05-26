package fatec.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author ltshi
 */
public class Registro {
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private Hospede hospede;
    private Recepcionista recepcionista;
    private ArrayList<ServicoQuarto> servicosQuarto;
    private Quarto quarto;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        servicosQuarto = new ArrayList<ServicoQuarto>();
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }


    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }
    

    public double getValorHospedagem() {
        return valorHospedagem;
    }
    
    public void addServico(ServicoQuarto servico) {
        servicosQuarto.add(servico);
    }

    public Quarto getQuarto() {
        return quarto;
    }

    
    public void reservarQuarto(Hospede hospede, Quarto quarto){
        quarto.reservar();
        this.hospede = hospede;
        this.quarto = quarto;
    }
    
    public double liberarQuarto() {
        long qtdDias = ChronoUnit.DAYS.between(dataEntrada,dataSaida);
        System.out.println(qtdDias);
        System.out.println(quarto.getTotalFaturado());
        double totalFat = quarto.liberar(qtdDias);
        double totalServ = 0;
        for (ServicoQuarto s : servicosQuarto) {
            totalServ += s.getValor();
        }
        return totalFat*(1-(hospede.getTaxaDesconto()/100)) + totalServ;
    }

}
