import java.util.Scanner;

class Course{
    static int countObject;
    public String sbName;
    public int maxPeople;
    public int people;
    public int grade;

    public Course(String sbName, int maxPeople, int grade){
        this.sbName = sbName;
        this.maxPeople = maxPeople;
        this.grade = grade;
        this.people = 0;
        countObject++;
    }
    public String getSbName(){
        return sbName;
    }
    public  int getMaxPeople(){
        return maxPeople;
    }
    public int getPeople(){
        return people;
    }
    public int getGrade(){
        return grade;
    }
    public int getCountObject(){
        return countObject;
    }

    public String returnData(){
        return sbName + "     " + maxPeople + "           " + people;
    }
    public void setSbName(String sbName){
        this.sbName = sbName;
    }
    public void setMaxPeople(int maxPeople){
        this.maxPeople = maxPeople;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public void increaseMaxPeople(int maxPeople){
        this.maxPeople += maxPeople;
    }

}

class Student{
    private int studentCode;
    public String stName;
    public int appliCredit;
    public int maxAppliCredit;

    public Student(int studentCode, String stName, int maxAppliCredit){
        this.studentCode = studentCode;
        this.stName = stName;
        this.maxAppliCredit = maxAppliCredit;
        this.appliCredit = 0;
    }
    public String getStName(){
        return stName;
    }
    public int getStudentCode(){
        return studentCode;
    }
    public int getMaxAppliCredit(){
        return maxAppliCredit;
    }
    public int getAppliCredit(){
        return appliCredit;
    }
    public String returnStData(){
        return studentCode + "    " + stName + "    " + appliCredit; //학번 이름 신청 학점수 한꺼번에 문자열의 형태로 반환
    }
    public void setStudentCode(int studentCode){
        this.studentCode = studentCode;
    }
    public void setStName(String stName){
        this.stName = stName;
    }
    public void setMaxAppliCredit(int maxAppliCredit){
        this.maxAppliCredit = maxAppliCredit;
    }

}

class Register{
    Student student;
    Course course;
    public Register(Student student, Course course){
        this.student = student;
        this.course = course;

        if(course.people < course.maxPeople){
            course.people++;
        }else{
            System.out.println("정원이 차서 수강 신청할 수 없다.");
        }
        if(student.appliCredit + course.grade <= student.maxAppliCredit){
            student.appliCredit += course.grade;
        }else {
            System.out.println("학점 초과로 수강 신청할 수 없다.");
        }

    }

    public String returndata(){
        return student.getStName() + ": " + course.getSbName() + " 수강 신청";
    }

}

public class Driver {
    public static void main(String[] args){
        Course course1 = new Course("알고리즘",30,4);
        Course course2 = new Course("자료구조",25,3);

        System.out.println("수강 신청전");
        System.out.println();
        System.out.println("교과목명     최대 학생수     현재 학생수");
        System.out.println(course1.returnData());
        System.out.println(course2.returnData());

        course1.increaseMaxPeople(6);
        course2.increaseMaxPeople(3);
        System.out.println("\n수강 인원 증원후\n");

        System.out.println("교과목명     최대 학생수     현재 학생수");
        System.out.println(course1.returnData());
        System.out.println(course2.returnData());

        System.out.println("\n생성된 교과목들의 수: "+ course1.getCountObject() +"\n");

        Student student1 = new Student(2101,"선남",18);
        Student student2 = new Student(2102,"선녀",21);
        Student student3 = new Student(2103,"길동",18);

        System.out.println("학번     이름    신청 학점수");
        System.out.println(student1.returnStData());
        System.out.println(student2.returnStData());
        System.out.println(student3.returnStData());

        Register register1 = new Register(student1,course1);
        Register register2 = new Register(student2,course1);
        Register register3 = new Register(student2,course2);
        Register register4 = new Register(student3,course1);
        Register register5 = new Register(student3,course2);

        System.out.println();
        System.out.println(register1.returndata());
        System.out.println(register2.returndata());
        System.out.println(register3.returndata());
        System.out.println(register4.returndata());
        System.out.println(register5.returndata());

        System.out.println("\n수강신청후\n");

        System.out.println("교과목명     최대 학생수     현재 학생수");
        System.out.println(course1.returnData());
        System.out.println(course2.returnData());

        System.out.println("\n학번     이름    학점수");
        System.out.println(student1.returnStData());
        System.out.println(student2.returnStData());
        System.out.println(student3.returnStData());


    }
}
