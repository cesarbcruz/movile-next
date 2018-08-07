package movile.next.abstracaocategoria.model.usuario;

import movile.next.abstracaocategoria.particionamento.core.Particionavel;
import movile.next.abstracaocategoria.particionamento.core.SubConjunto;
import movile.next.abstracaocategoria.particionamento.core.SubConjuntoTemplate;

public class GrupoUsuario extends SubConjuntoTemplate {
    public GrupoUsuario(Particionavel particionavel, SubConjunto subConjunto) {
        super(particionavel, subConjunto);
    }
}
