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

        User alexey = new User("Alexey", "Semenov", "user1@mail.ru");
        User dimon = new User("Dimon", "Kammisarov", "user2@mail.ru");
        User shurik = new User("Shurik", "Papin", "user3@mail.ru");
        User igor = new User("Igor", "Kiselev", "user4@mail.ru");

        Car alexeyCar = new Car("Mersedes", 220);
        Car dimonCar = new Car("Audi", 100);
        Car shurikCar = new Car("BMW", 525);
        Car igorCar = new Car("Жигули", 5);

        userService.add(alexey);
        userService.add(dimon);
        userService.add(shurik);
        userService.add(igor);

        alexeyCar.setUser(alexey);
        dimonCar.setUser(dimon);
        shurikCar.setUser(shurik);
        igorCar.setUser(igor);


        userService.addCar(alexeyCar);
        userService.addCar(dimonCar);
        userService.addCar(shurikCar);
        userService.addCar(igorCar);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("_______________________");
            System.out.println("Добавлен новый User :" + user.getFirstName());
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("_______________________");
            System.out.println();
        }

      List<User> users1 = userService.listUserByCar(alexeyCar);
      for (User user : users1) {
         System.out.println("\n" + "Достаём собственника по модели машины и по серии \n" +
                 "___________________________");
         System.out.println("Модель собственника: " + alexeyCar.getModel() + " , серия: " +
                 alexeyCar.getSeries());
         System.out.println("Данные владельца: \n"+"Id = "+ user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+ user.getEmail());
         System.out.println("__________________________");
      }


        List<User> users2 = userService.listUserByCar(dimonCar);
        for (User user : users2) {
            System.out.println("\n" + "Достаём собственника по модели машины и по серии \n" +
                    "___________________________");
            System.out.println("Модель собственника: " + dimonCar.getModel() + " , серия: " +
                    dimonCar.getSeries());
            System.out.println("Данные владельца: \n"+"Id = "+ user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+ user.getEmail());
            System.out.println("__________________________");
        }


        List<User> users3 = userService.listUserByCar(shurikCar);
        for (User user : users3) {
            System.out.println("\n" + "Достаём собственника по модели машины и по серии \n" +
                    "___________________________");
            System.out.println("Модель собственника: " + shurikCar.getModel() + " , серия: " +
                    shurikCar.getSeries());
            System.out.println("Данные владельца: \n"+"Id = "+ user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+ user.getEmail());
            System.out.println("__________________________");
        }

        List<User> users4 = userService.listUserByCar(igorCar);
        for (User user : users4) {
            System.out.println("\n" + "Достаём собственника по модели машины и по серии \n" +
                    "___________________________");
            System.out.println("Модель собственника: " + igorCar.getModel() + " , серия: " +
                    igorCar.getSeries());
            System.out.println("Данные владельца: \n"+"Id = "+ user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+ user.getEmail());
            System.out.println("__________________________");
        }
        context.close();
    }
}
