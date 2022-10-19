package com.vereview.export;

import com.vereview.message.FileMessage;

public class TextCopyWorker implements Runnable{

    private FileMessage message;

    public TextCopyWorker(FileMessage message) {
        this.message = message;
    }

    public void run(){
        try{
            Export export = new Export();
            export.copyText(message);
            System.out.println("Text File Export | From: " + message.getTextVeFiles().toString() + " | To: " + message.getTextExportFile());
        }catch (Throwable t){
            System.out.println(message.toString());
            t.printStackTrace();
        }
    }
}
