package hiber.dao;

import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {

      Query query = sessionFactory.getCurrentSession().createQuery("FROM User");

      return query.getResultList();
   }

   @Override
   public List<User> getUsers(String model, int series) {

      Query query = sessionFactory.getCurrentSession().createQuery("SELECT a FROM User a INNER JOIN a.car c WHERE c.model = :model and c.series = :series")
               .setParameter("series", series)
                .setParameter("model", model);

      return query.getResultList();
   }
}
