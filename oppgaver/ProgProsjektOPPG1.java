public class ProgProsjektOPPG1 {

    //tabeller
    public static double[] powerprices_day = {
            0.1, 0.2, 0.3, 0.4, 0.5, 0.6,
            0.7, 0.8, 1.9, 1.0, 1.1, 1.2,
            1.3, 1.4, 1.5, 1.6, 1.7, 1.8,
            1.9, 2.0, 1.5, 1.0, 0.5, 0.1
    };

    public static double[] powerusage_day = {

            0.34, 0.29, 0.31, 0.45, 0.41, 0.38,
            2.12, 1.87, 2.03, 1.01, 0.95, 0.89,
            1.11, 0.84, 0.93, 1.08, 2.45, 2.78,
            2.36, 2.19, 0.91, 0.73, 0.66, 0.59

    };

    // Metode som skriver ut strømprisene
    public static void printPowerPrices(double[] prices) {
        System.out.println("OPPGAVE 1a Strømpriser (NOK per kWh):");

        // for-løkke som går gjennom alle prisene
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("Time %02d: %.2f NOK%n", i, prices[i]);
        }
    }
    // Metode som skriver ut strømforbruket
    public static void printPowerUsage(double[] usage) {
        System.out.println("OPPGAVE 1b Strømforbruk (kWh per time):");
        // for-løkke som går gjennom strømforbruket
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("Time %02d: %.2f kWh%n", i, usage[i]);
        }
    }
    // Metode som beregner totalt strømforbruk for en dag
    public static double computePowerUsage(double[] usage) {
        double total = 0.0;
        for (int i = 0; i < usage.length; i++) {
            total += usage[i];  // summerer alle timene
        }
        return total;
    }


    // Beregner total strømpris for dagen
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double totalCost = 0.0;

        // Sjekk at tabellene er like lange
        if (usage.length != prices.length) {
            System.out.println("Feil: tabellene har ulik lengde!");
            return 0.0;
        }

        // Beregn kostnaden per time og summer
        for (int i = 0; i < usage.length; i++) {
            double costForHour = usage[i] * prices[i];
            totalCost += costForHour;
        }

        return totalCost;
    }

    //Oppgave 1e
    private static final double THRESHOLD = 0.9375;  // 93,75 øre per kWh
    private static final double PERCENTAGE = 0.9;    // 90 % støtte

    private static double getSupport(double usage, double price) {
        double support = 0.0;

        if (price > THRESHOLD) {
            double difference = price - THRESHOLD;   // beløp over støttegrensen
            support = difference * PERCENTAGE * usage;
        }

        return support;
    }


    //oppgave 1f
    public static double computePowerSupport(double[] usage, double[] prices) {
        double totalSupport = 0.0;

        if (usage.length != prices.length) {
            System.out.println("Feil: tabellene har ulik lengde!");
            return 0.0;
        }

        for (int i = 0; i < usage.length; i++) {
            totalSupport += getSupport(usage[i], prices[i]);
        }

        return totalSupport;
    }

    //oppgave 1f
    public static double computeNorgesPrice(double[] usage) {
        double price = 0.0;
        double fixedRate = 0.50; // NOK per kWh

        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * fixedRate; // multipliser forbruk med fastpris
        }

        return price;
    }

    //oppgave 1h
    public static double findPeakUsage(double[] usage) {

        double temp_max = 0.0;

        for (int i = 0; i < usage.length; i++) {
            if (usage[i] > temp_max) {
                temp_max = usage[i]; // oppdater maksimum hvis vi finner større verdi
            }
        }

        return temp_max;
    }
    //Oppgave 1j
    public static double findAvgPower(double[] usage) {

        double total = 0.0;

        for (int i = 0; i < usage.length; i++) {
            total += usage[i]; // summerer alt forbruk
        }

        double average = total / usage.length; // deler på antall timer (24)
        return average;
    }

        // main (for testing av metodene)
    public static void main(String[] args){
            //skriv ut strømpris-metoden
        printPowerPrices(powerprices_day);
        System.out.println(); // separerer metode-utskriftene
            //skriv ut strømforbruk-metoden
        printPowerUsage(powerusage_day);

        double totalUsage = computePowerUsage(powerusage_day);
        System.out.println();
        System.out.printf("Oppgave 1c Totalt strømforbruk for dagen: %.2f kWh%n", totalUsage);
        System.out.println();
        double totalPrice = computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("Oppgave 1d Total strømpris for dagen: %.2f NOK%n", totalPrice);

        System.out.println("\nOPPGAVE 1e – Strømstøtte per time:");
        for (int i = 0; i < powerusage_day.length; i++) {
            double support = getSupport(powerusage_day[i], powerprices_day[i]);
            System.out.printf("Time %02d: støtte = %.3f NOK%n", i, support);
        }

        //Oppgave 1f
        System.out.println();
        double totalSupport = computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("Oppgave 1f Total strømstøtte for dagen: %.2f NOK%n", totalSupport);
        double priceAfterSupport = totalPrice - totalSupport;
        System.out.printf("Oppgave 1f Total pris etter støtte: %.2f NOK%n", priceAfterSupport);


        //oppgave 1g
        System.out.println();
        double norgesPrice = computeNorgesPrice(powerusage_day);
        System.out.printf("Oppgave 1g Norgespris (fast 50 øre/kWh): %.2f NOK%n", norgesPrice);

        //oppgave 1h
        System.out.println();
        double peakUsage = findPeakUsage(powerusage_day);
        System.out.printf("Oppgave 1h Størst strømforbruk i løpet av dagen: %.2f kWh%n", peakUsage);

        //oppgave 1j
        System.out.println();
        double avgUsage = findAvgPower(powerusage_day);
        System.out.printf("Oppgave 1i Gjennomsnittlig strømforbruk per time: %.2f kWh%n", avgUsage);



    }



}
