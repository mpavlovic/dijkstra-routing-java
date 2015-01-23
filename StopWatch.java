/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Milan
 */
public class StopWatch {
    private long start = 0;
    private long stop = 0;
    
    private final double TIME_UNIT = 1000000000; // nanoseconds
    
    public void start() {
        start = System.nanoTime();
    }
    
    public void stop() {
        stop = System.nanoTime(); 
    }
    
    public double getElapsedSeconds() {
        return (stop-start) / TIME_UNIT;
    }
}
