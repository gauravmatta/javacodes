import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springimplant.selfjoin.Entity.Employee;

public class Main {

	public static void main(String[] args) {
		 
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        Employee manager1 = new Employee("Chuck", "Norris");
        
        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");

        employee1.setManager(manager1);
        employee2.setManager(manager1);
        
        session.save(employee1);
        session.save(employee2);
        
        session.getTransaction().commit();
        session.close();
    }
	
	
}
