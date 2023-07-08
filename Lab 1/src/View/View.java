package View;
import java.util.Scanner;
import Model.*;
import Controller.Controller;
import Repository.Repository;
import Repository.RepositoryInterface;
import Repository.MyException;

public class View {

    public static void printMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Add a vehicle");
        //System.out.println("2. Delete a vehicle");
        System.out.println("2. Filter red vehicles");
        System.out.println("3. View all vehicles");
    }

    public static void printVehicleTypes(){
        System.out.println("\n Vehicle types>> ");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Motorcycle");
    }

    public static EntityInterface addVehicle() throws MyException{
        String vehicle_id, color;
        int type_id;

        Scanner type = new Scanner(System.in);
        printVehicleTypes();

        type_id = type.nextInt();

        if(type_id == 1){
            Scanner scan= new Scanner(System.in);
            System.out.println("Car ID: ");
            vehicle_id = scan.nextLine();
            System.out.println("Car color: ");
            color = scan.next();
            return new Car(vehicle_id, color);
        }
        else if(type_id == 2){
            Scanner scan= new Scanner(System.in);
            System.out.println("Bike ID: ");
            vehicle_id = scan.nextLine();
            System.out.println("Bike color: ");
            color = scan.nextLine();
            return new Bicycle(vehicle_id, color);
        }
        else if(type_id == 3){
            Scanner scan= new Scanner(System.in);
            System.out.println("Motorcycle ID: ");
            vehicle_id = scan.nextLine();
            System.out.println("Motorcycle color: ");
            color = scan.nextLine();
            return new Motorcycle(vehicle_id, color);

        }
        else
            throw new MyException("Invalid choice. Please pick a proper vehicle!");

    }

    public void deleteVehicle() throws MyException{

    }

    public static void main(String[] args) throws MyException{
        Repository r = new Repository(10);
        Controller c = new Controller(r);

        try{
            c.add(new  Car("Ford Focus", "black"));
            c.add(new Bicycle("Anna's bike", "red"));
            c.add(new Car("Toyota C-HR", "red"));
            c.add(new Motorcycle("Eskel's motorcycle", "silver"));
            c.add(new Car("Volkswagen Tiguan", "red"));

//            EntityInterface[] filtered = c.filtered("red");
//
//            for(int i=0;i<filtered.length;i++) {
//                if(filtered[i] != null)
//                    System.out.println(filtered[i]);
//            }

        }
        catch(MyException exc){
            System.out.println(exc.getMessage());
        }

        try {
           boolean over = false;

           while( !over){
               int choice;
               printMenu();
               Scanner scan = new Scanner(System.in);
               choice = scan.nextInt();

               if(choice == 0){
                   over = true;
                   System.out.println("Goodbye! :)");
               }
               else if (choice == 1)
                   try{
                   EntityInterface vehicle = addVehicle();
                   c.add(vehicle);
                   System.out.println("A new vehicle had been added: ");
                   System.out.println(vehicle.getColor() + vehicle.toString());
                   }
                   catch(MyException exc){
                       System.out.println(exc.getMessage());
                   }
               else if (choice == 2){
                   EntityInterface[] filter = c.filtered("red");
                   System.out.println(filter.length);

                   for(int i=0;i<filter.length;i++)
                       if(filter[i] != null)
                           System.out.println(filter[i]);
               }
               else if (choice == 3){
                   EntityInterface[] vehicles = c.getVehicles();

                   for(int i=0;i<vehicles.length;i++)
                       if(vehicles[i] != null)
                           System.out.println(vehicles[i]);
               }

               else
                   throw new MyException("Invalid choice. Please try again!");
           }

        }
        catch(MyException exc){
            System.out.println(exc.getMessage());
        }


    }
}
