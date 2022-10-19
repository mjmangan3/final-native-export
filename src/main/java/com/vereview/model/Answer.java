package com.vereview.model;

/**
 * Created by mjmangan on 8/26/17.
 */
public class Answer {
    private Long answerId;
    private Long fileId;
    private Long questionId;
    private Long responseId;
    private String value;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", fileId=" + fileId +
                ", questionId=" + questionId +
                ", responseId=" + responseId +
                ", value='" + value + '\'' +
                '}';
    }
}
