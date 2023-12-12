package ru.nechman.myuirestdbservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nechman.myuirestdbservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
