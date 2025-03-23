package mediator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ATC implements ATCMediator {

    private Flight currentFlight;

    private List<Flight> flights = new ArrayList<>();
    private Runway runway;
    private SupportTeam supportTeam;

    // Observer
    private Queue<Flight> waitingQueue = new LinkedList<>();

    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    @Override
    public void registerFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public void registerSupportTeam(SupportTeam supportTeam) {
        this.supportTeam = supportTeam;
    }

    @Override
    public boolean isLandingOk(Flight flight) {
        if (currentFlight != null && currentFlight != flight) {
            return false;
        }

        if (runway.isLandingOk()) {
            supportTeam.prepareForLanding();
            return true;
        }

        return false;
    }

    //Subscribe do Observer
    @Override
    public void reserveRunway(Flight currentFlight) {
        waitingQueue.add(currentFlight);
    }

    private void land(Flight flight) {
        System.out.println("-----------------------------LAND-----------------------------");

        this.currentFlight = flight;
        runway.setOccupiedBy(currentFlight);
        runway.setRunwayState(RunwayStateEnum.INDISPONIVEL_ID);

        this.wait(300, supportTeam::clearLanding);
        this.wait(300, supportTeam::refuel);
        this.wait(300, supportTeam::loadBaggage);

        this.wait(1000, flight::land);
    }

    private void wait(Integer ms, Runnable action) {
        try {
            Thread.sleep(ms);
            action.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setLandingStatus(Integer status) {
        runway.setRunwayState(status);
        if (status.equals(RunwayStateEnum.DISPONIVEL_ID)) {
            this.currentFlight = null;

            if (!waitingQueue.isEmpty()) {
                Flight nextFlight = waitingQueue.poll();
                this.land(nextFlight);
            }
        }
    }

    @Override
    public void start() {
        setLandingStatus(RunwayStateEnum.DISPONIVEL_ID);
    }
}
