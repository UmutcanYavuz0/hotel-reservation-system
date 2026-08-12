package restorant.demorestorant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorant.demorestorant.Entities.Room;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;
import restorant.demorestorant.Repositoryies.RoomrdateRepository;
import restorant.demorestorant.Repositoryies.UserRepository;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomrdateRepository roomrdateRepository;


    public String rezerveroom(String roomname,String day,String user){
        //oda varsa sonra boşsa
        //select * from room_properties where roomname=roomname
        //oda vars boş mu diye bak
        //varsa oda 13,gün için geldi 13 boşmu diye bak
        //select * from roomrdate where roomname=room
        //11 12 13 14

        ///BÖYLE BİR ODA VARMI DİYE BAKIYOR
        Collection<Room>room=userRepository.odavarmı(roomname);
        if(room.isEmpty()){
            return "böyle bir oda yok";
        }

        ///O GÜN ODA DOLUMU DİYE BAKIYOR
        Collection<Roomrdate>gelenodalar=roomrdateRepository.odagünlerigetir(roomname);
        for(Roomrdate aa:gelenodalar){
            if(aa.getDay().equals(day)){
                return "oda o gün dolu";
            }
        }

        ///DB YE REZERVASYONU KAYDEDİYOR
        userRepository.rexerveroom(roomname,day,user);
        return "rezerve edildi";
    }

    public Collection<RoomProperty> getRooms(){
        return userRepository.getRooms();
    }
    public void deleterezervation(String id){
        userRepository.deleterezervataion(id);
    }
    public Collection<Roomrdate> getusersrezervations(String user){
      return userRepository.getUsersRezervations(user)  ;
    }
}
