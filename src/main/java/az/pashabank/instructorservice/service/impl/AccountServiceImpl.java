package az.pashabank.instructorservice.service.impl;

import az.pashabank.instructorservice.dao.repository.TeacherAccountRepository;
import az.pashabank.instructorservice.dao.entity.TeacherEntity;
import az.pashabank.instructorservice.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/7/2022, Thu
 **/

@Service
public class AccountServiceImpl implements AccountService {
    private final TeacherAccountRepository teacherAccountRepository;

    final String SIGN = "@";
    final String COUNTRY_CODE = ".az";

    public AccountServiceImpl(TeacherAccountRepository teacherAccountRepository) {
        this.teacherAccountRepository = teacherAccountRepository;
    }

    @Override
    public TeacherEntity saveData(TeacherEntity teacherEntity) {
        teacherEntity.setName(teacherEntity.getName());
        teacherEntity.setSurname(teacherEntity.getSurname());
        teacherEntity.setInstitution(teacherEntity.getInstitution());

        teacherEntity = teacherAccountRepository.save(teacherEntity);

        return generateEmail(teacherEntity.getId(),
                teacherEntity.getName(),
                teacherEntity.getSurname(),
                teacherEntity.getInstitution());
    }

    @Override
    public TeacherEntity generateEmail(Long id, String name, String surname, String institution) {
        String username = String.valueOf(name.toLowerCase().charAt(0))
                .concat(surname.toLowerCase())
                .concat(String.valueOf(id));

        String domain = SIGN.concat(institution).concat(COUNTRY_CODE);
        String eMail = username.concat(domain);

        return teacherAccountRepository.save(TeacherEntity.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .institution(institution)
                .email(eMail)
                .build());
    }

    @Override
    public List<TeacherEntity> findAllTeachers() {
        return teacherAccountRepository.findAll();
    }

}
