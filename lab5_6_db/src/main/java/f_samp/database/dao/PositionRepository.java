package f_samp.database.dao;

import org.springframework.data.repository.CrudRepository;
import f_samp.database.model.Position;
import f_samp.database.model.Persons;
import javax.persistence.Query;

import java.util.Collection;
import java.util.List;

public interface PositionRepository extends CrudRepository<Position,Integer> {
    Collection<Position> findByPosition(String position);

}

