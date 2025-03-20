package mediator;

public enum RunwayStateEnum implements RunwayState {

    INDISPONIVEL() {
        public void land() {
            System.out.println("Landing permission denied.");
        }

        public boolean isLandingOk(Flight flight) {
            return runway.getOccupiedBy() == flight;
        }
    },

    DISPONIVEL {
        public void land() {
            System.out.println("Landing permission granted.");
        }

        public boolean isLandingOk(Flight flight) {
            if (runway.getOccupiedBy() == null) {
                runway.setOccupiedBy(flight);
            }
            return true;
        }
    },

    INSEGURA {
        public void land() {
            System.out.println("Landing permission denied.");
        }

        public boolean isLandingOk(Flight flight) {
            return false;
        }
    };

    protected Runway runway;

    public void setRunway(Runway runway) {
        this.runway = runway;
    }
}
