package br.com.zupacademy.gui.casadocodigo.configs;

public class ErroDTO {
    private String campo;
    private String descricao;

    @Deprecated
    public ErroDTO() {
    }

    public ErroDTO(String campo, String descricao) {
        this.campo = campo;
        this.descricao = descricao;
    }

    public String getCampo() {
        return campo;
    }

    public String getDescricao() {
        return descricao;
    }
}
