package org.example.subject;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject{
    private final String name;

    public Channel(String name) {
        this.name = name;
    }
    private final List<Observer> subscribers = new ArrayList<>();

    public void uploadVideo(String title){
        // TODO: Notify all subscribers about new video
        this.notifyObservers("uploadVideo" + title);
    }

    @Override
    public void subscribe(Observer observer) {
        observer.update("Subscribed to "+this.name);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observer.update("Unsubscribed from "+this.name);
    }


    @Override
    public void notifyObservers(String message) {
        for (Observer observer : subscribers) {
            observer.update(message);
        }
    }

    public String getName() {
        return name;
    }
}
