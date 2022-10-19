package com.vereview.csv;

import com.vereview.model.File;
import com.vereview.model.Folder;
import com.vereview.utils.DateUtils;

import java.util.HashMap;

public class IndividualRowBuilder extends RowBuilder {

    protected File family;
    protected Folder fileFolder;
    protected File parent;

    public IndividualRowBuilder(File file, File family, Folder folder, File parent) {
        this.row = new HashMap<>();
        fileId = file.getFileId();
        this.file = file;
        this.family = family;
        this.fileFolder = folder;
        this.parent = parent;
    }

    @Override
    public RowBuilder familyId(){
        this.row.put(StandardColumnNames.FAMILY_ID.getColumnName(), processNull(family!=null?family.getNumber():""));
        return this;
    }

    @Override
    public RowBuilder custodian(){
        this.custodian = indexManager.getCustodainByCustodianId().get(file.getCustodianId());
        return this;
    }

    @Override
    public RowBuilder folder(){
        this.folder = fileFolder != null ? fileFolder.getFullName() : "";
        return this;
    }

    @Override
    public RowBuilder fileName(){
        this.name = file.getName();
        return this;
    }

    @Override
    public RowBuilder extension(){
        this.extension = file.getExtension();
        return this;
    }

    @Override
    public RowBuilder parentId(){
        String pNum = parent==null?"":parent.getNumber();
        this.row.put(StandardColumnNames.PARENT_ID.getColumnName(), processNull(pNum));
        return this;
    }

    @Override
    public RowBuilder dateCreated(){
        dateCreated = DateUtils.getDateString(file.getDateCreated());
        return this;
    }

    @Override
    public RowBuilder dateModified(){
        dateModified = DateUtils.getDateString(file.getDateModified());
        return this;
    }


}
