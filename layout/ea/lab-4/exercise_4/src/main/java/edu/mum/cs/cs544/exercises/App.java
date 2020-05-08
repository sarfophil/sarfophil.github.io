package edu.mum.cs.cs544.exercises;

import java.time.LocalDate;
import java.util.*;

import edu.mum.cs.cs544.exercises.domain.q1.Employee;
import edu.mum.cs.cs544.exercises.domain.q1.Laptop;
import edu.mum.cs.cs544.exercises.domain.q2.Flight;
import edu.mum.cs.cs544.exercises.domain.q2.Passenger;
import edu.mum.cs.cs544.exercises.domain.q3.School;
import edu.mum.cs.cs544.exercises.domain.q3.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;








public class App {

	private static final SessionFactory sessionFactory;

    private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		question1();
		question2();
		question3();
    }
    

	
	private static void question1() {
		Session session = null;
        Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Set Laptops
			Set<Laptop> laptops = new HashSet<>();
			laptops.add(new Laptop("Lenovo","345-4"));


			Employee employee = new Employee("Philip","Sarfo");
			employee.setLaptops(laptops);

			session.persist(employee);

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

	private static void question2(){
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Passenger passenger = new Passenger("Philip");

			List<Flight> flights = new ArrayList<>();
			flights.add(new Flight("2343","Ottunwa","Fairfield"));

			passenger.setFlights(flights);

			session.persist(passenger);

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

	private static void question3(){
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();



			School school = new School("MIU");

			Map<Long, Student> studentMap = new HashMap<>();
			studentMap.put(school.getId(),new Student("Philip","Sarfo"));

			school.setStudentMap(studentMap);

			session.persist(school);

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
