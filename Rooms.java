package Hotel;

import java.util.ArrayList;


class Food 
{
	int itemno;
	int price;
	int quantity;
	
	Food(int itemno,int quantity)
	{
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*75;
                break;
            case 2:price=quantity*250;
                break;
            case 3:price=quantity*150;
                break;
            case 4:price=quantity*50;
                break;
        }
	}
}

class Toiletries 
{
	int itemno;
	int price;
	int quantity;
	
	Toiletries(int itemno,int quantity)
	{
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*45;
                break;
            case 2:price=quantity*35;
                break;
            case 3:price=quantity*20;
                break;
            case 4:price=quantity*25;
                break;
        }
	}
}

class Regular_Room 
{
	String name;
	String contact;
	ArrayList<Food> food = new ArrayList<>();
	ArrayList<Toiletries> toiletries = new ArrayList<>();
	
    Regular_Room()
    {
        this.name="";
    }
    Regular_Room(String name,String contact)
    {
        this.name=name;
        this.contact=contact;
    }
}

class Double_Room extends Regular_Room 
{
	
    String name2;
    String contact2; 
    
    Double_Room()
    {
        this.name="";
        this.name2="";
    }
    Double_Room(String name,String contact,String name2,String contact2)
    {
        this.name=name;
        this.contact=contact;

        this.name2=name2;
        this.contact2=contact2;
    }
}

class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return " Room not Available !";
    }
}

class holder 
{
    Double_Room Regular_Family_Room[]=new Double_Room[20];
    Double_Room Deluxe_Family_Suite[]=new Double_Room[10]; 
    Regular_Room Luxury_suite[]=new Regular_Room[10]; 
    Regular_Room Regular_room[]=new Regular_Room[20];
}


