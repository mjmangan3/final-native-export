package com.vereview.dao;

import com.vereview.model.PageInfo;
import com.vereview.model.PageLocationType;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 9/9/17.
 */
public class PageInfoDao {
    private ConnectionManager mgr;

    public PageInfoDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Map<Long, PageInfo>> getPageInfoByType(PageLocationType type) throws  SQLException{
        Map<Long, Map<Long, PageInfo>> ret = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select p.file_id, p.number, pl.type, pl.location from page p join page_location pl on(p.page_id = pl.page_id) where pl.type = ?");
            ps.setString(1, type.getType());
            ResultSet r = ps.executeQuery();
            while (r.next()){
                PageInfo i = marshall(r);
                Map<Long, PageInfo> pi = null;
                if(!ret.containsKey(i.getFileId())){
                    pi = new HashMap<>();
                    pi.put(i.getPageNumber(), i);
                    ret.put(i.getFileId(), pi);
                }else {
                    pi = ret.get(i.getFileId());
                    pi.put(i.getPageNumber(), i);
                    ret.replace(i.getFileId(), pi);
                }
            }
        }catch (SQLException se){
            throw se;
        }
        return ret;
    }

    public PageInfo marshall(ResultSet r) throws SQLException{
        PageInfo p = new PageInfo();
        p.setFileId(r.getLong("file_id"));
        p.setLocation(Paths.get(r.getString("location")));
        p.setPageNumber(r.getLong("number"));
        p.setType(PageLocationType.getType(r.getString("type")));
        return p;
    }
}
