package com.bishwajit.vikram.utilities;

import java.util.UUID;

/**
 * 
 * @author Bishwajit
 *
 */
public class UUIDConversion {
	
	public static void main(String[] args) {
		checkUUID(null);
		checkUUID("null");
		checkUUID("Vikram");
		
		checkUUID(UUID.randomUUID().toString());
		checkUUID(UUID.randomUUID().toString() + "_Vikram");
	}

	private static void checkUUID(String str) {
		System.out.println("\nValue received ::::::: " + str);
		UUID finalValue = null;
		try {
			finalValue = UUID.fromString(str);
		} catch (Exception e) {
			System.err.println("ERROR!!!!");
		}
		
		isUUID(finalValue);
		
	}

	private static void isUUID(UUID finalValue) {
		if (null != finalValue) {
			System.out.println("Value = " + finalValue);
		} else {
			System.out.println("It's a null!!!");
		}
	}
}
