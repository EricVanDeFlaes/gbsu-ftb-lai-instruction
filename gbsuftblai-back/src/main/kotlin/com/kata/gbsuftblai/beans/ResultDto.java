package com.kata.gbsuftblai.beans;

import java.io.Serializable;

public class ResultDto   implements Serializable{
	
	private static final long serialVersionUID = 1641998425012927954L;
	
	private String result;
	
	public ResultDto(){
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
