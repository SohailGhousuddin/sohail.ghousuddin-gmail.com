package com.mastercard.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastercard.challenge.service.RoadService;


@SpringBootTest
class Solution11ApplicationTests {

	@Autowired
	private RoadService roadService;
	@BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }


	
	
    @Test
    void testInitialize() 
    {
        System.out.println("======Initialize test case =======");
        String data = " Boston, New York\n" + 
        		" Philadelphia, Newark\n" + 
        		" Newark, Boston\n" + 
        		" Trenton, Albany\n" + 
        		" Trenton, Boston";
        roadService.initialize(data);
    }
    
    @Test
    void testgetConnectedYES() 
    {
    	System.out.println("======getConnectedYES test case =======");
        String res = roadService.getConnection("Boston","Philadelphia");
        assertEquals("YES",res);
    }
    
    @Test
    void testgetConnectedNO() 
    {
    	System.out.println("======getConnectedNO test case =======");
        String res = roadService.getConnection("Boston","Jersey");
        assertEquals("NO",res);
    }

}
