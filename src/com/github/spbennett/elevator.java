package com.github.spbennett;

/**
 * Created by sbennett on 7/7/15.
 *
 * Elevators move up n' down.
 */
public class elevator {
    private Direction direction;
    private boolean[] floorsToVisit;
    private int currentFloor;



    private void moveUp(){
        // Move the elevator up
        setDirection(Direction.UP);
        setCurrentFloor(getCurrentFloor() + 1);
    }

    private void moveDown(){
        // Move the elevator down
        setDirection(Direction.DOWN);
        setCurrentFloor(getCurrentFloor() - 1);
    }

    void goToFloor(int floor){
        floorsToVisit[floor] = true;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean[] getFloorsToVisit() {
        return floorsToVisit;
    }

    public void setFloorsToVisit(boolean[] floorsToVisit) {
        this.floorsToVisit = floorsToVisit;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static void main (String args[]){
        elevator e = new elevator();

    }

    private enum Direction {
        UP,
        DOWN,
        STOP
    }
}
