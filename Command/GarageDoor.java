package Command;

public class GarageDoor {
    // 0: closed 1: opened 2: half opened/closed
    private static int CLOSED = 0;
    private static int OPENED = 1;
    private static int HALF = 2;

    private int status;
    private boolean lightStatus;

    public GarageDoor() {
        this.status = 0;
        this.lightStatus = false;
    }

    public int getStatus(){
        return this.status;
    }
    public boolean getLightStatus() {
        return this.lightStatus;
    }

    public void up() {
        this.status = OPENED;
    }
    public void down() {
        this.status = CLOSED;
    }
    public void stop() {
        this.status = HALF;
    }
    public void lightOn() {
        this.lightStatus = true;
    }
    public void lightOff() {
        this.lightStatus = false;
    }
}
