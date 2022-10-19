package com.vereview.export;

import com.phutility.vault.VeSaaSVaultService;
import com.vereview.message.FileMessage;
import com.vereview.message.TextInfo;
import com.vereview.model.PageInfo;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by mjmangan on 9/11/17.
 */
public class Export {
    private final String userName = "storage";
    private final String password = "5t0r4g3";
    private VeSaaSVaultService service;

    public Export() {
        service = new VeSaaSVaultService();
    }

    public void copyNative(FileMessage message) throws IOException{
        if(message.getNativeVeFile() != null) {
            Files.createDirectories(message.getNativeExportFile().getParent());
            Boolean compressed = !message.getNativeVeFile().endsWith(".msg.gz");
            try (InputStream in = service.getUncompressedInputStream(message.getNativeVeFile().toAbsolutePath().toString(), userName, password, compressed);
                 OutputStream out = Files.newOutputStream(message.getNativeExportFile())) {
                IOUtils.copy(in, out);
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
            Files.createDirectories(message.getTextExportFile().getParent());
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
            try (OutputStream out = Files.newOutputStream(message.getTextExportFile())) {
                out.write(b.toString().getBytes());
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }

    public String extractText(Path textFile) throws IOException{
        StringBuilder b = new StringBuilder();
        try (InputStream in = service.getUncompressedInputStream(textFile.toAbsolutePath().toString(), userName, password, true); BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
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
