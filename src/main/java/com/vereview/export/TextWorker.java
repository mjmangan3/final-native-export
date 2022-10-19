package com.vereview.export;

import com.vereview.MainApp;
import com.vereview.message.FileMessage;
import com.vereview.queue.QueueManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mjmangan on 9/11/17.
 */
public class TextWorker implements Runnable {
    private QueueManager queueManager = QueueManager.getInstance();

    @Override
    public void run(){
        try {
            ExecutorService textService = Executors.newFixedThreadPool(100);
            while (!queueManager.getTextQueue().isEmpty()) {
                FileMessage message = queueManager.getTextQueue().poll();
                TextCopyWorker tw = new TextCopyWorker(message);
                textService.execute(tw);
            }
            textService.shutdown();
            MainApp.TEXT_PROCESSED.set(true);
        }catch (Throwable t){
            //TODO
            t.printStackTrace();
        }
    }
}
