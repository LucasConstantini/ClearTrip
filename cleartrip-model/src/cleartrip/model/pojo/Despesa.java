package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;

public class Despesa extends BasePOJO {

   private CategoriaDespesa categoriaDespesa;
   private Viagem viagem;
   private byte[] comprovante;
   private double valor;
   private String nomeEstabelecimento;
   private Date dataCompra;
   private Time horaCompra;
   private long cnpj;
   private String descritivo;
   private long valorRealAutorizado;

    /**
     * @return the categoriaDespesa
     */
    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    /**
     * @param categoriaDespesa the categoriaDespesa to set
     */
    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    /**
     * @return the viagem
     */
    public Viagem getViagem() {
        return viagem;
    }

    /**
     * @param viagem the viagem to set
     */
    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    /**
     * @return the comprovante
     */
    public byte[] getComprovante() {
        return comprovante;
    }

    /**
     * @param comprovante the comprovante to set
     */
    public void setComprovante(byte[] comprovante) {
        this.comprovante = comprovante;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the nomeEstabelecimento
     */
    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    /**
     * @param nomeEstabelecimento the nomeEstabelecimento to set
     */
    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the horaCompra
     */
    public Time getHoraCompra() {
        return horaCompra;
    }

    /**
     * @param horaCompra the horaCompra to set
     */
    public void setHoraCompra(Time horaCompra) {
        this.horaCompra = horaCompra;
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

    /**
     * @return the descritivo
     */
    public String getDescritivo() {
        return descritivo;
    }

    /**
     * @param descritivo the descritivo to set
     */
    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    /**
     * @return the valorRealAutorizado
     */
    public long getValorRealAutorizado() {
        return valorRealAutorizado;
    }

    /**
     * @param valorRealAutorizado the valorRealAutorizado to set
     */
    public void setValorRealAutorizado(long valorRealAutorizado) {
        this.valorRealAutorizado = valorRealAutorizado;
    }
   
    
}