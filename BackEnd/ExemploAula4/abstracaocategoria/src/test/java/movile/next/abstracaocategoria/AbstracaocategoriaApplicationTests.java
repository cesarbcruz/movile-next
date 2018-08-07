package movile.next.abstracaocategoria;

import movile.next.abstracaocategoria.model.cidade.Cidade;
import movile.next.abstracaocategoria.model.cidade.CidadeUF;
import movile.next.abstracaocategoria.model.usuario.GrupoUsuario;
import movile.next.abstracaocategoria.model.usuario.Usuario;
import movile.next.abstracaocategoria.particionamento.core.Alvo;
import movile.next.abstracaocategoria.particionamento.core.Particao;
import movile.next.abstracaocategoria.particionamento.core.ParticaoRepository;
import movile.next.abstracaocategoria.particionamento.core.SubConjunto;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class AbstracaocategoriaApplicationTests {


    @Autowired
    private ParticaoRepository particaoRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testParticaoCidadeUF() {

        Particao particao = new Particao("UF", "Unidade da Federação", Alvo.CIDADE);
        SubConjunto subConjunto = new SubConjunto("SP", "São Paulo", particao);
        particao.addSubConjunto(subConjunto)
                .addSubConjunto(new SubConjunto("AL", "Alagoas", particao))
                .addSubConjunto(new SubConjunto("BA", "Bahia", particao))
                .addSubConjunto(new SubConjunto("AP", "Amapá", particao))
                .addSubConjunto(new SubConjunto("AM", "Amazonas", particao));

        Cidade cidade = new Cidade("Campinas");
        CidadeUF cidadeUF = new CidadeUF(cidade, subConjunto);
    }

    @Test
    public void testParticaoGrupoUsuario() {

        Particao particao = new Particao("GRUPO_USUARIO", "Grupo de Usuário", Alvo.USUARIO);
        SubConjunto subConjunto = new SubConjunto("ADMINISTRADOR_SISTEMA", "Administrador do sistema", particao);
        particao.addSubConjunto(subConjunto)
                .addSubConjunto(new SubConjunto("COMERCIAL", "Grupo de usuário do setor comercial", particao))
                .addSubConjunto(new SubConjunto("VENDA", "Grupo de usuário do setor venda", particao));

        Usuario usuario = new Usuario("César Cruz", "ccruz");
        GrupoUsuario grupoUsuario = new GrupoUsuario(usuario, subConjunto);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testParticaoGrupoUsuarioInvalido() {

        expectedEx.expect(IllegalStateException.class);
        expectedEx.expectMessage("Não é permitido relacionar CIDADE com Grupo de Usuário");

        Particao particao = new Particao("GRUPO_USUARIO", "Grupo de Usuário", Alvo.USUARIO);
        SubConjunto subConjunto = new SubConjunto("ADMINISTRADOR_SISTEMA", "Administrador do sistema", particao);
        particao.addSubConjunto(subConjunto);

        Cidade cidade = new Cidade("Limeira");
        GrupoUsuario grupoUsuario = new GrupoUsuario(cidade, subConjunto);
    }

    @Test
    public void testGravarParticao(){

        Particao particao = new Particao("GRUPO_USUARIO", "Grupo de Usuário", Alvo.USUARIO);
        SubConjunto subConjunto = new SubConjunto("ADMINISTRADOR_SISTEMA", "Administrador do sistema", particao);
        particao.addSubConjunto(subConjunto)
                .addSubConjunto(new SubConjunto("COMERCIAL", "Grupo de usuário do setor comercial", particao))
                .addSubConjunto(new SubConjunto("VENDA", "Grupo de usuário do setor venda", particao));

        particaoRepository.save(particao);

        Optional<Particao> particaoPersistida = particaoRepository.findById(particao.getId());
        Assert.assertNotNull(particaoPersistida.get());
        Assert.assertEquals(particao.getNome(), particaoPersistida.get().getNome());
        Assert.assertEquals(particao.getDescricao(), particaoPersistida.get().getDescricao());
        Assert.assertEquals(particao.getAlvo(), particaoPersistida.get().getAlvo());
        Assert.assertEquals(particao.getSubConjuntos(), particaoPersistida.get().getSubConjuntos());
    }

}
