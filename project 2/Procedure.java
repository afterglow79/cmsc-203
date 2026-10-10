// Written by Kelvin Zimmerman on 9 Oct. 2026 for CMSC 203
// this class represents a medical procedure with details such as name, date, practitioner, and cost.
// It provides methods to retrieve and modify these details, apply discounts, categorize charges, and format the output for display.
public class Procedure {
    private String procedureDate;
    private String name;
    private String practitioner;
    private double cost;

    public Procedure() {}

    public Procedure(String procedureName, String procedureDate){
        this.name = procedureName;
        this.procedureDate = procedureDate;
    }

    public Procedure(String procedureName, String procedureDate, String practitioner, double cost){
        this.name = procedureName;
        this.procedureDate = procedureDate;
        this.practitioner = practitioner;
        this.cost = cost;
    }

    public String getProcedureDate()  {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getProcedureName() {
        return name;
    }

    public void setProcedureName(String name) {
        this.name = name;
    }

    public String getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(String practitioner) {
        this.practitioner = practitioner;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
        return String.format("%-19s %-13s %-21s %9s %s", name, procedureDate, practitioner, getFormattedCharge(), getChargeCategory());
    }

    public boolean isExpensiveProcedure() {
        return cost >= 1000;
    }

    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100."); // handle invalid discount percentage
        }
        cost -= cost * (discountPercentage / 100);
    }

    public String getChargeCategory() {
        if (cost < 500) {
            return "Low";
        } else if (cost < 1000) {
            return "Medium";
        } else {
            return "High";
        }
    }

    public boolean isPerformedBy(String practitionerName) {
        return practitioner.equalsIgnoreCase(practitionerName);
    }

    public String getFormattedCharge() {
        return String.format("$%,.2f", cost); // dollar sign, commas, two decimal places
    }
}
