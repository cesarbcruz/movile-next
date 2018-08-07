package movile.next.abstracaocategoria.particionamento.core;



import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Particao {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Alvo alvo;
    @OneToMany
    private Set<SubConjunto> subConjuntos = new HashSet<>();

    public Particao(String nome, String descricao, Alvo alvo) {
        this.nome = nome;
        this.descricao = descricao;
        this.alvo = alvo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Particao setNome(String nome) {
        this.nome = nome; return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Particao setDescricao(String descricao) {
        this.descricao = descricao; return this;
    }

    public Set<SubConjunto> getSubConjuntos() {
        return subConjuntos;
    }

    public Particao addSubConjunto(SubConjunto subConjunto) {
        this.subConjuntos.add(subConjunto); return this;
    }

    public void setAlvo(Alvo alvo) {
        this.alvo = alvo;
    }

    public Alvo getAlvo() {
        return alvo;
    }
}
