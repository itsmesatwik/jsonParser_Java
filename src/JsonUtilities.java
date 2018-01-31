import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class JsonUtilities {


    /**
     * A hash map for mapping all the grades with their index in the array.
     * Used for getting the index values of specific grades in the number of students
     */


    private static HashMap<String, Integer> gradeScale = new HashMap<>();

    static {
        gradeScale.put("A+",0);
        gradeScale.put("A",1);
        gradeScale.put("A-",2);
        gradeScale.put("B+",3);
        gradeScale.put("B",4);
        gradeScale.put("B-",5);
        gradeScale.put("C+",6);
        gradeScale.put("C",7);
        gradeScale.put("C-",8);
        gradeScale.put("D+",9);
        gradeScale.put("D",10);
        gradeScale.put("D-",11);
        gradeScale.put("F",12);
        gradeScale.put("W",13);
    }



    /**
     * returns the json string form from the list of file names that are passed to it.
     * @return return Array List of strings
     */


    public static ArrayList<String> jsonStringRetriever(List<String> jsonFiles) {

        ArrayList<String> jsonStrings = new ArrayList<>();
        //extracting strings from a list of filenames

        for (String json : jsonFiles) {
            jsonStrings.add(Data.getFileContentsAsString(json));
        }

        return jsonStrings;
    }


    /**
     * function for returning the list of list of courses from the json
     * files passed to it as a string
     * @param jsonStrings the list of json strings
     * @return list of course objects being returned
     */


    public static ArrayList<Course> courseJsonToObject(ArrayList<String> jsonStrings) {

        ArrayList<Course> courseData = new ArrayList<>();
        Gson gson = new Gson();

        //checking for empty arrays

        if (jsonStrings.size() == 0) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        //getting objects from the list of strings using the Gson library.

        for (String json : jsonStrings) {

            courseData.addAll(gson.fromJson(json,new TypeToken<ArrayList<Course>>(){}.getType()));
            //above code was inspired by code found on
            // "http://goo.gl/Bdk84P"
        }

        return courseData;
    }


    /**
     * function for returning all the courses from a certain department
     * throw an exception if the subject is invalid
     * @param subject the department name
     * @return return the list of courses belonging to the department
     */


    public static ArrayList<Course> subjectSearch(String subject, ArrayList<Course> courseData) {

        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        ArrayList<Course> subjectList = new ArrayList<>();

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        for (Course course : courseData) {
            // getting the subject from the course obj and checking if matches
            if(course.getSubject().equals(subject)) {
                    subjectList.add(course);
            }
        }

        //if not found ie the size of the list we're returning is 0
        //then throw a nosuchElement Exception

        if(subjectList.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return subjectList;
    }


    /**
     * function for searching all the courses taught by a certain instructor
     * @param instr name of the instructor to be searched
     * @return a list of courses that are taught by the given instructor
     */


    public static ArrayList<Course> instructorSearch(String instr, ArrayList<Course> courseData) {

        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        ArrayList<Course> instructorCourses = new ArrayList<>();

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        //checking all the courses for the instructor, if matches adding to the returned ArrList
        for (Course course : courseData) {
            //if the name contains the string passed to the method
            if(course.getInstructor().contains(instr)) {
                instructorCourses.add(course);
            }
        }
        //again if not found ie the list is empty then throw a no such element exception.
        if(instructorCourses.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return instructorCourses;
    }

    /**
     * function for searching all the courses that have their CRN in a given range
     * @param lo the low bound
     * @param hi the high bound
     * @return list of courses that fall in the range
     */

    public static ArrayList<Course> courseNumberSearch(int lo, int hi, ArrayList<Course> courseData) {
        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        //checking if the lo index is higher than the hi index and throwing an exception if true
        if(lo > hi || lo < 0) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        ArrayList<Course> crnList = new ArrayList<>();

        //for each course check if the CRN is in range, append to list if true
        for (Course course : courseData) {
            //checking if within the range
            if(course.getCrn() >= lo && course.getCrn() <= hi) {
                crnList.add(course);
            }
        }

        //Empty List check
        if(crnList.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return crnList;
    }

    /**
     * function that returns a list of courses which has number of students in a given range
     * @param lo the lower bound for the number
     * @param hi the upper bound for the number of students
     * @return return a list of course objects that fall in the range
     */

    public static ArrayList<Course> numberOfStudentsInRange(int lo, int hi, ArrayList<Course> courseData) {

        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        //checking if the parameters have been passed correctly
        if(lo > hi || lo < 0) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        ArrayList<Course> numOfCoursesInRange = new ArrayList<>();

        //see each course and then for each course get the sum and check if sum is in range.
        for (Course course : courseData) {
            int sum = 0;

            //getting the sum of students
            for(int i = 0; i < course.getGrades().length; i++) {
                sum += course.getGrades()[i];
            }

            //checking if sum is in range
            if(sum > lo && sum < hi) {
                numOfCoursesInRange.add(course);
            }
        }

        //empty return list check
        if(numOfCoursesInRange.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return numOfCoursesInRange;
    }

    /**
     * function that returns a list of courses for a given semester
     * @param term the term code for the semester
     * @return return a list of courses that are from the semester
     */


    public static ArrayList<Course> coursesFromASemester(int term, ArrayList<Course> courseData) {

        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        ArrayList<Course> semesterList = new ArrayList<>();

        //checking if the course matches the term for all the courses
        for(Course course : courseData) {

            if(course.getTerm() == term) {
                semesterList.add(course);
            }
        }

        //return list not empty check
        if(semesterList.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return semesterList;
    }

    /**
     * function that returns the number of students in a specific course
     * @param course the course
     * @return total students in the course
     */
    public static int numberOfStudentsInCourse(Course course) {

        //null argument check
        if(course == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        int totalStudents = 0;

        //summing all the students from the grades array
        for(int numOfStudents : course.getGrades()) {
            totalStudents += numOfStudents;
        }

        return totalStudents;
    }

    /**
     * function that returns the number of students in a certain collection of classes
     * @param filteredList list of the courses for which we want the number of students
     * @return return the number of students
     */


    public static int numberOfStudentsInClasses(ArrayList<Course> filteredList) {

        if(filteredList == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if(filteredList.size() == 0) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        int totalStudents = 0;

        for(Course course : filteredList) {
            totalStudents += numberOfStudentsInCourse(course);
        }

        return totalStudents;
    }

    /**
     * function for returning the number of students in a grade range
     * @param lo lower index grade or the Upper Grade Bound
     * @param hi high index grade or the Lower Grade Bound
     * @param filteredList the list of courses for which we want the result
     * @return the number of students who were in the grade range
     */


    public static int gradeStudentSearch(String lo, String hi, ArrayList<Course> filteredList) {

        //null check
        if(filteredList == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if(filteredList.size() == 0) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        //getting the index of the grades from the hash map initialized in the
        // beginning of this class
        int totalStudents = 0, loIndex = gradeScale.get(lo), hiIndex = gradeScale.get(hi);

        //checking if the arguments were provided in the correct Order
        if(loIndex > hiIndex) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        for(Course course : filteredList) {
            //getting grades
            for(int i = loIndex; i <= hiIndex; i++) {
                totalStudents += course.getGrades()[i];
            }
        }
        return totalStudents;
    }


    /**
     * function to return the weighted average GPA of a list of classes
     * @param filteredList list of courses for which the average is to be calculated
     * @return return weighted avg.
     */


    public static double weightedAvgGPA(ArrayList<Course> filteredList) {

        if(filteredList == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if(filteredList.size() == 0) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        double weightAvgSum = 0.0;
        double totalStudents = (double) numberOfStudentsInClasses(filteredList);

        for(Course course : filteredList) {
           weightAvgSum += course.getAverage()*((double)numberOfStudentsInCourse(course)/totalStudents);
        }

        return weightAvgSum;
    }



    /**
     * function that returns a list of course objects that match a certain type
     * @param type type of course ONL, LEC etc.
     * @return return a list of all the courses found.
     */


    public static ArrayList<Course> typeSearch(String type, ArrayList<Course> courseData) {

        if(courseData == null) {
            throw new NullPointerException(ErrorConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }

        if (courseData.size() == 0) {
            //throw an exception if the list is empty
            throw new IllegalArgumentException(ErrorConstants.EMPTY_ARRAYLIST_EXCEPTION);
        }

        ArrayList<Course> typeList = new ArrayList<>();

        for (Course course : courseData) {
            if(course.getType().equals(type)) {
                typeList.add(course);
            }
        }

        if(typeList.size() == 0) {
            throw new NoSuchElementException(ErrorConstants.NO_SUCH_ELEMENT_EXCEPTION);
        }

        return typeList;
    }
}
