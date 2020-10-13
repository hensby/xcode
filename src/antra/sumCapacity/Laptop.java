package antra.sumCapacity;

public class Laptop {

    String lap_name;
    int chargeCapacity;

    public Laptop(String lap_name, int chargeCapacity) {
        this.lap_name = lap_name;
        this.chargeCapacity = chargeCapacity;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lap_name='" + lap_name + '\'' +
                ", chargeCapacity=" + chargeCapacity +
                '}';
    }
}
