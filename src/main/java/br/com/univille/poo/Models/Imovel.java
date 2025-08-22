package br.com.univille.poo.Models;

public class Imovel {
    String endereco;

    String tipo;

    int quartos;

    int banheiros;

    String descricao;

    Boolean disponivel;

    public Imovel(String endereco, String tipo, int quartos, int banheiros, String descricao) {
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {this.disponivel = disponivel;}

}
