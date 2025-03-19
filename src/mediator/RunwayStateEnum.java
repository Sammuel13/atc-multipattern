package mediator;

public enum RunwayStateEnum implements RunwayState {

    INDISPONIVEL {
        public void land() {
            System.out.println("Landing permission denied.");
        }

        public boolean isLandingOk() {
            return false;
        }
    },

    DISPONIVEL {
        public void land() {
            System.out.println("Landing permission granted.");
        }

        public boolean isLandingOk() {
            return true;
        }
    },

    INSEGURA {
        public void land() {
            System.out.println("Landing permission denied.");
        }

        public boolean isLandingOk() {
            return false;
        }
    }
}
