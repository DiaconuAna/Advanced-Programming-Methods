package Repository;

import Model.EntityInterface;

public class Repository implements RepositoryInterface{

    private EntityInterface[] vehicles;
    private int index;
    private int size;

    public Repository(int s){
        this.vehicles = new EntityInterface[s];
        this.index = 0;
        this.size = s;
    }

    @Override
    public void add(EntityInterface entity) throws MyException {
        if(this.index == this.size)
            throw new MyException("No more vehicles can be added to the list!");
        this.vehicles[this.index++] = entity;
    }

    @Override
    public void delete(int position) throws MyException {
        if(position >= this.size-1 || position < 0)
            throw new MyException("There is no vehicle on that position!");

        //bring the last element from the array on the position of the element we want to delete
        this.vehicles[position] = this.vehicles[this.index-1];
        this.index--;

    }

    @Override
    public EntityInterface[] filter(String colour) {
        int i = 0;
        int tmp = 0;

        EntityInterface[] filtered = new  EntityInterface[this.size];

        for(i=0;i<this.index;i++){
            if(this.vehicles[i].checkColor("red")) {
                filtered[tmp++] = this.vehicles[i];
            }
        }

        return filtered;
    }

    @Override
    public EntityInterface[] getEntity() {
        return this.vehicles;
    }

    @Override
    public int getCurrentSize() {
        return this.index;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
