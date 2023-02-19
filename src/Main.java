import java.io.IOException;
import java.util.*;

public class Main {
    private ArrayList<Car> cars;
    private int parkingLotLength;
    private int parkingLotWidth;
    private int X, Y;


    public boolean canCarFit(Car car, int [][] parkingLot, int width, int length)
    {
        boolean check = false;

        for (int i = 0; i < length && !check; i++)
        {
            for (int j = 0; j < width && !check; j++)
            {
                if (parkingLot[i][j] == 0)
                {
                    X = j;
                    Y = i;
                    check = checkCoordinate(car, X, Y, parkingLot);
                }
            }
        }

        if (check)
        {

            carParked(car, parkingLot, X, Y);
            return true;
        }
        return false;
    }

    public void carParked(Car car, int[][] parkingLot, int x, int y)
    {

        for (int i = x; i < car.getCarWidth()+x; i++)
        {
            for (int j = y; j < car.getCarLength()+y; j++)
            {
                parkingLot[j][i] = car.getCarID();
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean checkCoordinate(Car car, int X, int Y, int [][] parkingLot)
    {
        //... If car length/width exceeds parking lot length/width, return false
        if ((X + car.getCarWidth() > parkingLotWidth) || (Y + car.getCarLength() > parkingLotLength))
        {
            return false;
        }

        for (int i = Y; i < Y + car.getCarLength(); i++)
        {
            for (int j = X; j < X + car.getCarWidth(); j++)
            {
                if (parkingLot[i][j] != 0)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public void validateCarSize(int [][] parkingLot, int width, int length)
    {
        boolean FIT = false;
        for(int i = 0; i < cars.size(); i++)
        {
            FIT = canCarFit(cars.get(i), parkingLot, width, length);

            //... let's rotate and try again
            if(!FIT)
            {
                cars.get(i).rotateCar();
                FIT = canCarFit(cars.get(i), parkingLot, width, length);
            }

            //... if we still can't fit, break
            if(!FIT)
            {
                break;
            }
        }

        if (!FIT)
        {
            cars.get(0).rotateCar();

            parkingLot = new int[width][length];

            for(int i = 0; i < cars.size(); i++)
            {
                FIT = canCarFit(cars.get(i), parkingLot, width, length);

                //... let's rotate and try again
                if(!FIT)
                {
                    cars.get(i).rotateCar();
                    FIT = canCarFit(cars.get(i), parkingLot, width, length);
                }

                //... if we still can't fit, then car is too big
                if(!FIT)
                {
                    System.out.println("Car with ID: " + cars.get(i).getCarID() + " is too damn big to fit in the parking lot...");
                    cars.get(i).printCar();
                    return;
                }
            }

        }
    }




    public static void main(String[] args) throws IOException
    {
        Main main  = new Main();
       main.cars =new ArrayList<Car>();
       main.X = 0; main.Y = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of parking lot: ");
        main.parkingLotLength = scanner.nextInt();
        System.out.println("Enter the width of parking lot: ");
        main.parkingLotWidth = scanner.nextInt();

        int [][] parkingLot = new int [main.parkingLotLength][main.parkingLotWidth];

        System.out.println("Enter the number of number of cars to park: ");
        int noOfCars = scanner.nextInt();

        System.out.println("Enter the length and width of each car.");

        for (int i = 0; i < noOfCars; i++)
        {
            System.out.println("Car " + i);
            int carLength = scanner.nextInt();
            int carWidth = scanner.nextInt();

            if(carLength < carWidth)
                main.cars.add(new Car(carWidth, carLength));
            else
                main.cars.add(new Car(carLength, carWidth));

        }
        scanner.close();

        Collections.sort(main.cars, (o1, o2) -> {
            int result = Integer.compare(o2.getCarWidth(), o1.getCarWidth());
            if(result == 0)
            {
                result = Integer.compare(o2.getCarLength(), o1.getCarLength());
            }
            return result;
        });

        main.validateCarSize(parkingLot, main.parkingLotWidth, main.parkingLotLength);

        for(int i = 0; i < main.parkingLotLength; i++)
        {
            for(int j = 0; j < main.parkingLotWidth; j++)
            {
                if(j < main.parkingLotWidth - 1)
                {
                    System.out.print(parkingLot[i][j] + "\t");
                }
                else
                {
                    System.out.print(parkingLot[i][j]);
                }
            }
            if(i < main.parkingLotLength - 1)
            {
                System.out.println();
            }
        }


    }
}
