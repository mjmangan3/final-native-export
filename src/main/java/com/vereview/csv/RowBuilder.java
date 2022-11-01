package com.vereview.csv;


import com.vereview.model.File;
import com.vereview.model.FileProduction;
import com.vereview.model.Folder;
import com.vereview.utils.DateUtils;
import com.vereview.utils.FileUtils;

import java.util.*;

/**
 * Created by mjmangan on 8/16/17.
 */
public class RowBuilder extends Builder{
    protected File file;
    protected String documentId;
    protected String familyId;
    protected String begDoc;
    protected String endDoc;
    protected String begAttach;
    protected String endAttach;
    protected String custodian;
    protected String folder;
    protected String name;
    protected String extension;
    protected String parentId;
    protected String dateModified;
    protected String dateCreated;
    protected String eSha1Hash;
    protected String dateAccessed;
    protected String application;
    protected String docDate;
    protected String fileSize;
    protected String hotDoc;
    protected String eMd5Hash;

    public RowBuilder() {
    }

    public RowBuilder(Long fileId) {
        this.fileId = fileId;
        row = new HashMap<>();
        file = indexManager.getFileByFileId().get(fileId);
    }

    public RowBuilder fileId(){
        this.row.put(StandardColumnNames.FILE_ID.getColumnName(), processNull(String.valueOf(fileId)));
        return this;
    }

    public RowBuilder category(){
        if (file != null && file.getCategoryId() != null) {
            String category = file.getCategoryId() == null ? "" : indexManager.getCategoriesByCategoryId().get(file.getCategoryId());
            this.row.put(StandardColumnNames.CATEGORY.getColumnName(), category);
        }
        return this;
    }

    public RowBuilder documentId(){
        if (file != null && file.getNumber() != null && !file.getNumber().isEmpty()) {
            this.row.put(StandardColumnNames.DOCUMENT_ID.getColumnName(), FileUtils.removeIllegalFileSystemCharacters(processNull(file.getNumber())));
        }
        return this;
    }

    public RowBuilder familyId(){
        if (file != null && file.getFamilyId() != null) {
            File family = indexManager.getFileByFileId().get(file.getFamilyId());
            this.row.put(StandardColumnNames.FAMILY_ID.getColumnName(), processNull(family != null ? family.getNumber() : ""));
        }
        return this;
    }


    public RowBuilder custodian(){
        if (file != null && file.getCustodianId() != null) {
            this.custodian = indexManager.getCustodainByCustodianId().get(file.getCustodianId());
        }
        return this;
    }

    public RowBuilder folder(){
        if (file != null && file.getFolderId() != null) {
            Folder f = indexManager.getFolderByFolderId().get(file.getFolderId());
            if (f != null) {
                this.folder = f.getFullName();
            }
        }
        return this;
    }

    public RowBuilder fileName(){
        if (file != null && file.getName() != null && !file.getName().isEmpty()) {
            this.name = file.getName();
        }
        return this;
    }

    public RowBuilder extension(){
        if (file != null && file.getName() != null && !file.getName().isEmpty()) {
            this.extension = file.getExtension();
        }
        return this;
    }

    public RowBuilder parentId(){
        if (file != null && file.getParentId() != null) {
            Long id = file.getParentId();
            String pNum = id == null ? "" : indexManager.getFileByFileId().get(id).getNumber();
            this.row.put(StandardColumnNames.PARENT_ID.getColumnName(), processNull(pNum));
        }
        return this;
    }

    public RowBuilder dateCreated(){
        if (file != null && file.getDateCreated() != null) {
            dateCreated = DateUtils.getDateString(file.getDateCreated());
        }
        return this;
    }

    public RowBuilder dateModified(){
        if (file != null && file.getDateModified() != null) {
            dateModified = DateUtils.getDateString(file.getDateModified());
        }
        return this;
    }

    public RowBuilder eSha1Hash(){
        if (file != null && file.getEsha1Hash() != null && !file.getEsha1Hash().isEmpty()) {
            eSha1Hash = file.getEsha1Hash();
        }
        return this;
    }

    public RowBuilder dateAccessed(){
        if (file != null && file.getDateAccessed() != null) {
            dateAccessed = DateUtils.getDateString(file.getDateAccessed());
        }
        return this;
    }

    public RowBuilder application(){
        if (file != null && file.getApplication() != null) {
            application = file.getApplication();
        }
        return this;
    }

    public RowBuilder docDate(){
        if (file != null && file.getDocDate() != null) {
            docDate = DateUtils.getDateString(file.getDocDate());
        }
        return this;
    }

    public RowBuilder size(){
        if (file != null && file.getSize() != null) {
            fileSize = String.valueOf(file.getSize());
        }
        return this;
    }

    public RowBuilder hotDoc(){
        hotDoc = file != null && file.getHotDoc()?"YES":"NO";
        return this;
    }

    public RowBuilder eMd5Hash(){
        if (file != null && file.getEmd5Hash() != null) {
            eMd5Hash = file.getEmd5Hash();
        }
        return this;
    }

    public Map<String, String> build(){

        this.row.put(StandardColumnNames.FILE_NAME.getColumnName(), processNull(this.name));
        this.row.put(StandardColumnNames.FILE_EXTENSION.getColumnName(), FileUtils.removeIllegalFileSystemCharacters(processNull(this.extension)));
        this.row.put(StandardColumnNames.CUSTODIAN.getColumnName(), processNull(this.custodian));
        this.row.put(StandardColumnNames.FOLDER.getColumnName(), processNull(this.folder));

        this.row.put(StandardColumnNames.DATE_CREATED.getColumnName(), processNull(this.dateCreated));
        this.row.put(StandardColumnNames.DATE_MODIFIED.getColumnName(), processNull(this.dateModified));
        this.row.put(StandardColumnNames.E_SHA1_HASH.getColumnName(), processNull(this.eSha1Hash));
        this.row.put(StandardColumnNames.DATE_ACCESSED.getColumnName(), processNull(this.dateAccessed));
        this.row.put(StandardColumnNames.APPLICATION.getColumnName(), processNull(this.application));
        this.row.put(StandardColumnNames.DOC_DATE.getColumnName(), processNull(this.docDate));
        this.row.put(StandardColumnNames.FILE_SIZE.getColumnName(), processNull(this.fileSize));
        this.row.put(StandardColumnNames.HOT_DOC.getColumnName(), processNull(this.hotDoc));
        this.row.put(StandardColumnNames.E_MD5_HASH.getColumnName(), processNull(this.eMd5Hash));
        return this.row;
    }

    public static enum StandardColumnNames{
        /*BEGDOC("BEGDOC"),
        ENDDOC("ENDDOC"),
        BEG_ATTACH("BEGATTACH"),
        END_ATTACH("ENDATTACH"),*/
        CUSTODIAN("CUSTODIAN"),
        FOLDER("FOLDER"),
        FILE_NAME("Filename"),
        FILE_EXTENSION("FileExtension"),
        DATE_CREATED("DATECREATED"),
        DATE_MODIFIED("DATEMODIFIED"),
        PARENT_ID("PARENTID"),
        E_SHA1_HASH("FILEHASH"),
        DATE_ACCESSED("DateLastAccessed"),
        APPLICATION("Application"),
        DOC_DATE("DocDate"),
        FILE_SIZE("FileSize_Bytes"),
        HOT_DOC("Key_Hot Document"),
        E_MD5_HASH("MD5Hash"),
        FILE_ID("VEFILEID"),
        DOCUMENT_ID("DOCUMENTID"),
        FAMILY_ID("FAMILYID"),
        CATEGORY("CATEGORIES");


        private String columnName;

        StandardColumnNames(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }

        public static List<String> getHeader(){
            List<String> h = new ArrayList<>();
            for(StandardColumnNames names : StandardColumnNames.values()){
                h.add(names.getColumnName());
            }
            return h;
        }
    }
}
