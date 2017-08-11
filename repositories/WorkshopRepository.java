package app.repositories;

import app.models.WorkShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<WorkShop, Long> {

    @Query("SELECT w FROM WorkShop AS w WHERE w.participant.size >= 5 GROUP BY w.location")
    List<WorkShop> findAllByLocation();

    @Query("SELECT DISTINCT w.location FROM WorkShop AS w")
    List<String> findAllLocations();

    @Query("SELECT w FROM WorkShop AS w WHERE w.location = :location AND w.participant.size >= 5")
    List<WorkShop> findWorkshopsByLocation(@Param(value = "location") String location);

}
