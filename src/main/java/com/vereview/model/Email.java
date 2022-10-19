package com.vereview.model;

import java.util.Date;

/**
 * Created by mjmangan on 8/18/17.
 */
public class Email {
    private Long emailId;
    private Long fileId;
    private String folder;
    private String from;
    private String subject;
    private String to;
    private String cc;
    private String bcc;
    private String header;
    private Date dateSent;
    private Date dateReceived;
    private String messageId;
    private String inReplyTo;
    private String references;
    private Long messageSize;
    private String conversationTopic;
    private String conversationIndex;
    private String emailClient;
    private String entryId;
    private Long attachmentCount;
    private Long originalId;
    private String emailType;
    private Boolean unread;
    private Integer importance;
    private Integer sensitivity;
    private String userEntered;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Long getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(Long messageSize) {
        this.messageSize = messageSize;
    }

    public String getConversationTopic() {
        return conversationTopic;
    }

    public void setConversationTopic(String conversationTopic) {
        this.conversationTopic = conversationTopic;
    }

    public String getConversationIndex() {
        return conversationIndex;
    }

    public void setConversationIndex(String conversationIndex) {
        this.conversationIndex = conversationIndex;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Long getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Long attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Integer sensitivity) {
        this.sensitivity = sensitivity;
    }

    public String getUserEntered() {
        return userEntered;
    }

    public void setUserEntered(String userEntered) {
        this.userEntered = userEntered;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", fileId=" + fileId +
                ", folder='" + folder + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", header='" + header + '\'' +
                ", dateSent=" + dateSent +
                ", dateReceived=" + dateReceived +
                ", messageId='" + messageId + '\'' +
                ", inReplyTo='" + inReplyTo + '\'' +
                ", references='" + references + '\'' +
                ", messageSize=" + messageSize +
                ", conversationTopic='" + conversationTopic + '\'' +
                ", conversationIndex='" + conversationIndex + '\'' +
                ", emailClient='" + emailClient + '\'' +
                ", entryId='" + entryId + '\'' +
                ", attachmentCount=" + attachmentCount +
                ", originalId=" + originalId +
                ", emailType='" + emailType + '\'' +
                ", unread=" + unread +
                ", importance=" + importance +
                ", sensitivity=" + sensitivity +
                ", userEntered='" + userEntered + '\'' +
                '}';
    }
}
