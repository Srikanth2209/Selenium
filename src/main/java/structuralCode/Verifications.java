package structuralCode;

public class Verifications extends Actions
{
    public boolean verifyPageTitle(String exp_Title) {
        String actual_Title = getPageTitle();

        if (actual_Title.equals(exp_Title)) {

            System.out.println("Expected title and actual title  Matched");
            return true;
        }else {
            System.out.println("Expected title and actual title Mismatched");
            return false;
        }
    }
}
