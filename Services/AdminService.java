package restorant.demorestorant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;
import restorant.demorestorant.Repositoryies.AdminRepository;
import restorant.demorestorant.Repositoryies.Ortakrepository;

import java.util.Collection;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private Ortakrepository ortakrepository;
    public void addRoom(String roomName,String Personcapacity){
        adminRepository.addRoom(roomName,Personcapacity);
    }

    public void deleteroom(String id){
        adminRepository.deleteroom(id);
    }
    public void deleteallrooms(){
        adminRepository.deleteallrooms();
    }

    public Collection<RoomProperty> getroomproperties(){
        return adminRepository.getroomproperties();
    }
    public Collection<Roomrdate> getrezervations(){
        return adminRepository.getRezervations();
    }
    public String changeroomname(String oldroomname,String newroomname){
        if(odavarmi(oldroomname)){
            return "böyle oda yok";
        }
        adminRepository.changeroomname(oldroomname,newroomname);
        return "oda adı değişti";
    }
    public String changeroomcapacity(String roomname,String newcapacity){
        if(odavarmi(roomname)){
            return "böyle oda yok";
        }

        adminRepository.changeroomcapacity(roomname, newcapacity);
        return "oda kapasitesi değişti";
    }

    private boolean odavarmi(String roomname){
        Collection<RoomProperty>oda=ortakrepository.odavarmi(roomname);
        if(oda.isEmpty()){
            //oda yoksa true döner
            return true;
        }else {
            //oda varsa false döner
            return false;
        }
    }






}
