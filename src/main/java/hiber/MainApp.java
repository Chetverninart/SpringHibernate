package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car logan = new Car("Logan", 5);
        Car rio = new Car("Rio", 2);
        Car solaris = new Car("Solaris", 3);

        User user1 = new User("LoganUser", "Logan", "logan@mail.ru", logan);
        User user2 = new User("RioUser", "Rio", "rio@mail.ru", rio);
        User user3 = new User("SolarisUser", "Solaris", "solaris@mail.ru", solaris);
        User user4 = new User("NoCarUser", "NoCar", "nocar@mail.ru");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println(user.toString());
//        }
//
//        List<Car> cars = userService.listCars();
//        for (Car car : cars) {
//            System.out.println(car.toString());
//        }

        User result = userService.getUserByCar("Rio", 2);
        System.out.println(result);

        context.close();
    }
}
