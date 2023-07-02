package repositores;

import ru.itis.models.User;

public interface UserRepository extends CrudRepository<User> {
    User findByEmail(String emailUser);
}
