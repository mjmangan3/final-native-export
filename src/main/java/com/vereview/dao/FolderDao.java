package com.vereview.dao;

import com.vereview.model.Folder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/13/17.
 */
public class FolderDao {

    private ConnectionManager mgr;

    public FolderDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Folder> findAll() throws SQLException{
        Map<Long, Folder> folders = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from folder");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Folder f = marshall(r);
                Long folderId = f.getFolderId();
                folders.put(folderId, f);
            }
        }catch (SQLException se){
            throw se;
        }
        return folders;
    }

    public Folder findFolderByFolderId(Long folderId) throws SQLException {
        Folder f = null;
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from folder where folder_id = ?");
            ps.setLong(1, folderId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                f = marshall(r);
            }
        }catch (SQLException se){
            throw se;
        }
        return f;
    }

    public Folder marshall(ResultSet r) throws SQLException{
        Folder f = new Folder();
        f.setDeviceId(r.getLong("device_id"));
        f.setFolderId(r.getLong("folder_id"));
        f.setFullName(r.getString("full_name"));
        f.setFullNameSha1(r.getString("full_name_sha1"));
        f.setName(r.getString("name"));
        f.setParentId(r.getLong("parent_id"));
        return f;
    }
}
