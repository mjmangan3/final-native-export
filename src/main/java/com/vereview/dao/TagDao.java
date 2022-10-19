package com.vereview.dao;

import com.vereview.model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/22/17.
 */
public class TagDao {
    private ConnectionManager mgr;

    public TagDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, String> getTags() throws SQLException{
        Map<Long, String> tags = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from tag");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Tag tag = marshall(r);
                tags.put(tag.getTagId(), tag.getName());
            }

        }catch (SQLException se){
            throw se;
        }
        return tags;
    }

    public Tag marshall(ResultSet r) throws SQLException{
        Tag tag = new Tag();
        tag.setName(r.getString("name"));
        tag.setTagId(r.getLong("tag_id"));
        return tag;
    }
}
