package restorant.demorestorant.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roomrdate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roomrdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomname;

    private String day;

    private String user;

}
