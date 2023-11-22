package com.stac.daijin.domain.clinic.domain.repository;

import com.stac.daijin.domain.clinic.domain.Coordinate;
import com.stac.daijin.domain.clinic.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, UUID> {

    @Query(
            "SELECT clinc FROM Clinic clinc "
                    + "WHERE ( 6371000 * acos( cos( radians(:#{#current_coordinate.latitude}) ) "
                    + "      * cos( radians( clinc.coordinate.latitude ) ) "
                    + "      * cos( radians( clinc.coordinate.longitude ) - radians(:#{#current_coordinate.longitude}) ) "
                    + "      + sin( radians(:#{#current_coordinate.latitude}) ) "
                    + "      * sin( radians( clinc.coordinate.latitude ) ) ) ) <= :distance"
    )
    List<Clinic> findAllByCoordinateAndDistanceInMeters(
            @Param("current_coordinate") Coordinate coordinate,
            @Param("distance") double distance
    );

}
