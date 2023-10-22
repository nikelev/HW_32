package ait.homework_32_Garage.cars.model;

public class Car {
    String regNumber;
    String model;
    String company;
    double engine;
    String color;

    public Car(String regNumber, String model, String company, double engine, String color) {
        this.regNumber = regNumber;
        this.model = model;
        this.company = company;
        this.engine = engine;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "regNumber='" + regNumber + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Car car = (Car) object;

        if (!regNumber.equals(car.regNumber)) return false;
        if (!model.equals(car.model)) return false;
        if (!company.equals(car.company)) return false;
        return color.equals(car.color);
    }

    @Override
    public int hashCode() {
        int result = regNumber.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
