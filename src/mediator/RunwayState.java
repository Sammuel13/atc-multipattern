package mediator;

public interface RunwayState extends Command {

    void land();

    boolean isLandingOk();

}
