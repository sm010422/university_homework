import java.util.jar.JarEntry;

class Course{
    public String courseName;
    public String courseNumber;

    public Course(String courseName, String courseNumber){
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }

    public String getCourseName(){
        return this.courseName;
    }
    public String getCourseNumber(){
        return this.courseNumber;
    }
    public String getAllData(){
        return this.courseName + " " + this.courseNumber;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setCourseNumber(String courseNumber){
        this.courseNumber = courseNumber;
    }
}

class GenEdu extends Course{
    String pass;
    public GenEdu(String courseName, String courseNumber,String pass){
        super(courseName,courseNumber);
        this.pass = pass;
    }
    public String isPass(){
        return this.pass;
    }

    @Override
    public String getAllData() {
        return "교과목명: " + this.courseName + "\n교과목 번호: " + this.courseNumber + "\n이수구분: " + this.pass;
    }
    public void  setPass(String pass){
        this.pass = pass;
    }
}

class Major extends Course{
    String major;
    String preCourse;
    public Major(String courseName, String courseNumber, String major, String preCourse){
        super(courseName,courseNumber);
        this.major = major;
        this.preCourse = preCourse;
    }
    public String getMajor(){
        return this.major;
    }
    public String getPreCourse(){
        return this.preCourse;
    }

    @Override
    public String getAllData(){
        return "교과목명: " + this.courseName + "\n교과목 번호: " + this.courseNumber + "\n전공: " + this.major + "\n선수과목: " + this.preCourse;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public void setPreCourse(String preCourse){
        this.preCourse = preCourse;
    }

}

class Elective extends Course{
    public String elective;
    public Elective(String elective, String courseNumber){
        super(elective,courseNumber);
    }

    @Override
    public String getAllData(){
        return "선택 과목:\n" + "교과목명: " + this.courseName + "\n교과목 번호: " + this.courseNumber;
    }



}

public class Driver{
    public static void main(String[] args){

        Course[] courses = new Course[5];

        courses[0] = new Major("자바","CS101","컴퓨터공학","C");
        System.out.println(courses[0].getAllData());

        System.out.println();
        courses[1] = new Major("이산 수학", "CS215", "컴퓨터공학", "없음");
        System.out.println(courses[1].getAllData());

        System.out.println();
        courses[2] = new GenEdu("물리학", "PHS210", "학분기초교양");
        System.out.println(courses[2].getAllData());

        System.out.println();
        courses[3] = new GenEdu("영어 1", "ENG101", "공통교양");
        System.out.println(courses[3].getAllData());

        System.out.println();
        courses[4] = new Elective("테니스", "REC310");
        System.out.println(courses[4].getAllData());
    }
}