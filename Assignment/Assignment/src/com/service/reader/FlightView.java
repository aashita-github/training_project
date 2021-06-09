package com.service.reader;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author aashita
 *Comparator to compare enteries by fare or duration as specified.
 */
public class FlightView {

    public static void viewFlightsByFare(List<Flight> unsortedlistbyfare) {
        int flag=0;
        try{List<Flight> list1 = unsortedlistbyfare.stream()
		        .sorted(new Comparator<Flight>() {
		            @Override
		            public int compare(Flight o1, Flight o2) {
		                if(o1.getFare() == o2.getFare())
		                    return o1.getFlightNo().compareTo(o2.getFlightNo());
		                else if(o1.getFare() > o2.getFare())
		                    return 1;
		                else return -1;
		            }
		        })
		        .collect(Collectors.toList());
        System.out.println("\n \t\t ***** FLIGHT INFORMATION *****");
        System.out.println("FLIGHT_NO|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FARE  |FLIGHT_DURN|\n");
        for(Flight b:list1){
        
            flag=1;
            if(b.getClassType().equals("B"))
            {
            	 System.out.println(b.getFlightNo()+"\t |"+b.getDepLoc()+"\t | "+b.getArrLoc()+"\t |"+b.getValidTill()+"| "+b.getFlightTime()+"\t |"+(b.getFare()*1.4)+"\t| "+b.getFlightDur()+"\t|");
            }
            System.out.println(b.getFlightNo()+"\t |"+b.getDepLoc()+"\t | "+b.getArrLoc()+"\t |"+b.getValidTill()+"| "+b.getFlightTime()+"\t |"+(b.getFare())+"\t| "+b.getFlightDur()+"\t|");
        }
        
       
        if(flag==0)
        {
            System.out.println("Flights Not Available.");
        }
        }
        catch(java.lang.NullPointerException e) {
        	System.out.println("\nArrival and Departure location not present!\n");
        }
       

    }
    public static void viewFlightsByTime(List<Flight> unsortedlistbytime) {
    	int flag=0;
    	try{List<Flight> list2 = unsortedlistbytime.stream()
		        .sorted(new Comparator<Flight>() {
		            @Override
		            public int compare(Flight o1, Flight o2) {
		                if(o1.getFlightDur() == o2.getFlightDur())
		                    return o1.getFlightNo().compareTo(o2.getFlightNo());
		                else if(o1.getFlightDur() > o2.getFlightDur())
		                    return 1;
		                else return -1;
		            }
		        })
		        .collect(Collectors.toList());
    	System.out.println("\n \t\t ***** FLIGHT INFORMATION *****");
        System.out.println("FLIGHT_NO|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FARE  |FLIGHT_DURN|\n");
    	 for(Flight b:list2){
         	flag=2;
         	
            
             if(b.getClassType().equals("B"))
             {
             	System.out.println(b.getFlightNo()+"\t |"+b.getDepLoc()+"\t | "+b.getArrLoc()+"\t |"+b.getValidTill()+"| "+b.getFlightTime()+"\t |"+(b.getFare()*1.4)+"\t| "+b.getFlightDur()+"\t|");
             }
             System.out.println(b.getFlightNo()+"\t |"+b.getDepLoc()+"\t | "+b.getArrLoc()+"\t |"+b.getValidTill()+"| "+b.getFlightTime()+"\t |"+(b.getFare())+"\t| "+b.getFlightDur()+"\t|");
         }
        
         if(flag==0)
         {
             System.out.println("Flights Not Available.");
         }
    	}
    	catch(java.lang.NullPointerException e) {
    		System.out.println("Arrival and Departure location not present!");
    	}
    }
}
