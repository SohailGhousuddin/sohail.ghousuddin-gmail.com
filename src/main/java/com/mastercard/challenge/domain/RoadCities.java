package com.mastercard.challenge.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoadCities {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	ArrayList<Vertex> cities;

	public RoadCities(){}
	public void createGraph(String data) {
		cities = new ArrayList<>();
		String[] entries = data.split("\n",-1);
		String[] entry;
		for(String s:entries) {
			entry = s.split(",",2);
			entry[0]=entry[0].trim();
			entry[0]=entry[0].toUpperCase();
			entry[1]=entry[1].trim();
			entry[1]=entry[1].toUpperCase();
			addVertices(entry[0]);
			addVertices(entry[1]);	
			addNeighbor(cities.get(indexForName(entry[0])),entry[1]);
			addNeighbor(cities.get(indexForName(entry[1])),entry[0]);
			LOGGER.info("Searching vertex:"+entry[0]+"Found at:"
					+cities.get(indexForName(entry[0])));
		}

	}

	public void addNeighbor(Vertex v, String edge) {
		LOGGER.info("EDGE: "+ v.getName()+ "-> "+edge);
		Neighbor temp ;
		if(v.getAdjList()==null) {
			temp = new Neighbor(edge,null);
			v.setAdjList(temp);
		} 
		else { 
			Neighbor prev = v.getAdjList();
			Neighbor next = v.getAdjList().next;

			if(this.indexofEdge(v, edge)==-1) {
				while(next!=null) {
					prev=next;
					next=next.next;
				}
				temp = new Neighbor(edge,null);
				prev.next=temp;

			}
		}
	}


	public void addVertices(String vertex) {  
		if(indexForName(vertex)==-1) {
			cities.add(new Vertex(vertex));
			LOGGER.info("Vertex: " + vertex);
		}

	}

	public int indexForName(String vName) {
		int res=-1;
		for (int i = 0; i < cities.size(); i++)
		{
			if(cities.get(i).name.equals(vName)) {
				res=i;
			}
		}
		return res;
	}

	public int indexofEdge(Vertex v, String edge)
	{
		int res = -1;
		Neighbor i = v.getAdjList();
		while(i!=null) {
			if(i.getEdge().equals(edge))
				res = res+1;
			i=i.next;
		}


		return res;
	}

	public void printRoads()
	{

		LOGGER.info("From RoadCities Printing");
		Neighbor vRoot;
		for (int i = 0; i < cities.size(); i++)
		{

			LOGGER.info(cities.get(i).name);
			vRoot = cities.get(i).getAdjList();
			while(vRoot!=null) {
				LOGGER.info("-->"+ vRoot.getEdge());
				vRoot=vRoot.next;
			}

		}
	}
	public String getNeighbor(String src, String dest) {
		src=src.toUpperCase();
		dest=dest.toUpperCase();
		if( bfs(src,dest)) return "YES";
		return "NO";
	}

	public boolean bfs(String source, String dest) {
		boolean res = false;
        int source_index= indexForName(source);
		if(source_index!=-1) {
			res =   bfs(source_index, dest);
		}
		return res;


	}

	// BFS starting at source vertex v
	private boolean bfs(int index, String dest) {
		boolean res = false;
		HashSet<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		if(cities.get(index).name.equals(dest)) return true;
		visited.add(cities.get(index).name);

		queue.offer(cities.get(index).name);
		/*
		 * 1. read the name and see if it is already visited
		 *    if yes , read next neighbor
		 *    if no, add this to queue 
		 * 2. read all the neighbors at the end pop first element 
		 *    from queue and read the next item   
		 */

		while (!queue.isEmpty()) {
			String ind = queue.poll();

			Neighbor i = cities.get(this.indexForName(ind)).getAdjList();
			while(i!=null) {
				if(i.getEdge().equals(dest))
					return true;
				if(!visited.contains(i.getEdge())) {
					queue.offer(i.getEdge());
				}
				i=i.next;
			}
			visited.add(ind);
		}

		return res;
	}
	
}
