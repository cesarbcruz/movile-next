package movile.next.abstracaocategoria.model.cidade;

import movile.next.abstracaocategoria.particionamento.core.Particionavel;
import movile.next.abstracaocategoria.particionamento.core.SubConjunto;
import movile.next.abstracaocategoria.particionamento.core.SubConjuntoTemplate;

public class CidadeUF extends SubConjuntoTemplate {

    public CidadeUF(Particionavel particionavel, SubConjunto subConjunto) {
        super(particionavel, subConjunto);
    }
}
