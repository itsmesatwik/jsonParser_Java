import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class JsonUtilitiesTest {

    private ArrayList<Course> courseObj = new ArrayList<>();
    private ArrayList<String> testStringList;
    private ArrayList<Course> testList = new ArrayList<>();
    private ArrayList<Course> emptyObjectList = new ArrayList<>();
    private ArrayList<String> emptyStringList = new ArrayList<>();

    @Before
    public void setUp() {
        testStringList = JsonUtilities.jsonStringRetriever(Data.getJsonFilesAsList());
        courseObj = JsonUtilities.courseJsonToObject(testStringList);
        testList = JsonUtilities.subjectSearch("VM", courseObj);
    }

    @Test
    public void jsonStringRetriever() {
        assertEquals(6, JsonUtilities.jsonStringRetriever(Data.getJsonFilesAsList()).size());
    }




    @Test
    public void courseJsonToObject() {
        assertEquals(9994, JsonUtilities.courseJsonToObject(testStringList).size());
    }

    @Test
    public void courseJsonToObject2() {
        try {
            JsonUtilities.courseJsonToObject(emptyStringList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void subjectSearch() {
        assertEquals(19, JsonUtilities.subjectSearch("VM", courseObj).size());
    }

    @Test
    public void subjectSearch2() {
        try {
            JsonUtilities.subjectSearch("Memes", courseObj);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void subjectSearch3() {
        try {
            JsonUtilities.subjectSearch("memez", emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void subjectSearch4(){
        try {
            JsonUtilities.subjectSearch("Memez", null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void instructorSearch() {
        assertEquals(9, JsonUtilities.instructorSearch("Zilles", courseObj).size());
    }

    @Test
    public void instructorSearch2() {
        try {
            JsonUtilities.instructorSearch("Memes", courseObj);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void instructorSearch3() {
        try {
            JsonUtilities.instructorSearch("Memes", emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void instructorSearch4() {
        try {
            JsonUtilities.instructorSearch("Memelord", null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }




    @Test
    public void courseNumberSearch() {
        assertEquals(6, JsonUtilities.courseNumberSearch(41000, 41090, courseObj).size());
    }

    @Test
    public void courseNumberSearch2() {
        try {
            JsonUtilities.courseNumberSearch(5, 4, courseObj);
            fail();
        } catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void courseNumberSearch3() {
        try {
            JsonUtilities.courseNumberSearch(4100,4200, courseObj);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void courseNumberSearch4() {
        try {
            JsonUtilities.courseNumberSearch(0,2, emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void courseSearch5(){
        try {
            JsonUtilities.courseNumberSearch(0, 1, null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void numberOfStudentsInRangeSearch() {
        assertEquals(104, JsonUtilities.numberOfStudentsInRange(48,50, courseObj).size());
    }
    @Test
    public void numberOfStudentsInRangeSearch2() {
        try {
            JsonUtilities.numberOfStudentsInRange(23, 21, courseObj);
            fail();
        } catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void numberOfStudentsInRangeSearch3() {
        try {
            JsonUtilities.numberOfStudentsInRange(0,10, courseObj);
            fail();
        }
        catch(Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void numberOfStudentsInRangeSearch4() {
        try {
            JsonUtilities.numberOfStudentsInRange(0,2, emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void numberOfStudentsInRangeSearch5() {
        try {
            JsonUtilities.numberOfStudentsInRange(0, 2, null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void coursesFromASemester() {
        assertEquals(2586, JsonUtilities.coursesFromASemester(120138, courseObj).size());
    }
    @Test
    public void coursesFromASemester2() {
        try {
            JsonUtilities.coursesFromASemester(10, courseObj);
            fail();
        }
        catch(Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }

    }
    @Test
    public void coursesFromASemester3() {
        try {
            JsonUtilities.coursesFromASemester(2100, emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void coursesFromASemester4() {
        try {
            JsonUtilities.coursesFromASemester(1234, null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void numberOfStudentsInCourse() {
        assertEquals(35, JsonUtilities.numberOfStudentsInCourse(courseObj.get(0)));
    }
    @Test
    public void numberOfStudentsInCourse2() {
        try {
            JsonUtilities.numberOfStudentsInCourse(null);
            fail();
        }
        catch(Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void numberOfStudentsInClasses() {
        assertEquals(2203, JsonUtilities.numberOfStudentsInClasses(testList));
    }
    @Test
    public void numberOfStudentsInClasses2() {
        try {
            JsonUtilities.numberOfStudentsInClasses(null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void numberOfStudentsInClasses3() {
        try {
            JsonUtilities.numberOfStudentsInClasses(emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void gradeStudentSearch() {
        assertEquals(3, JsonUtilities.gradeStudentSearch("D-", "W", testList));
    }
    @Test
    public void gradeStudentSearch2() {
        try {
            JsonUtilities.gradeStudentSearch("F", "A", testList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void gradeStudentSearch3() {
        try {
            JsonUtilities.gradeStudentSearch("A","Memez", emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void gradeStudentSearch4() {
        try {
            JsonUtilities.gradeStudentSearch("A","Memez", null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void weightedAvgGPA() {
        assertEquals(2.733, JsonUtilities.weightedAvgGPA(testList), 0.001);
    }

    @Test
    public void weightedAvgGPA2() {
        try {
            JsonUtilities.weightedAvgGPA(null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void weightedAvgGPA3() {
        try {
            JsonUtilities.weightedAvgGPA(emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }





    @Test
    public void typeSearch() {
        assertEquals(641, JsonUtilities.typeSearch("ONL", courseObj).size());
    }
    @Test
    public void typeSearch2() {
        try {
            JsonUtilities.typeSearch("Memes4Dayzz", courseObj);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void typeSearch3() {
        try {
            JsonUtilities.typeSearch("MEME", emptyObjectList);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION, e.getMessage());
        }
    }
    @Test
    public void typeSearch4() {
        try {
            JsonUtilities.typeSearch("MemeRUs", null);
            fail();
        }
        catch (Exception e) {
            assertEquals(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        }
    }
}