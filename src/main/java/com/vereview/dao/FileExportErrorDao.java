package com.vereview.dao;

import com.vereview.model.FileExportError;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileExportErrorDao {
    private ConnectionManager mgr;

    public FileExportErrorDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public void save(FileExportError error) throws SQLException {
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into file_export_error (file_id, stacktrace, date_created, export_id, message) values (?,?,?,?,?)");
            ps.setLong(1, error.getFileId());
            ps.setString(2, error.getStackTrace());
            ps.setDate(3, error.getDateCreated() == null ? null : new Date(error.getDateCreated().getTime()));
            ps.setLong(4, error.getExportId());
            ps.setString(5, error.getJsonMessage());
            ps.executeUpdate();
        }
    }
}
