public class programDjikstra {

    static void djikstra(int[][] State, int source) {
        int Node = State.length;
        int jarak[] = new int[Node];
        Boolean[] titik_singgah = new Boolean[Node];

        for (int i = 0; i < Node; i++) {
            jarak[i] = Integer.MAX_VALUE;
            titik_singgah[i] = false;
        }
        jarak[source] = 0;

        for (int count = 0; count < Node - 1; count++) {
            int u = jarakMinimal(jarak, titik_singgah);
            titik_singgah[u] = true;

            for (int v = 0; v < Node; v++) {
                if (!titik_singgah[v] && State[u][v] != 0 && jarak[u] != Integer.MAX_VALUE
                        && jarak[u] + State[u][v] < jarak[v]) {
                    jarak[v] = jarak[u] + State[u][v];
                }
            }
        }
        cetakSolusi(jarak);
    }

    static int jarakMinimal(int[] jarak, Boolean[] titik_singgah) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < jarak.length; v++) {
            if (!titik_singgah[v] && jarak[v] <= min) {
                min = jarak[v];
                min_index = v;
            }
        }
        return min_index;
    }

    static void cetakSolusi(int[] jarak) {
        System.out.println("Titik ke\t\t Jarak tujuan dari Asal");
        for (int i = 0; i < jarak.length; i++) {
            System.out.println(i + " \t\t " + jarak[i]);
        }
    }

    public static void main(String[] args) {
        int[][] State = {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        djikstra(State, 0);
    }
}