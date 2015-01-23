

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class DijkstraRouter {

    private static final int UNREACHABLE = 9999;
    
    private static void computePaths(Vertex source) {
        Random rand = new Random();

        source.setMinDistance(0.);
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            
            for (Edge e : u.getAdjacencies()) {
                if (e.getWeight() < UNREACHABLE) {
                    Vertex v = e.getTarget();
                    double weight = e.getWeight();
                    double distanceThroughU = u.getMinDistance() + weight;
                    if (distanceThroughU < v.getMinDistance()) {
                        vertexQueue.remove(v);
                        v.setMinDistance(distanceThroughU);
                        v.setPrevious(u);
                        vertexQueue.add(v);
                    }
                }
            }
        }
    }

    private static void randomizeEdgeWeights(Vertex[] allVertices) {
        Random rand = new Random();
        
        for(Vertex vertex: allVertices) {
            for (Edge edge : vertex.getAdjacencies()) {
               int newWeight = rand.nextInt(16);
               if(newWeight == 0) {
                   newWeight = UNREACHABLE;
               }
               
               edge.setWeight(newWeight);
               
               for(Edge targetAdjacentEdge: edge.getTarget().getAdjacencies()) {
                   if(targetAdjacentEdge.getTarget().getName().equals(vertex.getName())) {
                       targetAdjacentEdge.setWeight(newWeight);
                   }
               }
            }
        }
    }
    
    private static void printAdjacentWeights(Vertex current, boolean beforeChange) {
        if(beforeChange) System.out.println("Current distances to neighbours:");
        else System.out.println("After randomization:");
        for(Edge edge: current.getAdjacencies()) {
            double weight = edge.getWeight();
            if(weight != UNREACHABLE) {
                System.out.println("Distance to " + edge.getTarget() + ": " + edge.getWeight());
            }
            else {
                System.out.println("Router " + edge.getTarget() + " is unreachable.");
            }
        }
        System.out.println();
    }
    
    private static void printCurrentPosition(Vertex current) {
        System.out.println("I'm on router: " + current);
    }
    
    private static void printNewShortestPath(List<Vertex> shortestPath, StopWatch watch) {
        System.out.println("New SP: " + shortestPath + " (in " + watch.getElapsedSeconds() + " s)");
    }
    
    private static void resetVerticesData(Vertex[] allVertices) {
        for(Vertex vertex: allVertices) {
            vertex.setMinDistance(Double.POSITIVE_INFINITY);
            vertex.setPrevious(null);
        }
    }
    
    private static double getEdgeWeight(Vertex left, Vertex right) {
        for(Edge adjacentEdge: left.getAdjacencies()) {
            if(adjacentEdge.getTarget().getName().equals(right.getName())) {
                return adjacentEdge.getWeight();
            }
        }
        return -1;
    }
    
    private static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
    
    public static List<Vertex> getShortestPath(Vertex source, Vertex destination) {
        computePaths(source);
        return getShortestPathTo(destination);
    } 
    
    public static void computeRoutingPath(Vertex source, Vertex destination, Vertex[] allVertices) {
        StopWatch globalWatch = new StopWatch();
        StopWatch localWatch = new StopWatch();
        
        List<Vertex> shortestPath;
        List<Vertex> realPath = new ArrayList<>();
        
        globalWatch.start();
        
        localWatch.start();
        shortestPath = getShortestPath(source, destination);
        localWatch.stop();
        
        double realWeight = 0;
        Vertex current = null;
        Vertex previous = null;
        
        System.out.println("Initial shortest path from " + source + " to " + 
                destination + ": " + shortestPath + 
                " (in " + localWatch.getElapsedSeconds() + " s)");
        System.out.println("Total cost: " + destination.getMinDistance() + "\n");
        
        realPath.add(source);
        
        // go to next hop from source;    
        if(shortestPath.size() > 1) {
            previous = source;
            current = shortestPath.get(1);
        }
        else {
            System.out.println("Source is equal to destination.");
            return;
        }
        
        
        while(!current.getName().equals(destination.getName())) {
            realPath.add(current);
            
            double crossedEdgeWeight = getEdgeWeight(previous, current);
            if(crossedEdgeWeight != -1) {
                realWeight += getEdgeWeight(previous, current);
            }
            else {
                System.out.println("There was an error with edge weight.");
                return;
            }
            
            printCurrentPosition(current);         
            printAdjacentWeights(current, true);
            randomizeEdgeWeights(allVertices);
            printAdjacentWeights(current, false);
            
            // calculate new shortest path
            resetVerticesData(allVertices);
            localWatch.start();
            shortestPath = getShortestPath(current, destination);
            localWatch.stop();
            printNewShortestPath(shortestPath, localWatch);
            
            // go to next hop
            if(shortestPath.size() > 1) {
                previous = current; 
                current = shortestPath.get(1);
            }
            else {
                System.out.print("Destination is unreachable.\nAll links were broken.");
                return;
            }
        }
        
        realPath.add(current);
        realWeight += getEdgeWeight(previous, current);
        printCurrentPosition(current);
        globalWatch.stop();
        
        System.out.println("Real path: " + realPath);
        System.out.println("Real cost: " + realWeight);
        System.out.println("Total time: " + globalWatch.getElapsedSeconds() + " s");
        
    }

    

}
