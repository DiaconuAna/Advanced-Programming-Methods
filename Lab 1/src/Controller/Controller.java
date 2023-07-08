package Controller;
import Model.EntityInterface;
import Repository.Repository;
import Repository.RepositoryInterface;
import Repository.MyException;

public class Controller {
    RepositoryInterface repo;

    public Controller(RepositoryInterface r){
        this.repo = r;
    }

    public void add(EntityInterface vehicle) throws MyException{
        this.repo.add(vehicle);
    }

    public void delete(int position) throws Exception {
        this.repo.delete(position);
    }

    public EntityInterface[] filtered(String colour){
       // return this.repo.filter(colour);
        EntityInterface[] vehicles = this.repo.getEntity();
        int i = 0;
        int tmp = 0;
        int size = this.repo.getSize();
        int index = this.repo.getCurrentSize();

        EntityInterface[] filtered = new  EntityInterface[size];

        for(i=0;i<index;i++){
            if(vehicles[i].checkColor("red")) {
                filtered[tmp++] = vehicles[i];
            }
        }

        return filtered;
    }

    public EntityInterface[] getVehicles(){
        return this.repo.getEntity();
    }


}
