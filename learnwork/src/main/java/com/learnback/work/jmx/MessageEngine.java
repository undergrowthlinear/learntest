package com.learnback.work.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationListener;



public class MessageEngine extends NotificationBroadcasterSupport implements MessageEngineMXBean {
    private final Message message = Echo.msg;
    private long sequenceNumber = 1;
    
    public MessageEngine() {
        addNotificationListener(new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
                System.out.println("*** Handling new notification ***");
                System.out.println("Message: " + notification.getMessage());
                System.out.println("Seq: " + notification.getSequenceNumber());
                System.out.println("*********************************");
            }
        }, null, null);
    }
    
    @Override
    public void stop() {
        Echo.running = false;
    }

    @Override
    public boolean isPaused() {
        return Echo.pause;
    }

    @Override
    public void pause(boolean pause) {
        Notification n = new AttributeChangeNotification(this,
                sequenceNumber++, System.currentTimeMillis(),
                "Pause changed", "Paused", "boolean",
                Echo.pause, pause);
        Echo.pause = pause;
        this.sendNotification(n);
    }

    @Override
    public Message getMessage() {
        return this.message;
    }

    @Override
    public void changeMessage(Message m) {
        this.message.setBody(m.getBody());
        this.message.setTitle(m.getTitle());
        this.message.setBy(m.getBy());
    }
    
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
            AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = 
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
        
    }
}
