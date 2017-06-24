package com.yzu.game;

import java.util.ArrayList;

public class Game {

	String Fizz = "Fizz";
	String Buzz = "Buzz";
	String Whizz = "Whizz";
	
	public ArrayList<Object> sort(int num1,int num2,int num3){
		ArrayList<Object >  list1 = new ArrayList<Object>(100);
		for(int i = 1;i<=100;i++){
			if(i % num1 == 0 || haveNum1(i, num1)){
				list1.add(Fizz);
				if(i % num2 == 0 && !haveNum1(i, num1)){
					list1.set(i-1, Fizz+Buzz);
					if(i % num3 == 0 && !haveNum1(i, num1)){
						list1.set(i-1, Fizz+Buzz+Whizz);
					}
				}else if(i % num3 == 0 && !haveNum1(i, num1)){
					list1.set(i-1, Fizz+Whizz);
				}
			}else if(i % num2 == 0){
				list1.add(Buzz);
				if(i % num3 == 0){
					list1.set(i-1, Buzz+Whizz);
				}
			}else if(i % num3 == 0){
				list1.add(Whizz);
			}else{
				list1.add(i);
			}
		}
		return list1;
	}
	
	public boolean haveNum1(int number,int num1){
		if(number%10 == num1 || number/10%10 == num1 || number/100 == num1){
			return true;
		}else{
			return false;
		}
	}
	
}

