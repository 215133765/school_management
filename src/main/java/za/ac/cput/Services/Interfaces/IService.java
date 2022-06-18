package za.ac.cput.Services.Interfaces;

public interface IService <T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    String delete(ID id);
}
