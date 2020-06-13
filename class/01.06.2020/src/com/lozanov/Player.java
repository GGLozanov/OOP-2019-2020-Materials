package com.lozanov;

public class Player implements Runnable {
    private Ball ball;
    private int direction;

    public Player(Ball ball, int direction) {
        this.ball = ball;
        this.direction = direction;
    }

    @Override
    public void run() { // every class has a lock, and synchronized allows the instance to lock itself
        while(true) {
            // synchronize this as well
            synchronized (ball) { // locks the lock of the Ball instance
                ball.setX((int) (direction + ball.getX()));
                System.out.println(Thread.currentThread().getName() + "kicked the ball to " + ball.getX());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Ball getBall() {
        return ball;
    }

    public int getDirection() {
        return direction;
    }
}
