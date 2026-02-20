public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void setNamaMakanan(int index, String nama) {
        nama_makanan[index] = nama;
    }

    public void setHargaMakanan(int index, double harga) {
        harga_makanan[index] = harga;
    }

    public void setStok(int index, int stok) {
        this.stok[index] = stok;
    }

    public String getNamaMakanan(int index) {
        return nama_makanan[index];
    }

    public double getHargaMakanan(int index) {
        return harga_makanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    public static byte getId() {
        return id;
    }

public void tambahMenuMakanan(String nama, double harga, int stok) {
    this.nama_makanan[id] = nama;
    this.harga_makanan[id] = harga;

    if (stok < 0) {
        System.out.println("stok tidak boleh negatif");
        this.stok[id] = 0;
    } else {
        this.stok[id] = stok;
    }

    id++;
}

public void tampilMenuMakanan() {
    for (int i = 0; i <= id; i++) {
        if (!isOutOfStock(i)) {
            System.out.println(
                nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
            );
        }
    }

    id++;
}

public void pesanMenu(int index, int jumlah) {
    if (stok[index] >= jumlah) {
        stok[index] -= jumlah;
        System.out.println(
            "Pesanan berhasil: " + nama_makanan[index] +
            " sebanyak " + jumlah
        );
    } else {
        System.out.println(
            "Pesanan ditolak, stok " + nama_makanan[index] +
            " tidak mencukupi"
        );
    }
}

public boolean isOutOfStock(int id) {
    if (stok[id] == 0) {
        return true;
    } else {
        return false;
    }
}
}