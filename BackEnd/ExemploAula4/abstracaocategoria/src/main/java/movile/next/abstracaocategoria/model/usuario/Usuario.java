package movile.next.abstracaocategoria.model.usuario;

import movile.next.abstracaocategoria.particionamento.core.Alvo;
import movile.next.abstracaocategoria.particionamento.core.Particionavel;

public class Usuario implements Particionavel {

    private String nome;
    private String login;

    public Usuario(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Alvo getAlvo() {
        return Alvo.USUARIO;
    }
}
