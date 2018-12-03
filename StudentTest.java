package hw1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import java.util.List;

class StudentTest {
	
	//create some classes
	Class se450 = new Class("se450");
	Class se440 = new Class("se440");
	Class csc447 = new Class("csc447");
	
    // Test that a class gets added to the students' Classes list
    @Test
    public void testAddClass(){
    	
        // Arrange
		Student student = new Student(1);
		
        // Act
		student.addClass(se450);
		List<Class> classList = new ArrayList();
		classList = student.getClasses();
		
        // Assert
		assertTrue(classList.contains(se450));
    }

    // Test that a class does not get added if maxNumberOfClasses
    // has been reached. Create a student with a max number of classes
    // of 2, add three classes, make sure the first two were added but
    // the third was not.
    @Test
    public void testAddClassDoesntAddClassesIfMaxed(){

        // Arrange
		Student student = new Student(2);
		
        // Act
		student.addClass(se450);
		student.addClass(se440);
		student.addClass(csc447);
		
		List<Class> classList = new ArrayList();
		classList = student.getClasses();
		
        // Assert
		assertFalse(classList.contains(csc447));

    }

    // Test the formatting of the schedule when getFormattedSchedule is called.
    // Add a couple classes to student, then make sure the string returned by
    // getFormattedSchedule is in the format {ClassName1}\r\n{ClassName2}\r\n
    @Test
    public void testGetFormattedSchedule(){

        // Arrange
		Student student = new Student(2);
		
        // Act
		Class se440 = new Class("se440");
		Class csc447 = new Class("csc447");
		student.addClass(se440);
		student.addClass(csc447);
		
        // Assert
		System.out.println(student.getFormattedSchedule());
        assertEquals("se440\r\ncsc447\r\n",student.getFormattedSchedule());
    }

    // Test that if a student has no classes, when getFormattedSchedule is called
    // the string "No classes added." gets returned.
    @Test
    public void testGetFormattedScheduleReturnsNoClassesAddedIfNoClasses(){

        // Arrange
		Student student = new Student(2);
		
        // Act- nothing needed here
		
        // Assert
		assertEquals("No classes added.", student.getFormattedSchedule());
    }
}