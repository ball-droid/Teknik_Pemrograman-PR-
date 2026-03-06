package Soal3;

// ===== Salesperson.java =====
public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ":\t" + totalSales;
    }

    public boolean equals(Object other) {
        return (lastName.equals(((Salesperson) other).getLastName()) &&
                firstName.equals(((Salesperson) other).getFirstName()));
    }

    // urut berdasarkan sales, nama sebagai tiebreaker
    public int compareTo(Object other) {
        int result;
        Salesperson otherPerson = (Salesperson) other;
        result = this.totalSales - otherPerson.getSales();
        if (result == 0) {
            result = this.lastName.compareTo(otherPerson.getLastName());
            if (result == 0)
                result = this.firstName.compareTo(otherPerson.getFirstName());
        }
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }
}
