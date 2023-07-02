package repositores.Impl;

import repositores.UserRepository;
import ru.itis.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsersRepositoryFileImpl implements UserRepository {
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void save(User model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(model.getId() + "|" + model.getEmail() +"|" + model.getPassword());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User findByEmail(String emailUser) {
        if (emailUser.equals("julian@gmail.com")) {
            return User.builder()
                    .id("c7199a01-c7f1-4e65-bc8c-960a8ef6e68b")
                    .email("julian@gmail.com")
                    .password("julian2003")
                    .build();
        }
        return null;
    }
}
