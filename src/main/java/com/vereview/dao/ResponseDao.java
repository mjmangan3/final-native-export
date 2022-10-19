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
public class ResponseDao {

    private ConnectionManager mgr;

    public ResponseDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> getResponses() throws SQLException {
        Map<Long, String> questions = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from response");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long rid = r.getLong("response_id");
                String value = r.getString("value");
                questions.put(rid, value);
            }
        }catch (SQLException se){
            throw se;
        }
        return questions;
    }
}
