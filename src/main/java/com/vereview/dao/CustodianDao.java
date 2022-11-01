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
public class CustodianDao {
    private ConnectionManager mgr;

    public CustodianDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> findAll() throws SQLException{
        Map<Long, String> cs = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from custodian");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long cid = r.getLong("custodian_id");
                String name = r.getString("name");
                cs.put(cid, name);
            }
        }catch (SQLException se){
            throw se;
        }
        return cs;
    }


    public Map<Long, String> findByExportId(Long exportId) throws SQLException{
        Map<Long, String> cs = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from custodian where custodian_id in(select custodian_id from [file] where file_id in(select file_id from file_export where export_id = ?))");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long cid = r.getLong("custodian_id");
                String name = r.getString("name");
                cs.put(cid, name);
            }
        }catch (SQLException se){
            throw se;
        }
        return cs;
    }


}
