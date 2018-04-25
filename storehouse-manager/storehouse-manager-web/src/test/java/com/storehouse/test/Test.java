package com.storehouse.test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			List names=new ArrayList();
			int n=reader.nextInt();
			System.out.println("总数是："+n);
			for(int i=0;i<n;i++)
			{
					String name=reader.next();
					names.add(name);
			}
				System.out.println(names.toString());
			}
			
		}
//		Scanner xx = new Scanner( System.in );
//		int n = xx.nextInt();
//		xx = new Scanner( System.in );
//		int count=xx.nextInt();
//	int c=0;
//        System.out.println("100~999之间的水仙花数是：");
//        for(int custNo=n;custNo<=count;custNo++){
//            int geWei=custNo%10;
//            int shiWei=custNo/10%10;
//            int baiWei=custNo/100%10;
//            if(custNo==geWei*geWei*geWei+shiWei*shiWei*shiWei+baiWei*baiWei*baiWei){
//                System.out.print(custNo+"");
//                c++;
//            }else{
//            	
//            }
//        }
//		if(c==0)
//		{
//			System.out.println("no");
//		}
//		DecimalFormat    df   = new DecimalFormat("######0.00");   
//		new java.text.DecimalFormat("#.00").format(3.1415926);
//		//Scanner reader=new Scanner(System.in);
//        while(reader.hasNextInt()){
//            int m=reader.nextInt();
//            int n=reader.nextInt();
//            System.out.print(m);
//            System.out.println(n);
//            if(100<=m&&m<=n&&n<=999){
//                int j=0;
//                for(int i=m;i<=n;i++)
//                {
//                    int geWei,shiWei,baiWei;
//                     baiWei=i/100;
//                     shiWei=(i-baiWei*100)/10;
//                     geWei=i-baiWei*100-shiWei*10;
//                 if(i==geWei*geWei*geWei+shiWei*shiWei*shiWei+baiWei*baiWei*baiWei)
//                 {j=j+1;
//                 if(j>1){
//                     System.out.print(" "+i);
//                 }
//                 else{
//                     System.out.print(i);
//                 }
//                  
//                 }
//                             }
//                if(j==0){
//                    System.out.print("no");
//                }
//                System.out.println();
//            }
//        }
 //   }

}
