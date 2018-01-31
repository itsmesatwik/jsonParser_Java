import com.google.gson.annotations.SerializedName;
/*
 *{
  "CRN": 41758,
  "Subject": "AAS",
  "Number": 100,
  "Title": "Intro Asian American Studies",
  "Section": "AD1",
  "Type": "DIS",
  "Term": 120138,
  "Instructor": "Arai, Sayuri",
  "Grades": [
    6,
    16,
    5,
    3,
    2,
    3,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0
  ],
  "Average": 3.72
}
 */
public class Course {
    @SerializedName("CRN") private int crn;

    @SerializedName("Number") private int number;

    @SerializedName("Term") private int term;

    @SerializedName("Subject") private String subject;

    @SerializedName("Title") private String title;

    @SerializedName("Section") private String section;

    @SerializedName("Type") private String type;

    @SerializedName("Instructor") private String instructor;

    @SerializedName("Grades") private int[] grades;

    @SerializedName("Average") private double average;

    public Course() {
    }


    public int getCrn() {
        return crn;
    }

    public int getNumber() {
        return number;
    }

    public int getTerm() {
        return term;
    }

    public double getAverage() {
        return average;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getType() {
        return type;
    }

    public String getInstructor() {
        return instructor;
    }

    public int[] getGrades() {
        return grades;
    }
}
