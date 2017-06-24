package com.yzu.game;

import java.util.ArrayList;

public class Game {
	
	public ArrayList<Object> sort(int num1,int num2,int num3){
		ArrayList<Object> list = new ArrayList<>();
		
		//8个标志位代表不同单词
		 String[] name = new String[8];
	     name[1] = "Fizz";
	     name[2] = "Buzz";
	     name[3] = "FizzBuzz";
	     name[4] = "Whizz";
	     name[5] = "FizzWhizz";
	     name[6] = "BuzzWhizz";
	     name[7] = "FizzBuzzWhizz";
		
		int[] resultInt = new int[101];
		
		setResult(num1, 1, resultInt);
		setResult(num2, 2, resultInt);
		setResult(num3, 4, resultInt);
		
		//将十位数或者个位数中含有num1的标志改成1
		 for (int i = 0; i < 10; i++){
             resultInt[num1 * 10 + i] = resultInt[i * 10 + num1] = 1;
         }
		 
		 for (int j = 1; j < 101; j++){
             if (resultInt[j] == 0)
                 list.add(j);
             else
                 list.add(name[resultInt[j]]);

         }
     
		return list;
	}
	
	//为每个数字设定相应的标志
	void setResult(int a, int b, int[] resultInt){
        for (int i = 1, l = 100 / a + 1; i < l; i++){
            resultInt[a * i] += b;
        }
    }
	
	
	
}

