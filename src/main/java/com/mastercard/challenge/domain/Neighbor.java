package com.mastercard.challenge.domain;

public class Neighbor {
    String edge;
    Neighbor next;

    public String getEdge() {
        return edge;
    }

    public void setedge(String edge) {
        this.edge = edge;
    }

    public Neighbor getNext() {
        return next;
    }

    public void setNext(Neighbor next) {
        this.next = next;
    }

    public Neighbor(String edge, Neighbor next) {
        this.edge = edge;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "edge=" + edge +
                ", next=" + next +
                '}';
    }
}
