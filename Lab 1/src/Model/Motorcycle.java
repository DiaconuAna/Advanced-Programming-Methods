package Model;

import java.util.Objects;

public class Motorcycle implements EntityInterface {

    private String motoID;
    private String color;

    public Motorcycle(String id, String c){
        this.motoID = id;
        this.color = c;
    }

    public String getMotoID(){
        return this.motoID;
    }

    public void setColor(String c){
        this.color = c;
    }

    public void setMotoID(String id){
        this.motoID  = id;
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
        return this.motoID + ": " + this.color + " motorcycle";

    }
}
