package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;

public class Parametros extends BasePOJO {

    private Empresa empresa;
    private Time manha;
    private Time tarde;
    private Time noite;
    private double custoKm;
    private int margemDeslocamento;
    private Date dataInicio;
    private Date dataTermino;

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the manha
     */
    public Time getManha() {
        return manha;
    }

    /**
     * @param manha the manha to set
     */
    public void setManha(Time manha) {
        this.manha = manha;
    }

    /**
     * @return the tarde
     */
    public Time getTarde() {
        return tarde;
    }

    /**
     * @param tarde the tarde to set
     */
    public void setTarde(Time tarde) {
        this.tarde = tarde;
    }

    /**
     * @return the noite
     */
    public Time getNoite() {
        return noite;
    }

    /**
     * @param noite the noite to set
     */
    public void setNoite(Time noite) {
        this.noite = noite;
    }

    /**
     * @return the custoKm
     */
    public double getCustoKm() {
        return custoKm;
    }

    /**
     * @param custoKm the custoKm to set
     */
    public void setCustoKm(double custoKm) {
        this.custoKm = custoKm;
    }

    /**
     * @return the margemDeslocamento
     */
    public int getMargemDeslocamento() {
        return margemDeslocamento;
    }

    /**
     * @param margemDeslocamento the margemDeslocamento to set
     */
    public void setMargemDeslocamento(int margemDeslocamento) {
        this.margemDeslocamento = margemDeslocamento;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    
}