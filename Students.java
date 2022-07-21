import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students extends MyFunctions{


    public void enroll() throws IOException {
        clearArrayList();
        reloadCourseData();
        reloadmoduledata();
        reloadStudentdata();

        String StudentId = "";
        String Studentname = "";
        String CourseId = "";
        int level = 0;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Student ID\n-> ");
        StudentId = s.nextLine();

        if(super.StudentID.contains(StudentId)){
            System.out.println("Student Id already exists");
            return;
        }

        System.out.print("Enter your Name\n-> ");
        Studentname = s.nextLine();

        System.out.print("Enter Course ID\n-> ");
        CourseId = s.nextLine();

        if(!super.CourseId.contains(CourseId)){
            System.out.println("Course not found");
            return;
        }

        System.out.print("Enter Level\n-> ");
        level = Integer.parseInt(s.nextLine());

        if(!super.Level.contains(level)){
            System.out.println("Level not found");
            return;
        }

        for(int i = 0; i<super.ModuleID.size(); i++) {

            if (super.isOptional.get(i) && super.Level.get(i) == level && super.Sem.get(i) == 1) {
                super.Sem1optionalmodules.add(super.ModuleID.get(i));
            }

            if (!super.isOptional.get(i) && super.Level.get(i) == level && super.Sem.get(i) == 1) {
                super.Sem1compulsorymodules.add(super.ModuleID.get(i));
            }

            if (super.isOptional.get(i) && super.Level.get(i) == level && super.Sem.get(i) == 2) {
                super.Sem2optionalmodules.add(super.ModuleID.get(i));
            }

            if (!super.isOptional.get(i) && super.Level.get(i) == level && super.Sem.get(i) == 2) {
                super.Sem2compulsorymodules.add(super.ModuleID.get(i));
            }
        }

        for(String sem1compulsorymodules : super.Sem1compulsorymodules) {
            super.yourmodules.add(sem1compulsorymodules);
        }

        for(String sem2compulsorymodules : super.Sem2compulsorymodules){
            super.yourmodules.add(sem2compulsorymodules);
        }

        if(level == 4){
             register(StudentId, Studentname);
        }
        else if(level == 5){
             register(StudentId, Studentname);
        }
        else if(level == 6){
            System.out.println("Choose from Optional Modules for Sem 1");
            System.out.print("| ");
            for(String sem1optionalmodules : super.Sem1optionalmodules) {
                System.out.print(sem1optionalmodules+" | ");
            }

            String OM1 = "";
            String OM2 = "";
            String om1 = "";
            String om2 = "";

            System.out.print("\nEnter your 1st Optional Module's ID\n-> ");
            OM1 = s.nextLine();

            if(!super.Sem1optionalmodules.contains(OM1)){
                System.out.println("Module not found");
                return;
            }

            super.yourmodules.add(OM1);

            super.Sem1optionalmodules.remove(OM1);
            System.out.println("Choose from Optional Modules for Sem 1");
            System.out.print("| ");
            for(String sem1optionalmodules : super.Sem1optionalmodules) {
                System.out.print(sem1optionalmodules+" | ");
            }


            System.out.print("\nEnter your 2nd Optional Modules's ID\n-> ");
            OM2 = s.nextLine();

            if(!super.Sem1optionalmodules.contains(OM2)){
                System.out.println("Module not found");
                return;
            }

            super.yourmodules.add(OM2);

            System.out.println("Choose from Optional Modules for Sem 2");
            System.out.print("| ");
            for(String sem2optionalmodules : super.Sem2optionalmodules) {
                System.out.print(sem2optionalmodules+" | ");
            }

            System.out.print("\nEnter your 1st Optional Module's ID\n-> ");
            om1 = s.nextLine();

            if(!super.Sem2optionalmodules.contains(om1)){
                System.out.println("Module not found");
                return;
            }

            super.yourmodules.add(om1);

            super.Sem2optionalmodules.remove(om1);
            System.out.println("Choose from Optional Modules for Sem 2");
            System.out.print("| ");
            for(String sem2optionalmodules : super.Sem2optionalmodules) {
                System.out.print(sem2optionalmodules+" | ");
            }

            System.out.print("\nEnter your 2nd Optional Module's ID\n-> ");
            om2 = s.nextLine();

            if(!super.Sem2optionalmodules.contains(om2)){
                System.out.println("Module not found");
                return;
            }

            super.yourmodules.add(om2);

            register(StudentId, Studentname);
        }
    }

    public void register(String StudentID, String StudentName) throws IOException {

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Students.txt");
        fr = new FileWriter(myObj, true);

        int currentIndex = 0;
            String line = "";
            line += (StudentID + ",");
            line += (StudentName + "");
            for(int j=0; j<super.yourmodules.size(); j++) {
                line += ",";
                line += super.yourmodules.get(j);
                currentIndex += 1;
            }
            line += "\n";
            fr.write(line);
        fr.close();

    }

    public void checkinstructors(){
        clearArrayList();
        reloadCourseData();
        reloadinstructorData();
        reloadmoduledata();
        reloadStudentdata();

        String StudentId = "";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Student ID\n-> ");
        StudentId = s.nextLine();

        if(!super.StudentID.contains(StudentId)){
            System.out.println("Student Id not found");
            return;
        }

        int index = super.StudentID.indexOf(StudentId);

        for(int i = 0; i<super.StudentModules.get(index).size(); i++){
            String Instructorname = Moduleinstructor(super.StudentModules.get(index).get(i).toString());
            if(Instructorname.length() > 0){
                System.out.println(Instructorname);
            }
        }

    }

    public String Moduleinstructor(String ModuleID){
        clearArrayList();
        reloadCourseData();
        reloadinstructorData();
        reloadStudentdata();
        reloadmoduledata();

        String Instructorname = "";

        for(int i = 0; i<super.InstructorID.size(); i++){
            if(super.InstructorModules.get(i).contains(ModuleID)){
                Instructorname = super.InstructorName.get(i);
                break;
            }
        }
        return Instructorname;
    }

}
