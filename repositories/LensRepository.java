package app.repositories;

import app.models.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long>{

    List<Lens> findByIdIn(Iterable<Long> id);

}
