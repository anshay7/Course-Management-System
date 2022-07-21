import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Instructor extends MyFunctions{

    public void checkmodules(){
        clearArrayList();
        reloadmoduledata();
        reloadinstructorData();

        String InstructorID = "";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Instructor ID\n-> ");
        InstructorID = s.nextLine();

        if(!super.InstructorID.contains(InstructorID)){

            System.out.println("Instructor ID not found");
        }

        else{
            int index = super.InstructorID.indexOf(InstructorID);
            for(int i = 0 ; i < super.InstructorModules.get(index).size(); i++){
                System.out.println(super.InstructorModules.get(index).get(i));
            }
        }
    }

    public void checkstudents(){
        clearArrayList();
        reloadmoduledata();
        reloadinstructorData();
        reloadStudentdata();

        String InstructorId = "";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Instructor ID\n-> ");
        InstructorId = s.nextLine();

        if(!super.InstructorID.contains(InstructorId)){

            System.out.println("Instructor ID not found");
            return;
        }

        int index = super.InstructorID.indexOf(InstructorId);
        for(int i = 0 ; i < super.InstructorModules.get(index).size(); i++){
            for(int j = 0 ; j < super.StudentID.size(); j++){
                for(int k = 0 ; k < super.StudentModules.size(); k++){
                    if(StudentModules.get(j).contains(super.InstructorModules.get(index).get(i))){
                        System.out.println(super.InstructorModules.get(index).get(i)+" >> "+super.StudentID.get(j)+" "+StudentName.get(j));
                        break;
                    }
                }
            }
        }

    }

    public void addmarks() throws IOException {
        clearArrayList();
        reloadinstructorData();
        reloadStudentdata();
        reloadmoduledata();
        reloadMarks();

        String ModuleId = "";
        String InstructorID = "";
        int FullMarks = 0;
        int PassMarks = 0;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Instructor ID\n-> ");
        InstructorID = s.nextLine();

        if(!super.InstructorID.contains(InstructorID)){

            System.out.println("Instructor ID not found");
            return;
        }


        System.out.print("Enter your Module ID\n-> ");
        ModuleId = s.nextLine();

        int index = super.InstructorID.indexOf(InstructorID);


        if(!super.InstructorModules.get(index).contains(ModuleId)){

            System.out.println("You are not assigned to this module");
            return;
        }

        if(super.InstructorModules.get(index).contains(ModuleId)){
            System.out.print("Enter the Module's Full Marks\n-> ");
            FullMarks = Integer.parseInt(s.nextLine());

            System.out.print("Enter the Module's Pass Marks\n-> ");
            PassMarks = Integer.parseInt(s.nextLine());

            int index2 = super.ModuleID.indexOf(ModuleId);
            super.FullMarks.set(index2, FullMarks);
            super.PassMarks.set(index2, PassMarks);

        }

        FileWriter fr;
        File myObj;
        myObj = new File(Path+"ModuleMarks.txt");
        fr = new FileWriter(myObj);

        for(int i = 0 ; i < super.ModuleID.size(); i++){
            fr.write(super.ModuleID.get(i)+","+super.FullMarks.get(i)+","+super.PassMarks.get(i)+"\n");
        }

        fr.close();
    }

}
