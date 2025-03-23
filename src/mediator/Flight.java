package mediator;

/**
 * Componente 1: Flight (representa um vôo de uma empresa aérea)
 *
 * @author alexs
 */
public class Flight implements Command {

    private ATCMediator atcMediator = null;
    private String flightNumber = null;
    private String airline = null;

    public Flight(ATCMediator atcMediator, String airline, String flight) {
        this.atcMediator = atcMediator;
        this.flightNumber = flight;
        this.airline = airline;
    }

    @Override
    public void land() {
        if (atcMediator.isLandingOk(this)) {
            System.out.println("Flight " + flightNumber + " Successfully Landed.");
            atcMediator.setLandingStatus(ATC.DISPONIVEL);
        } else {
            System.out.println("Waiting for landing.");
        }
    }

    public void getReady() {
        System.out.println("Voo " + this.flightNumber + " da " + this.airline + " solicitando autorizacao para pouso...");

        if (atcMediator.isLandingOk(this)) {
            System.out.println("Pista liberada para pouso.");
        } else {
            System.out.println("Runway is busy. Wait for permission.");
        }
        // Se a pista estiver vazia ele pousa, se não entra na fila
        atcMediator.reserveRunway(this);
    }

    public String getFlight() {
        return this.flightNumber;
    }
}
