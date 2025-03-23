package mediator;

public interface ATCMediator {

    public void start();

    public void registerRunway(Runway runway);
    
    public void registerFlight(Flight flight);

    public void registerSupportTeam(SupportTeam supportTeam);
 
    public boolean isLandingOk(Flight flight);

    public void reserveRunway(Flight currentFlight);

    public void setLandingStatus(Integer status);
}
