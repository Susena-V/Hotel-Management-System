package Hotel;

import java.util.Scanner;

class Hotel 
{
    static holder hotel_holder=new holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact;
        String name2 = null, contact2 = null; 
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        if(i<3)
        {
	        System.out.print("Enter second customer name: ");
	        name2 = sc.next();
	        System.out.print("Enter contact number: ");
	        contact2=sc.next();

        }      
        
      switch (i) 
      {
        case 1:
        	hotel_holder.Regular_Family_Room[rn]=new Double_Room(name,contact,name2,contact2);
            break;
        case 2:
        	hotel_holder.Deluxe_Family_Suite[rn]=new Double_Room(name,contact,name2,contact2);
            break;
        case 3:
        	hotel_holder.Luxury_suite[rn]=new Regular_Room(name,contact);
            break;
        case 4:
        	hotel_holder.Regular_room[rn]=new Regular_Room(name,contact);
            break;
        default:
        	System.out.println("Wrong option");
            break;
       }
    }
    
    static void bookRoom(int i)
    {
    	int j;
    	int room_no;
    	System.out.println("Choose a room number: ");
    	
    	switch(i)
    	{
    		case 1:
    			for(j=0;j<hotel_holder.Regular_Family_Room.length;j++)
    			{
    				if(hotel_holder.Regular_Family_Room[j]==null)
    				{
    					System.out.print(j+1+" ");
    				}
    			}
    			System.out.println("\nEnter number: ");
    			try{
                    room_no=sc.nextInt();
                    room_no=room_no-1;
                    if(hotel_holder.Regular_Family_Room[room_no]!=null)
                        throw new NotAvailable();
                    CustDetails(i,room_no);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                
    		case 2:
    			for(j=0;j<hotel_holder.Deluxe_Family_Suite.length;j++)
    			{
    				if(hotel_holder.Deluxe_Family_Suite[j]==null)
    				{
    					System.out.print(j+21+" ");
    				}
    			}
    			System.out.println("\nEnter number: ");
    			try{
                    room_no=sc.nextInt();
                    room_no=room_no-21;
                    if(hotel_holder.Deluxe_Family_Suite[room_no]!=null)
                        throw new NotAvailable();
                    CustDetails(i,room_no);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                    
    		case 3:
    			for(j=0;j<hotel_holder.Luxury_suite.length;j++)
    			{
    				if(hotel_holder.Luxury_suite[j]==null)
    				{
    					System.out.print(j+31+" ");
    				}
    			}
    			System.out.println("\nEnter number: ");
    			try{
                    room_no=sc.nextInt();
                    room_no=room_no-31;
                    if(hotel_holder.Luxury_suite[room_no]!=null)
                        throw new NotAvailable();
                    CustDetails(i,room_no);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;
                    
    		case 4:
       			for(j=0;j<hotel_holder.Regular_room.length;j++)
    			{
    				if(hotel_holder.Regular_room[j]==null)
    				{
    					System.out.print(j+41+" ");
    				}
    			}
    			System.out.println("\nEnter number: ");
    			try{
                    room_no=sc.nextInt();
                    room_no=room_no-41;
                    if(hotel_holder.Regular_room[room_no]!=null)
                        throw new NotAvailable();
                    CustDetails(i,room_no);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Option");
                        return;
                    }
                    break;	
                    
    		default:
    			System.out.println("Enter valid option");
    			break;                    	
    	}
    	System.out.println("Room Booked");
    }
    
    static void availability()
    {
		int j;
		int count1=0,count2=0,count3=0,count4=0;

		for(j=0;j<hotel_holder.Regular_Family_Room.length;j++)
		{
		    if(hotel_holder.Regular_Family_Room[j]==null)
		        count1++;
		}
		for(j=0;j<hotel_holder.Deluxe_Family_Suite.length;j++)
		{
		    if(hotel_holder.Deluxe_Family_Suite[j]==null)
		        count2++;
		}
		for(j=0;j<hotel_holder.Luxury_suite.length;j++)
		{
		    if(hotel_holder.Luxury_suite[j]==null)
		        count3++;
		}
		
		for(j=0;j<hotel_holder.Regular_room.length;j++)
		{
		    if(hotel_holder.Regular_room[j]==null)
		        count4++;
		}
		
		System.out.println("Regular Family Rooms : "+count1);
		System.out.println("Deluxe Family Suites : "+count2);
		System.out.println("Luxury Suites        : "+count3);
		System.out.println("Regular Rooms        : "+count4);
    }
    
    static void bill(int rn,int rtype)
    {
        double amount=0;
        System.out.println("Enter duration of stay: ");
        int duration=sc.nextInt();
        String food_list[]={"Sandwich","Pasta","Noodles","Coke"};
        String toiletries_list[]= {"Shampoo","BodyWash","Toothpaste","Toothbrush"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
            	
            	if(duration<=0)
            	{
            		amount+=9500;
            	}
            	else
            	{
            		amount+=9500*(duration);
            	}

                System.out.println("\nRoom Charge - "+amount);
                System.out.println("\n===============");
                System.out.println("Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Food f:hotel_holder.Regular_Family_Room[rn].food)
                {
                    amount+=f.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,food_list[f.itemno-1],f.quantity,f.price );
                }
                
                System.out.println("\nToiletries Charges:- ");
                System.out.println("=======================");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Toiletries t:hotel_holder.Regular_Family_Room[rn].toiletries)
                {
                    amount+=t.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,toiletries_list[t.itemno-1],t.quantity,t.price );
                }
                    
                    
                break;
                
            case 2:
	            if(duration<=0)
	        	{
	        		amount+=12000;
	        	}
	            else 
	            {
	            	amount+=12000*(duration);
	            }
	    		
                System.out.println("Room Charge - "+amount);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Food f:hotel_holder.Deluxe_Family_Suite[rn].food)
                {
                    amount+=f.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,food_list[f.itemno-1],f.quantity,f.price );
                }
                
                System.out.println("\nToiletries Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Toiletries t:hotel_holder.Deluxe_Family_Suite[rn].toiletries)
                {
                    amount+=t.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,toiletries_list[t.itemno-1],t.quantity,t.price );
                }    
                break;
                
            case 3:
	            if(duration<=0)
	        	{
	        		amount+=10000;
	        	}
	            else 
	            {
	            	amount+=10000*(duration);
	            }
                System.out.println("Room Charge - "+amount);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Food f:hotel_holder.Luxury_suite[rn].food)
                {
                    amount+=f.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,food_list[f.itemno-1],f.quantity,f.price );
                }
                
                System.out.println("\nToiletries Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Toiletries t:hotel_holder.Luxury_suite[rn].toiletries)
                {
                    amount+=t.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,toiletries_list[t.itemno-1],t.quantity,t.price );
                }  
                break;
                
            case 4:
	            if(duration<=0)
	        	{
	        		amount+=7500;
	        	}
	            else 
	            {
	            	amount+=7500*(duration);
	            }
                System.out.println("Room Charge - "+amount);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Food f:hotel_holder.Regular_room[rn].food)
                {
                    amount+=f.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,food_list[f.itemno-1],f.quantity,f.price );
                }
                
                System.out.println("\nToiletries Charges:- ");
                System.out.println("===============");
                System.out.println("Item            Quantity      Price");
                System.out.println("-----------------------------------");
                
                for(Toiletries t:hotel_holder.Regular_room[rn].toiletries)
                {
                    amount+=t.price;
                    String format = "%-20s%-10s%-10s%n";
                    System.out.printf(format,toiletries_list[t.itemno-1],t.quantity,t.price );
                }  
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }
    
    static void checkOut(int rn,int rtype)
    {
        char w;
        switch (rtype) {
            case 1:               
                if(hotel_holder.Regular_Family_Room[rn]!=null)
                    System.out.println("Room being used by "+hotel_holder.Regular_Family_Room[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Would you like to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_holder.Regular_Family_Room[rn]=null;
                    System.out.println("Checked Out succesfully");
                }
                
                break;
            case 2:
                if(hotel_holder.Deluxe_Family_Suite[rn]!=null)
                    System.out.println("Room being used by "+hotel_holder.Deluxe_Family_Suite[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Would you like to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_holder.Deluxe_Family_Suite[rn]=null;
                    System.out.println("Checked Out succesfully");
                }
                 
                break;
            case 3:
                if(hotel_holder.Luxury_suite[rn]!=null)
                    System.out.println("Room being used by "+hotel_holder.Luxury_suite[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Would you like to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_holder.Luxury_suite[rn]=null;
                    System.out.println("Checked Out succesfully");
                }
                
                break;
            case 4:
                if(hotel_holder.Regular_room[rn]!=null)
                    System.out.println("Room being used by "+hotel_holder.Regular_room[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Would you like to checkout ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_holder.Regular_room[rn]=null;
                    System.out.println("Checked Out succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{
             System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.75\n2.Pasta\t\tRs.250\n3.Noodles\tRs.150\n4.Coke\t\tRs.50\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity:- ");
            q=sc.nextInt();
           
              switch(rtype){
            case 1: hotel_holder.Regular_Family_Room[rn].food.add(new Food(i,q));
                break;
            case 2: hotel_holder.Deluxe_Family_Suite[rn].food.add(new Food(i,q));
                break;
            case 3: hotel_holder.Luxury_suite[rn].food.add(new Food(i,q));
                break;
            case 4: hotel_holder.Regular_room[rn].food.add(new Food(i,q));
                break;                                                 
        }
              System.out.println("Do you want to order anything else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println("\nRoom not booked");
            }
         catch(Exception e)
         {
             System.out.println("Cannot be done");
         }
    }
    
    static void buy(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{ 
             System.out.println("\nToiletries\n===================\n1. Shampoo\t45\n2. BodyWash\t35\n3. Toothpaste\t20\n4. Toothbrush\t25 ");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity:- ");
            q=sc.nextInt();
           
              switch(rtype){
            case 1: hotel_holder.Regular_Family_Room[rn].toiletries.add(new Toiletries(i,q));
                break;
            case 2: hotel_holder.Deluxe_Family_Suite[rn].toiletries.add(new Toiletries(i,q));
                break;
            case 3: hotel_holder.Luxury_suite[rn].toiletries.add(new Toiletries(i,q));
                break;
            case 4: hotel_holder.Regular_room[rn].toiletries.add(new Toiletries(i,q));
                break;                                                 
        }
              System.out.println("Do you want to buy anything else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println("\nRoom not booked");
            }
         catch(Exception e)
         {
             System.out.println("Cannot be done");
         }
    }
}