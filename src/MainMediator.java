import mediator.*;

public class MainMediator {

	public static void main(String[] args) {
        ATCMediator atcMediator = new ATC();
        
        //Componentes 1 e 2
        Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
        Flight f2 = new Flight(atcMediator, "GOL", "GL1273");
        
        //Componente 3
        Runway mainRunway = new Runway(atcMediator);

        //Componente 4
        SupportTeam supportTeam = new SupportTeam();

        atcMediator.registerRunway(mainRunway);

        atcMediator.registerFlight(f1);
        atcMediator.registerFlight(f2);

        atcMediator.registerSupportTeam(supportTeam);

        mainRunway.land();

        System.out.println(">> Contato da aeronave 1....");
        f1.getReady();
        System.out.println();
        
        System.out.println(">> Consultando situacao da pista....");
        mainRunway.land();
        System.out.println();

        System.out.println(">> Contato da aeronave 2....");
        f2.getReady();
        System.out.println();

        System.out.println(">> Consultando situacao da pista....");
        mainRunway.land();
        
        f1.land();

        mainRunway.land();
        f2.land();

	}

}
