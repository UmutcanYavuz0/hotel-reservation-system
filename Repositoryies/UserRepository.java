package restorant.demorestorant.Repositoryies;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restorant.demorestorant.Entities.Room;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<Room,Long> {
    @Query(value = "SELECT * FROM rooms", nativeQuery = true)
    Collection<Room> findallrooms();

    @Modifying
    @Transactional
    @Query(value = "insert into roomrdate(roomname,day,user) values (:roomname,:day,:user)", nativeQuery = true)
    void rexerveroom(String roomname,String day,String user);



    @Query(value = "select * from room_properties where room_name=:roomname", nativeQuery = true)
    Collection<Room> odavarmı(String roomname);

    @Query(value = "select * from room_properties", nativeQuery = true)
    Collection<RoomProperty> getRooms();

    @Modifying
    @Transactional
    @Query(value = "delete from roomrdate where id=:id", nativeQuery = true)
    void deleterezervataion(String id);

    @Query(value = "select * from roomrdate where user=:user", nativeQuery = true)
    Collection<Roomrdate> getUsersRezervations(String user);





}
