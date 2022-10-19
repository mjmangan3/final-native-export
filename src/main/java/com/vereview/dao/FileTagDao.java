package com.vereview.dao;

import com.vereview.index.IndexManager;
import com.vereview.model.FileTag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/22/17.
 */
public class FileTagDao {
    private IndexManager indexManager = IndexManager.getInstance();
    private ConnectionManager mgr;

    public FileTagDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Set<String>> getFileTags() throws SQLException{
        Map<Long, Set<String>> fts = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_tag");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileTag f = marshall(r);
                Set<String> v = null;
                String name = indexManager.getTagByTagId().get(f.getTagId());;
                if(!fts.containsKey(f.getFileId())){
                    v = new HashSet<>();
                    if(indexManager.getTagByTagId().containsKey(f.getTagId())) {
                        v.add(name);
                    }
                    fts.put(f.getFileId(), v);
                }else {
                    v = fts.get(f.getFileId());
                    if(!v.contains(name)){
                        v.add(name);
                        fts.replace(f.getFileId(), v);
                    }
                }
            }
        }catch (SQLException se){
            throw se;
        }
        return fts;
    }

    public Set<String> findFileTagsByFileId(Long fileId) throws SQLException {
        Set<String> v = new HashSet<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_tag where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileTag f = marshall(r);
                String name = indexManager.getTagByTagId().get(f.getTagId());
                if(name != null && !v.contains(name)) {
                    v.add(name);
                }
            }
        }catch (SQLException se){
            throw se;
        }
        return v.isEmpty() ? null : v;
    }

    public FileTag marshall(ResultSet r) throws SQLException{
        FileTag f = new FileTag();
        f.setFileId(r.getLong("file_id"));
        f.setId(r.getLong("id"));
        f.setTagId(r.getLong("tag_id"));
        return f;
    }
}
