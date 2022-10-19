package com.vereview.export;


import com.vereview.message.FileMessage;

public class NativeCopyWorker implements Runnable{
    private FileMessage message;

    public NativeCopyWorker(FileMessage message) {
        this.message = message;
    }

    public void run(){
        try {
            Export export = new Export();
            export.copyNative(message);
            System.out.println("Native File Export | From: " + message.getNativeVeFile() + " | To: " + message.getNativeExportFile());
        }catch (Throwable t){
            System.out.println(message.toString());
            t.printStackTrace();
        }

    }
}
