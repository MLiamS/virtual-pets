
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class PersonTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void person_instantiatesCorrectly_true() {
    Person testPerson = new Person("Henry", "henry@henry.com");
    assertEquals(true, testPerson instanceof Person);
  }

  @Test
  public void save_insertOjectIntoDatabase_Person() {
    Person testPerson = new Person ("Henry", "henry@henry.com");
    testPerson.save();
    assertTrue(Person.all().get(0).equals(testPerson));
  }

  @Test
 public void all_returnsAllInstancesOfPerson_true() {
   Person firstPerson = new Person("Henry", "henry@henry.com");
   firstPerson.save();
   Person secondPerson = new Person("Harriet", "harriet@harriet.com");
   secondPerson.save();
   assertEquals(true, Person.all().get(0).equals(firstPerson));
   assertEquals(true, Person.all().get(1).equals(secondPerson));
 }
}
