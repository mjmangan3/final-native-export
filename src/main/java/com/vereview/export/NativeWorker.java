package com.vereview.export;

import com.vereview.MainApp;
import com.vereview.message.FileMessage;
import com.vereview.queue.QueueManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mjmangan on 9/11/17.
 */
public class NativeWorker implements Runnable {
    private QueueManager queueManager = QueueManager.getInstance();

    @Override
    public void run(){
        ExecutorService nativeService = Executors.newFixedThreadPool(100);
        System.out.println("Native Thread Start");
        try {
            while (!queueManager.getNativeQueue().isEmpty()) {
                FileMessage message = queueManager.getNativeQueue().poll();
                NativeCopyWorker cw = new NativeCopyWorker(message);
                nativeService.execute(cw);
            }
            nativeService.shutdown();
            MainApp.NATIVE_PROCESSED.set(true);
        }catch (Throwable t){
            //TODO
            t.printStackTrace();
        }
    }
}
