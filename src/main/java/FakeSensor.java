public class FakeSensor implements Sensor {
    private double pressure;

    public FakeSensor(double pressure) {
        this.pressure = pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public double getPressure() {
        return pressure;
    }
}
