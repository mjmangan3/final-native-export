package com.vereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class QuestionDao {
    private ConnectionManager mgr;

    public QuestionDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> getQuestions() throws SQLException{
        Map<Long, String> questions = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from question");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long qid = r.getLong("question_id");
                String name = r.getString("name");
                questions.put(qid, name);
            }
        }catch (SQLException se){
            throw se;
        }
        return questions;
    }
}
