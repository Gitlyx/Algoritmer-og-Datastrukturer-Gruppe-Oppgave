package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.*;


public class Oblig1 {
    ///// Oppgave 1 //////////////////////////////////////

    /*
    Oppgave 1 - Teoretiske spørsmål

Flest ombyttinger
Når verdiene i arrayet er i synkende (descending) rekkefølge. Da vil vi ved bruk av bubbel sort få n - 1 antall
ombyttinger for å finne det største tallet i arrayet.

Færrest ombyttinger
Når verdiene i arrayet er i stigende rekkefølge, men nest siste index har størst verdi og siste index har nest størst
verdi. Dette fører til at vi kun får 1 ombytting. Unntak er dersom arrayet allerede er sortert, da vil vi ha 0 ombyttinger.

Gjennomsnittlig antall ombyttinger
Det gjennomsnittlige antall ombyttinger vi kommer til å få kan Bergens ved å ta
worst-case (flest ombyttinger) + best case (færrest ombyttinger) og dele dette på 2:

				( (n-1) + 0 ) / 2 = (n-1) / 2

Maks metoden bedre/dårligere
Sammenlignet med maks metoden der vi bruker en hjelpevariabel for å lagre index for maks verdi, vil denne
tilnærmingsmåten være mindre effektiv med tanke på at vi må utføre ombyttinger sammenlignet med å oppdatere en
index variabel.
     */

    public static int maks(int[] a) {
        //throw new UnsupportedOperationException();

        if (a.length < 1) {
            throw new NoSuchElementException("Arrayet kan ikke være tomt!");
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        return a[a.length - 1]; // Returnerer siste element i arrayet
    }

    public static int ombyttinger(int[] a) {
        //throw new UnsupportedOperationException();
        if (a.length < 1) {
            throw new NoSuchElementException("Arrayet kan ikke være tomt!");
        }
        int teller = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                teller++;
            }
        }

        return teller; // Returnerer siste element i arrayet
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        boolean stigende = true;
        int teller = 1; // teller antall ulike verdier i arrayet

        if (a.length == 0) {
            return 0;
        } else {
            int temp = a[0]; // hjelpevariabel for å holde på verdi
            for (int i = 1; i < a.length; i++) {
                if (temp < a[i]) { // sjekker om neste tall større
                    temp = a[i]; // oppdater hjelpevariabel
                    teller++;
                }
                if (temp > a[i]) {  // Sjekker om tall større enn neste tall
                    stigende = false;
                    break;
                }
            }

            if (!stigende) {
                throw new IllegalStateException("Arrayet må være sortert stigende!");
            }

            return teller;
        }
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        int antall =0;
        for(int i =0; i<a.length; i++){
            int j=0;
            for(; j<i; j++){
                /* Gå gjennom tabllet og sjekk om veridene er like. Om det er sant,
                stoppes for løkke. */
                if(a[i]==a[j]){
                    break;
                }
            }
            /* Om både verdiene og indeksene er like, lgger til 1 til count */
            if(j==i){
                antall ++;
            }

        }
        return  antall;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int v = 0; // Venstre grense
        int h = a.length - 1; // Høyre grense

        while (v < h) {
            /*
            Gå gjennom tabellen og sjekk høyre og venstre side. Dersom høyre er
            partall sjekk neste verdi mot venstre. Dersom venstre er oddetall sjekk
            neste verdi mot høyere.
            */
            while (v <= h && a[h] % 2 == 0) h--;
            while (v <= h && a[v] % 2 != 0) v++;

            if (v < h) {
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;
            }
        }
        kvikksortering0(a, 0, h);
        kvikksortering0(a, v, a.length - 1);


    }

   /*
   Følgende kode er kopiert fra Kap 1.3.9 som omhandler kvikksortering
   https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#1.3.9
    */

    // Kode kopiert start

    public static void bytt(int[] a, int i, int j) // Metode for å bytte plass mellom to verdier
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
    Metode som returnerer venstre verdi, etter å ha sortet tall større en skilleverdi og tall mindre enn skilleverdi
     */
    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true) {
            while (v <= h && a[v] < skilleverdi) v++;
            while (v <= h && a[h] >= skilleverdi) h--;

            if (v < h) bytt(a, v++, h--);
            else return v;
        }
    }

    /*
    Metode som flytter skilleverdien bakerst før sortering av verdier mindre/større enn skilleverdi utføres.
    Returnerer index til venstre verdi.
     */
    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h); // Flytt skille verdi bakerst
        int pos = parter0(a, v, h - 1, a[h]); // Sorter mindre/større enn skilleverdi
        bytt(a, pos, h); // Sett skilleverdien tilbake til riktig plass ifht. sortering
        return pos; // returner venstre verdi
    }

    private static void kvikksortering0(int[] a, int v, int h) { // Rekrusiv metode
        if (v >= h) return; // Feilhåndtering
        int k = sParter0(a, v, h, (v + h) / 2); // Sorter array med mindre/større verdier enn midt verdi.
        kvikksortering0(a, v, k - 1); // Utfør ny sortering på siden bestående av verdier mindre enn skilleverdi
        kvikksortering0(a, k + 1, h); // Utfør ny sortering på siden bestående av verdier større enn skilleverdi
    }


    public static void kvikksortering(int[] a, int fra, int til) {
        kvikksortering0(a, fra, til - 1);
    }


    // Kode kopiert slutt

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length > 1) {
            char[] first = new char[1];   // Array for det siste elementet
            char[] last = new char[1];      // Array for det første elementet
            char[] ress = new char[a.length - 2]; // Array for restene elementene
            // bytter de to elementene
            if (a.length == 2) {
                char temp;
                for (int i = 0; i < a.length - 1; i++) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
                // legger til restende elemntene
            } else {
                for (int i = 0; i < ress.length; i++) {
                    ress[i] = a[i + 1];
                }

                /* legger til det første elementet
                og bytter første elementet til indeks 1  */

                for (int i = 0; i < first.length; i++) {
                    first[i] = a[i];
                    a[i + 1] = first[i];
                }
                /* legger til det siste elementet
                og bytter det siste elementet til indeks 0   */
                for (int i = 0; i < last.length; i++) {
                    last[i] = a[a.length - 1];
                    a[i] = last[i];
                }
                //bytter indeksene til restene elementene
                for (int i = 2; i < a.length; i++) {
                    a[i] = ress[i - 2];
                }
            }

        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if(a.length==0){
            return;
        }
            char [] temp;
            // rotasjon mot venstre
            if(k<1){
                // midlertidig array som trekker k elementer fra venstre side av originale array
                temp = new char[-1*k];
                for(int i=0; i<-1*k;i++){
                    temp[i]= a[i];
                }
                for(int i =-1*k; i<a.length; i++){
                    a[i-(-1*k)]=a[i];
                }
                // plaserer temp array i orignale
                for(int i =0; i< temp.length; i++){
                    a[i+a.length-(-1*k)]= temp[i];
                }
            }
            // rotasjon mot høyre

            if(k>=1){
                // om k aer større en a.length la k = k-a.length
                if(k>a.length){
                    k=k-a.length;
                }

                    temp = new char[a.length -k];
                    for(int i=0; i<temp.length; i++){
                        temp[i]= a[i];
                    }
                    for( int i = 0; i<k; i++){
                        a[i]= a[i+a.length-k];
                    }

                    for( int i = k; i< a.length;i++){
                        a[i]= temp[i-k];
                    }
            }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

       // Gjør om hver innparameter fra String til String-Array.
       String[] a = new String[s.length()];
       String[] b = new String[t.length()];
       String[] c = new String[s.length() + t.length()];

       for (int i = 0; i < s.length(); i++) {
          a[i] = String.valueOf(s.charAt(i));
       }

       for (int i = 0; i < t.length(); i++) {
          b[i] = String.valueOf(t.charAt(i));
       }

       // Strengen flettecoms sammen alternerende i tillegg til at indeksene oppdateres etter de er aksessert og tilordnet.
       // Løkken stopper når det korteste strengen er brukt opp.
       int i = 0, j = 0, k = 0;
       while (i < a.length && j < b.length) {
          c[k++] = a[i++];
          c[k++] = b[j++];
       }

       // Output strengen konkatineres med gjenstående tekst fra største strengen.
       while (i < a.length) c[k++] = a[i++];
       while (j < b.length) c[k++] = b[j++];

       // Gjør om tekst til streng.
       String cText = "";
       for (int y = 0; y < c.length; y++) {
          cText += c[y];
       }

       return cText;

    }

    /// 7b)
    public static String flett(String... s) {

        int posisjonString = 0; // Førstebokstav, andrebokstav, tredjebokstav......
        int posisjonChar = 0;
        int antallChar = 0;

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                antallChar++;
            }
        }

        char[] c = new char[antallChar];
        int teller = 0;


        while (teller < c.length) {
            for (int i = 0; i < s.length; i++) { // Gå gjennom alle strings i array
                for (int j = posisjonString; j < posisjonString + 1; j++) { // Hent ut bokstav
                    if (posisjonString < s[i].length() && posisjonChar < c.length) {
                        c[posisjonChar] = s[i].charAt(j);
                        posisjonChar++;
                        teller++;
                    }
                }
            }
            posisjonString++;
        }
        String print = "";
        for (int i = 0; i < c.length; i++) {
            print += c[i];
        }
        return print;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] cloneA = a.clone(); // Clone of array
        int index_pos = 0;  // Index position
        int min_index = 0; // Current min index
        int[] index = new int[a.length]; // Index array

        while (index_pos < a.length) {
            for (int i = 0; i < a.length; i++) {
                if (cloneA[min_index] > cloneA[i]) {
                    min_index = i;
                }
            }
            cloneA[min_index] = 0xfffffff; // Setter lik maks verdi
            index[index_pos] = min_index;
            index_pos++;
        }

        return index;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Ikke nok verdier å sammenlikne.");
        }

        int[] bArray = {a[0], a[1], a[2]};
        int[] b = indekssortering(bArray);

        int s = b[0], m = b[1], l = b[2];
        int sVerdi = a[s], mVerdi = a[m], lVerdi = a[l];

        for (int i = 3; i < a.length; i++) {
            if (lVerdi > a[i]) {
                if (mVerdi > a[i]) {
                    if (sVerdi > a[i]) {
                        l = m;
                        m = s;
                        s = i;
                        lVerdi = a[l];
                        mVerdi = a[m];
                        sVerdi = a[s];
                    } else {
                        l = m;
                        m = i;
                        lVerdi = a[l];
                        mVerdi = a[i];
                    }
                } else {
                    l = i;
                    lVerdi = a[i];
                }
            }
        }
        return new int[]{s, m, l};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {

        String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int[] aCounter = new int[29];
        int[] bCounter = new int[29];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < c.length(); j++) {
                if (a.charAt(i) == c.charAt(j)) {
                    aCounter[j]++;
                }
            }
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < c.length(); j++) {
                if (b.charAt(i) == c.charAt(j)) {
                    bCounter[j]++;
                }
            }
        }

        for (int i = 0; i < bCounter.length; i++) {
            if (aCounter[i] > bCounter[i]) {
                return false;
            }
        }
        return true;
    }
}  // Oblig1
