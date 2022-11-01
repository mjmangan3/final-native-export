package com.vereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FileExportDao {
    private ConnectionManager mgr;

    public FileExportDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Set<Long> fetchFileIdsByExportId(Long exportId) throws SQLException {
        Set<Long> s = new HashSet<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select file_id from file_export where export_id = ?");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                s.add(r.getLong("file_id"));
            }
        }catch (SQLException se){
            throw se;
        }
        return s;
    }
}
