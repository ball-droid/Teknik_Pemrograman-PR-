// ===== Commission.java  =====
public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = commRate;
        totalSales = 0;
    }

    public void addSales(double sales) {
        totalSales += sales;
    }

    public double pay() {
        double payment = super.pay() + (commissionRate * totalSales);
        totalSales = 0; // reset setelah dibayar
        return payment;
    }

    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}
