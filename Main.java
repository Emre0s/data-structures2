public class Main {

    static Huffman[] nesne;
    private static Huffman[] kopyası;
    static int es = 0;
    static int elemanlar;

    public static void main(String[] args) {

        nesne = new Huffman[8];
        nesne[0] = new Huffman("a", 54);
        nesne[1] = new Huffman("e", 53);
        nesne[2] = new Huffman("d", 48);
        nesne[3] = new Huffman("b", 43);
        nesne[4] = new Huffman("c", 40);
        nesne[5] = new Huffman("f", 38);
        nesne[6] = new Huffman("g", 34);
        nesne[7] = new Huffman("s", 33);
        es = nesne.length;
        kopyası = new Huffman[(nesne.length * 2) - 1];

        yerlestirme(nesne);
        atama(kopyası);
        bitatama();
        orjinalprint(nesne);

    }

    static void yerlestirme(Huffman[] arr) {

        for (int i = 0; i < es; i++) {
            kopyası[i] = arr[i];
        }
        selectionsort(kopyası);
        elemanlar = es;
        while (es > 1 && es != 0) {
            String x1 = kopyası[es - 1].harf;
            int y1 = kopyası[es - 1].sayi;
            String x2 = kopyası[es - 2].harf;
            int y2 = kopyası[es - 2].sayi;
            kopyası[elemanlar] = new Huffman(x1 + x2, y1 + y2);
            elemanlar++;
            es++;
            selectionsort(kopyası);
            es = es - 2;
        }
    }

    static void print(Huffman[] arr) {
        for (int i = 0; i < es; i++) {
            System.out.println(arr[i].harf + "\t" + arr[i].sayi + "\t" + arr[i].binary);
        }
        System.out.println();
    }

    static void selectionsort(Huffman[] arr) {
        for (int i = 0; i < elemanlar; i++) {
            int max = i;
            for (int j = i + 1; j < elemanlar; j++) {
                if (arr[j].sayi > arr[max].sayi) {
                    max = j;
                }
                Huffman temp = new Huffman(arr[max].harf, arr[max].sayi);
                arr[max] = new Huffman(arr[i].harf, arr[i].sayi);
                arr[i] = new Huffman(temp.harf, temp.sayi);
            }
        }
    }

    static void orjinalprint(Huffman[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].harf + "\t" + arr[i].sayi + "\t" + arr[i].binary);
        }
        System.out.println();
    }

    static void atama(Huffman[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                arr[i].binary = "1";
            } else {
                arr[i].binary = "0";
            }
        }
    }

    static void bitatama() {
        for (int i = 0; i < nesne.length; i++) {
            for (int j = 1; j < kopyası.length; j++) {
                String elemanKarakteri = kopyası[j].harf;
                for (int k = 0; k < elemanKarakteri.length(); k++) {
                    if (elemanKarakteri.charAt(k) == nesne[i].harf.charAt(0)) {
                        nesne[i].binary = nesne[i].binary + kopyası[j].binary;
                    }
                }
            }
        }
    }
}
