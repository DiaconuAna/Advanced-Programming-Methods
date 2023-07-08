package Model;

import java.util.Objects;

public class Car implements EntityInterface{
    private String carID;
    private String color;

    public Car(String id, String c){
        this.carID = id;
        this.color = c;
    }

    public String getID(){
        return this.carID;
    }

    public void setID(String id){
        this.carID = id;
    }

    public void setColor(String c){
        this.color = c;
    }

    @Override
    public boolean checkColor(String c) {
        return Objects.equals(this.color, c);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString(){
        return this.carID + ": " + this.color + " car";
    }
}
