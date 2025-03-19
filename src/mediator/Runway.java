package mediator;

/**
 * Componente 2: Runway (representa a pista de pouso)
 *
 * @author alexs
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;

    private RunwayState state;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;

        this.state = RunwayStateEnum.DISPONIVEL;
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
    }

    public RunwayState getRunwayState() {
        return this.state;
    }

    @Override
    public void land() {
        state.land();
    }

    public boolean isLandingOk() {
        return false;
    }
}
