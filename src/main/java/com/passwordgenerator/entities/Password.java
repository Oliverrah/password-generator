package com.passwordgenerator.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Password {
	
	@NotNull
	@Size(min = 4, max = 100)
	private Integer passwordLenght;
	private Boolean uppercaseLetters;
	private Boolean lowercaseLetters;
	private Boolean numbers;
	private Boolean specialCharacters;
	private String result;
	
	public Integer getPasswordLenght() {
		return passwordLenght;
	}

	public void setPasswordLenght(Integer passwordLenght) {
		this.passwordLenght = passwordLenght;
	}

	public Boolean getUppercaseLetters() {
		return uppercaseLetters;
	}

	public void setUppercaseLetters(Boolean uppercaseLetters) {
		this.uppercaseLetters = uppercaseLetters;
	}

	public Boolean getLowercaseLetters() {
		return lowercaseLetters;
	}

	public void setLowercaseLetters(Boolean lowercaseLetters) {
		this.lowercaseLetters = lowercaseLetters;
	}

	public Boolean getNumbers() {
		return numbers;
	}

	public void setNumbers(Boolean numbers) {
		this.numbers = numbers;
	}

	public Boolean getSpecialCharacters() {
		return specialCharacters;
	}

	public void setSpecialCharacters(Boolean specialCharacters) {
		this.specialCharacters = specialCharacters;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}