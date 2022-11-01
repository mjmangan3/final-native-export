package com.vereview.dao;

import com.vereview.model.File;
import com.vereview.model.FileLocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 9/2/17.
 */
public class FileLocationDao {
    private ConnectionManager mgr;

    public FileLocationDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, FileLocation> fetchFileLocationsByType(String type) throws SQLException{
        Map<Long, FileLocation> locations = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_location where type = ?");
            ps.setString(1, type);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileLocation f = marshall(r);
                locations.put(f.getFileId(), f);
            }
        }catch (SQLException se){
            throw se;
        }
        return locations;
    }

    public Map<Long, FileLocation> fetchFileLocationsByTypeAndExportId(String type, Long exportId) throws SQLException{
        Map<Long, FileLocation> locations = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_location where type = ? and file_id in(select file_id from file_export where export_id = ?)");
            ps.setString(1, type);
            ps.setLong(2, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileLocation f = marshall(r);
                locations.put(f.getFileId(), f);
            }
        }catch (SQLException se){
            throw se;
        }
        return locations;
    }


    public FileLocation marshall(ResultSet r) throws SQLException{
        FileLocation f = new FileLocation();
        f.setCompressed(r.getBoolean("compressed"));
        f.setDetected(r.getBoolean("is_detected"));
        f.setEncoding(r.getString("encoding"));
        f.setFileId(r.getLong("file_id"));
        f.setId(r.getLong("id"));
        f.setLocation(r.getString("location"));
        f.setMd5Hash(r.getString("md5_hash"));
        f.setName(r.getString("name"));
        f.setPart(r.getLong("part"));
        f.setPlaceHolder(r.getBoolean("place_holder"));
        f.setSha1Hash(r.getString("sha1_hash"));
        f.setSize(r.getLong("size"));
        f.setType(r.getString("type"));
        f.setUnixLocation(r.getString("unix_location"));
        return f;
    }
}
