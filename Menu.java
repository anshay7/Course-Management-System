import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void MainMenu() throws IOException {

        int choice = 0;

        System.out.println("    Log In As");

        Scanner s = new Scanner(System.in);
        System.out.println("1 - As A Course Administrator");
        System.out.println("2 - As A Instructor");
        System.out.println("3 - As A Student");
        System.out.print("  -> ");
        choice = Integer.parseInt(s.nextLine());

        switch (choice) {
            case 1:
                CourseAdministratorMenu();
                break;
            case 2:
                InstructorMenu();
                break;
            case 3:
                StudentMenu();
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    public void CourseAdministratorMenu() throws IOException {

        CourseAdministrator C = new CourseAdministrator();

        int choice = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("    Choose your Choice");
        System.out.println("1 - Add Course");
        System.out.println("2 - Rename Course");
        System.out.println("3 - Cancel Course");
        System.out.println("4 - Delete Course");
        System.out.println("5 - Add Module");
        System.out.println("6 - Rename Module");
        System.out.println("7 - Add Instructor");
        System.out.println("8 - Remove Instructor");
        System.out.println("9 - Generate Result");
        System.out.print("  -> ");

        choice = Integer.parseInt(s.nextLine());

        switch (choice) {
            case 1:
                C.addcourse();
                break;
            case 2:
                C.renameCourse();
                break;
            case 3:
                C.cancelcourse();
                break;
            case 4:
                C.deletecourse();
                break;
            case 5:
                C.addmodule();
                break;
            case 6:
                C.renameModule();
                break;
            case 7:
                C.addinstructor();
                break;
            case 8:
                C.removeinstructor();
                break;
            case 9:
                C.generateresult();
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    public void InstructorMenu() throws IOException {

        Instructor C = new Instructor();

        int choice = 0;

        System.out.println("    Choose your Choice");
        Scanner s = new Scanner(System.in);
        System.out.println("1 - Check Modules");
        System.out.println("2 - Check Students");
        System.out.println("3 - Add Marks");
        System.out.print("  -> ");

        choice = Integer.parseInt(s.nextLine());

        switch (choice) {
            case 1:
                C.checkmodules();
                break;
            case 2:
                C.checkstudents();
                break;
            case 3:
                C.addmarks();
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    public void StudentMenu() throws IOException {

        Students C = new Students();

        int choice = 0;

        System.out.println("    Choose your Choice");
        Scanner s = new Scanner(System.in);
        System.out.println("1 - Choose Course and Enroll");
        System.out.println("2 - Check Instructors");
        System.out.print("  -> ");

        choice = Integer.parseInt(s.nextLine());

        switch (choice) {
            case 1:
                C.enroll();
                break;
            case 2:
                C.checkinstructors();
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    public static void main(String[] args) throws IOException {

        Menu C = new Menu();
        C.MainMenu();

    }

}
