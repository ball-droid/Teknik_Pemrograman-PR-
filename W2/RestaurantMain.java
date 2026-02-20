public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);

        menu.tambahMenuMakanan("Spaghetti", 80000, 20);

        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);

        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        menu.tampilMenuMakanan();

        System.out.println("\n--- Pemesanan ---");
        menu.pesanMenu(0, 5);
        menu.pesanMenu(1, 25);

        System.out.println("\n--- Setelah Pemesanan ---");
        menu.tampilMenuMakanan();
    }
}
