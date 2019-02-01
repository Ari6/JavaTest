package Command;

public class StereoOnWithCDCommand implements Command {
    Streo stereo;

    public StereoOnWithCDCommand(Streo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume();
    }
}
