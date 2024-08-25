package com.example.springbootexersicemain.model.dto;

import com.example.springbootexersicemain.model.enums.Number;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Accessors(chain = true)
public class OptionDto {

    @Accessors(chain = true)
    public static class SelectOptionDto {

        private Long id;
        private Number number;
        private QuestionDto.SelectQuestionDto question;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Number getNumber() {
            return number;
        }

        public void setNumber(Number number) {
            this.number = number;
        }

        public QuestionDto.SelectQuestionDto getQuestion() {
            return question;
        }

        public void setQuestion(QuestionDto.SelectQuestionDto question) {
            this.question = question;
        }
    }

    @Accessors(chain = true)
    public static class InsertOptionDto {

        @NotNull
        private Number number;

        @NotNull
        private Long questionId;

        public Number getNumber() {
            return number;
        }

        public void setNumber(Number number) {
            this.number = number;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

}
