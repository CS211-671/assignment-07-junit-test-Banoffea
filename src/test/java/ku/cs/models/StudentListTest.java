package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    public void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "John Doe");

        Student student = studentList.findStudentById("S001");

        assertNotNull(student);
        assertEquals("S001", student.getId());
        assertEquals("John Doe", student.getName());
    }
    @Test
    public void testAddNewStudentWithoutScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "John Doe");

        Student student = studentList.findStudentById("S001");

        assertNotNull(student);
        assertEquals("S001", student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals(0.0, student.getScore(), 0.01); // Assuming default score is 0
    }

    @Test
    public void testAddNewStudentWithScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S002", "Jane Doe", 95.0);

        Student student = studentList.findStudentById("S002");

        assertNotNull(student);
        assertEquals("S002", student.getId());
        assertEquals("Jane Doe", student.getName());
        assertEquals(95.0, student.getScore(), 0.01);
    }

    @Test
    public void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S004", "Charlie Green");

        studentList.giveScoreToId("S004", 85.0);

        Student student = studentList.findStudentById("S004");

        assertNotNull(student);
        assertEquals(85.0, student.getScore(), 0.01);
    }

    @Test
    public void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S005", "Eve White", 72.0);

        String grade = studentList.viewGradeOfId("S005");

        assertNotNull(grade);
        assertEquals("C", grade); // Assuming the grade scale is used to return grade
    }
}