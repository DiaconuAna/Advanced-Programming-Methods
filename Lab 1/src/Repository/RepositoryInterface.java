package Repository;
import Model.EntityInterface;

public interface RepositoryInterface {

    void add(EntityInterface entity) throws MyException;
    void delete(int position) throws MyException;
    EntityInterface[] filter(String colour);
    EntityInterface[] getEntity();
    int getCurrentSize();
    int getSize();
}
