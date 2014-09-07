package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;

public class CategoriaDespesa extends BasePOJO {

    private String nome;
    private int valorLimite;

   

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valorLimite
     */
    public int getValorLimite() {
        return valorLimite;
    }

    /**
     * @param valorLimite the valorLimite to set
     */
    public void setValorLimite(int valorLimite) {
        this.valorLimite = valorLimite;
    }
}