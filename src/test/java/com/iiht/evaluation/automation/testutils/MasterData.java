package com.iiht.evaluation.automation.testutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterData {
	public static final Map<String, String> test_success_login_master_data = new HashMap<>();
	public static final Map<String, String> test_failure_login_master_data = new HashMap<>();
	
	static {
		test_success_login_master_data.put("email","prashant.ranjan.qa@gmail.com");
		test_success_login_master_data.put("password","igetup@7AM");

		/* **********************************/
		test_failure_login_master_data.put("email","prashant.ranjan.qa@gmail.commmmm");
		test_failure_login_master_data.put("password","igetup@7AMmmmmmm");
		test_failure_login_master_data.put("error_message","Invalid User Id/EmailID or Password. Please try again.");

	}
}
