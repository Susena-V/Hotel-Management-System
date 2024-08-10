package Hotel;

import java.util.Scanner;

public class Hotel_Main 
{
	public static void main(String args[]) {
		
		System.out.println("...................................................");
		System.out.println("Welcome to Green Paradise Hotel!");
		System.out.println("...................................................");
		System.out.println("The Rooms that we offer are:");
		System.out.println("Regular Family Room    Daily Price:9500");
		System.out.println("Deluxe Family Suite    Daily Price:12000");
		System.out.println("Luxury Suite           Daily Price:10000");
		System.out.println("Regular Room           Daily Price:7500");
		System.out.println("...................................................");
		System.out.println("Choose the service you want to avail from our Menu");
		System.out.println("...................................................");
		
        Scanner sc = new Scanner(System.in);
        int ch,ch2;        
        int val=1;
        
        while(val==1)
        {
        	System.out.println("\nEnter your choice :\n1.Display room availability \n2.Book\n3.Order food\n4.Buy toiletries\n5.Checkout\n6.Exit\n");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                        Hotel.availability();
                    break;
                case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                         ch2 = sc.nextInt();
                         Hotel.bookRoom(ch2);                     
                    break;
                case 3:
                     System.out.print("Room Number:- ");
                         ch2 = sc.nextInt();
                         if(ch2>60)
                             System.out.println("Room doesn't exist");
                         else if(ch2>40)
                             Hotel.order(ch2-41,4);
                         else if(ch2>30)
                             Hotel.order(ch2-31,3);
                         else if(ch2>20)
                             Hotel.order(ch2-21,2);
                         else if(ch2>0)
                             Hotel.order(ch2-1,1);
                         else
                             System.out.println("Room doesn't exist");
                         break;
                         
                case 4:
                    System.out.print("Room Number:- ");
                    ch2 = sc.nextInt();
                    if(ch2>60)
                        System.out.println("Room doesn't exist");
                    else if(ch2>40)
                        Hotel.buy(ch2-41,4);
                    else if(ch2>30)
                        Hotel.buy(ch2-31,3);
                    else if(ch2>20)
                        Hotel.buy(ch2-21,2);
                    else if(ch2>0)
                        Hotel.buy(ch2-1,1);
                    else
                        System.out.println("Room doesn't exist");
                    break;
                case 5:                 
                    System.out.print("Room Number:- ");
                         ch2 = sc.nextInt();
                         if(ch2>60)
                             System.out.println("Room doesn't exist");
                         else if(ch2>40)
                             Hotel.checkOut(ch2-41,4);
                         else if(ch2>30)
                             Hotel.checkOut(ch2-31,3);
                         else if(ch2>20)
                             Hotel.checkOut(ch2-21,2);
                         else if(ch2>0)
                             Hotel.checkOut(ch2-1,1);
                         else
                             System.out.println("Room doesn't exist");
                         break;
                case 6:
                	val=0;
                	break;
                    
            }
      
        } 
	}
}
