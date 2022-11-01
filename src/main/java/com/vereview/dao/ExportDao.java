package com.vereview.dao;

import com.vereview.model.Export;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportDao {
    private ConnectionManager mgr;

    public ExportDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public List<Export> getTodoExports() throws SQLException {
        List<Export> exports = new ArrayList<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from export where status = 'TODO' order by export_id");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                exports.add(marshall(r));
            }
        }
        return exports.isEmpty() ? null : exports;
    }

    public void updateExport(Export export) throws SQLException {
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("update export set name = ?, type = ?, status = ?, date_started = ?, date_completed = ? where export_id = ?");
            ps.setString(1, export.getName());
            ps.setString(2, export.getType());
            ps.setString(3, export.getStatus());
            ps.setDate(4, export.getDateStarted() == null ? null : new java.sql.Date(export.getDateStarted().getTime()));
            ps.setDate(5, export.getDateCompleted() == null ? null : new java.sql.Date(export.getDateCompleted().getTime()));
            ps.setLong(6, export.getExportId());
            ps.executeUpdate();
        }
    }

    public Export marshall(ResultSet r) throws SQLException {
        Export e = new Export();
        e.setExportId(r.getLong("export_id"));
        e.setName(r.getString("name"));
        e.setType(r.getString("type"));
        e.setStatus(r.getString("status"));
        java.sql.Date sd = r.getDate("date_started");
        e.setDateStarted(sd == null ? null : new Date(sd.getTime()));
        java.sql.Date dc = r.getDate("date_completed");
        e.setDateCompleted(dc == null ? null : new Date(dc.getTime()));
        return e;
    }
}
