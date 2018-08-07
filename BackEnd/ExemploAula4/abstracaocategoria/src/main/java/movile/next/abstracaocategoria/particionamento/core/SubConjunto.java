package movile.next.abstracaocategoria.particionamento.core;


import javax.persistence.*;

@Entity
public class SubConjunto {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    @ManyToOne
    private Particao particao;

    public SubConjunto(String nome, String descricao, Particao particao) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("nome inválido");
        }

        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("descricao inválida");
        }

        if (particao == null) {
            throw new IllegalArgumentException("partição inválida");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.particao = particao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public SubConjunto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public SubConjunto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Particao getParticao() {
        return particao;
    }
}
