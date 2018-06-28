package f_samp.database.dao;

import f_samp.database.model.Persons;
import f_samp.database.model.Position;
import org.jboss.logging.annotations.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


public interface PersonRepository extends CrudRepository<Persons,Integer> {

    List<Persons> findPersonsByPassport(String pass);

    @Transactional
    void deleteByPassport(String passport);

    @Transactional
    void deleteById(Integer id);

    Collection<Persons> findBySurname(String surname);

    Collection<Persons> findById(Integer id);
}
