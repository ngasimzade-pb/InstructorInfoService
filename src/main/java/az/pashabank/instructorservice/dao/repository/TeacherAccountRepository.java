package az.pashabank.instructorservice.dao.repository;

import az.pashabank.instructorservice.dao.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/7/2022, Thu
 **/
public interface TeacherAccountRepository extends CrudRepository<TeacherEntity, Long> {

    List<TeacherEntity> findAll();
}
