package com.vereview.dao;

import com.vereview.model.DocumentNumbers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/16/17.
 */
public class DocumentNumbersDao {
    private ConnectionManager mgr;

    public DocumentNumbersDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, DocumentNumbers> findAllByProductionId(Long productionId) throws SQLException{
        Map<Long, DocumentNumbers> d = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from dbo.document_numbers(?)");
            ps.setLong(1, productionId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                DocumentNumbers dn = marshall(r);
                d.put(dn.getFileId(), dn);
            }
        }catch (SQLException se){
            throw se;
        }
        return d;
    }

    public DocumentNumbers marshall(ResultSet r) throws SQLException{
        DocumentNumbers d = new DocumentNumbers();
        d.setBegAttach(r.getString("begattach"));
        d.setBegDoc(r.getString("begdoc"));
        d.setEndAttach(r.getString("endattach"));
        d.setEndDoc(r.getString("enddoc"));
        d.setFileId(r.getLong("file_id"));
        return d;
    }
}
