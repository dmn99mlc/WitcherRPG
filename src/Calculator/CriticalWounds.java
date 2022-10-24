package Calculator;

public class CriticalWounds {

    public static double BonusDMG(int result) {

        double bonusDMG;

        if (result < 7)
            bonusDMG = 0;
        else if (result < 10)
            bonusDMG = 3;
        else if (result < 13)
            bonusDMG = 5;
        else if (result < 15)
            bonusDMG = 8;
        else bonusDMG = 10;

        return bonusDMG;
    }

    public static void CriticalEffect(double bonusDMG, String locationName, boolean piercing) {
        if (bonusDMG < 3) {
            System.out.println("Brak rany krytycznej");
        } else if (bonusDMG < 5) {
            if (locationName.contains("Noga")) {
                System.out.println("\nSkręcenie. Masz trudności z chodzeniem.\nOtrzymujesz karę -2 do TEMPA, testów Atletyki i Zwinności (W tym uników).\n");
            }
            if (locationName.contains("Ręka")) {
                System.out.println("\nSkręcenie. Trudno Ci poruszać ręką.\nOtrzymujesz karę -2 do wszystkich akcji z jej użyciem.\n");
            }
            if (locationName.contains("Korpus")) {
                if (piercing) {
                    System.out.println("\nUłamek. W ranie pozostał kawałek broni, ubrania lub pancerza, powodując zakażenie. \nDo 1/4 normalnej wartości spadają Zdrowienie oraz CIAŁO postaci na potrzeby określania czasu leczenia Ran Krytycznych.\n");
                } else {
                    System.out.println("\nStłuczone żebra. Z ich powodu trudno Ci oddychać i tracisz siły.\nNa potrzeby testów i określania bonusów do obrażeń CIAŁO spada o 2.\n");
                }
            }
            if (locationName.contains("Głowa")) {
                if (piercing) {
                    System.out.println("\nSzpecąca blizna. Trafienie pozostawiło paskudny ślad na twarzy.\nPostać otrzymuje karę -3 do Konfliktu Społecznego porozumienia (Amorów, Empatii, Oszustwa, Perswazji, Uroku).\n");
                } else {
                    System.out.println("\nZłamana szczęka.\nPostać otrzymuje karę -2 do zdolności magicznych i Konfliktu Społecznego.\n");
                }
            }
        } else if (bonusDMG < 8) {
            if (locationName.contains("Noga")) {
                System.out.println("\nZłamanie. Trudności z chodzeniem.\nPostać otrzymuję karę -3 do TEMPA, testów Atletyki i Zwinności\n");
            }
            if (locationName.contains("Ręka")) {
                System.out.println("\nZłamanie.\nOtrzymujesz karę -3 do wszystkich akcji z jej użyciem.\n");
            }
            if (locationName.contains("Korpus")) {
                if (piercing) {
                    System.out.println("\nW śledzionę. Cios powoduje wewnętrzne krwawienie. \nPostać musi wykonywać test Przytomności co 5 rund. Dodatkowo krwawi.\n");
                } else {
                    System.out.println("\nPołamane żebra. Okrutnie bolą.\nKara -2 do CIAŁA oraz -1 do GRACJI i REAKCJI.\n");
                }
            }
            if (locationName.contains("Głowa")) {
                if (piercing) {
                    System.out.println("\nWstrząśnienie mózgu. Od ciosu miesza się postaci w głowie.\nOtrzymuje karę -1 do ROZUMU i WOLI oraz traci 10 Punktów Przytomności.\n");
                } else {
                    System.out.println("\nWybite zęby. Rzuć 1k10 na to, ile ich postać traci.\nKara -3 do zdolności magicznych i Konfliktu Społecznego\n");
                }
            }
        } else if (bonusDMG < 10) {
            if (locationName.contains("Noga")) {
                System.out.println("\nOtwarte złamanie. Postać nie może korzystać z jednej z nóg.\nTEMPO, Atletyka i Zwinność postaci spadają do 1/4 normalnej wartości. Dodatkowo postać krwawi\n");
            }
            if (locationName.contains("Ręka")) {
                System.out.println("\nOtwarte złamanie.\nNie można wykonywać Akcji jedną z rąk. Dodatkowo postać krwawi.\n");
            }
            if (locationName.contains("Korpus")) {
                if (piercing) {
                    System.out.println("\nPrzebite płuco. Krew zatapia postać. \nKara -3 do CIAŁA i TEMPA. Postać się dusi.\n");
                } else {
                    System.out.println("\nW żołądek. Jego zawartość rozlewa się po wnętrznościach.\nKara -2 do wszystkich Akcji. Postać otrzymuje też 4 dodatkowe obrażenia w korpus co rundę.\n");
                }
            }
            if (locationName.contains("Głowa")) {
                if (piercing) {
                    System.out.println("\nPęknięta czaszka.\nKara -1 do GRACJI i ROZUMU. Mnożnik obrażeń głowy rośnie z x3 do x4.\n");
                } else {
                    System.out.println("\nWstrząs mózgu. Postać wykonuje test Przytomności co 1k6 rund.\nKara -2 do GRACJI, REAKCJI i ROZUMU.\n");
                }
            }
        } else if (bonusDMG >= 10) {
            if (locationName.contains("Noga")) {
                System.out.println("\nOdcięta noga. Nie da się jej już uratować.\nTEMPO, Atletyka i Zwinność postaci spadają do 1/4 normalnej wartości. Postać rzecz jasna krwawi.\n");
            }
            if (locationName.contains("Ręka")) {
                System.out.println("\nOdcięta ręka. Bez ręki jest się jak bez ręki.\nZ kończyny nie da się korzystać, a postać krwawi.\n");
            }
            if (locationName.contains("Korpus")) {
                if (piercing) {
                    System.out.println("\nW serducho.\nPostać musi przejść test Konania. Jeśli go nie zda, umiera na miejscu. Jeśli przeżyje, zmniejsza swoje maksimum Punktów Wytrwałości, CIAŁO oraz TEMPO do 1/4 początkowej wartości oraz krwawi.\n");
                } else {
                    System.out.println("\nSzok septyczny. Uszkodzenie organów wewnętrznych powoduje wstrząs dla całego ciała.\nPostać zmniejsza swoje maksimum Punktów Wytrwałości do 1/4, otrzymuje karę -3 do GRACJI, REAKCJI, ROZUMU i WOLI oraz jest zatruta\n");
                }
            }
            if (locationName.contains("Głowa")) {
                if (piercing) {
                    System.out.println("\nDekapitacja. Czyli odcięta głowa (a przynajmniej przecięty kręgosłup).\nOd tego się umiera na miejscu.\n");
                } else {
                    System.out.println("\nW oko. Gałka oczna postaci zostaje uszkodzona.\nKara -5 do testów Czujności opartych na wzroku oraz -4 do GRACJI. Rana krwawi.\n");
                }


            }
        }
    }
}