package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.emailservice;

import java.util.LinkedList;
import java.util.List;

public class MailTaskRunner implements Runnable {
    private final Thread runnerThread;
    private final List<Command> pendingCommands;
    private volatile boolean stop;
    private static final MailTaskRunner RUNNER = new MailTaskRunner();

    public static final MailTaskRunner getInstance() {
        return RUNNER;
    }

    private MailTaskRunner() {
        pendingCommands = new LinkedList<>();
        runnerThread = new Thread(this);

        runnerThread.start();
    }

    @Override
    public void run() {
        System.out.println("Thread run method started...");

        while (true) {
            Command cmd = null;

            synchronized (pendingCommands) {
                if (pendingCommands.isEmpty()) {
                    try {
                        pendingCommands.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Runner interrupted");

                        if (stop) {
                            System.out.println("Runner stopping");
                            return;
                        }
                    }
                }

                cmd = pendingCommands.isEmpty()?null:pendingCommands.remove(0);
            }

            if (cmd == null)
                return;

            cmd.execute();
        }
    }

    public void addCommand(Command command) {
        synchronized (pendingCommands) {
            pendingCommands.add(command);
            pendingCommands.notifyAll();
        }
    }
    public void shutdown() {
        stop = true;
        runnerThread.interrupt();
    }
}
