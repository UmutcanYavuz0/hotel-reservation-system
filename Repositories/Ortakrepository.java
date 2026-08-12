package restorant.demorestorant.Repositoryies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;

import java.util.Collection;

@Repository
public interface Ortakrepository extends JpaRepository<Roomrdate,Long> {

    @Query(value = " select * from room_properties where room_name=:roomname", nativeQuery = true)
    Collection<RoomProperty> odavarmi(String roomname);








}
