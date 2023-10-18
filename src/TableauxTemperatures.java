import java.text.DecimalFormat;
import java.util.Random;

@SuppressWarnings("ALL")
public class TableauxTemperatures {
    public static void main(String[] args) {
        int [] temperaturesDuMatin = new int[7];
        int [] temperaturesDeApresMidi = new int[7];
        int [] temperaturesTous = new int[temperaturesDuMatin.length + temperaturesDeApresMidi.length];
        int indice = 0;
        Random rd = new Random();
        DecimalFormat df = new DecimalFormat("0.00");

        String [] jours = new String[7];
        jours[0] = new String("Lundi");
        jours[1] = new String("Mardi");
        jours[2] = new String("Mercredi");
        jours[3] = new String("Jeudi");
        jours[4] = new String("Vendredi");
        jours[5] = new String("Samedi");
        jours[6] = new String("Dimanche");

        System.out.println("Les temperatures du matin de chaque jour de semain: ");
        for (int i = 0; i < temperaturesDuMatin.length; i++) {
            temperaturesDuMatin[i] = rd.nextInt(21) - 10;
            temperaturesTous[indice] = temperaturesDuMatin[i];
            indice++;
            System.out.println(jours[i] + ": " + temperaturesDuMatin[i] + "º");
        }
        System.out.println("\nLes temperatures de l'apres-midi de chaque jour de semain: ");
        for (int i = 0; i < temperaturesDeApresMidi.length; i++) {
            temperaturesDeApresMidi[i] = rd.nextInt(10, 31);
            temperaturesTous[indice] = temperaturesDeApresMidi[i];
            indice++;
            System.out.println(jours[i] + ": " + temperaturesDeApresMidi[i] + "º");
        }

        System.out.println("\nTous temperatures de chaque jour de semain: ");

        for (int i = 0; i < jours.length; i++) {
            System.out.println(jours[i] + " du matin est de: " + temperaturesTous[i] + "º" + "; de l'apres-midi est de: " + temperaturesTous[i + 7] + "º");
        }


        System.out.println("\nLe temperature maximum du matin est de " + temperatureMax(temperaturesDuMatin, jours) + "º");
        System.out.println("Le temperature maximum de l'apres-midi est de " + temperatureMax(temperaturesDeApresMidi, jours) + "º");
        System.out.println("Le temperature maximum de tous temperatures est de " + temperatureMax(temperaturesTous, jours) + "º");

        System.out.println("\nLe temperature minimum du matin est de " + temperatureMin(temperaturesDuMatin, jours) + "º");
        System.out.println("Le temperature minimum de l'apres-midi est de " + temperatureMin(temperaturesDeApresMidi, jours) + "º");
        System.out.println("Le temperature minimum de tous temperatures est de " + temperatureMin(temperaturesTous, jours) + "º");


        System.out.println("\nLe temperature moyenne du matin est de: " + df.format(temperatureMoyenne(temperaturesDuMatin)) + "º");
        System.out.println("Le temperature moyenne de l'apres-midi est de: " + df.format(temperatureMoyenne(temperaturesDeApresMidi)) + "º");
        System.out.print("Le temperature moyenne de tous temperatures est de: " + df.format(temperatureMoyenne(temperaturesTous)) + "º");
    }

    public static String temperatureMax(int [] temperatures, String [] jours) {
        int max = Integer.MIN_VALUE;
        String max_jour = null;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > max) {
                if (i >= 7) {
                    max = temperatures[i];
                    max_jour = jours[i - 7].toLowerCase() + ": " + max;
                } else {
                    max = temperatures[i];
                    max_jour = jours[i].toLowerCase() + ": " + max;
                }
            }
        }
        return max_jour;
    }

    public static String temperatureMin(int [] temperatures, String [] jours) {
        int min = Integer.MAX_VALUE;
        String min_jour = null;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < min) {
                if (i >= 7) {
                    min = temperatures[i];
                    min_jour = jours[i - 7].toLowerCase() + ": " + min;
                } else {
                    min = temperatures[i];
                    min_jour = jours[i].toLowerCase() + ": " + min;
                }
            }
        }
        return min_jour;
    }

    public static double temperatureMoyenne(int [] temperatures) {
        double moyenne = 0;
        for (int i = 0; i < temperatures.length; i++) {
            moyenne += temperatures[i];
        }
        moyenne = moyenne / temperatures.length;
        return moyenne;
    }
}