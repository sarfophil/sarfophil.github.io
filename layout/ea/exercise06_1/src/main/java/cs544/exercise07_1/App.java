package cs544.exercise07_1;

import cs544.exercise07_1.model.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
       fillDatabase();
    }

   private static void fillDatabase(){
       Session session = null;
       Transaction tx = null;
       try {
           session = sessionFactory.openSession();
           tx = session.beginTransaction();

           Address address = new Address("100 Main Street","Boston","23114");

           Patient patient = new Patient("John Doe",address);

           Payment payment = new Payment("12/06/08",100);

           Doctor doctor = new Doctor("Eye Doctor","Frank","Brown");

           Appointment appointment = new Appointment("15/05/08",patient,payment,doctor);

           session.persist(appointment);

           tx.commit();

       } catch (Exception e) {
           if (tx != null) {
               System.err.println("Rolling back: " + e.getMessage());
               tx.rollback();
           }
       } finally {
           if (session != null) {
               session.close();
           }
       }
   }
}
