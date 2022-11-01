package com.vereview.utils;

import com.phutility.vault.VeSaaSVaultService;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static String removeIllegalFileSystemCharacters(String value){
        return value.replaceAll("[\\\\/:*?\"<>|]", "");
    }

    public static Boolean isInvalidFileShare(String  file){
        if(file.contains("192.168.22.73") || file.contains("192.168.22.31")){
            return true;
        }
        return false;
    }

    public static void copyToFileShare(Path file, String shareDir, String userName, String password) throws IOException {
        String smbUrl = new VeSaaSVaultService().uncToSmb(shareDir);
        String user = userName + ":" + password;
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        SmbFile smbFile = new SmbFile(smbUrl, auth);
        try (InputStream in = Files.newInputStream(file); OutputStream out = new SmbFileOutputStream(smbFile)) {
            IOUtils.copy(in, out);
        }
    }

    public static Path createTempFile(String fileName) throws IOException {
        Path tempDir = Files.createTempDirectory("DAT");
        Path tempFile = Paths.get(tempDir.toString(), fileName);
        return Files.createFile(tempFile);
    }

    public static void deleteTempFile(Path tempFile) throws IOException {
        Path tempDir = tempFile.getParent();
        Files.deleteIfExists(tempFile);
        Files.deleteIfExists(tempDir);
    }

    public static void createShareDir(Path dir, String userName, String password) throws IOException {
        if (dir.toString().startsWith("\\")) {
            String smbUrl = new VeSaaSVaultService().uncToSmb(dir.toString());
            String user = userName + ":" + password;
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
            SmbFile smbDir = new SmbFile(smbUrl, auth);
            try {
                smbDir.mkdirs();
            } catch (SmbException smbe) {
                return;
            }
        } else {
            Files.createDirectories(dir);
        }
    }

    public static OutputStream createSmbOutputStream(Path outputPath, String userName, String password) throws IOException {
        if (outputPath.toString().startsWith("\\")) {
            String smbUrl = new VeSaaSVaultService().uncToSmb(outputPath.toString());
            String user = userName + ":" + password;
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
            SmbFile smbFile = new SmbFile(smbUrl, auth);
            return new SmbFileOutputStream(smbFile);
        }
        return Files.newOutputStream(outputPath);
    }
}