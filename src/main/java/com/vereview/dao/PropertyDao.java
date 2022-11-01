package com.vereview.dao;


import com.vereview.model.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/20/17.
 */
public class PropertyDao {
    private ConnectionManager mgr;

    public PropertyDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Property> getProperties(Long productionId) throws SQLException{
        Map<Long, Property> props = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from property where file_id in(select file_id from file_production where production_id = ?)");
            ps.setLong(1, productionId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Property p = marshall(r);
                props.put(p.getFileId(), p);
            }
        }catch (SQLException se){
            throw se;
        }
        return props;
    }

    public Map<Long, Property> findAll() throws SQLException{
        Map<Long, Property> props = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from property where file_id is not null");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Property p = marshall(r);
                props.put(p.getFileId(), p);
            }
        }catch (SQLException se){
            throw se;
        }
        return props;
    }

    public Property findPropertyByFileId(Long fileId) throws SQLException {
        Property p = null;
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from property where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            if (r.next()){
                p = marshall(r);
            }
        }catch (SQLException se){
            throw se;
        }
        return p;
    }

    public Map<Long, Property> findByExportId(Long exportId) throws SQLException{
        Map<Long, Property> props = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from property where file_id in(select file_id from file_export where export_id = ?)");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Property p = marshall(r);
                props.put(p.getFileId(), p);
            }
        }catch (SQLException se){
            throw se;
        }
        return props;
    }

    public Property marshall(ResultSet r) throws SQLException{
        Property p = new Property();
        p.setAuthor(r.getString("author"));
        p.setCompany(r.getString("company"));
        p.setDateCreated(r.getDate("date_created"));
        p.setDateLastPrinted(r.getDate("date_last_printed"));
        p.setDateLastRead(r.getDate("date_last_read"));
        p.setDateLastSaved(r.getDate("date_last_saved"));
        p.setFileId(r.getLong("file_id"));
        p.setLastSavedBy(r.getString("last_saved_by"));
        p.setOriginalId(r.getLong("original_id"));
        p.setPageCount(r.getLong("page_count"));
        p.setPropertyId(r.getLong("property_id"));
        p.setRevision(r.getString("revision"));
        p.setTitle(r.getString("title"));
        p.setUserEntered(r.getString("user_entered"));
        return p;
    }
}
