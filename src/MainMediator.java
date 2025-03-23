import mediator.*;

public class MainMediator {

        public static void main(String[] args) {
                ATCMediator atcMediator = new ATC();

                // Componentes 1 e 2 - Voos
                Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
                Flight f2 = new Flight(atcMediator, "GOL", "GL1273");
                Flight f3 = new Flight(atcMediator, "AZUL", "AZ2384");
                Flight f4 = new Flight(atcMediator, "TAM", "JJ8841");
                Flight f5 = new Flight(atcMediator, "VOEPASS", "2Z1102");

                // Componente 3 - Pista
                Runway mainRunway = new Runway(atcMediator);

                // Componente 4 - Equipe de apoio
                SupportTeam supportTeam = new SupportTeam();

                atcMediator.registerRunway(mainRunway);
                atcMediator.registerSupportTeam(supportTeam);

                atcMediator.registerFlight(f1);
                atcMediator.registerFlight(f2);
                atcMediator.registerFlight(f3);
                atcMediator.registerFlight(f4);
                atcMediator.registerFlight(f5);

                // Início da simulação
                System.out.println(">> Contato da aeronave 1....");
                f1.getReady();
                System.out.println();

                System.out.println(">> Contato da aeronave 2....");
                f2.getReady();
                System.out.println();

                System.out.println(">> Contato da aeronave 3....");
                f3.getReady();
                System.out.println();

                System.out.println(">> Contato da aeronave 4....");
                f4.getReady();
                System.out.println();

                System.out.println(">> Contato da aeronave 5....");
                f5.getReady();
                System.out.println();

                atcMediator.start();
        }
}
