

/* 
 * Copyright 2020 Pablo Claramunt Hernandis - pablo.claramunt.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo Claramunt Hernandis - pablo.claramunt.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Random RND = new Random();

    public static void main(String[] args) {

        //Nombre Parking
        System.out.println("Párking Morvedre");

        //Separador
        System.out.println("===============");

        //Entrada hora
        int hEnt = 0;
        try {
            System.out.print("Hora entrada........: ");
            hEnt = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Entrada Incorrecta");
            System.out.println("------------------------------------------");
            System.exit(0);
        } finally {
            SCN.nextLine();
        }

        //Entrada minuto
        int mEnt = 0;
        try {
            System.out.print("Minuto entrada......: ");
            mEnt = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Entrada Incorrecta");
            System.out.println("------------------------------------------");
            System.exit(0);
        } finally {
            SCN.nextLine();
        }

        //Separador
        System.out.println("---");

        System.out.printf("Momento entrada.....: %02d:%02dh%n", hEnt, mEnt);

        //Hora Entrada
        int tEnt = hEnt * 60 + mEnt;

        //Limites Temporales
        final int H_MAX = 23;
        final int H_MIN = hEnt;
        final int M_MAX = 59;
        final int M_MIN = mEnt;
        final int T_MAX = H_MAX * 60 + M_MAX;
        final int T_MIN = H_MIN * 60 + M_MIN;

        //Hora Aleatoria
        int tRnd = RND.nextInt(T_MAX - T_MIN + 1) + T_MIN;
        int hRnd = tRnd / 60;
        int mRnd = tRnd % 60;

        System.out.printf("Momento Salida......: %02d:%02dh%n", hRnd, mRnd);

        //Hora Salida
        int tSal = hRnd * 60 + mRnd;

        //Separador
        System.out.println("---");

        //Tarifa
        final double tarifa = 0.15;
        System.out.printf(Locale.ENGLISH, "Tarifa..............: %.2f €/min%n",
                tarifa);

        //Tiempo facturado
        int tFac = tSal - tEnt;
        int hdif = tFac / 60;
        int mdif = tFac % 60;

        System.out.printf("Tiempo facturado....: %d minutos (%02dh + %02dm)%n",
                tFac, hdif, mdif);

        //Importe
        final double importe = (tFac * tarifa);
        System.out.printf(Locale.ENGLISH, "Importe.............: %.2f €%n", 
                importe);

    }
}
