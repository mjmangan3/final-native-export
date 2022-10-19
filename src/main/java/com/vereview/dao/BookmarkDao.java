package com.vereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/23/17.
 */
public class BookmarkDao {
    private ConnectionManager mgr;

    public BookmarkDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> findAll() throws SQLException{
        Map<Long, String> bookmarks = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select bookmark_id, name from bookmark");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long bid = r.getLong("bookmark_id");
                String n = r.getString("name");
                bookmarks.put(bid, n);
            }
        }catch (SQLException se){
            throw se;
        }
        return bookmarks;
    }
}
