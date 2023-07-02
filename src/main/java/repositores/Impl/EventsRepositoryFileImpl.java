package repositores.Impl;

import repositores.EventsRepository;
import repositores.UserRepository;
import ru.itis.models.Event;
import ru.itis.models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsRepositoryFileImpl implements EventsRepository {
    private final String fileName;
    private final String eventsFileUsersFileName;
    public EventsRepositoryFileImpl(String fileName, String eventsFileUsersFileName) {
        this.fileName = fileName;
        this.eventsFileUsersFileName = eventsFileUsersFileName;
    }
    @Override
    public void save(Event model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(model.getId() + "|" + model.getName() +"|" + model.getDate());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Event findByName(String nameEvent) {
        if (nameEvent.equals("Practice for Java")) {
            return Event.builder()
                    .id("7d9d2183-3557-4a39-827a-5d40b900657b")
                    .name("Practice for Java").
                    date(LocalDate.parse("2023-07-01")).
                    build();
        }
        if (nameEvent.equals("Practice of Golang")) {
            return Event.builder().id("ded35514-84d7-475d-b4e0-e23ef4d0a4fe")
                    .name("Practice of Golang")
                    .date(LocalDate.parse("2023-07-02"))
                    .build();
        }
        return null;
    }

    @Override
    public void saveUserToEvent(User user, Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventsFileUsersFileName, true))){
            writer.write(user.getId() + " | " + event.getId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Event> findAllByMembersContains(User user) {

        List<Event> eventList = new ArrayList<>();
        eventList.add(findByName("Practice for Java"));
        eventList.add(findByName("Practice of Golang"));
        return eventList;
    }

}
