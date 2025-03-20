package mediator;

import java.util.ArrayList;
import java.util.List;

public class ATC implements ATCMediator {

    public static Integer INDISPONIVEL = 0;
    public static Integer DISPONIVEL = 1;
    public static Integer INSEGURA = 2;

    private Flight currentFlight;

    private List<Flight> flights = new ArrayList<>();
    private Runway runway;
    private SupportTeam supportTeam;
    public boolean land;

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
        return runway.isLandingOk();
    }

    @Override
    public void reserveRunway(Flight currentFlight) {
        if (this.currentFlight != null) {
            System.out.println("Pista ocupada.");
            return;
        }
        this.currentFlight = currentFlight;
        runway.setOccupiedBy(currentFlight);
        runway.setRunwayState(INDISPONIVEL);
    }

    @Override
    public void setLandingStatus(Integer status) {
        runway.setRunwayState(status);
    }
}
