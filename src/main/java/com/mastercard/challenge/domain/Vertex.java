package com.mastercard.challenge.domain;

public class Vertex {
    String name;
    Neighbor adjList;
    
    public Vertex(){}
    
    public Vertex(String name)
    {
    	this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Neighbor getAdjList() {
        return adjList;
    }

    public void setAdjList(Neighbor adjList) {
        this.adjList = adjList;
    }

    public Vertex(String name, Neighbor adjList) {
        this.name = name;
        this.adjList = adjList;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", adjList=" + adjList +
                '}';
    }
}
