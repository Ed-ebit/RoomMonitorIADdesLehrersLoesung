package de.iad.ef.RoomMonitorApp;

import de.iad.ef.model.WarningCounter;

public class RoomMonitor extends WarningCounter {
    private Integer currentInRoom=0;
    private Integer maxInRoom=0;
    private Integer totalInRoom=0;

    public RoomMonitor(){
        super(0 , Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        RoomMonitor monitor = new RoomMonitor();
        System.out.println(monitor);
        // Erster Anlauf
        for (int i = 0; i <10 ; i++) {
            monitor.enterRoom();
        }
        System.out.println(monitor);
        for (int i = 0; i < Math.random()*8; i++) {
            monitor.exitRoom();
        }
        System.out.println(monitor);
        monitor.enterRoom();
        monitor.enterRoom();
        System.out.println(monitor);
    }
    public void enterRoom(){
        super.count();
        if(this.maxInRoom< super.currentCount()){
            maxInRoom= currentCount();
        }
        ++this.totalInRoom;
    }
    public void exitRoom(){
        super.uncount();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoomMonitor{");
        sb.append("Im Raum befinden sich zur Zeit :").append(this.currentObjectsInRoom()).append(" Personen");
        sb.append(", maxInRoom=").append(maxInRoom);
        sb.append(", totalInRoom=").append(this.totalObjectsInRoom());
        sb.append('}');
        return sb.toString();
    }

    public Integer currentObjectsInRoom() {
        return super.currentCount();
    }

    public Integer maxObjectsInRoom() {
        return maxInRoom;
    }

    public Integer totalObjectsInRoom() {
        return totalInRoom;
    }
}
