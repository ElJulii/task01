import repositores.EventsRepository;
import repositores.Impl.EventsRepositoryFileImpl;
import repositores.UserRepository;
import repositores.Impl.UsersRepositoryFileImpl;
import services.AppService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UsersRepositoryFileImpl("users.txt");
        EventsRepository eventsRepository = new EventsRepositoryFileImpl("events.txt", "events_users.txt");
        AppService appService = new AppService(userRepository, eventsRepository);
//        appService.signUp("theBoss@gmail.com", "1234567");
//        appService.signUp("julian@gmail.com", "julian2003");
//
//        appService.addEvent("Practice for Java", LocalDate.now());
//        appService.addEvent("Practice of Golang", LocalDate.now().plusDays(1));
//
//        appService.addUserToEvent("julian@gmail.com", "Practice for Java");
//        appService.addUserToEvent("julian@gmail.com", "Practice of Golang");

        appService.getAllEventsByUser("theBoss@gmail.com");
    }
}
