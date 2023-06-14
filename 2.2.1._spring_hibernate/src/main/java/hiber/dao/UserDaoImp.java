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
      String hqlQuaryreciveId = "select c.id from Car c where c.model=: carModel";
      String hql = "select c from User c where c.id= : idCar";


      Query query1 = sessionFactory.getCurrentSession().createQuery(hqlQuaryreciveId);
      query1.setParameter("carModel",car.getModel());

      Query quary = sessionFactory.getCurrentSession().createQuery(hql);;
      quary.setParameter("idCar",query1.getResultList().get(0));

      return quary.getResultList();
   }
}