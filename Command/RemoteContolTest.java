package Command;

//import javafx.scene.effect.Light;

public class RemoteContolTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        System.out.println("Light is " + light.getStatus());

        remote.setCommand(lightOff);
        remote.buttonWasPressed();
        System.out.println("Light is " + light.getStatus());

        //Garage door
        System.out.println("+++ Garage Door +++");
        GarageDoor gd = new GarageDoor();
        GarageDoorOpenCommand gdOpen = new GarageDoorOpenCommand(gd);
        remote.setCommand(gdOpen);
        remote.buttonWasPressed();
        System.out.println("Garage door is " + gd.getStatus() + " and light is " + gd.getLightStatus());

    }
}
