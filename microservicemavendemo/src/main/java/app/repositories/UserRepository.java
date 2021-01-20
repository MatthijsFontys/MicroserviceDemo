package app.repositories;

import app.entities.UserDto;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import static java.util.UUID.randomUUID;

public class UserRepository extends AbstractDAO<UserDto> {

    private SessionFactory context;

    public UserRepository(SessionFactory context) {
        super(context);
        this.context = context;
    }

    public UserDto findById(int id){
        return get(id);
    }

    public UserDto addUser(String name){
        final String email = String.format("%s@gmail.com", name);
        final String salt = randomUUID().toString();
        final String passHash = randomUUID().toString();
        final UserDto entity = new UserDto(name, email, salt, passHash, false);
        persist(entity);
        return entity;
    }

}
