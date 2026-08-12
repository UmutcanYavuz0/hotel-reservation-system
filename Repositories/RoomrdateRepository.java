package restorant.demorestorant.Repositoryies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restorant.demorestorant.Entities.Roomrdate;

import java.util.Collection;
@Repository
public interface RoomrdateRepository extends JpaRepository<Roomrdate,Long> {
    @Query(value = "select * from roomrdate where roomname=:roomname", nativeQuery = true)
    Collection<Roomrdate> odagünlerigetir(String roomname);

}
