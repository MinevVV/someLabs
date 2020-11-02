package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;
    private int freeParks;

    public Parking(String type, int capacity) {

        this.capacity = capacity;
        this.type = type;
        this.data = new ArrayList<>();
        this.freeParks = 0;


    }

    public void add(Car car) {
        if (this.freeParks < this.capacity) {

            this.data.add(car);
            this.freeParks++;
        }


    }

    public boolean remove(String manufacturer, String model) {

        for (int i = 0; i < data.size(); i++) {

            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                this.data.remove(this.data.get(i));
                return true;
            }
        }

        return false;
    }

    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < data.size(); i++) {

            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                return this.data.get(i);

            }
        }

        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are parked in %s:%n", this.type));
        this.data.forEach(e -> {
            sb.append(e.toString());
            sb.append(String.format("%n"));

        });
        return sb.toString();
    }

    public int getCount() {

        return this.data.size();
    }

    public Car getLatestCar() {

        if (this.data.size() != 0) {
            List<Car> copy = new ArrayList<>(this.data);
            Object[] objects = copy.stream().sorted((l, r) -> r.compareTo(l)).toArray();
            Car car = (Car) objects[0];
            return car;
        }
        return null;
    }
}