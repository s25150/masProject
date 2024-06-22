package projectmas.wwc;

public enum Engine {
    petrol,
    diesel,
    hybrid,
    electric;

    @Override
    public String toString() {
        switch(this) {
            case diesel: return "Diesel";
            case petrol: return "Petrol";
            case electric: return "Electric";
            case hybrid: return "Hybrid";
            default: throw new IllegalArgumentException();
        }
    }
}
