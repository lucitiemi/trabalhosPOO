package fatec.poo.control;

import fatec.poo.model.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ltshi
 */
public class DaoQuarto {
    private Connection conn;

    public DaoQuarto(Connection conn) {
        this.conn = conn;
    }
    
    public Quarto consultar(int numero) {
        Quarto objQuarto = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from tblQuarto where Numero_Quarto = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery(); 
           
            if (rs.next()) {
                objQuarto = new Quarto(rs.getInt("Numero_Quarto"),rs.getString("Tipo_Quarto"),rs.getDouble("ValorDiaria_Quarto"));
                objQuarto.setSituacao(rs.getBoolean("Situacao_Quarto"));
                objQuarto.setTotalFaturado(rs.getDouble("TotalFaturado_Quarto"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return objQuarto;
    }
    
    public void inserir(Quarto quarto) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblQuarto(Numero_Quarto, Tipo_Quarto, Situacao_Quarto, ValorDiaria_Quarto, TotalFaturado_Quarto) VALUES (?,?,?,?,?)");
            ps.setInt(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setBoolean(3, quarto.getSituacao());
            ps.setDouble(4, quarto.getValorDiaria());
            ps.setDouble(5, quarto.getTotalFaturado());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Quarto quarto) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE tblQuarto SET Tipo_Quarto = ?, " +
                                                              "Situacao_Quarto = ?, " +
                                                              "ValorDiaria_Quarto = ?, " +
                                                              "TotalFaturado_Quarto = ? " +
                                                         "WHERE Numero_Quarto = ?");
            ps.setString(1, quarto.getTipo());
            ps.setBoolean(2, quarto.getSituacao());
            ps.setDouble(3, quarto.getValorDiaria());
            ps.setDouble(4, quarto.getTotalFaturado());
            ps.setInt(5, quarto.getNumero());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Quarto quarto) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM tblQuarto WHERE Numero_Quarto = ?");
            ps.setInt(1, quarto.getNumero());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
        
    
    
    
}
