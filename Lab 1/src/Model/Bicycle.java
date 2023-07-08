package Model;

import java.util.Objects;

public class Bicycle implements EntityInterface {
    private String bike_id;
    private String color;

    public Bicycle(String id, String c){
        this.bike_id = id;
        this.color = c;
    }

    public String getID(){
        return this.bike_id;
    }

    public void setID(String id){
        this.bike_id = id;
    }

    public void setColor(String color){
        this.color = color;
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
        return this.bike_id + ": " + this.color + " bike";
    }
}
