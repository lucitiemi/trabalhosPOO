package fatec.poo.model;

/**
 *
 * @author ltshi
 */
public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
}
