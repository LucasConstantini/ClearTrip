package cleartrip.model.pojo;

import cleartrip.model.base.BasePOJO;
import java.sql.Date;
import java.sql.Time;


public class Viagem extends BasePOJO{

    private Usuario usuario;
    private MeioTransporte meiotransporte;
    private String status;
    private String destino;
    private String motivo;
    private String enderecoDestino;
    private String telefoneDestino;
    private String outrosMateriais;
    private String cidadePartida;
    private String enderecoPartida;
    private String telefonePartida;
    private Date dataPartida;
    private Time horaPartida;
    private String aeroportoPartida;
    private String ciaAereaPartida;
    private String numeroVooIda;
    private Date dataCompromisso;
    private Time horaCompromisso;
    private Date dataVolta;
    private Time horaVolta;
    private String aeroportoVolta;
    private String ciaAereaVota;
    private String numeroVooVolta;
    private double valorAdiantamento;
    private double valorReembolso;
    private double valorRessarciamento;
    private String numeroReciboAdiantamento;
    private String numeroReciboRessarcimento;
    private String relatoViagem;
    private Date dataAprovacao;
    private Date dataEncerramento;

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the meiotransporte
     */
    public MeioTransporte getMeiotransporte() {
        return meiotransporte;
    }

    /**
     * @param meiotransporte the meiotransporte to set
     */
    public void setMeiotransporte(MeioTransporte meiotransporte) {
        this.meiotransporte = meiotransporte;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the enderecoDestino
     */
    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    /**
     * @param enderecoDestino the enderecoDestino to set
     */
    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    /**
     * @return the telefoneDestino
     */
    public String getTelefoneDestino() {
        return telefoneDestino;
    }

    /**
     * @param telefoneDestino the telefoneDestino to set
     */
    public void setTelefoneDestino(String telefoneDestino) {
        this.telefoneDestino = telefoneDestino;
    }

    /**
     * @return the outrosMateriais
     */
    public String getOutrosMateriais() {
        return outrosMateriais;
    }

    /**
     * @param outrosMateriais the outrosMateriais to set
     */
    public void setOutrosMateriais(String outrosMateriais) {
        this.outrosMateriais = outrosMateriais;
    }

    /**
     * @return the cidadePartida
     */
    public String getCidadePartida() {
        return cidadePartida;
    }

    /**
     * @param cidadePartida the cidadePartida to set
     */
    public void setCidadePartida(String cidadePartida) {
        this.cidadePartida = cidadePartida;
    }

    /**
     * @return the enderecoPartida
     */
    public String getEnderecoPartida() {
        return enderecoPartida;
    }

    /**
     * @param enderecoPartida the enderecoPartida to set
     */
    public void setEnderecoPartida(String enderecoPartida) {
        this.enderecoPartida = enderecoPartida;
    }

    /**
     * @return the telefonePartida
     */
    public String getTelefonePartida() {
        return telefonePartida;
    }

    /**
     * @param telefonePartida the telefonePartida to set
     */
    public void setTelefonePartida(String telefonePartida) {
        this.telefonePartida = telefonePartida;
    }

    /**
     * @return the dataPartida
     */
    public Date getDataPartida() {
        return dataPartida;
    }

    /**
     * @param dataPartida the dataPartida to set
     */
    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    /**
     * @return the horaPartida
     */
    public Time getHoraPartida() {
        return horaPartida;
    }

    /**
     * @param horaPartida the horaPartida to set
     */
    public void setHoraPartida(Time horaPartida) {
        this.horaPartida = horaPartida;
    }

    /**
     * @return the aeroportoPartida
     */
    public String getAeroportoPartida() {
        return aeroportoPartida;
    }

    /**
     * @param aeroportoPartida the aeroportoPartida to set
     */
    public void setAeroportoPartida(String aeroportoPartida) {
        this.aeroportoPartida = aeroportoPartida;
    }

    /**
     * @return the ciaAereaPartida
     */
    public String getCiaAereaPartida() {
        return ciaAereaPartida;
    }

    /**
     * @param ciaAereaPartida the ciaAereaPartida to set
     */
    public void setCiaAereaPartida(String ciaAereaPartida) {
        this.ciaAereaPartida = ciaAereaPartida;
    }

    /**
     * @return the numeroVooIda
     */
    public String getNumeroVooIda() {
        return numeroVooIda;
    }

    /**
     * @param numeroVooIda the numeroVooIda to set
     */
    public void setNumeroVooIda(String numeroVooIda) {
        this.numeroVooIda = numeroVooIda;
    }

    /**
     * @return the dataCompromisso
     */
    public Date getDataCompromisso() {
        return dataCompromisso;
    }

    /**
     * @param dataCompromisso the dataCompromisso to set
     */
    public void setDataCompromisso(Date dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    /**
     * @return the horaCompromisso
     */
    public Time getHoraCompromisso() {
        return horaCompromisso;
    }

    /**
     * @param horaCompromisso the horaCompromisso to set
     */
    public void setHoraCompromisso(Time horaCompromisso) {
        this.horaCompromisso = horaCompromisso;
    }

    /**
     * @return the dataVolta
     */
    public Date getDataVolta() {
        return dataVolta;
    }

    /**
     * @param dataVolta the dataVolta to set
     */
    public void setDataVolta(Date dataVolta) {
        this.dataVolta = dataVolta;
    }

    /**
     * @return the horaVolta
     */
    public Time getHoraVolta() {
        return horaVolta;
    }

    /**
     * @param horaVolta the horaVolta to set
     */
    public void setHoraVolta(Time horaVolta) {
        this.horaVolta = horaVolta;
    }

    /**
     * @return the aeroportoVolta
     */
    public String getAeroportoVolta() {
        return aeroportoVolta;
    }

    /**
     * @param aeroportoVolta the aeroportoVolta to set
     */
    public void setAeroportoVolta(String aeroportoVolta) {
        this.aeroportoVolta = aeroportoVolta;
    }

    /**
     * @return the ciaAereaVota
     */
    public String getCiaAereaVota() {
        return ciaAereaVota;
    }

    /**
     * @param ciaAereaVota the ciaAereaVota to set
     */
    public void setCiaAereaVota(String ciaAereaVota) {
        this.ciaAereaVota = ciaAereaVota;
    }

    /**
     * @return the numeroVooVolta
     */
    public String getNumeroVooVolta() {
        return numeroVooVolta;
    }

    /**
     * @param numeroVooVolta the numeroVooVolta to set
     */
    public void setNumeroVooVolta(String numeroVooVolta) {
        this.numeroVooVolta = numeroVooVolta;
    }

    /**
     * @return the valorAdiantamento
     */
    public double getValorAdiantamento() {
        return valorAdiantamento;
    }

    /**
     * @param valorAdiantamento the valorAdiantamento to set
     */
    public void setValorAdiantamento(double valorAdiantamento) {
        this.valorAdiantamento = valorAdiantamento;
    }

    /**
     * @return the valorReembolso
     */
    public double getValorReembolso() {
        return valorReembolso;
    }

    /**
     * @param valorReembolso the valorReembolso to set
     */
    public void setValorReembolso(double valorReembolso) {
        this.valorReembolso = valorReembolso;
    }

    /**
     * @return the valorRessarciamento
     */
    public double getValorRessarciamento() {
        return valorRessarciamento;
    }

    /**
     * @param valorRessarciamento the valorRessarciamento to set
     */
    public void setValorRessarciamento(double valorRessarciamento) {
        this.valorRessarciamento = valorRessarciamento;
    }

    /**
     * @return the numeroReciboAdiantamento
     */
    public String getNumeroReciboAdiantamento() {
        return numeroReciboAdiantamento;
    }

    /**
     * @param numeroReciboAdiantamento the numeroReciboAdiantamento to set
     */
    public void setNumeroReciboAdiantamento(String numeroReciboAdiantamento) {
        this.numeroReciboAdiantamento = numeroReciboAdiantamento;
    }

    /**
     * @return the numeroReciboRessarcimento
     */
    public String getNumeroReciboRessarcimento() {
        return numeroReciboRessarcimento;
    }

    /**
     * @param numeroReciboRessarcimento the numeroReciboRessarcimento to set
     */
    public void setNumeroReciboRessarcimento(String numeroReciboRessarcimento) {
        this.numeroReciboRessarcimento = numeroReciboRessarcimento;
    }

    /**
     * @return the relatoViagem
     */
    public String getRelatoViagem() {
        return relatoViagem;
    }

    /**
     * @param relatoViagem the relatoViagem to set
     */
    public void setRelatoViagem(String relatoViagem) {
        this.relatoViagem = relatoViagem;
    }

    /**
     * @return the dataAprovacao
     */
    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    /**
     * @param dataAprovacao the dataAprovacao to set
     */
    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    /**
     * @return the dataEncerramento
     */
    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    /**
     * @param dataEncerramento the dataEncerramento to set
     */
    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
    
}