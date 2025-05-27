
import fatec.poo.model.*;
import java.time.LocalDate;

/**
 *
 * @author ltshi
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hospede hosp = new Hospede("322.035.228-60", "Luciana");
        Recepcionista recep = new Recepcionista(123, "Eros");
        Quarto quarto = new Quarto(302, "S", 100);
        ServicoQuarto serv = new ServicoQuarto(1, "janta");
        
        hosp.setTaxaDesconto(10);
        serv.setValor(20);
        
        System.out.println("Situacao quarto: " + quarto.getSituacao());
        
        Registro reg = new Registro(456, LocalDate.of(2025, 5, 1), recep);
        reg.reservarQuarto(hosp, quarto);
        reg.addServico(serv);
        
        System.out.println("Situacao quarto: " + quarto.getSituacao());
        System.out.println("Nome hospede: " + reg.getHospede().getNome());
        System.out.println("Nome recepcionista: " + reg.getRecepcionista().getNome());
        System.out.println("Valor seviço: " + serv.getValor());
        System.out.println("Numero do quarto: " + reg.getQuarto().getNumero());
        
        reg.setDataSaida(LocalDate.of(2025, 5, 5));
        
        double valorHosp1 = reg.liberarQuarto();
        
        System.out.println("Valor primeira hospedagem " + valorHosp1);
        System.out.println("Total faturado quarto: " + quarto.getTotalFaturado());
        System.out.println("Situacao quarto: " + quarto.getSituacao());
        
        Registro reg2 = new Registro(789, LocalDate.of(2025, 5, 1), recep);
        reg2.reservarQuarto(hosp, quarto);
        
        System.out.println("Situacao quarto: " + quarto.getSituacao());
        System.out.println("Nome hospede: " + reg2.getHospede().getNome());
        System.out.println("Nome recepcionista: " + reg2.getRecepcionista().getNome());
        System.out.println("Numero do quarto: " + reg2.getQuarto().getNumero());
        
        reg2.setDataSaida(LocalDate.of(2025, 5, 5));
        
        double valorHosp2 = reg2.liberarQuarto();
        
        System.out.println("Valor segunda hospedagem " + valorHosp2);
        System.out.println("Total faturado quarto: " + quarto.getTotalFaturado());
        System.out.println("Situacao quarto: " + quarto.getSituacao());
        
        
    }
    
}
