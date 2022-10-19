package com.vereview.processor;

import com.vereview.csv.*;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.model.File;

import java.util.Map;

/**
 * Created by mjmangan on 9/4/17.
 */
public class RowProcessor {
    private IndexManager indexManager = IndexManager.getInstance();

    public FileMessage process(Long fileId){
        FileMessage message = new FileMessage();
        Map<String, String> row = new RowBuilder(fileId)
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
        Map<String, String> emailRow = new EmailRowBuilder(fileId)
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
        Map<String, String> propertyRow = new PropertyRowBuilder(fileId)
                .title()
                .author()
                .revision()
                .datePrinted()
                .build();
        Map<String, String> tagRow = new TagBuilder(fileId)
                .tags()
                .build();
        Map<String, String> bookmarkRow = new BookmarkBuilder(fileId)
                .bookmarks()
                .build();
        Map<String, String> questionRow = new QuestionBuilder(fileId).questions().build();
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
