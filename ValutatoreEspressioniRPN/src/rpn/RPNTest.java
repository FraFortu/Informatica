/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author FortuF100
 */
public class RPNTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\Users\\Francesco\\Desktop\\Scuola\\Triennio\\"
                + "4IC 2017 2018\\Informatica\\Java\\"
                + "ValutatoreEspressioniRPN\\src\\rpn\\input.txt");
        Scanner s = new Scanner(f);
        PrintWriter p = new PrintWriter("output.txt");
        RPN rpn = new RPN();
        while(s.hasNextLine()) {
            rpn.riempi(s.nextLine());
            System.out.println(rpn.exp.toString());
            p.println(rpn.value().info);
        }
        p.close();
    }
    
}
