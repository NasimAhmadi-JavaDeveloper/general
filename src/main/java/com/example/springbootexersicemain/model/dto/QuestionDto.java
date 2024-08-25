package com.example.springbootexersicemain.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.List;

@Accessors(chain = true)
public class QuestionDto {

    @Setter
    @Getter
    @Accessors(chain = true)
    public static class InsertQuestionDto {

        @NotNull
        private Integer questionNumber;
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    public static class SelectQuestionDto {

        private Long id;
        private Integer questionNumber;
        private List<OptionDto> options;
    }
}


