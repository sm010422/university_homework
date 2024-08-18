import java.util.Scanner;

class Student{
    public int studentCode;
    public String studentName;
    Student(int studentCode, String studentName){
        this.studentCode = studentCode;
        this.studentName = studentName;
    }
    public int getStudentCode(){ return this.studentCode; }
    public String getStudentName(){ return this.studentName; }
}

class ClassRoll{
    public String subject;
    public int currentStudent = 0;
    public int maxStudent;

    Student[] students;
    ClassRoll(String subject){
        this.subject = subject;
        this.maxStudent = 30;
        students = new Student[maxStudent];

    }

public void addStudent(Student st) {
    if (currentStudent == maxStudent) {
        System.out.println("출석부의 크기 부족으로 추가할 수 없습니다");
    } else {
        int i;

        for (i = currentStudent - 1; i >= 0 && students[i].studentCode > st.studentCode; i--) {
            students[i + 1] = students[i];
        }
        students[i + 1] = st;
        currentStudent++;
    }
}

    public int findIndex(int studentCode){
        for(int i = 0; i < maxStudent; i++){
            if(students[i].studentCode == studentCode){
                return i;
            }
        }
        return -1;
    }
    public void deleteStudent(int studentCode) {
        int index = findIndex(studentCode);
        if (index != -1) {

            for (int i = index; i < currentStudent - 1; i++) {
                students[i] = students[i + 1];
            }
            students[currentStudent - 1] = null;
            currentStudent--;
        } else {
            System.out.println("주어진 학생이 출석부에 없어 삭제할 수 없습니다");
        }
    }

    public String findName(int studentCode){
        if(findIndex(studentCode) != -1){
            return students[findIndex(studentCode)].studentName;
        }else{
            System.out.println("주어진 학생이 출석부에 없습니다");
            return null;
        }
    }

    public void printAllData(){
        System.out.println("\n출석부");
        System.out.println("\n교과목명= " + subject);
        System.out.println("\n학번   이름");
        for(int i = 0; i < currentStudent; i++){
            System.out.println(students[i].studentCode + " " + students[i].studentName);
        }
        System.out.println();
    }

}

public class Driver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("교과목명을 입력하세요= ");
        ClassRoll classRoll = new ClassRoll(scan.next());
        while(true){
            System.out.println("원하는 연산을 선택하세요=");
            System.out.println("<1> 추가\n<2> 삭제\n<3> 찾기\n<4> 출력\n<5> 종료");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.print("추가하는 학생의 학번을 입력하세요= ");
                    int stCode = scan.nextInt();
                    System.out.print("추가하는 학생의 이름을 입력하세요= ");
                    String stName = scan.next();
                    Student st = new Student(stCode,stName);
                    classRoll.addStudent(st);

                    classRoll.printAllData();
                    break;
                case 2:
                    System.out.print("삭제하는 학생의 학번을 입력하세요= ");
                    int deleteStCode = scan.nextInt();
                    classRoll.deleteStudent(deleteStCode);

                    classRoll.printAllData();
                    break;
                case 3:
                    System.out.print("찾는 학생의 학번을 입력하세요= ");
                    int findStCode = scan.nextInt();
                    System.out.println("학생이름= " + classRoll.findName(findStCode));
                    break;
                case 4:
                    classRoll.printAllData();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");



            }
        }


    }

}