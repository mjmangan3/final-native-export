package com.vereview.export;

import com.phutility.vault.VeSaaSVaultService;
import com.vereview.context.ApplicationContext;
import com.vereview.message.FileMessage;
import com.vereview.message.TextInfo;
import com.vereview.model.PageInfo;
import com.vereview.utils.FileUtils;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.ZipException;

/**
 * Created by mjmangan on 9/11/17.
 */
public class Export {
    // private final String userName = "storage";
    // private final String password = "5t0r4g3";
    private VeSaaSVaultService service;
    private ApplicationContext context;

    public Export() {
        service = new VeSaaSVaultService();
        context = ApplicationContext.getInstance();
    }

    public void copyNative(FileMessage message) throws IOException{
        if(message.getNativeVeFile() != null) {
            //Files.createDirectories(message.getNativeExportFile().getParent());
            FileUtils.createShareDir(message.getNativeExportFile().getParent(), context.getExportPathUserName(), context.getExportPathPassword());
            Boolean compressed = !message.getNativeVeFile().endsWith(".msg.gz");
            try (InputStream in = service.getUncompressedInputStream(message.getNativeVeFile().toString(), context.getStorageUserName(), context.getStoragePassword(), compressed);
                 OutputStream out = FileUtils.createSmbOutputStream(message.getNativeExportFile(), context.getExportPathUserName(), context.getExportPathPassword())) {
                IOUtils.copy(in, out);
            } catch (ZipException ze) {
                try (InputStream in = service.getUncompressedInputStream(message.getNativeVeFile().toString(), context.getStorageUserName(), context.getStoragePassword(), false);
                     OutputStream out = FileUtils.createSmbOutputStream(message.getNativeExportFile(), context.getExportPathUserName(), context.getExportPathPassword())) {
                    IOUtils.copy(in, out);
                }
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }

    public void copyNativeNew(FileMessage message) throws IOException{
        if(message.getNativeVeFile() != null) {
            Files.createDirectories(message.getNativeExportFile().getParent());
            Boolean compressed = !message.getNativeVeFile().endsWith(".msg.gz");
            try (InputStream in = Files.newInputStream(message.getNativeVeFile());
                 OutputStream out = Files.newOutputStream(message.getNativeExportFile())) {
                IOUtils.copy(in, out);
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }

    public void copyText(FileMessage message) throws IOException{
        if(message.getTextVeFiles() != null && (message.getTextVeFiles().hasPageText() || message.getTextVeFiles().getFileText() != null)) {
            //Files.createDirectories(message.getTextExportFile().getParent());
            FileUtils.createShareDir(message.getTextExportFile().getParent(), context.getExportPathUserName(), context.getExportPathPassword());
            StringBuilder b = new StringBuilder();
            if (message.getTextVeFiles().hasPageText()) {
                Map<Long, PageInfo> infos = message.getTextVeFiles().getTextFilePaths();
                for (Long pageNum : infos.keySet()) {
                    PageInfo pi = infos.get(pageNum);
                    b.append(extractText(pi.getLocation()));
                    b.append("\n");
                }
            } else {
                b.append(extractText(message.getTextVeFiles().getFileText()));
            }
            try (OutputStream out = FileUtils.createSmbOutputStream(message.getTextExportFile(), context.getExportPathUserName(), context.getExportPathPassword())) {
                out.write(b.toString().getBytes());
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }

    public String extractText(Path textFile) throws IOException{
        StringBuilder b = new StringBuilder();
        try (InputStream in = service.getUncompressedInputStream(textFile.toString(), context.getStorageUserName(), context.getStoragePassword(), true); BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            String line;
            while ((line = reader.readLine()) != null){
                b.append(line);
            }

        }catch (IOException ioe){
            throw ioe;
        }
        return b.toString();
    }


}
