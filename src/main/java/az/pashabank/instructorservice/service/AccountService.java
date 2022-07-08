package az.pashabank.instructorservice.service;

import az.pashabank.instructorservice.dao.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/7/2022, Thu
 **/

@Service
public interface AccountService {

    List<TeacherEntity> findAllTeachers();

    TeacherEntity saveData(TeacherEntity teacherEntity);


    TeacherEntity generateEmail(Long id, String name, String surname, String institution);

}
