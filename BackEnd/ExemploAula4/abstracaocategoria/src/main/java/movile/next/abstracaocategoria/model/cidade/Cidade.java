package movile.next.abstracaocategoria.model.cidade;

import movile.next.abstracaocategoria.particionamento.core.Alvo;
import movile.next.abstracaocategoria.particionamento.core.Particionavel;

public class Cidade implements Particionavel {

    private String nome;

    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Alvo getAlvo() {
        return Alvo.CIDADE;
    }
}
