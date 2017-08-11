package app.repositories;

import app.models.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {

    @Query("SELECT p FROM Photographer AS p WHERE CONCAT(p.firstName,' ', p.lastName) = :name")
    Photographer findByName(@Param(value = "name") String fullName);

    List<Photographer> findAllByOrderByFirstNameAscLastNameDesc();

    @Query("SELECT p FROM Photographer AS p WHERE p.primaryCamera.cameraType = 'DSLR' ORDER BY p.firstName ASC ")
    List<Photographer> findAllLandscapePhotographers();

    @Query("SELECT p FROM Photographer AS p WHERE p.primaryCamera.make = p.secondaryCamera.make")
    List<Photographer> sameCamMakePhotographers();

}
