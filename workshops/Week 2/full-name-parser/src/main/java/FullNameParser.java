public class FullNameParser {
    private String firstName;
    private String middleName;
    private String lastName;


    public FullNameParser(String fullName) {

        String trimmedName = fullName.trim();


        String[] nameParts = trimmedName.split("\\s+");

        if (nameParts.length == 2) {
            this.firstName = nameParts[0];
            this.middleName = "(none)";
            this.lastName = nameParts[1];
        }
        else if (nameParts.length >= 3) {
            this.firstName = nameParts[0];
            this.middleName = nameParts[1];
            this.lastName = nameParts[2];
        }
        else {
            this.firstName = "Invalid";
            this.middleName = "Invalid";
            this.lastName = "Invalid";
        }
    }


    public void displayNames() {
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}