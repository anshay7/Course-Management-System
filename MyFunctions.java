import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFunctions {
    public ArrayList<String> ModuleCourse = new ArrayList<>();
    public ArrayList<String> ModuleName = new ArrayList<>();
    public ArrayList<String> ModuleID = new ArrayList<>();
    public ArrayList<Boolean> isOptional = new ArrayList<>();
    public ArrayList<Integer> Sem = new ArrayList<>();
    public ArrayList<Integer> Level = new ArrayList<>();
    public ArrayList<Integer> FullMarks = new ArrayList<>();
    public ArrayList<Integer> PassMarks = new ArrayList<>();
    public ArrayList<String> CourseId = new ArrayList<>();
    public ArrayList<String> Coursename = new ArrayList<>();
    public ArrayList<Boolean> isCancel = new ArrayList<>();
    public ArrayList<String> ModuleCourseId = new ArrayList<>();
    public ArrayList<String> InstructorID = new ArrayList<>();
    public ArrayList<String> InstructorName = new ArrayList<>();
    public ArrayList<ArrayList> InstructorModules = new ArrayList<>();
    public String Path = new File("src").getAbsolutePath() +"\\"+"TextFiles"+"\\";
    public ArrayList<String> StudentID = new ArrayList<>();
    public ArrayList<String> StudentName = new ArrayList<>();
    public ArrayList<ArrayList> StudentModules = new ArrayList<>();
    public ArrayList<String> StudentMarksheetID = new ArrayList<>();
    public ArrayList<ArrayList> StudentModuleMarks = new ArrayList<>();
    public ArrayList<Boolean> Resit = new ArrayList<>();
    public ArrayList<String> Grade = new ArrayList<>();
    public ArrayList<String> Sem1compulsorymodules = new ArrayList<>();
    public ArrayList<String> Sem2compulsorymodules = new ArrayList<>();
    public ArrayList<String> Sem1optionalmodules = new ArrayList<>();
    public ArrayList<String> Sem2optionalmodules = new ArrayList<>();
    public ArrayList<String> yourmodules = new ArrayList<>();

    public void reloadinstructorData() {
        try {
            File myObj = new File(Path+"Instructors.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() >2) {
                    this.InstructorID.add(data.split(",")[0].trim());
                    this.InstructorName.add(data.split(",")[1].trim());

                    ArrayList<String> mod = new ArrayList<String>();

                    for(int i=2; i<data.split(",").length; i++) {
                        mod.add(data.split(",")[i].trim());
                    }
                    this.InstructorModules.add(mod);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void clearArrayList(){
        this.ModuleCourse.clear();
        this.ModuleName.clear();
        this.ModuleID.clear();
        this.isOptional.clear();
        this.Sem.clear();
        this.Level.clear();
        this.FullMarks.clear();
        this.PassMarks.clear();
        this.CourseId.clear();
        this.Coursename.clear();
        this.StudentID.clear();
        this.StudentName.clear();
        this.isCancel.clear();
        this.ModuleCourseId.clear();
        this.StudentModules.clear();
        this.InstructorID.clear();
        this.InstructorName.clear();
        this.InstructorModules.clear();
        this.Sem1compulsorymodules.clear();
        this.Sem2compulsorymodules.clear();
        this.Sem1optionalmodules.clear();
        this.Sem2optionalmodules.clear();
        this.yourmodules.clear();
        this.StudentModuleMarks.clear();
        this.Resit.clear();
        this.Grade.clear();
        this.StudentMarksheetID.clear();
    }


    public void reloadmoduledata() {
        File myObj;

        myObj = new File(Path+"Modules.txt");

        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                this.ModuleCourseId.add(data.split(",")[0]);
                this.ModuleID.add(data.split(",")[1]);
                this.ModuleName.add(data.split(",")[2]);
                this.Level.add(Integer.parseInt(data.split(",")[3]));
                this.Sem.add(Integer.parseInt(data.split(",")[4]));
                this.isOptional.add(Boolean.parseBoolean(data.split(",")[5]));
            }
            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public void reloadCourseData() {

        try {
            File myObj = new File(Path+"Courses.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                this.CourseId.add(data.split(",")[0]);
                this.Coursename.add(data.split(",")[1]);
                this.isCancel.add(Boolean.parseBoolean(data.split(",")[2]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void reloadStudentdata() {
        try {
            File myObj = new File(Path+"Students.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                    this.StudentID.add(data.split(",")[0].trim());
                    this.StudentName.add(data.split(",")[1].trim());

                    ArrayList<String> mod = new ArrayList<String>();

                    for(int i=2; i<data.split(",").length; i++) {
                        mod.add(data.split(",")[i].trim());
                    }

                    this.StudentModules.add(mod);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void reloadMarks(){

        try {
            File myObj = new File(Path+"ModuleMarks.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                    this.FullMarks.add(Integer.parseInt(data.split(",")[1].trim()));
                    this.PassMarks.add(Integer.parseInt(data.split(",")[2].trim()));
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void reloadMarksheet(){

        try {
            File myObj = new File(Path+"Marksheet.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() >2) {
                    this.StudentMarksheetID.add(data.split(",")[0].trim());
                    this.Resit.add(Boolean.parseBoolean(data.split(",")[1].trim()));
                    this.Grade.add(data.split(",")[2].trim());

                    ArrayList<String> mod = new ArrayList<String>();

                    for(int i=3; i<data.split(",").length; i++) {
                        mod.add(data.split(",")[i].trim());
                    }
                    this.StudentModuleMarks.add(mod);
                }

            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

