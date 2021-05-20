package com.loginportal.forgotpassword.model;

import java.util.ArrayList;
import java.util.List;

public class SecurityQuestionList {
	private List<SecurityQuestion> sq;

	public SecurityQuestionList() {
		sq = new ArrayList<SecurityQuestion>();
	}

	public List<SecurityQuestion> getSq() {
		return sq;
	}

	public void setSq(List<SecurityQuestion> sq) {
		this.sq = sq;
	}

}
