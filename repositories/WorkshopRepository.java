package app.repositories;

import app.models.WorkShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<WorkShop, Long> {
}
