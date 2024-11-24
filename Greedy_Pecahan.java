public class Greedy_Pecahan {
    public static void main(String[] args) {
        int[] pecahan = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100};
        int jumlah = 2575800;

        System.out.println("Jumlah : " + jumlah);

        for (int i = 0; i < pecahan.length; i++) {
            if (jumlah >= pecahan[i]) {
                int n = jumlah / pecahan[i];
                jumlah -= pecahan[i] * n;
                System.out.println("Pecahan " + pecahan[i] + " sebanyak: " + n);
            }
        }
    }
}

//tes
