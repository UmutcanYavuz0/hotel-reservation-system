package restorant.demorestorant.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "room_properties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RoomProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String personCapacity;
}
