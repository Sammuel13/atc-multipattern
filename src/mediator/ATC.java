package mediator;

import java.util.ArrayList;
import java.util.List;

public class ATC implements ATCMediator {

    public static Integer INDISPONIVEL = 0;
    public static Integer DISPONIVEL = 1;
    public static Integer INSEGURA = 2;

    private List<Flight> flight = new ArrayList<>();
    private Runway runway;
    public boolean land;

    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    @Override
    public void registerFlight(Flight flight) {
        this.flight.add(flight);
    }

    @Override
    public boolean isLandingOk() {
        return runway.isLandingOk();
    }

    @Override
    public void setLandingStatus(Integer status) {
        runway.setRunwayState(status);
    }

}
