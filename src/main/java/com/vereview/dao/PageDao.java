package com.vereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/13/17.
 */
public class PageDao {
    private ConnectionManager mgr;

    public PageDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> getEndBatesIndex() throws SQLException{
        Map<Long, String> mb = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select file_id, max(bates) from page group by file_id");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long fileId = r.getLong(1);
                String bates = r.getString(2);
                mb.put(fileId, bates);
            }
        }catch (SQLException se){
            throw se;
        }
        return mb;
    }

    public Map<Long, String> getStartBatesIndex() throws SQLException{
        Map<Long, String> mb = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select file_id, min(bates) from page group by file_id");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long fileId = r.getLong(1);
                String bates = r.getString(2);
                mb.put(fileId, bates);
            }
        }catch (SQLException se){
            throw se;
        }
        return mb;
    }


    public Map<Long, String> getStartAttachIndex() throws SQLException{
        Map<Long, String> mb = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("");
        }catch (SQLException se){
            throw se;
        }
        return mb;
    }

}
