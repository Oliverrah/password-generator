package com.passwordgenerator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class PasswordUtils {
	
	private static List<Character> listOfLowerLetters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
														'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z');
	
	private static List<Character> listOfUpperLetters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
														'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z');
											
	private static List<Character> listOfNumbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
	
	private static List<Character> listOfSpecialCharacters = Arrays.asList('!', '@', '#', '$', '%', '&', '*', ')', '(');
			
	
	public static String generateRandomPassword(int passwordLenght, boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters){	
		String result = "";
		if(passwordLenght < 4 || lowerCase == false && upperCase == false && numbers == false && specialCharacters == false) {
			throw new RuntimeException("Password should have four or more characteres and at least one parameter must be selected");
		}
		
		else {
			List<Character> finalPassword = new ArrayList<>();
			
			if(allTrue(lowerCase, upperCase, numbers, specialCharacters)) {	
					
				//getting a random index and putting on the final list	
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters)); 
					
				
				//making a list of the elements 
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noLowerLetters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noUpperLetters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters));  
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);			
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noNumbers(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noSpecialCharacters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfNumbers));
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noLetters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters));
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}

			else if(noNumbersAndSpecial(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			else if(noNumbersAndUpper(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters));
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			else if(noNumberAndLower(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			else if(noSpecialAndUpper(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters));  
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(noSpecialAndLower(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(onlySpecialCharacters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfSpecialCharacters));
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(onlyNumbers(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfNumbers)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(onlyUpperLetters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfUpperLetters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			else if(onlyLowerLetters(lowerCase, upperCase, numbers, specialCharacters)) {
				finalPassword.add(generateRandonIndex(listOfLowerLetters)); 
				
				List<Character> allElements = generateAllElements(lowerCase, upperCase, numbers, specialCharacters);		
				for(int i = finalPassword.size(); i < passwordLenght; i ++) {
					Random random = new Random();
					int index = random.nextInt(allElements.size());
					finalPassword.add(allElements.get(index));
				}
			}
			
			Collections.shuffle(finalPassword);
		
			for (Character c : finalPassword) {
				result += c;
			}
			
		}
		
		return result;

	}
	
	public static boolean allTrue(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == true && numbers == true && specialCharacters == true; 
			
	}
	
	public static boolean noLowerLetters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == true && numbers == true && specialCharacters == true;	
	}
	
	public static boolean noUpperLetters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == false && numbers == true && specialCharacters == true;
	}
	
	public static boolean noNumbers(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == true && numbers == false && specialCharacters == true;			
	}
	
	public static boolean noSpecialCharacters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == true && numbers == true && specialCharacters == false;			
	}
	
	public static boolean noNumbersAndSpecial(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == true && numbers == false && specialCharacters == false;		
	}
	
	public static boolean noNumbersAndUpper(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == false && numbers == false && specialCharacters == true;

	}
	public static boolean noNumberAndLower(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == true && numbers == false && specialCharacters == true;
	}
	
	public static boolean noSpecialAndUpper(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == false && numbers == true && specialCharacters == false;
	}
	public static boolean noSpecialAndLower(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == true && numbers == true && specialCharacters == false;
	}
		
	public static boolean noLetters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == false && numbers == true && specialCharacters == true;
	}
	
	public static boolean onlySpecialCharacters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == false && numbers == false && specialCharacters == true;
	}

	public static boolean onlyNumbers(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == false && numbers == true && specialCharacters == false;
	}
	
	public static boolean onlyUpperLetters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == false && upperCase == true && numbers == false && specialCharacters == false;
	}
	
	public static boolean onlyLowerLetters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == false && numbers == false && specialCharacters == false;
	}

	public static boolean noNumbersAndSpecialCharacters(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters) {
		return lowerCase == true && upperCase == true && numbers == false && specialCharacters == false;
	}

	public static char generateRandonIndex(List<Character> list) {
		Random random = new Random();
		int index = random.nextInt(list.size());
		return list.get(index);
	}
	
	public static List<Character> generateAllElements(boolean lowerCase, boolean upperCase, boolean numbers, boolean specialCharacters){
		List<Character> allElements = new ArrayList<>();
		if(allTrue(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfNumbers);
			allElements.addAll(listOfSpecialCharacters);
		}
		else if(noLowerLetters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfNumbers);
			allElements.addAll(listOfSpecialCharacters);
		}
		else if(noUpperLetters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfNumbers);
			allElements.addAll(listOfSpecialCharacters);
		}
		
		else if(noNumbers(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfSpecialCharacters);
		}
		
		else if(noSpecialCharacters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfNumbers);
		}
		
		else if(noLetters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfNumbers);
			allElements.addAll(listOfSpecialCharacters);
		}

		else if(noNumbersAndSpecial(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfUpperLetters);
		}
		else if(noNumbersAndUpper(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfSpecialCharacters);
		}
		else if(noNumberAndLower(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfSpecialCharacters);
		}
		else if(noSpecialAndUpper(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
			allElements.addAll(listOfNumbers);
		}
		
		else if(noSpecialAndLower(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfUpperLetters);
			allElements.addAll(listOfNumbers);
		}
		
		else if(onlySpecialCharacters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfSpecialCharacters);
		}
		
		else if(onlyNumbers(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfNumbers);
		}
		
		else if(onlyUpperLetters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfUpperLetters);
		}
		
		else if(onlyLowerLetters(lowerCase, upperCase, numbers, specialCharacters)) {
			allElements.addAll(listOfLowerLetters);
		}
		
		return allElements;
	}
}
