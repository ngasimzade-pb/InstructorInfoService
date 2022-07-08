package az.pashabank.instructorservice.dao.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author : Nabat Gasimzada
 * @since : 7/7/2022, Thu
 **/

@Table(name = "teacherData")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String institution;
    private String email;
}
