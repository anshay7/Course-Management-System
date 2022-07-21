import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CourseAdministrator extends MyFunctions {
    public void addcourse() throws IOException {
        boolean State = false;
        String CourseID ="";
        String CourseName ="";
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Course ID\n-> ");
        CourseID = s.nextLine();
        System.out.print("Enter Course Name\n-> ");
        CourseName = s.nextLine();

        for (int level = 4; level < 6; level++) {
            for (int sem = 1; sem < 3; sem++) {
                for (int module = 1; module < 5; module++) {
                    System.out.print("Enter Level "+level+" Sem "+sem+" Module ID "+module+"\n-> ");
                    ModuleID.add(s.nextLine());
                    System.out.print("Enter Level "+level+" Sem "+sem+" Module Name "+module+"\n-> ");
                    ModuleName.add(s.nextLine());
                    Level.add(level);
                    Sem.add(sem);
                    isOptional.add(false);
                    FullMarks.add(100);
                    PassMarks.add(40);
                }
            }
        }

            for (int module = 1; module < 3; module++) {
                System.out.print("Enter Level 6 Sem 1 Compulsory Module ID "+module+"\n-> ");
                ModuleID.add(s.nextLine());
                System.out.print("Enter Level 6 Sem 1 Compulsory Module Name "+module+"\n-> ");
                ModuleName.add(s.nextLine());
                Level.add(6);
                Sem.add(1);
                isOptional.add(false);
                FullMarks.add(100);
                PassMarks.add(40);
            }

            for (int module = 1; module < 4; module++) {
                System.out.print("Enter Level 6 Sem 1 Optional Module ID " + module+"\n-> ");
                ModuleID.add(s.nextLine());
                System.out.print("Enter Level 6 Sem 1 Optional Module Name " + module+"\n-> ");
                ModuleName.add(s.nextLine());
                Level.add(6);
                Sem.add(1);
                isOptional.add(true);
                FullMarks.add(100);
                PassMarks.add(40);
            }

            for (int module = 1; module < 3; module++) {
            System.out.print("Enter Level 6 Sem 2 Compulsory Module ID "+module+"\n-> ");
            ModuleID.add(s.nextLine());
            System.out.print("Enter Level 6 Sem 2 Compulsory Module Name "+module+"\n-> ");
            ModuleName.add(s.nextLine());
            Level.add(6);
            Sem.add(2);
            isOptional.add(false);
            FullMarks.add(100);
            PassMarks.add(40);
        }

        for (int module = 1; module < 4; module++) {
            System.out.print("Enter Level 6 Sem 2 Optional Module ID " +module+"\n-> ");
            ModuleID.add(s.nextLine());
            System.out.print("Enter Level 6 Sem 2 Optional Module Name " +module+"\n-> ");
            ModuleName.add(s.nextLine());
            Level.add(6);
            Sem.add(2);
            isOptional.add(true);
            FullMarks.add(100);
            PassMarks.add(40);
        }


           FileWriter fr;
           FileWriter fr1;
           FileWriter fr2;
           File myObj;
           File myObj1;
           File myObj2;
                myObj = new File(Path+"Courses.txt");
                myObj1 = new File(Path+"Modules.txt");
                myObj2 = new File(Path+"ModuleMarks.txt");
                fr = new FileWriter(myObj, true);
                fr1 = new FileWriter(myObj1, true);
                fr2 = new FileWriter(myObj2, true);

                if(myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }

        fr.write(CourseID+","+CourseName+","+State+"\n");
        for (int i = 0; i < ModuleID.size(); i++) {
            fr1.write(CourseID+","+ModuleID.get(i)+","+ModuleName.get(i)+","+Level.get(i)+","+Sem.get(i)+","+isOptional.get(i)+"\n");

            fr2.write(super.ModuleID.get(i)+","+super.FullMarks.get(i)+","+super.PassMarks.get(i)+"\n");
        }

        fr.close();
        fr1.close();
        fr2.close();

        }


    public void cancelcourse() throws IOException {
        clearArrayList();
        reloadCourseData();
            Scanner s = new Scanner(System.in);
            String Cancel = "";
            System.out.print("Enter Course ID\n-> ");
            Cancel = s.nextLine();


        if(!super.CourseId.contains(Cancel)){

            System.out.println("Course ID mismatched");
            return;
        }

            int index = CourseId.indexOf(Cancel);
            isCancel.set(index, true);


            FileWriter fr;
            File myObj;
            myObj = new File(Path+"Courses.txt");
            myObj.delete();
            myObj = new File(Path+"Courses.txt");
            fr = new FileWriter(myObj, true);

            for (int i = 0; i < CourseId.size(); i++) {
                fr.write(CourseId.get(i)+","+Coursename.get(i)+","+isCancel.get(i)+"\n");

            }
            fr.close();
        }

    public void renameCourse() throws IOException {
        clearArrayList();
        reloadCourseData();
        Scanner s = new Scanner(System.in);
        String Rename = "";
        String RenameID = "";
        System.out.print("Enter Course ID\n-> ");
        RenameID = s.nextLine();

        if(!super.CourseId.contains(RenameID)){

            System.out.println("Course ID mismatched");
            return;
        }

        System.out.print("Enter new course name\n-> ");
        Rename = s.nextLine();


        int index = CourseId.indexOf(RenameID);
        Coursename.set(index, Rename);


        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Courses.txt");
        myObj.delete();
        myObj = new File(Path+"Courses.txt");
        fr = new FileWriter(myObj, true);

        for (int i = 0; i < CourseId.size(); i++) {
            fr.write(CourseId.get(i)+","+Coursename.get(i)+","+isCancel.get(i)+"\n");

        }
        fr.close();
    }

    public void renameModule() throws IOException {
        clearArrayList();
        reloadmoduledata();
        reloadCourseData();

        Scanner s = new Scanner(System.in);
        String Rename = "";
        String RenameModuleID = "";
        String RenameCourseID = "";
        System.out.print("Enter Course ID\n-> ");
        RenameCourseID = s.nextLine();

        if(!super.CourseId.contains(RenameCourseID)){

            System.out.println("Course ID mismatched");
            return;
        }

        System.out.print("Enter the Module ID of the module you want to rename\n-> ");
        RenameModuleID = s.nextLine();

        if(!super.ModuleID.contains(RenameModuleID)){

            System.out.println("Module ID mismatched");
            return;
        }

        System.out.print("Enter new Module Name\n-> ");
        Rename = s.nextLine();

        int index = ModuleID.indexOf(RenameModuleID);
        ModuleName.set(index, Rename);

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Modules.txt");
        myObj.delete();

        myObj = new File(Path+"Modules.txt");

        fr = new FileWriter(myObj);

        for (int i = 0; i < ModuleID.size(); i++) {
            fr.write(ModuleCourseId.get(i)+","+ModuleID.get(i)+","+ModuleName.get(i)+","+Level.get(i)+","+Sem.get(i)+","+isOptional.get(i)+"\n");
        }
        fr.close();
    }

    public void addmodule() throws IOException {
        clearArrayList();
        reloadmoduledata();
        reloadCourseData();

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Modules.txt");

        String CourseId = "";
        int level = 0;
        int sem = 0;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter Course ID\n-> ");
        CourseId = s.nextLine();

        if(!super.CourseId.contains(CourseId)){

            System.out.println("Course ID mismatched");
            return;
        }

        super.ModuleCourseId.add(CourseId);

        System.out.print("Enter New Module ID\n-> ");
        ModuleID.add(s.nextLine());

        System.out.print("Enter New Module Name\n-> ");
        ModuleName.add(s.nextLine());

        System.out.print("Enter Level\n-> ");
        level = Integer.parseInt(s.nextLine());

        if(!super.Level.contains(level)){

            System.out.println("Level not found");
            return;
        }

        super.Level.add(level);

        System.out.print("Enter Sem\n-> ");
        sem = Integer.parseInt(s.nextLine());

        if(!super.Sem.contains(sem)){

            System.out.println("Sem not found");
            return;
        }

        super.Sem.add(sem);

        System.out.print("Enter true if module is optional else false\n-> ");
        isOptional.add(Boolean.parseBoolean((s.nextLine())));

        fr = new FileWriter(myObj);
        for (int i = 0; i < ModuleID.size(); i++) {
            fr.write(super.ModuleCourseId.get(i)+","+ModuleID.get(i)+","+ModuleName.get(i)+","+Level.get(i)+","+Sem.get(i)+","+isOptional.get(i)+"\n");

        }
        fr.close();
    }

    public void deletecourse() throws IOException {
        clearArrayList();
        reloadCourseData();
        reloadmoduledata();

        Scanner s = new Scanner(System.in);
        String delete = "";
        System.out.print("Enter Course ID\n-> ");
        delete = s.nextLine();

        if(!super.CourseId.contains(delete)){

            System.out.println("Course ID mismatched");
            return;
        }

        FileWriter fr;
        FileWriter fr1;
        File myObj;
        File myObj1;
        myObj = new File(Path+"Courses.txt");
        myObj1 = new File(Path+"Modules.txt");
        fr = new FileWriter(myObj);
        fr1 = new FileWriter(myObj1);

        for (int i = 0; i < CourseId.size(); i++) {
            if(!CourseId.get(i).equals(delete)) {
                fr.write(CourseId.get(i) + "," + Coursename.get(i) + "," + isCancel.get(i) + "\n");
            }
        }

        for (int i = 0; i < ModuleID.size(); i++) {
            if(!ModuleCourseId.get(i).equals(delete)) {
                fr1.write(ModuleCourseId.get(i)+","+ModuleID.get(i)+","+ModuleName.get(i)+","+Level.get(i)+","+Sem.get(i)+","+isOptional.get(i)+"\n");
            }
        }

        fr.close();
        fr1.close();

    }

    public void addinstructor() throws IOException {
        clearArrayList();
        reloadCourseData();
        reloadmoduledata();
        reloadinstructorData();

        String InstructorID ="";
        String InstructorName ="";
        String ModuleID ="";


        Scanner s = new Scanner(System.in);
        System.out.print("Enter Instructor ID\n-> ");
        InstructorID = s.nextLine();
        if(!super.InstructorID.contains(InstructorID)){
            System.out.print("Enter Instructor Name\n-> ");
            InstructorName = s.nextLine();
        }

        System.out.print("Assign Module(Enter Module ID) for the instructor\n-> ");
        ModuleID = s.nextLine();
        int InsIndex = super.InstructorID.indexOf(InstructorID);


        if(!super.ModuleID.contains(ModuleID)){
            System.out.println("Module not Found");
        }

        else {
            if(super.InstructorID.contains(InstructorID)){
                super.InstructorModules.get(InsIndex).add(ModuleID);
            }
            else {
                super.InstructorID.add(InstructorID);
                super.InstructorName.add(InstructorName);
                ArrayList<String> m =new ArrayList<>();
                m.add(ModuleID);
                super.InstructorModules.add(m);
            }
        }

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Instructors.txt");
        fr = new FileWriter(myObj);

        int currentIndex = 0;
        for(int i=0; i<super.InstructorID.size(); i++) {
            String line = "";
            line += (super.InstructorID.get(i) + ",");
            line += (super.InstructorName.get(i) + "");
            for(int j=0; j<super.InstructorModules.get(i).size(); j++) {
                line += ",";
                line += super.InstructorModules.get(i).get(j);
                currentIndex += 1;
            }
            line += "\n";
            fr.write(line);
        }
        fr.close();
    }

    public void removeinstructor() throws IOException {
        clearArrayList();
        reloadCourseData();
        reloadinstructorData();
        reloadmoduledata();

        String InstructorID = "";
        String ModuleID = "";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter Instructor ID\n-> ");
        InstructorID = s.nextLine();

        if(!super.InstructorID.contains(InstructorID)){
            System.out.println("Instructor ID mismatched");
            return;
        }

        int InsIndex = super.InstructorID.indexOf(InstructorID);

        System.out.print("Enter Module ID\n-> ");
        ModuleID = s.nextLine();


        if(!super.InstructorModules.get(InsIndex).contains(ModuleID)){

            System.out.println("Instructor is not assigned to this module");
            return;
        }

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Instructors.txt");
        fr = new FileWriter(myObj);

        for(int i=0; i<super.InstructorID.size(); i++) {
            String line = "";
            line += (super.InstructorID.get(i) + ",");
            line += (super.InstructorName.get(i) + "");
                for(int j=0; j<super.InstructorModules.get(i).size(); j++) {
                    if(!super.InstructorModules.get(i).get(j).equals(ModuleID)){
                        line += ",";
                        line += (super.InstructorModules.get(i).get(j));
                    }
                }

            line += "\n";
            fr.write(line);
        }
        fr.close();
    }

    public void generateresult() throws IOException {
        clearArrayList();
        reloadCourseData();
        reloadmoduledata();
        reloadinstructorData();
        reloadStudentdata();
        reloadMarks();
        reloadMarksheet();

        String StudentId = "";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Student ID\n-> ");
        StudentId = s.nextLine();

        if(!super.StudentID.contains(StudentId)){
            System.out.println("Student Id not found");
            return;
        }

        int index = super.StudentID.indexOf(StudentId);

        String line = StudentId;
        String Marks = "";
        int marks = 0;
        int marksgained = 0;
        int totalmarks = 0;
        String Grade = "";
        int totalmodules = super.StudentModules.get(index).size();

        for(int i = 0; i < super.StudentModules.get(index).size(); i++){
            try{
                System.out.println("Enter Marks on "+super.StudentModules.get(index).get(i));
                marks = Integer.parseInt(s.nextLine());
                marksgained += marks;
                totalmarks += super.FullMarks.get(super.ModuleID.indexOf(StudentModules.get(index).get(i)));

            }
            catch (NumberFormatException err){
                System.out.println("You can only enter integer");
                return;
            }

            Marks = Marks+","+marks;
        }

        boolean resit = false;
        System.out.print("Resit true or false\n-> ");
        resit = s.nextBoolean();


        Grade = findGrade(((marksgained * 100f)/totalmarks));

        line += ","+resit;
        line += ","+Grade;
        line += Marks;

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"Marksheet.txt");
        fr = new FileWriter(myObj);
        int index1 = StudentMarksheetID.indexOf(StudentId);

        if(!(index1 == -1)){
            super.StudentMarksheetID.remove(StudentId);
            super.Resit.remove(index1);
            super.Grade.remove(index1);
            super.StudentModuleMarks.remove(index1);
        }

        for(int i = 0; i < super.StudentMarksheetID.size(); i++){
            String line1 = "";
            line1 += super.StudentMarksheetID.get(i);
            line1 += ","+super.Resit.get(i);
            line1 += ","+super.Grade.get(i);

            for(int j = 0; j < super.StudentModuleMarks.get(i).size(); j++){
                line1 += ","+super.StudentModuleMarks.get(i).get(j);
            }
            line1 += "\n";
            fr.write(line1);
        }
        fr.write(line+"\n");

        fr.close();

    }

    public String findGrade(float mark) {
        String Grade = "E";

        if (mark > 90 && mark < 101) {
            Grade = "A+";
        } else if (mark > 80 & mark < 91) {
            Grade = "A";
        } else if (mark > 70 & mark < 81) {
            Grade = "B+";
        } else if (mark > 60 & mark < 71) {
            Grade = "B";
        } else if (mark > 50 & mark < 61) {
            Grade = "C+";
        } else if (mark > 40 & mark < 51) {
            Grade = "C";
        } else if (mark > 30 & mark < 41) {
            Grade = "D+";
        } else if (mark > 20 & mark < 31) {
            Grade = "D";
        } else {
            Grade = "E";
        }
        return Grade;
    }

}
