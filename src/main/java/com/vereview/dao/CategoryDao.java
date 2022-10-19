package com.vereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategoryDao {
    private ConnectionManager mgr;

    public CategoryDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }


    public Map<Long, String> getCategories() throws SQLException{
        Map<Long, String> categories = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select category_id, name from category");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Long id = r.getLong("category_id");
                String name = r.getString("name");
                categories.put(id, name);
            }
        }catch (SQLException se){
            throw se;
        }
        return categories;
    }
}
