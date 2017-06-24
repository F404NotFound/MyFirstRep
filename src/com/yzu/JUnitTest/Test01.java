package com.yzu.JUnitTest;

import java.util.ArrayList;

import com.yzu.game.Game;

import junit.framework.TestCase;

public class Test01 extends TestCase{
	Game game ;
	@Override  
    protected void setUp() throws Exception  
    {  
        super.setUp();  
        game = new Game();  
    }  
  
    @Override  
    protected void tearDown() throws Exception  
    {  
        super.tearDown();  
    }  
    
    public void testSort(){
    	ArrayList<Object> list = game.sort(3, 5, 7);
    	assertEquals("Fizz", list.get(2));
    	assertEquals("FizzBuzz", list.get(14));
    	assertEquals("FizzWhizz", list.get(20));
    	assertEquals("BuzzWhizz", list.get(69));
    	assertEquals("Fizz", list.get(30));
    	assertEquals(1, list.get(0));
    }

}
