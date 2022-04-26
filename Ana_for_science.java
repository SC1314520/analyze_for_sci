/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ana_for_science;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author blc0000421gmail.com
 */
public class Ana_for_science {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a1,a2,b1,b2,c1,ans1,ans2,pp;
        Scanner sc = new Scanner(System.in);
        String method,cont;
        while(true){
        System.out.println("不確定度傳遞程式");
        System.out.print("輸入不確定度傳遞方法(+/-/*/%/^):");
        method=sc.next();
        if(method.equals("+")||method.equals("-")||method.equals("*")||method.equals("%")){
        
        System.out.print("輸入數值一之真值:");
        a1=sc.nextDouble();
        System.out.print("輸入數值一之不確定度:");
        a2=sc.nextDouble();
        System.out.print("輸入數值二之真值:");
        b1=sc.nextDouble();
        System.out.print("輸入數值二之不確定度:");
        b2=sc.nextDouble();
            if(method.equals("+")){
            ans1 = a1 + b1;
            DecimalFormat cf = new DecimalFormat("#####.#####");
            System.out.println("傳遞後真值:"+cf.format(ans1));
            ans2 = Math.sqrt((Math.pow(a2, 2)) + (Math.pow(b2, 2)));
            DecimalFormat df = new DecimalFormat("#####.#####");
            System.out.println("傳遞後不確定度:"+df.format(ans2));
            }
            if(method.equals("-")){
            ans1 = a1 - b1;
            DecimalFormat cf = new DecimalFormat("#####.#####");
            System.out.println("傳遞後真值:"+cf.format(ans1));
            ans2 = Math.sqrt((Math.pow(a2, 2)) + (Math.pow(b2, 2)));
            DecimalFormat df = new DecimalFormat("#####.#####");
            System.out.println("傳遞後不確定度:"+df.format(ans2));
            }
            if(method.equals("*")){
            ans1 = a1 * b1;
            DecimalFormat cf = new DecimalFormat("##########.#########################################################");
            System.out.println("傳遞後真值:"+cf.format(ans1));
            double g = (a2 / a1) * (a2 / a1);
            double h = (b2 / b1) * (b2 / b1);
            ans2 = ans1 * Math.sqrt(g + h);
            DecimalFormat df = new DecimalFormat("##########.#########################################################");
            System.out.println("傳遞後不確定度:"+df.format(ans2));
            }
            if(method.equals("%")){
            ans1 = a1 / b1;
            DecimalFormat cf = new DecimalFormat("##########.#########################################################");
            System.out.println("傳遞後真值:"+cf.format(ans1));
            double g = (a2 / a1) * (a2 / a1);
            double h = (b2 / b1) * (b2 / b1);
            ans2 = ans1 * Math.sqrt(g + h);
            DecimalFormat df = new DecimalFormat("##########.#########################################################");
            System.out.println("傳遞後不確定度:"+df.format(ans2));
            }
        }
        else{
        System.out.println("不確定度傳遞程式");
        System.out.print("輸入數值一之真值:");
        a1=sc.nextDouble();
        System.out.print("輸入數值一之不確定度:");
        a2=sc.nextDouble();
        System.out.print("輸入次方數:");
        pp=sc.nextDouble();
        DecimalFormat cf = new DecimalFormat("##########.#########################################################");
        ans1 = Math.pow(a1,pp);
        System.out.println("傳遞後真值:"+cf.format(ans1));
        ans2= Math.pow(a1,pp)*(pp*(a2/a1));
        DecimalFormat df = new DecimalFormat("##########.#########################################################");
        System.out.println("傳遞後不確定度:"+df.format(ans2));
        }
        System.out.print("是否繼續T/F:");
        cont=sc.next();
        if(cont.equalsIgnoreCase("T")){
            continue;
        }
        else
            break;
        }
    }
    
}
