package com.learnback.work.jmx;

public interface MessageEngineMXBean {
    public void stop();
    public boolean isPaused();
    public void pause(boolean pause);
    public Message getMessage();
    public void changeMessage(Message m);
}
