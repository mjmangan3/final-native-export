package com.vereview.csv;

import com.vereview.model.Email;
import com.vereview.utils.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/19/17.
 */
public class EmailRowBuilder extends Builder{
    private Email email;

    public EmailRowBuilder(Long fileId) {
        this.fileId = fileId;
        row = new HashMap<>();
        email = indexManager.getEmailByFileId().get(fileId);
    }

    public EmailRowBuilder(Long fileId, Email email) {
        this.fileId = fileId;
        row = new HashMap<>();
        this.email = email;
    }

    public EmailRowBuilder from(){
        String from = email==null?"":email.getFrom();
        row.put(EmailHeaders.FROM.getColumnName(), processNull(from));
        return this;
    }

    public EmailRowBuilder to(){
        String to = email==null?"":email.getTo();
        row.put(EmailHeaders.TO.getColumnName(), processNull(to));
        return this;
    }

    public EmailRowBuilder cc(){
        String cc = email==null?"":email.getCc();
        row.put(EmailHeaders.CC.getColumnName(), processNull(cc));
        return this;
    }

    public EmailRowBuilder bcc(){
        String bcc = email==null?"":email.getBcc();
        row.put(EmailHeaders.BCC.getColumnName(), processNull(bcc));
        return this;
    }

    public EmailRowBuilder subject(){
        String subject = email==null?"":email.getSubject();
        row.put(EmailHeaders.SUBJECT.getColumnName(), processNull(subject));
        return this;
    }

    public EmailRowBuilder dateSent(){
        String dateSent = email==null?"": DateUtils.getDateString(email.getDateSent());
        row.put(EmailHeaders.DATE_SENT.getColumnName(), processNull(dateSent));
        return this;
    }

    public EmailRowBuilder timeSent(){
        String timeSent = email==null?"": DateUtils.getTimeString(email.getDateSent());
        row.put(EmailHeaders.TIME_SENT.getColumnName(), processNull(timeSent));
        return this;
    }

    public EmailRowBuilder dateReceived(){
        String dateReceived = email==null?"": DateUtils.getDateString(email.getDateReceived());
        row.put(EmailHeaders.DATE_RECEIVED.getColumnName(), processNull(dateReceived));
        return this;
    }

    public EmailRowBuilder timeReceived(){
        String timeReceived = email==null?"": DateUtils.getTimeString(email.getDateReceived());
        row.put(EmailHeaders.TIME_RECEIVED.getColumnName(), processNull(timeReceived));
        return this;
    }

    public EmailRowBuilder conversationIndex(){
        String ci = email!=null?email.getConversationIndex():"";
        row.put(EmailHeaders.CONVERSATION_INDEX.getColumnName(), processNull(ci));
        return this;
    }

    public EmailRowBuilder header(){
        String h = email!=null?email.getHeader():"";
        row.put(EmailHeaders.HEADER.getColumnName(), processNull(h));
        return this;
    }

    public EmailRowBuilder importance(){
        String i = email!=null?String.valueOf(email.getImportance()):"";
        row.put(EmailHeaders.IMPORTANCE.getColumnName(), processNull(i));
        return this;
    }

    public EmailRowBuilder inReplyTo(){
        String irt = email!=null?email.getInReplyTo():"";
        row.put(EmailHeaders.IN_REPLY_TO.getColumnName(), processNull(irt));
        return this;
    }

    public EmailRowBuilder internetMessageId(){
        String imi = email!=null?email.getMessageId():"";
        row.put(EmailHeaders.INTERNET_MESSAGE_ID.getColumnName(), processNull(imi));
        return this;
    }

    public EmailRowBuilder entryId(){
        String eid = email!=null?email.getEntryId():"";
        row.put(EmailHeaders.ENTRY_ID.getColumnName(), processNull(eid));
        return this;
    }

    public EmailRowBuilder attachmentCount(){
        String ac = email!=null?String.valueOf(email.getAttachmentCount()):"";
        row.put(EmailHeaders.ATTACHMENT_COUNT.getColumnName(), processNull(ac));
        return this;
    }

    public EmailRowBuilder unread(){
        String ac = email!=null?(email.getUnread()?"YES":"NO"):"";
        row.put(EmailHeaders.UNREAD.getColumnName(), processNull(ac));
        return this;
    }

    public EmailRowBuilder sensitivity(){
        String ac = email!=null?String.valueOf(email.getSensitivity()):"";
        row.put(EmailHeaders.SENSITIVITY.getColumnName(), processNull(ac));
        return this;
    }

    public Map<String, String> build(){
        return row;
    }


    public static enum EmailHeaders{
        FROM("FROM"),
        TO("TO"),
        CC("CC"),
        BCC("BCC"),
        SUBJECT("SUBJECT"),
        DATE_SENT("DATESENT"),
        TIME_SENT("TIMESENT"),
        DATE_RECEIVED("DATERECEIVED"),
        TIME_RECEIVED("TIMERECEIVED"),
        CONVERSATION_INDEX("Conversation_Index"),
        HEADER("Header"),
        IMPORTANCE("Importance"),
        IN_REPLY_TO("InReplyToID"),
        INTERNET_MESSAGE_ID("InternetMsgID"),
        ENTRY_ID("MessageID"),
        ATTACHMENT_COUNT("NumAttach"),
        UNREAD("ReadReceipt"),
        SENSITIVITY("Sensitivity");

        private String columnName;

        EmailHeaders(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }

        public static List<String> getHeader(){
            List<String> headers = new ArrayList<>();
            for(EmailHeaders header : EmailHeaders.values()){
                headers.add(header.getColumnName());
            }
            return headers;
        }
    }
}
