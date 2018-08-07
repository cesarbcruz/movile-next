package movile.next.abstracaocategoria.particionamento.core;

public abstract class SubConjuntoTemplate {

    private Particionavel particionavel;
    private SubConjunto subConjunto;

    public SubConjuntoTemplate(Particionavel particionavel, SubConjunto subConjunto) {

        if(!subConjunto.getParticao().getAlvo().equals(particionavel.getAlvo())){
            throw new IllegalStateException("Não é permitido relacionar "+particionavel.getAlvo()+
                    " com "+subConjunto.getParticao().getDescricao());
        }

        this.particionavel = particionavel;
        this.subConjunto = subConjunto;
    }

    public Particionavel getParticionavel() {
        return particionavel;
    }

    public SubConjunto getSubConjunto() {
        return subConjunto;
    }



}
