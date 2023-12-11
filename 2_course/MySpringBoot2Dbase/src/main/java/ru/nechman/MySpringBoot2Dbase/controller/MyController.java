package ru.nechman.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nechman.MySpringBoot2Dbase.entity.Discipline;
import ru.nechman.MySpringBoot2Dbase.entity.Student;
import ru.nechman.MySpringBoot2Dbase.service.DisciplineService;
import ru.nechman.MySpringBoot2Dbase.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    //Вывод всех студентов из БД
    @GetMapping("/students")
    public ResponseEntity<?> allStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        if (allStudents.isEmpty()) {
            return new ResponseEntity<>("Список студентов пуст.", HttpStatus.OK);
        }
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    //Вывод студента из БД по id
    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return new ResponseEntity<>("Студента с ID: " + id + " нет.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Добавление студента в БД
    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.saveStudent(student);
            return new ResponseEntity<>("Студент успешно сохранен с ID: " + savedStudent.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка при сохранении студента: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Редактирование студента
    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        try {
            Student existingStudent = studentService.getStudent(id);
            if (existingStudent == null) {
                return new ResponseEntity<>("Студент с ID: " + id + " не найден.", HttpStatus.NOT_FOUND);
            }
            student.setId(id);
            studentService.saveStudent(student);
            return new ResponseEntity<>("Студент успешно обновлен.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка при обновлении студента: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Удаление студента
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        try {
            Student student = studentService.getStudent(id);
            if (student == null) {
                return new ResponseEntity<>("Студент с ID: " + id + " не найден.", HttpStatus.NOT_FOUND);
            }
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Студент успешно удален.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка при удалении студента: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    private DisciplineService disciplineService;

    //Вывод  всех
    @GetMapping("/discipline")
    public ResponseEntity<?> allDisciplines() {
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        if (allDisciplines.isEmpty()) {
            return new ResponseEntity<>("Список дисциплин абсолютно пустой.", HttpStatus.OK);
        }
        return new ResponseEntity<>(allDisciplines, HttpStatus.OK);
    }

    //Вывод одной
    @GetMapping("/disciplines/{id}")
    public ResponseEntity<?> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline == null) {
            return new ResponseEntity<>("Дисциплина с ID: " + id + " отсутствует.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    // Добавление
    @PostMapping("/disciplines")
    public ResponseEntity<String> saveDiscipline(@RequestBody Discipline discipline) {
        try {
            Discipline savedDiscipline = disciplineService.saveDiscipline(discipline);
            return new ResponseEntity<>("Дисциплина  сохранена с ID: " + savedDiscipline.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("При сохранении дисциплины возникла ошибка: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Редактирование
    @PutMapping("/disciplines/{id}")
    public ResponseEntity<String> updateDiscipline(@PathVariable("id") int id, @RequestBody Discipline discipline) {
        try {
            Discipline existingDiscipline = disciplineService.getDiscipline(id);
            if (existingDiscipline == null) {
                return new ResponseEntity<>("Дисциплина с ID: " + id + " не найдена.", HttpStatus.NOT_FOUND);
            }
            discipline.setId(id);
            disciplineService.saveDiscipline(discipline);
            return new ResponseEntity<>("Информация о дисциплине  обновлена.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("При обновлении информации по дисциплине возникла ошибка: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Удаление дисциплины
    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable("id") int id) {
        try {
            Discipline discipline = disciplineService.getDiscipline(id);
            if (discipline == null) {
                return new ResponseEntity<>("Дисциплина с ID: " + id + " не найдена.", HttpStatus.NOT_FOUND);
            }
            disciplineService.deleteDiscipline(id);
            return new ResponseEntity<>("Информация о дисциплине  удалена.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("При удалении возникла ошибка: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}