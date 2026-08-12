package restorant.demorestorant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorant.demorestorant.Entities.RoomProperty;
import restorant.demorestorant.Entities.Roomrdate;
import restorant.demorestorant.Services.AdminService;

import java.util.Collection;

@RestController
public class Admin {
    //@RequestMapping("/api")
    @Autowired
    private AdminService adminService;
    @PostMapping("/admin/add/room")
    public void addRoom(@RequestParam String odaAdı,@RequestParam String personcapacity){
        adminService.addRoom(odaAdı,personcapacity);
    }

    @DeleteMapping("/admin/delete/room")
    public void deleteroom(@RequestParam String id){
        adminService.deleteroom(id);
    }

    @DeleteMapping("/admin/delete/allrooms")
    public void deleteallrooms(){
        adminService.deleteallrooms();
    }

    @GetMapping("admin/get/rooms")
    public Collection<RoomProperty> roomproperties(){
       return adminService.getroomproperties();
    }

    @GetMapping("admin/get/rezervations")
    public Collection<Roomrdate>  getrezervations(){
        return adminService.getrezervations();
    }
    @PostMapping("/admin/edit/room/name")
    public String editroomname(@RequestParam String oldroomname,@RequestParam String newroomname){
        return adminService.changeroomname(oldroomname, newroomname);
    }
    @PostMapping("/admin/edit/room/capacity")
    public String editroomcapacity(@RequestParam String roomname,String newcapacity){
        return adminService.changeroomcapacity(roomname, newcapacity);
    }




}
