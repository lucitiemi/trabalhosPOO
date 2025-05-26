
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
        
        System.out.println(quarto.getSituacao());
        
        Registro reg = new Registro(456, LocalDate.of(2025, 5, 1), recep);
        reg.reservarQuarto(hosp, quarto);
        reg.addServico(serv);
        
        System.out.println(quarto.getSituacao());
        System.out.println(reg.getHospede().getNome());
        System.out.println(serv.getValor());
        System.out.println(reg.getQuarto().getNumero());
        
        reg.setDataSaida(LocalDate.of(2025, 5, 5));
        
        double totalPagar = reg.liberarQuarto();
        
        System.out.println(totalPagar);
        
        
    }
    
}
