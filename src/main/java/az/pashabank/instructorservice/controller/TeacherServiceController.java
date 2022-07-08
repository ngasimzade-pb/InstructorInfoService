package az.pashabank.instructorservice.controller;

import az.pashabank.instructorservice.dao.entity.TeacherEntity;
import az.pashabank.instructorservice.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nabat Gasimzada
 * @since : 7/7/2022, Thu
 **/

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
public class TeacherServiceController {

    private final AccountServiceImpl accountService;

    public TeacherServiceController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public TeacherEntity saveAndGetMail(@RequestBody TeacherEntity teacher) {
        return accountService.saveData(teacher);
    }

    @GetMapping("/all")
    public List<TeacherEntity> getAllData() {
        return accountService.findAllTeachers();
    }
}
