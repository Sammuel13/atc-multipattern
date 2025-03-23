package mediator;

/**
 * Componente 2: Runway (representa a pista de pouso)
 *
 * @author alexs
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;

    private Flight occupiedBy = null;

    private RunwayState state;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    {   // INITIALIZER BLOCK
        this.setRunwayState(1);
    }

//    public void setRunwayState(RunwayState state) {
//        this.state = state;
//    }

    public void setRunwayState(Integer status) {
        switch (status) {
            case 0:
                this.state = RunwayStateEnum.INDISPONIVEL;
                break;
            case 1:
                this.state = RunwayStateEnum.DISPONIVEL;
                break;
            case 2:
                this.state = RunwayStateEnum.INSEGURA;
                break;
        }
        this.state.setRunway(this);
    }

    public RunwayState getRunwayState() {
        return this.state;
    }

    @Override
    public void land() {
        state.land();
    }

    public boolean isLandingOk() {
        return state.isLandingOk(occupiedBy);
    }

    public void setOccupiedBy(Flight flight) {
        this.occupiedBy = flight;
        setRunwayState(RunwayStateEnum.INDISPONIVEL_ID);
    }

    public Flight getOccupiedBy() {
        return this.occupiedBy;
    }
}
