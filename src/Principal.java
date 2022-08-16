
import br.edu.ifsp.pep.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class Principal {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("aula1PU");
        
        
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(new Date());
        pessoa.setNome("César");
        pessoa.setSalario(new BigDecimal(555.999999d));
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); //inicia uma transação
        
//        em.persist(pessoa);//insert
        em.merge(pessoa); //update se o objeto existir, senão faz o insert
        
        em.getTransaction().commit(); //finaliza a transação
        
        
        
        
        
    }
    
}
