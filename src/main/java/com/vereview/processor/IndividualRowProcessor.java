package com.vereview.processor;

import com.vereview.csv.*;
import com.vereview.message.DaoMessage;
import com.vereview.message.FileMessage;
import com.vereview.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class IndividualRowProcessor {

    public FileMessage process(DaoMessage daoMessage) {
        Long fileId = daoMessage.getFile().getFileId();
        FileMessage message = new FileMessage();
        Map<String, String> row = new IndividualRowBuilder(daoMessage.getFile(), daoMessage.getFamily(), daoMessage.getFolder(), daoMessage.getParent())
                .fileId()
                .documentId()
                .familyId()
                .fileName()
                .extension()
                .custodian()
                .folder()
                .parentId()
                .dateCreated()
                .dateModified()
                .eSha1Hash()
                .eMd5Hash()
                .dateAccessed()
                .application()
                .docDate()
                .size()
                .hotDoc()
                .category()
                .build();
        Map<String, String> emailRow = new EmailRowBuilder(fileId, daoMessage.getEmail())
                .from()
                .to()
                .cc()
                .bcc()
                .subject()
                .dateSent()
                .timeSent()
                .dateReceived()
                .timeReceived()
                .conversationIndex()
                .header()
                .importance()
                .inReplyTo()
                .internetMessageId()
                .entryId()
                .attachmentCount()
                .unread()
                .sensitivity()
                .build();
        Map<String, String> propertyRow = new PropertyRowBuilder(fileId, daoMessage.getProperty())
                .title()
                .author()
                .revision()
                .datePrinted()
                .build();
        Map<String, String> tagRow = new IndividualTagBuilder(fileId, daoMessage.getTags())
                .tags()
                .build();
        Map<String, String> bookmarkRow = new BookmarkBuilder(fileId)
                .bookmarks(daoMessage.getBookmarks())
                .build();
        Map<String, String> questionRow = new QuestionBuilder(fileId)
                .questions(daoMessage.getAnswerMap())
                .build();
        row.putAll(emailRow);
        row.putAll(propertyRow);
        row.putAll(tagRow);
        row.putAll(bookmarkRow);
        row.putAll(questionRow);
        message.setRow(row);
        message.setFileId(fileId);
        message.setDocumentId(row.get(RowBuilder.StandardColumnNames.DOCUMENT_ID.getColumnName()));
        return message;
    }
}
