import java.util.*;

public class StudentEnrollment {

    private Set<String> M = new HashSet<>();
    private Set<String> CS = new HashSet<>();
    private Set<String> P = new HashSet<>();

    public StudentEnrollment(){
        // Initializing the sets with predefinded students
        M.add("Bob");
        M.add("Charlie");
        M.add("David");

        CS.add("Alice");
        CS.add("Eve");
        CS.add("Frank");
        CS.add("Soo");

        P.add("Alice");
        P.add("Charlie");
        P.add("David");
        P.add("Eve");
        P.add("Gold");
    }

    public void displayStudents(){
        System.out.println("Math Students: " + M);
        System.out.println("Computer Science Students: " + CS);
        System.out.println("Physics Students: " + P);
    }

    public void addStudents(String course, String name){
        switch(course){
            case "M":
                M.add(name);
                System.out.println("Student Added.");
                break;
            case "CS":
                CS.add(name);
                System.out.println("Student Added.");
                break;
            case "P":
                P.add(name);
                System.out.println("Student Added.");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void evaluatePredicates(){
        evaluatePredicate1();
        evaluatePredicate2();
        System.out.println("Evaluation complete. All predicates have been processed.");
    }

    public void evaluatePredicate1(){
        Set<String> notInMath = new HashSet<>();
        for(String student : P){
            if(!M.contains(student)){
                notInMath.add(student);
            }
        }

        if(notInMath.isEmpty()){
            System.out.println("Predicate 1: For all students enrolled in Physics, they are also enrolled in Math.");
            System.out.println("Truth Value: True");
        }
        else{
            System.out.println("Predicate 1: For all students enrolled in Physics, they are also enrolled in Math.");
            System.out.println("Truth Value: False");
            System.out.println("Action: Added " + notInMath + " to Math set");
            M.addAll(notInMath);
        }
    }

    public void evaluatePredicate2(){
        Set<String> intersection = new HashSet<>(M);
        intersection.retainAll(CS);

        if(intersection.isEmpty()){
            System.out.println("Predicate 2: There does not exist a student enrolled in both Math and Computer Science.");
            System.out.println("Truth Value: True");
        }
        else{
            System.out.println("Predicate 2: There does not exist a student enrolled in both Math and Computer Science.");
            System.out.println("Truth Value: False");
            System.out.println("Action: Removed " + intersection + "from Computer Science set");
            CS.removeAll(intersection);
        }
    }

    private void menu(){
        Scanner scnr = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Menu: ");
            System.out.println("1. View Students");
            System.out.println("2. Add Students");
            System.out.println("3. Evaluate Predicates");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            try{
                choice = scnr.nextInt();
                scnr.nextLine();
                switch (choice) {
                    case 1:
                        displayStudents();
                        break;
                    case 2:
                        System.out.print("Enter Course (M, CS, P): ");
                        String course = scnr.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = scnr.nextLine();

                        addStudents(course, name);
                        break;
                    case 3:
                        evaluatePredicates();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid Choice. Please try again");
                        
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input. Please try again.");
                scnr.next();    // Clear invalid input
                choice = 0;     // Reset choice to continue loop
            }
        } while(choice != 4);

        scnr.close();
    }

    public static void main(String[] args) {
        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.menu();
    }
}