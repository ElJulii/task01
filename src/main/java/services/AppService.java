package services;

import repositores.EventsRepository;
import repositores.UserRepository;
import ru.itis.models.Event;
import ru.itis.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AppService {
    private final UserRepository userRepository;
    private final EventsRepository eventsRepository;

    public AppService(UserRepository userRepository, EventsRepository eventsRepository) {
        this.userRepository = userRepository;
        this.eventsRepository = eventsRepository;
    }

    public void signUp(String email, String password) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email(email)
                .password(password)
                .build();
        userRepository.save(user);
    }

    public void addEvent(String name, LocalDate date) {
        Event event = Event.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .date(date)
                .build();
        eventsRepository.save(event);
    }

    public void addUserToEvent(String emailUser, String nameEvent) {
        User user =  userRepository.findByEmail(emailUser);

        if (user == null) {
            throw new IllegalArgumentException("User was not found");
        }
        Event event = eventsRepository.findByName(nameEvent);
        if (event == null) {
            throw new IllegalArgumentException("Event was not found");
        }
        eventsRepository.saveUserToEvent(user, event);
    }

    public void getAllEventsByUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User was not found");
        } else {
            System.out.println(user.getId() + " : " + eventsRepository.findAllByMembersContains(user));
        }

    }
}
