package com.vereview.dao;

import com.vereview.model.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjmangan on 8/18/17.
 */
public class EmailDao {
    private ConnectionManager mgr;

    public EmailDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, Email> fetchAllEmails() throws SQLException{
        Map<Long, Email> e = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from email where file_id is not null");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Email email = marshall(r);
                Long file_id = email.getFileId();
                e.put(file_id, email);
            }
        }catch (SQLException se){
            throw se;
        }
        return e;
    }

    public Email fetchEmailByFileId(Long fileId) throws SQLException {
        Email e = null;
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from email where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            if (r.next()){
                e = marshall(r);
            }
        }catch (SQLException se){
            throw se;
        }
        return e;
    }

    public Map<Long, Email> fetchByExportId(Long exportId) throws SQLException{
        Map<Long, Email> e = new HashMap<>();
        try(Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from email where file_id in(select file_id from file_export where export_id = ?)");
            ps.setLong(1, exportId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Email email = marshall(r);
                Long file_id = email.getFileId();
                e.put(file_id, email);
            }
        }catch (SQLException se){
            throw se;
        }
        return e;
    }

    public Email marshall(ResultSet r) throws SQLException{
        Email e = new Email();
        e.setAttachmentCount(r.getLong("attachment_count"));
        e.setBcc(r.getString("bcc"));
        e.setCc(r.getString("cc"));
        e.setConversationIndex(r.getString("conversation_index"));
        e.setConversationTopic(r.getString("conversation_topic"));
        e.setDateReceived(r.getDate("date_received"));
        e.setDateSent(r.getDate("date_sent"));
        e.setEmailClient(r.getString("email_client"));
        e.setEmailId(r.getLong("email_id"));
        e.setEmailType(r.getString("email_type"));
        e.setEntryId(r.getString("entry_id"));
        e.setFileId(r.getLong("file_id"));
        e.setFolder(r.getString("folder"));
        e.setFrom(r.getString("from"));
        e.setHeader(r.getString("header"));
        e.setImportance(r.getInt("importance"));
        e.setInReplyTo(r.getString("in_reply_to"));
        e.setMessageId(r.getString("message_id"));
        e.setMessageSize(r.getLong("message_size"));
        e.setOriginalId(r.getLong("original_id"));
        e.setReferences(r.getString("references"));
        e.setSensitivity(r.getInt("sensitivity"));
        e.setSubject(r.getString("subject"));
        e.setTo(r.getString("to"));
        e.setUnread(r.getBoolean("unread"));
        e.setUserEntered(r.getString("user_entered"));
        return e;
    }
}
