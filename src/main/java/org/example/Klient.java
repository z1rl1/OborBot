package org.example;

public class Klient {
    private String ChatId;
    private String spOp;
    private String IdObor;
    private String IdOpl;
    private String IdArenda;
    private String IdPol;

    public Klient(String chatId, String spOp, String idObor, String idOpl, String IdArenda, String IdPol) {
        this.ChatId = chatId;
        this.spOp = spOp;
        this.IdObor = idObor;
        this.IdOpl = idOpl;
        this.IdArenda = IdArenda;
        this.IdPol = IdPol;
    }

    public Klient() {
    }

    public void setChatId(String chatId) {
        ChatId = chatId;
    }

    public void setSpOp(String spOp) {
        this.spOp = spOp;
    }


    public void setIdObor(String idObor) {
        IdObor = idObor;
    }

    public void setIdOpl(String idOpl) {
        IdOpl = idOpl;
    }

    public void setIdArenda(String idArenda) {
        IdArenda = idArenda;
    }

    public String getChatId() {
        return ChatId;
    }

    public String getSpOp() {
        return spOp;
    }

    public String getIdObor() {
        return IdObor;
    }

    public String getIdOpl() {
        return IdOpl;
    }

    public String getIdArenda() {
        return IdArenda;
    }

    public String getIdPol() {
        return IdPol;
    }

    public void setIdPol(String idPol) {
        IdPol = idPol;
    }
}
