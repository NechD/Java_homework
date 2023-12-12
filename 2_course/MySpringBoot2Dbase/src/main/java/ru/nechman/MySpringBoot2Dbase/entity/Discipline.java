package ru.nechman.MySpringBoot2Dbase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name") // Наименование дисциплины
    private String name;

    @Column(name = "description")
    private String description; // Текстовое описание дисциплины
}
