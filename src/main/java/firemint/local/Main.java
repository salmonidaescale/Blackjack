package firemint.local;

import static java.lang.System.*;
import com.opencsv.CSVWriter;
import java.util.*;
import java.io.*;

public class Main {
    static Scanner input = new Scanner(in);
    static List<Hand> handList = new ArrayList<>();//Create list that takes Hand objs
    public static void main(String[] args) {

        //Get initial amount
        double bankroll;
        out.print("Initial amount: ");
        bankroll = input.nextDouble();
        
        while (true) {
            //Get user bet value as double
            out.print("Enter bet: ");
            double bet = input.nextDouble();
            if (bet <= 0) {
                break;
            }
            double rWinnings;

            //rWinnings calculations
            out.print("Win(1) or loss(0)? ");
            if (input.nextInt() == 1) {
                out.print("Blackjack Y(1)/N(0)? ");
                if (input.nextInt() == 1) {
                    rWinnings = bet * 2.5;
                }
                else {
                    rWinnings = bet * 2;
                }
                out.println(bankroll);
                bankroll = bankroll - bet + rWinnings;
                out.println(bankroll);
            }
            else {
                rWinnings = bet * -1;
                bankroll += rWinnings;
                out.println(bankroll);
            }
            handList.add(new Hand(bet, rWinnings, bankroll));
            // break;
            bet = 0;
            // rWinnings = 0;
        }//End of loop

        String csvFile = "blk_jck_data.csv";
        exportToCSV(handList, csvFile);
    }

    public static void exportToCSV(List<Hand> list, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            //Generate header
            String[] header = {"Hand", "Bet", "rWinnings", "bankroll"};
            writer.writeNext(header);
            int hNum = 1;
            //Write player hand data
            for (Hand h : handList) {
                String[] hand = {
                    String.valueOf(hNum),
                    String.valueOf(h.getBet()),
                    String.valueOf(h.getrWinnings()),
                    String.valueOf(h.getBankroll())
                };
                writer.writeNext(hand);
                hNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
