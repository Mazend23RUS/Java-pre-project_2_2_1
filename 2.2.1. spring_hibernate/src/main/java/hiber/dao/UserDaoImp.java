package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   /**
   Метод позволяет по машине получить собсвенника авто
    */
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUserByCar(Car car) {
      String hql = "from User u where u.car.model =:carModel";
      Query quary = sessionFactory.getCurrentSession().createQuery(hql);
//      quary.setParameter("s",car.getSeries());
      quary.setParameter("carModel",car.getModel());
      return quary.getResultList();
   }
}