package com.vereview.queue;

import com.vereview.message.FileMessage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by mjmangan on 9/10/17.
 */
public class QueueManager {
    private static final QueueManager instance = new QueueManager();

    private Queue<FileMessage> nativeQueue;
    private Queue<FileMessage> textQueue;

    private QueueManager(){
        nativeQueue = new ConcurrentLinkedQueue();
        textQueue = new ConcurrentLinkedQueue();
    }

    public static QueueManager getInstance(){
        return instance;
    }

    public Queue<FileMessage> getNativeQueue() {
        return nativeQueue;
    }

    public Queue<FileMessage> getTextQueue() {
        return textQueue;
    }
}
