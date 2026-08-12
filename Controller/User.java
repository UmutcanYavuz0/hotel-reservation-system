package restorant.demorestorant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorant.demorestorant.Entities.Room;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;
import restorant.demorestorant.Services.UserService;

import java.util.Collection;

@RestController
public class User {
    @Autowired
    private UserService userService;

    @GetMapping("user/getrooms")
    public Collection<RoomProperty>getRooms(){
        return userService.getRooms();
    }
    @PostMapping("user/rezerve/room")
    public String rezerveroom(@RequestParam String roomname
            ,@RequestParam String user
             ,@RequestParam String day){
        return userService.rezerveroom(roomname,day,user);
    }

    @DeleteMapping("user/delete/rezervation")
    public void deleterezervation(String id){
        userService.deleterezervation(id);
    }

    @GetMapping("/user/rezervations")
    public Collection<Roomrdate> getusersrezervations(@RequestParam String username){
        return userService.getusersrezervations(username);
    }
}
