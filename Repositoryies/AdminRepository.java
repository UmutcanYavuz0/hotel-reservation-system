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
public interface AdminRepository extends JpaRepository<Room,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into room_properties(room_name,person_capacity)  values(:roomName,:personNumber)", nativeQuery = true)
    void addRoom(String roomName, String personNumber);

    @Modifying
    @Transactional
    @Query(value = "delete from rooms where id=:id", nativeQuery = true)
    void deleteroom(String id);


    @Modifying
    @Transactional
    @Query(value = "select * from room_properties", nativeQuery = true)
    Collection<RoomProperty> getroomproperties();

    @Modifying
    @Transactional
    @Query(value = "delete from room_properties where id=1 or 1=1", nativeQuery = true)
    void deleteallrooms();

    @Query(value = "select * from roomrdate", nativeQuery = true)
    Collection<Roomrdate> getRezervations();

    @Modifying
    @Transactional
    @Query(value = "update room_properties set room_name=:newroomname where room_name=:oldroomname;", nativeQuery = true)
    void changeroomname(String oldroomname,String newroomname);

    @Modifying
    @Transactional
    @Query(value = "update room_properties set person_capacity=:newcapacity where room_name=:roomname;", nativeQuery = true)
    void changeroomcapacity(String roomname,String newcapacity);





}
