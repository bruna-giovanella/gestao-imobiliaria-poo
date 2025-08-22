package br.com.univille.poo.Models;

import java.math.BigDecimal;
import java.sql.Date;


public class Contrato {

    Long imovelId;

    Long clienteId;

    BigDecimal valorAluguel;

    Date dataInicio;

    Date dataFim;

    Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Contrato(Long imovel, Long cliente, BigDecimal valorAluguel, Date dataInicio, Date dataFim) {
        this.imovelId = imovel;
        this.clienteId = cliente;
        this.valorAluguel = valorAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
