package com.vereview.dao;

import com.vereview.index.IndexManager;
import com.vereview.model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class AnswerDao {
    private IndexManager indexManager;
    private ConnectionManager mgr;

    public AnswerDao(ConnectionManager mgr) {
        this.mgr = mgr;
        this.indexManager =IndexManager.getInstance();
    }

    public Map<Long, Map<Long, List<Answer>>> getAnswers() throws SQLException{
        Map<Long, Map<Long, List<Answer>>> answers = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from answer");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Answer a = marshall(r);
                Map<Long, List<Answer>> qa;
                List<Answer> la;
                if(!answers.containsKey(a.getFileId())){
                    qa = new HashMap<>();
                    la = new ArrayList<>();
                    la.add(a);
                    qa.put(a.getQuestionId(), la);
                    answers.put(a.getFileId(), qa);
                }else {
                    qa = answers.get(a.getFileId());
                    if(!qa.containsKey(a.getQuestionId())){
                        la = new ArrayList<>();
                        la.add(a);
                        qa.put(a.getQuestionId(), la);
                        answers.replace(a.getFileId(), qa);
                    }else {
                        la = qa.get(a.getQuestionId());
                        la.add(a);
                        qa.replace(a.getQuestionId(), la);
                        answers.replace(a.getFileId(), qa);
                    }

                }

            }

        }catch (SQLException se){
            throw se;
        }
        return answers;
    }

    public Map<Long, Map<Long, List<Answer>>> getAnswersByExportId(Long exportId) throws SQLException{
        Map<Long, Map<Long, List<Answer>>> answers = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from answer where file_id in(select file_id from file_export where export_id = ?)");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Answer a = marshall(r);
                Map<Long, List<Answer>> qa;
                List<Answer> la;
                if(!answers.containsKey(a.getFileId())){
                    qa = new HashMap<>();
                    la = new ArrayList<>();
                    la.add(a);
                    qa.put(a.getQuestionId(), la);
                    answers.put(a.getFileId(), qa);
                }else {
                    qa = answers.get(a.getFileId());
                    if(!qa.containsKey(a.getQuestionId())){
                        la = new ArrayList<>();
                        la.add(a);
                        qa.put(a.getQuestionId(), la);
                        answers.replace(a.getFileId(), qa);
                    }else {
                        la = qa.get(a.getQuestionId());
                        la.add(a);
                        qa.replace(a.getQuestionId(), la);
                        answers.replace(a.getFileId(), qa);
                    }

                }

            }

        }catch (SQLException se){
            throw se;
        }
        return answers;
    }

    public Map<Long, List<Answer>> getAnswersByFileId(Long fileId) throws SQLException {
        Map<Long, List<Answer>> qa = null;
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from answer where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Answer a = marshall(r);
                List<Answer> la = null;
                if(qa == null) {
                    qa = new HashMap<>();
                    la = new ArrayList<>();
                    la.add(a);
                    qa.put(a.getQuestionId(), la);
                } else {
                    if(!qa.containsKey(a.getQuestionId())){
                        la = new ArrayList<>();
                        la.add(a);
                        qa.put(a.getQuestionId(), la);
                    }else {
                        la = qa.get(a.getQuestionId());
                        la.add(a);
                        qa.replace(a.getQuestionId(), la);
                    }
                }

            }

        }catch (SQLException se){
            throw se;
        }
        return qa;
    }


    public Answer marshall(ResultSet r) throws  SQLException{
        Answer a = new Answer();

        Long aid = r.getLong("answer_id");
        if(r.wasNull()) {
            aid = null;
        }
        a.setAnswerId(aid);
        Long fid = r.getLong("file_id");
        if(r.wasNull()){
            fid = null;
        }
        a.setFileId(fid);
        Long qid = r.getLong("question_id");
        if(r.wasNull()){
            qid = null;
        }
        a.setQuestionId(qid);
        Long rid = r.getLong("response_id");
        if(r.wasNull()){
            rid = null;
        }
        a.setResponseId(rid);
        a.setValue(r.getString("value"));
        return a;
    }
}
