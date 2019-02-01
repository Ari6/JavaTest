package Command;

public class Light {
    private boolean status;

    public void on() {
        this.status = true;
    };

    public void off() {
        this.status = false;
    };

    public boolean getStatus() {
        return this.status;
    }

}
