public class Car {

    private int carLength;
    private int carWidth;
    private int carID = 1;

    public Car(int length, int width)
    {
        this.carLength = length;
        this.carWidth = width;
        carID++;
    }

    public int getCarLength()
    {
        return carLength;
    }

    public int getCarWidth()
    {
        return carWidth;
    }

    public int getCarID()
    {
        return carID;
    }

    public void rotateCar()
    {
        int temp = carLength;
        carLength = carWidth;
        carWidth = temp;
    }

    public void printCar()
    {
        System.out.println("Car ID: " + this.carID + "\tLength: " + this.carLength + "\tWidth: " + this.carWidth);
    }
}
