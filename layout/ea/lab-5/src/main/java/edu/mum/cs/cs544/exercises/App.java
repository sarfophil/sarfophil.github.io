package edu.mum.cs.cs544.exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.mum.cs.cs544.exercises.domain.question1.Book;
import edu.mum.cs.cs544.exercises.domain.question1.CD;
import edu.mum.cs.cs544.exercises.domain.question1.Customer;
import edu.mum.cs.cs544.exercises.domain.question1.DVD;
import edu.mum.cs.cs544.exercises.domain.question1.Order;
import edu.mum.cs.cs544.exercises.domain.question1.OrderLine;
import edu.mum.cs.cs544.exercises.domain.question1.Product;








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
    }
    

	
	private static void question1() {
		Session session = null;
        Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Customer customer = new Customer("Philip", "Sarfo");

			List<Order> orList = new ArrayList<Order>();
            List<OrderLine> orderLines = new ArrayList<OrderLine>();
            
			
			OrderLine orderLine = new OrderLine("900");
			

			Product cd =  new CD("Laptop", "Lenovo","Jai Guru Dev 1");
			Product dvd = new DVD("Meditation", "Maharishi", "Jai Guru Dev");
			Product book = new Book("Meditation", "Maharishi", "Jai Guru Dev");

			
			orderLine.setProduct(cd);
			orderLine.setProduct(dvd);
			orderLine.setProduct(book);

			orderLines.add(orderLine);
			Order order = new Order();
			order.setOrderLines(orderLines);
			


			orList.add(order);

			customer.setoList(orList);

			session.persist(customer);

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
