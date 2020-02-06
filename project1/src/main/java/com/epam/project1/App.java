package com.epam.project1;


import java.util.*;
public class App {
	public static HashMap<String,Integer> sort(HashMap<String,Integer> hm){
		List<Map.Entry<String, Integer>> list=new LinkedList<Map.Entry<String,Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> arg0,
					Map.Entry<String, Integer> arg1) {
				return (arg0.getValue()).compareTo(arg1.getValue());
			}
		});
		HashMap<String, Integer> temp=new LinkedHashMap<String,Integer>();
		for(Map.Entry<String, Integer> gift:list){
			temp.put(gift.getKey(), gift.getValue());}
		return temp;
	}

	public static void main(String[] args) {
		int candies;
		int sweets;
		System.out.println("enter the number of students:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Student s[]=new Student[n];
		for(int i=0;i<n;i++)
		{
			s[i]=new Student();
			System.out.println("enter the student name:");
			String name=sc.next();
			s[i].setName(name);
			System.out.println("enter the number of candies(each candy costs Rs.5):");
			candies=sc.nextInt();
			s[i].setCandies(candies);
			System.out.println("enter the number of sweets(each sweet costs Rs.10):");
			sweets=sc.nextInt();
			s[i].setSweets(sweets);
		}
		HashMap al=new HashMap();
		for(int i=0;i<n;i++)
		{
			al.put(s[i].getName(),new Integer(s[i].getTotalCost()));
		}
		System.out.println("Total cost of gifts per student is as follows:");
		System.out.println(al.entrySet());
		System.out.println("Sorted order according to prices is:");
		Map<String,Integer> hm=sort(al);
		for(Map.Entry<String, Integer> en:hm.entrySet()){
			System.out.println(en.getKey()+"="+en.getValue());
		}

	}
}
class Student {
int candies;
int sweets;
String name;
int tcost;
public int getTotalCost (){
	numberOfSweets s=new numberOfSweets();
	numberOfCandies c=new numberOfCandies();
	tcost=s.calculateTotalCost(sweets)+c.calculateTotalCost(candies);
	return tcost;
	
}
public void setCandies(int candies) {
	this.candies = candies;
}

public void setSweets(int sweets) {
	this.sweets = sweets;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getT_cost() {
	return tcost;
}



}
class numberOfCandies {
	int cost=5;
	int totalcost;
	public int calculateTotalCost(int candies)
	{
		totalcost=candies*cost;
		return totalcost;
	}
}
class numberOfSweets {
int cost=10;
int totalcost;
public int calculateTotalCost(int sweets)
{
	totalcost=sweets*cost;
	return totalcost;
}
}