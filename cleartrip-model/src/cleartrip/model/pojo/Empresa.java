package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

public class Empresa extends BasePOJO{
	private String nome;
        private String nomeFantasia;
        private String endereco;
        private String telefone;
        private String nomeRepresentante;
        private long cpfRepresentante;
        private long cnpj;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the nomeRepresentante
     */
    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    /**
     * @param nomeRepresentante the nomeRepresentante to set
     */
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    /**
     * @return the cpfRepresentante
     */
    public long getCpfRepresentante() {
        return cpfRepresentante;
    }

    /**
     * @param cpfRepresentante the cpfRepresentante to set
     */
    public void setCpfRepresentante(long cpfRepresentante) {
        this.cpfRepresentante = cpfRepresentante;
    }

    /**
     * @return the cnpj
     */
    public long getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
 }