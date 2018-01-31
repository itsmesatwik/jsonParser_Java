import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseTest {

    private static final String COURSE_JSON = "{\n" +
            "   \"CRN\":41758,\n" +
            "   \"Subject\":\"AAS\",\n" +
            "   \"Number\":100,\n" +
            "   \"Title\":\"Intro Asian American Studies\",\n" +
            "   \"Section\":\"AD1\",\n" +
            "   \"Type\":\"DIS\",\n" +
            "   \"Term\":120138,\n" +
            "   \"Instructor\":\"Arai, Sayuri\",\n" +
            "   \"Grades\":[\n" +
            "      6,\n" +
            "      16,\n" +
            "      5,\n" +
            "      3,\n" +
            "      2,\n" +
            "      3,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "   ],\n" +
            "   \"Average\":3.72\n" +
            "}\n";
    private static final String COURSE_JSON_ARRAY = "[\n" +
            "  {\n" +
            "    \"CRN\": 41758,\n" +
            "    \"Subject\": \"AAS\",\n" +
            "    \"Number\": 100,\n" +
            "    \"Title\": \"Intro Asian American Studies\",\n" +
            "    \"Section\": \"AD1\",\n" +
            "    \"Type\": \"DIS\",\n" +
            "    \"Term\": 120138,\n" +
            "    \"Instructor\": \"Arai, Sayuri\",\n" +
            "    \"Grades\": [\n" +
            "      6,\n" +
            "      16,\n" +
            "      5,\n" +
            "      3,\n" +
            "      2,\n" +
            "      3,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "    ],\n" +
            "    \"Average\": 3.72\n" +
            "  },\n" +
            "  {\n" +
            "    \"CRN\": 47100,\n" +
            "    \"Subject\": \"AAS\",\n" +
            "    \"Number\": 100,\n" +
            "    \"Title\": \"Intro Asian American Studies\",\n" +
            "    \"Section\": \"AD2\",\n" +
            "    \"Type\": \"DIS\",\n" +
            "    \"Term\": 120138,\n" +
            "    \"Instructor\": \"Arai, Sayuri\",\n" +
            "    \"Grades\": [\n" +
            "      6,\n" +
            "      11,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      1,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "    ],\n" +
            "    \"Average\": 3.64\n" +
            "  },\n" +
            "  {\n" +
            "    \"CRN\": 47102,\n" +
            "    \"Subject\": \"AAS\",\n" +
            "    \"Number\": 100,\n" +
            "    \"Title\": \"Intro Asian American Studies\",\n" +
            "    \"Section\": \"AD3\",\n" +
            "    \"Type\": \"DIS\",\n" +
            "    \"Term\": 120138,\n" +
            "    \"Instructor\": \"Davis, Thomas E\",\n" +
            "    \"Grades\": [\n" +
            "      2,\n" +
            "      24,\n" +
            "      1,\n" +
            "      2,\n" +
            "      4,\n" +
            "      1,\n" +
            "      1,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "    ],\n" +
            "    \"Average\": 3.75\n" +
            "  },\n" +
            "  {\n" +
            "    \"CRN\": 51248,\n" +
            "    \"Subject\": \"AAS\",\n" +
            "    \"Number\": 100,\n" +
            "    \"Title\": \"Intro Asian American Studies\",\n" +
            "    \"Section\": \"AD4\",\n" +
            "    \"Type\": \"DIS\",\n" +
            "    \"Term\": 120138,\n" +
            "    \"Instructor\": \"Davis, Thomas E\",\n" +
            "    \"Grades\": [\n" +
            "      7,\n" +
            "      16,\n" +
            "      4,\n" +
            "      4,\n" +
            "      0,\n" +
            "      2,\n" +
            "      2,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "    ],\n" +
            "    \"Average\": 3.71\n" +
            "  }\n" +
            "]";

    private static Course testCourse;
    private static Course[] testCourse2;

    @Before
    public void gsonSetUp() {
        Gson testGson = new Gson();
        testCourse = testGson.fromJson(COURSE_JSON, Course.class);
        testCourse2 = testGson.fromJson(COURSE_JSON_ARRAY, Course[].class);
    }


    @Test
    public void getCrn() {
        assertEquals(41758, testCourse.getCrn());
        assertEquals(41758, testCourse2[0].getCrn());
    }
    @Test
    public void getNumber() {
        assertEquals(100, testCourse.getNumber());
        assertEquals(100, testCourse2[0].getNumber());
    }
    @Test
    public void getTerm() {
        assertEquals(120138, testCourse.getTerm());
        assertEquals(120138, testCourse2[0].getTerm());
    }

    @Test
    public void getAverage() {
        assertEquals(3.72, testCourse.getAverage(), 0.000001);
        assertEquals(3.72, testCourse2[0].getAverage(), 0.000001);
    }

    @Test
    public void getSubject() {
        assertEquals("AAS", testCourse.getSubject());
        assertEquals("AAS", testCourse2[0].getSubject());
    }

    @Test
    public void getTitle() {
        assertEquals("Intro Asian American Studies", testCourse.getTitle());
        assertEquals("Intro Asian American Studies", testCourse2[0].getTitle());
    }

    @Test
    public void getSection() {
        assertEquals("AD1", testCourse.getSection());
        assertEquals("AD1", testCourse2[0].getSection());
    }

    @Test
    public void getType() {
        assertEquals("DIS", testCourse.getType());
        assertEquals("DIS", testCourse2[0].getType());
    }

    @Test
    public void getInstructor() {
        assertEquals("Arai, Sayuri", testCourse.getInstructor());
        assertEquals("Arai, Sayuri", testCourse2[0].getInstructor());
    }

    @Test
    public void getGrades() {
        int[] testArr = new int[] {6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(testArr.length, testCourse.getGrades().length);
        assertEquals(testArr.length, testCourse2[0].getGrades().length);
        for (int i = 0; i < testArr.length; i++) {
            assertEquals(testArr[i], testCourse.getGrades()[i]);
            assertEquals(testArr[i], testCourse2[0].getGrades()[i]);
        }
    }

}