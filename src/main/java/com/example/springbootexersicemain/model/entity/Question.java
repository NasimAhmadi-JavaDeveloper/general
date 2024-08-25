package com.example.springbootexersicemain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_question")
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_question_id_seq")
    @SequenceGenerator(name = "field_question_id_seq", sequenceName = "SEQ_QUESTION_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUESTION_NUMBER", nullable = false)
    private Integer questionNumber;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Option> options;
}