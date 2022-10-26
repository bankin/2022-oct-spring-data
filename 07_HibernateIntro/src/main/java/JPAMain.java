import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("alabala-db-unit-name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Teo");
        entityManager.persist(student);

        Student found = entityManager.find(Student.class, 3);

        System.out.println(found.getId() + " " + found.getName());

//        entityManager.remove(found);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
