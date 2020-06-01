import java.util.Scanner;

public class EmployFast {
    public EmployFast() {
    }

    private void createSelectionCriteriaView(){
        System.out.print("Shuttle selected"
        + "\nPress 1 to acquire the employment requirements"
        + "\nPress 2 to create selection criteria"
        + "\nPress 0 to back to change a shuttle");
        int select = valueSelect(0,1);
        if(select == 2){
            System.out.print('\u000C');
            Mission mission = new Mission();
            criteriaMenu(mission.getSelectionCriteria());
        }
    }

    private void criteriaMenu(SelectionCriteria s){
        System.out.print("Shuttle selected"
                + "\nPress 1 for range of age"
                + "\nPress 2 for qualification"
                + "\nPress 3 for years of work experience"
                + "\nPress 4 for occupations"
                + "\nPress 5 for health records"
                + "\nPress 6 for criminal records"
                + "\nPress 7 to add computer skills"
                + "\nPress 8 to add languages spoken"
                + "\nPress 9 to view criteria created"
                + "\nPress 0 to back");
        int select = valueSelect(0,9);
        if (select == 0){
            createSelectionCriteriaView();
        }
        else if (0 <= select & select <= 9){
            criteriaEditMenu(select,s);
        }
        else if (select == 9){
            System.out.println("range of age: " + s.getMinimumAge() + "-" + s.getMaximumAge());
            System.out.println("qualification: " + createQuaStr(s));
            System.out.println("years of work experience: " + createWorExp(s));
            System.out.println("occupations: " + createOcc(s));
            System.out.println("health records: " + s.getHealthRecord());
            System.out.println("criminal records: " + s.getCriminalRecord());
            System.out.println("computer skill: " + s.getComputerSkill());
            System.out.println("language spoken: " + s.getLanguageSpoken());
        }
    }

    private void criteriaEditMenu(int select, SelectionCriteria s){
        if (select == 1){
            System.out.println(s.getMinimumAge() + "-" + s.getMaximumAge());
        }
        else if (select == 2){
            String quaStr = createQuaStr(s);
            System.out.println(quaStr);
        }
        else if(select == 3){
            String workExp = createWorExp(s);
            System.out.println(workExp);
        }
        else if(select == 4){
            String occStr = createOcc(s);
            System.out.println(occStr);
        }else if(select == 5){
            System.out.println(s.getHealthRecord());
        }
        else if(select == 6){
            System.out.println(s.getCriminalRecord());
        }
        else if(select == 7){
            System.out.println(s.getComputerSkill());
        }
        else if(select == 8){
            System.out.println(s.getLanguageSpoken());
        }
    }

    private int inputInt(String displayMessage)
    {
        boolean notAnInt = true;
        int integer = 0;
        while(notAnInt)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(displayMessage);
            //judge whether the input is an int number
            try
            {
                integer = sc.nextInt();
                notAnInt = false;
            }
            //not an int number
            catch(Exception e)
            {
                System.out.println("Please enter right options");
            }
        }
        return integer;
    }

    private int valueSelect(int min, int max){
        int select = -1;
        while (!(min <= select &  select <= max )) {
            select = inputInt("Please select an option");
        }
        return select;
    }

    private String createQuaStr(SelectionCriteria s){
        String str = "";
        for(int i =0; i < s.getQualification().size(); i++){
            if (i == 0){
                str = s.getQualification().get(i);
            }
            else if (i > 0){
                str = "," + s.getQualification().get(i);
            }
        }
        return str;
    }

    private String createWorExp(SelectionCriteria s){
        String exp = "";
        for(int i =0; i < s.getExperience().size(); i++){
            if (i == 0){
               exp = String.valueOf(s.getExperience().get(i));
            }
            else if (i > 0){
                exp = "," + s.getQualification().get(i);
            }
        }
        return exp;
    }

    private String createOcc(SelectionCriteria s){
        String occ = "";
        for(int i =0; i < s.getOccupation().size(); i++){
            if (i == 0){
                occ = String.valueOf(s.getOccupation().get(i));
            }
            else if (i > 0){
                occ = "," + s.getOccupation().get(i);
            }
        }
        return occ;
    }

    private void createSelectionCriteria(){

    }
}
