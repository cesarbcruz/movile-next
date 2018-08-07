package movile.next.abstracaocategoria.particionamento.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ParticaoRepository extends JpaRepository<Particao, Long> {

    Optional<Particao> findByAlvo(Alvo alvo);
}
