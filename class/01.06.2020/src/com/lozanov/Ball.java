package com.lozanov;

public class Ball {
    private double x;
    private double y;

    private Object lockX = new Object(); // lock used for specific syncing and not locking the entire class' lock (use its lock)
    private Object lockY = new Object(); // lock used for specific syncing and not locking the entire class' lock (use its lock)

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        synchronized (lockX) {
            return x;
        }
    }

    public double getY() {
        synchronized (lockY) {
            return y;
        }
    }

    /* public synchronized void setX(double x) {  -> synchronizes the entire method
        this.x = x;
    } */

    public void setX(double x) {
        synchronized(lockX) { // object for which lock which to use (this class' lock)
            this.x = x;
        }

        System.out.println("Non-critical section!");
    }


}
