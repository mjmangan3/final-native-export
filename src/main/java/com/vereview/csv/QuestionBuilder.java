package com.vereview.csv;

import com.vereview.index.IndexManager;
import com.vereview.model.Answer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mjmangan on 8/26/17.
 */
public class QuestionBuilder extends Builder{

    public QuestionBuilder(Long fileId) {
        this.fileId = fileId;
        this.row = new HashMap<>();
    }

    public QuestionBuilder questions(){
        Map<Long, List<Answer>> qa = null;
        if(indexManager.getAnswersByFileId().containsKey(fileId)){
             qa = indexManager.getAnswersByFileId().get(fileId);
        }
        return questions(qa);
    }

    public QuestionBuilder questions(Map<Long, List<Answer>> answerMap){
        for (Long qid : indexManager.getQuestionsByQuestionId().keySet()){
            String qName = indexManager.getQuestionsByQuestionId().get(qid);
            String cell = "";
            if(answerMap != null && !answerMap.isEmpty()){
                if(answerMap.containsKey(qid)){
                    List<Answer> answers = answerMap.get(qid);
                    cell = getAnswersAsString(answers);
                }
            }
            this.row.put(qName, cell);
        }

        return this;
    }

    private String getAnswersAsString(List<Answer> answers){
        if(answers == null || answers.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (Answer a : answers){
            if(a.getResponseId() != null) {
                builder.append(processNull(indexManager.getResponseByResponseId().get(a.getResponseId())));
                builder.append(";");
            }else {
                builder.append(processNull(a.getValue()));
                builder.append(";");
            }
        }
        return builder.deleteCharAt(builder.lastIndexOf(";")).toString();
    }

    public Map<String, String> build(){
        return this.row;
    }

    public static class QuestionHeaders{
        private static IndexManager indexManager = IndexManager.getInstance();

        public static List<String> getHeaders(){
            return indexManager.getQuestionsByQuestionId().values().parallelStream().collect(Collectors.toList());
        }
    }
}
