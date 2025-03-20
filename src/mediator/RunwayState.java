package mediator;

public interface RunwayState extends Command {

    void land();

    boolean isLandingOk(Flight flight);

    void setRunway(Runway runway);
}
