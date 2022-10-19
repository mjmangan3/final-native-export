package com.vereview.dao;

import com.vereview.model.FileProduction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/12/17.
 */
public class FileProductionDao {
    private ConnectionManager mgr;

    public FileProductionDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, FileProduction> findAllByProductionId(Long productionId) throws SQLException{
        Map<Long, FileProduction> fps = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from file_production where production_id = ?");
            ps.setLong(1, productionId);
            ResultSet results = ps.executeQuery();
            while (results.next()){
                FileProduction fp = marshall(results);
                Long fileId = fp.getFileId();
                fps.put(fileId, fp);
            }
        }catch (SQLException se){
            throw se;
        }
        return fps;
    }

    public FileProduction findFileProductionByFileIdAndProductionId(){
        FileProduction fp = null;

        return fp;
    }



    public FileProduction marshall(ResultSet r) throws SQLException{
        FileProduction fp = new FileProduction();
        fp.setCoding(r.getString("coding"));
        fp.setFileId(r.getLong("file_id"));
        fp.setNumber(r.getString("number"));
        fp.setProductionId(r.getLong("production_id"));
        fp.setStatus(r.getString("status"));
        fp.setVolume(r.getString("volume"));
        return fp;
    }
}
