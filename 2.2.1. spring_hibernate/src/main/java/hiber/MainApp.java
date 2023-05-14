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

      Car alexeyCar = new Car("Mersedes",220);
      Car dimonCar = new Car("Audi",100);
      Car shurikCar = new Car("BMW",525);
      Car igorCar = new Car("Жигули",5);

//      userService.addCar(alexeyCar);
//      userService.addCar(dimonCar);
//      userService.addCar(shurikCar);
//      userService.addCar(igorCar);

//      User alexey = new User("Alexey", "Semenov", "user1@mail.ru");
//      User dimon = new User("Dimon", "Kammisarov", "user2@mail.ru");
//      User shurik = new User("Shurik", "Papin", "user3@mail.ru");
//      User igor = new User("Igor", "Kiselev", "user4@mail.ru");

      User alexey = new User("Alexey", "Semenov", "user1@mail.ru",new Car("Mersedes",220));
      User dimon = new User("Dimon", "Kammisarov", "user2@mail.ru",new Car("Audi",100));
      User shurik = new User("Shurik", "Papin", "user3@mail.ru",new Car("BMW",525));
      User igor = new User("Igor", "Kiselev", "user4@mail.ru",new Car("Жигули",5));
      userService.add(alexey);
      userService.add(dimon);
      userService.add(shurik);
      userService.add(igor);



//      userService.addCar(alexeyCar);
//      userService.addCar(dimonCar);
//      userService.addCar(shurikCar);
//      userService.addCar(igorCar);

//      alexey.setCar(alexeyCar);
//      dimon.setCar(dimonCar);
//      shurik.setCar(shurikCar);
//      igor.setCar(igorCar);


//      userService.add(alexey);
//      userService.add(dimon);
//      userService.add(shurik);
//      userService.add(igor);

//      userService.add(new User("Alexey", "Semenov", "user1@mail.ru",new Car("Mersedes",220)));
//      userService.add(new User("Dimon", "Kammisarov", "user2@mail.ru",new Car("Audi",100)));
//      userService.add(new User("Shurik", "Papin", "user3@mail.ru",new Car("BMW",525)));
//      userService.add(new User("Igor", "Kiselev", "user4@mail.ru",new Car("Жигули",5)));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Model = " + user.getCar().getModel());
//         System.out.println();
//      }

      List<User> users = userService.listUserByCar(alexeyCar);
      for (User user : users) {
         System.out.println("\n" + "Достаём собственника по модели машины и по серии \n" +
                 "___________________________");
         System.out.println("Модель собственника: " + user.getCar().getModel() + " , серия: " +
                 user.getCar().getSeries());
         System.out.println("Данные владельца: \n"+"Id = "+ user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+ user.getEmail());
         System.out.println("__________________________");
      }

      context.close();
   }
}
