public class main {

    public static void main(String[] args){

         double[][] tabell1 = {{0.1, 0.2, 0.3, 0.4, 0.5, 0.6},
                 {0.7, 0.8, 1.9, 1.0, 1.1, 1.2},
                 {1.3, 1.4, 1.5, 1.6, 1.7, 1.8},
                 {1.9, 2.0, 1.5, 1.0, 0.5, 0.1}};

         for(double[] nummer : tabell1){ // en 2d tabell/ matrise/ matrix
             for(double rad : nummer){      // skriver ut alle tall på hver rad og kolonne
                 System.out.print(rad + " ");
             }
             System.out.println();

        }
        System.out.println(); // tom linje for å separere de to tabellene
        // oppgaven gir egentlig tabellen i en slik form kan den skrives ut slik::
        double[] tabell2 = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 1.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 1.5, 1.0, 0.5, 0.1};
         for(int i = 0; i < tabell2.length; i++){
             System.out.print(tabell2[i] + " ");
         }

    }

}
