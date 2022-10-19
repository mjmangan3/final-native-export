package com.vereview.dao;

import com.vereview.model.File;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/12/17.
 */
public class FileDao {
    private ConnectionManager mgr;

    public FileDao(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public Map<Long, File> findAll() throws SQLException{
        Map<Long, File> files = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from [file] where viewable = 1 order by file_id");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                File f = marshall(r);
                files.put(f.getFileId(), f);
            }
        }catch (SQLException se){
            throw se;
        }
        return files;
    }

    public Set<Long> findAllFileId() throws SQLException {
        Set<Long> s = new HashSet<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select file_id from [file] where viewable = 1 order by file_id");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                s.add(r.getLong("file_id"));
            }
        }catch (SQLException se){
            throw se;
        }
        return s;
    }

    public File findFileByFileId(Long fileId) throws SQLException {
        if(fileId == null) {
            return null;
        }
        File f = null;
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from [file] where file_id = ?");
            ps.setLong(1, fileId);
            ResultSet r = ps.executeQuery();
            if (r.next()){
                f = marshall(r);
            }
        }catch (SQLException se){
            throw se;
        }
        return f;
    }

    public Map<Long, File> findAllByProductionId(Long productionId) throws SQLException{
        Map<Long, File> files = new HashMap<>();
        try (Connection c = mgr.getDataSource().getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from [file] where file_id in(select file_id from file_production where production_id = ?)");
            ps.setLong(1, productionId);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                File f = marshall(r);
                files.put(f.getFileId(), f);
            }
        }catch (SQLException se){
            throw se;
        }
        return files;
    }

    public File marshall(ResultSet r) throws SQLException{
        File f = new File();
        f.setApplication(r.getString("application"));
        Long assignedUserId = r.getLong("assigned_user_id");
        if(!r.wasNull()) {
            f.setAssignedUserId(assignedUserId);
        }
        Long categoryId = r.getLong("category_id");
        if(!r.wasNull()) {
            f.setCategoryId(categoryId);
        }
        Long checkoutUserId = r.getLong("checkout_user_id");
        if(!r.wasNull()) {
            f.setCheckoutUserId(checkoutUserId);
        }
        f.setCorrupted(r.getBoolean("corrupted"));
        f.setCracked(r.getBoolean("cracked"));
        Long custodainId = r.getLong("custodian_id");
        if(!r.wasNull()) {
            f.setCustodianId(custodainId);
        }
        f.setDaejaHasStickyNotes(r.getBoolean("daeja_has_stickynotes"));
        f.setDaejaHasText(r.getBoolean("daeja_has_text"));
        f.setDaejaHighlighted(r.getBoolean("daeja_highlighted"));
        f.setDaejaRedacted(r.getBoolean("daeja_redacted"));
        f.setDateAccessed(r.getTimestamp("date_accessed"));
        f.setDateCreated(r.getTimestamp("date_created"));
        f.setDateDeleted(r.getTimestamp("date_deleted"));
        f.setDateLastReviewed(r.getTimestamp("date_last_reviewed"));
        f.setDateLastUpdated(r.getTimestamp("date_last_updated"));
        f.setDateLoaded(r.getTimestamp("date_loaded"));
        f.setDateModified(r.getTimestamp("date_modified"));
        f.setDeleted(r.getBoolean("deleted"));
        Long deviceId = r.getLong("device_id");
        if(!r.wasNull()) {
            f.setDeviceId(deviceId);
        }
        f.setDocDate(r.getTimestamp("doc_date"));
        f.setEmd5Hash(r.getString("emd5_hash"));
        f.setEndNumber(r.getString("end_number"));
        f.setEsha1Hash(r.getString("esha1_hash"));
        f.setEsha128Hash(r.getString("esha128_hash"));
        Long evidenceId = r.getLong("evidence_id");
        if(!r.wasNull()) {
            f.setEvidenceId(r.getLong("evidence_id"));
        }
        f.setExtension(r.getString("extension"));
        f.setExtracted(r.getBoolean("extracted"));
        Long familyId = r.getLong("family_id");
        if(!r.wasNull()) {
            f.setFamilyId(familyId);
        }
        Long fileId = r.getLong("file_id");
        if(!r.wasNull()) {
            f.setFileId(fileId);
        }
        f.setFilePatch(r.getBoolean("filepatch"));
        Long folderId = r.getLong("folder_id");
        if(!r.wasNull()) {
            f.setFolderId(folderId);
        }
        f.setHastext(r.getBoolean("hasText"));
        f.setHotDoc(r.getBoolean("hot_doc"));
        Long lastReviewerId = r.getLong("last_reviewer_id");
        if(!r.wasNull()) {
            f.setLastReviewerId(lastReviewerId);
        }
        f.setLoaderVersion(r.getString("loader_version"));
        f.setLocked(r.getBoolean("locked"));
        f.setMd5Hash(r.getString("md5_hash"));
        f.setName(r.getString("name"));
        f.setNumber(r.getString("number"));
        f.setOcrOverride(r.getBoolean("ocr_override"));
        Long originalId = r.getLong("original_id");
        if(!r.wasNull()) {
            f.setOriginalId(originalId);
        }
        Long pageCount = r.getLong("page_count");
        if(!r.wasNull()) {
            f.setPageCount(pageCount);
        }
        Long parentId = r.getLong("parent_id");
        if(!r.wasNull()) {
            f.setParentId(parentId);
        }
        f.setPassword(r.getString("password"));
        f.setPrefix(r.getString("prefix"));
        f.setProtectedFile(r.getBoolean("protected"));
        Long reviewLevelId = r.getLong("review_level_id");
        if(!r.wasNull()) {
            f.setReviewLevelId(reviewLevelId);
        }
        Long rootParentId = r.getLong("root_parent_id");
        if(!r.wasNull()) {
            f.setRootParentId(rootParentId);
        }
        f.setSha1Hash(r.getString("sha1_hash"));
        f.setSha128Hash(r.getString("sha128_hash"));
        f.setSignature(r.getString("signature"));
        Long size = r.getLong("size");
        if(!r.wasNull()) {
            f.setSize(size);
        }
        Long sourceId = r.getLong("source_id");
        if(!r.wasNull()) {
            f.setSourceId(sourceId);
        }
        f.setSuggestedExtension(r.getString("suggested_extension"));
        Long techId = r.getLong("tech_id");
        if(!r.wasNull()) {
            f.setTechId(techId);
        }
        f.setTiffEnabled(r.getBoolean("tiff_enabled"));
        f.setTiffOverride(r.getBoolean("tiff_override"));
        f.setType(r.getString("type"));
        f.setUserEntered(r.getString("user_entered"));
        f.setViewable(r.getBoolean("viewable"));
        return f;
    }
}
