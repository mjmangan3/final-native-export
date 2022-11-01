package com.vereview.dao;

import com.vereview.index.IndexManager;
import com.vereview.model.FileBookmark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/23/17.
 */
public class FileBookmarkDao {
    private IndexManager indexManager = IndexManager.getInstance();
    private ConnectionManager mgr;

    public FileBookmarkDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Set<String>> getFileBookmarks() throws SQLException{
        Map<Long, Set<String>> fts = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_bookmark");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileBookmark f = marshall(r);
                Set<String> v = null;
                String name = indexManager.getBookmarkByBookmarkId().get(f.getBookmarkId());
                if(!fts.containsKey(f.getFileId())){
                    v = new HashSet<>();
                    if(indexManager.getBookmarkByBookmarkId().containsKey(f.getBookmarkId())) {
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

    public Map<Long, Set<String>> getFileBookmarksByExportId(Long exportId) throws SQLException{
        Map<Long, Set<String>> fts = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_bookmark where file_id in(select file_id from file_export where export_id = ?)");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileBookmark f = marshall(r);
                Set<String> v = null;
                String name = indexManager.getBookmarkByBookmarkId().get(f.getBookmarkId());
                if(!fts.containsKey(f.getFileId())){
                    v = new HashSet<>();
                    if(indexManager.getBookmarkByBookmarkId().containsKey(f.getBookmarkId())) {
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

    public Set<String> fetchBookmarksByFileId(Long fileId) throws SQLException {
        Set<String> b = new HashSet<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_bookmark where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                FileBookmark f = marshall(r);
                String name = indexManager.getBookmarkByBookmarkId().get(f.getBookmarkId());
                if(name != null && !b.contains(name)){
                    b.add(name);
                }
            }
        }catch (SQLException se){
            throw se;
        }
        return b;
    }

    public FileBookmark marshall(ResultSet r) throws SQLException{
        FileBookmark fb = new FileBookmark();
        fb.setBookmarkId(r.getLong("bookmark_id"));
        fb.setDateAdded(r.getDate("date_added"));
        fb.setFileId(r.getLong("file_id"));
        fb.setId(r.getLong("id"));
        return fb;
    }
}
