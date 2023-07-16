package com.jspiders.buliderpattern.main;

import com.jspiders.buliderpattern.builder.MobileBuilder;
import com.jspiders.buliderpattern.object.Mobile;

public class MobileMain {

	public static void main(String[] args) {
		
		Mobile mobile = new MobileBuilder().
				brand("samsumng").model("S23").
				memory(256).colour("black").getMobile();
		
		System.out.println(mobile);
	}

}
