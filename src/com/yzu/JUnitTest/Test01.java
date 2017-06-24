package com.yzu.JUnitTest;

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
    
    public void testHaveNum1(){
    	assertTrue(game.haveNum1(23, 3));
    }
    
    public void testSort(){
    	
    }
}
