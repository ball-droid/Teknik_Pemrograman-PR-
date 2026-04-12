import java.util.Scanner;

class SumTask extends Thread {
    private int start, end;
    private long result = 0;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            result += i;
        }

        System.out.println(getName() +
                " menjumlahkan " + start + " - " + end +
                " | Hasil parsial: " + result);
    }

    public long getResult() {
        return result;
    }
}

public class Penjumlahan {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah Thread: ");
        int n = sc.nextInt();

        System.out.print("Angka Akhir: ");
        int max = sc.nextInt();

        SumTask[] threads = new SumTask[n];
        int range = max / n;

        int start = 1;

        // Pembagian tugas (lebih aman)
        for (int i = 0; i < n; i++) {
            int end = (i == n - 1) ? max : start + range - 1;

            threads[i] = new SumTask(start, end);
            threads[i].setName("Thread-" + (i + 1));
            threads[i].start();

            start = end + 1;
        }

        long total = 0;

        // Sinkronisasi + ambil hasil
        for (int i = 0; i < n; i++) {
            threads[i].join();
            total += threads[i].getResult();
        }

        System.out.println("=================================");
        System.out.println("Hasil akhir: " + total);

        sc.close();
    }
}