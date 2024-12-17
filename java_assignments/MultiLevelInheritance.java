class Vehicle {
    String dom;
    int mNo;
    String engType;

    protected Vehicle(String dom, int mNo, String engType) {
        this.dom = dom;
        this.mNo = mNo;
        this.engType = engType;
    }

    public void display() {
        System.out.println("\n--- Vehicle Info ---");
        System.out.println("Date of Making: " + dom);
        System.out.println("Model No: " + mNo);
        System.out.println("Engine Type: " + engType);
    }
}

class Car extends Vehicle {
    String modelName;

    protected Car(String dom, int mNo, String engType, String modelName) {
        super(dom, mNo, engType);
        this.modelName = modelName;
    }

    public void displayCar() {
        System.out.println("\n--- Car Info ---");
        System.out.println("Model Name: " + modelName);
        System.out.println("Date of Making: " + dom);
        System.out.println("Model No: " + mNo);
        System.out.println("Engine Type: " + engType);
    }
}

class ElectricCar extends Car {
    double fuel;

    protected ElectricCar(String dom, int mNo, String engType, String modelName, double fuel) {
        super(dom, mNo, engType, modelName);
        this.fuel = fuel;
    }
}

class RacerCar extends Car {
    String speed;

    protected RacerCar(String dom, int mNo, String engType, String modelName, String speed) {
        super(dom, mNo, engType, modelName);
        this.speed = speed;
    }
}

class Bike extends Vehicle {
    String modelName;

    protected Bike(String dom, int mNo, String engType, String modelName) {
        super(dom, mNo, engType);
        this.modelName = modelName;
    }

    public void displayBike() {
        System.out.println("\n--- Bike Info ---");
        System.out.println("Model Name: " + modelName);
        System.out.println("Date of Making: " + dom);
        System.out.println("Model No: " + mNo);
        System.out.println("Engine Type: " + engType);
    }
}

class MountainBike extends Bike {
    String tires;

    protected MountainBike(String dom, int mNo, String engType, String modelName, String tires) {
        super(dom, mNo, engType, modelName);
        this.tires = tires;
    }
}

class RacerBike extends Bike {
    int speed;

    protected RacerBike(String dom, int mNo, String engType, String modelName, int speed) {
        super(dom, mNo, engType, modelName);
        this.speed = speed;
    }
}

public class MultiLevelInheritance {

    public static void main(String[] args) {
        ElectricCar eCar = new ElectricCar("2019-11-15", 178, "DTS", "Honda", 77);
        eCar.display();
        eCar.displayCar();

        RacerBike rBike = new RacerBike("2017-01-18", 12345, "V6", "SuperSpeedBike", 200);
        rBike.display();
        rBike.displayBike();
    }
}
