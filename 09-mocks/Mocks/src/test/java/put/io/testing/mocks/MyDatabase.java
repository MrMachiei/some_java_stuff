package put.io.testing.mocks;

import java.util.*;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class MyDatabase implements IFancyDatabase {
    @Override
    public void connect() {
    }

    @Override
    public <T> void persist(T t) {
    }

    @Override
    public <T> List<T> queryAll(){
        return Collections.emptyList();
    }

    @Override
    public void close() {
    }

}
