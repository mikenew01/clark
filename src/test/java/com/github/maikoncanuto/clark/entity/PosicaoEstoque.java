package com.github.maikoncanuto.clark.entity;

public class PosicaoEstoque {

    private String protocolo;
    private String estabelecimento;
    private String produto;
    private String registro;

    public PosicaoEstoque() {
    }

    public PosicaoEstoque(String protocolo, String estabelecimento, String produto, String registro) {
        this.protocolo = protocolo;
        this.estabelecimento = estabelecimento;
        this.produto = produto;
        this.registro = registro;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "PosicaoEstoque{" +
                "protocolo='" + protocolo + '\'' +
                ", estabelecimento='" + estabelecimento + '\'' +
                ", produto='" + produto + '\'' +
                ", registro='" + registro + '\'' +
                '}';
    }
}
