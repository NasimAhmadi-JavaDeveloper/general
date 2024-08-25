package com.example.springbootexersicemain.model.entity;

import com.example.springbootexersicemain.model.enums.Number;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tbl_option")
@Accessors(chain = true)
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_option_id_seq")
    @SequenceGenerator(name = "field_option_id_seq", sequenceName = "SEQ_OPTION_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NUMBER", nullable = false)
    private Number number;

    @ManyToOne(optional = false)
    private Question question;

}