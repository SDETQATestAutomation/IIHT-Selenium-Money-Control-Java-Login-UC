package com.iiht.evaluation.automation.functional;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.App;
import com.iiht.evaluation.automation.testutils.MasterData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import com.iiht.evaluation.automation.SubActivities;
import org.testng.annotations.*;

import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;

public class TestAutomation extends App {

    @Test
    public static void test_login_uc_open_login_panel() throws IOException {
        boolean testcase_status = true;
        try {
            boolean open_login_panel_succeed = Activities.open_login_panel(driver);
            System.out.println("open_login_panel_succeed " + open_login_panel_succeed);
            if (!open_login_panel_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_login_uc_open_signin_box() throws IOException {
        boolean testcase_status = true;
        try {
            boolean open_signin_box_succeed = Activities.open_signin_box(driver);
            System.out.println("open_signin_box_succeed " + open_signin_box_succeed);
            if (!open_signin_box_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_login_uc_enter_email() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_success_login_master_data.get("email");
        try {
            boolean signin_box_enter_email_succeed = Activities.signin_box_enter_email(driver, email);
            System.out.println("signin_box_enter_email_succeed " + signin_box_enter_email_succeed);
            if (!signin_box_enter_email_succeed) {
                testcase_status = false;
            }

            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_login_uc_enter_password() throws IOException {
        boolean testcase_status = true;
        String password = MasterData.test_success_login_master_data.get("password");
        try {
            boolean signin_box_enter_password_succeed = Activities.signin_box_enter_password(driver, password);
            System.out.println("signin_box_enter_password_succeed " + signin_box_enter_password_succeed);
            if (!signin_box_enter_password_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_login_uc_click_login_button() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_success_login_master_data.get("email");
        String password = MasterData.test_success_login_master_data.get("password");
        try {
            boolean signin_box_click_login_button_succeed = Activities.signin_box_click_login_button(driver);
            System.out.println("signin_box_click_login_button_succeed " + signin_box_click_login_button_succeed);
            if (!signin_box_click_login_button_succeed) {
                testcase_status = false;
            }

            if (testcase_status) {
                boolean check_logged_in_user_succeed = Activities.check_logged_in_user(driver, email);
                System.out.println("check_logged_in_user_succeed " + check_logged_in_user_succeed);
                if (!check_logged_in_user_succeed) {
                    testcase_status = false;
                }
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_login_uc_check_logged_in_user() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_success_login_master_data.get("email");
        try {
            boolean check_logged_in_user_succeed = Activities.check_logged_in_user(driver, email);
            System.out.println("check_logged_in_user_succeed " + check_logged_in_user_succeed);
            if (!check_logged_in_user_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    public static void test_failure_login_uc_enter_email() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_failure_login_master_data.get("email");
        String password = MasterData.test_failure_login_master_data.get("password");
        String error_message = MasterData.test_failure_login_master_data.get("error_message");
        try {
            boolean signin_box_enter_email_succeed = Activities.signin_box_enter_email(driver, email);
            System.out.println("signin_box_enter_email_succeed " + signin_box_enter_email_succeed);
            if (!signin_box_enter_email_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public static void test_failure_login_uc_enter_password() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_failure_login_master_data.get("email");
        String password = MasterData.test_failure_login_master_data.get("password");
        String error_message = MasterData.test_failure_login_master_data.get("error_message");
        try {
            boolean signin_box_enter_password_succeed = Activities.signin_box_enter_password(driver, password);
            System.out.println("signin_box_enter_password_succeed " + signin_box_enter_password_succeed);
            if (!signin_box_enter_password_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public static void test_failure_login_uc_click_login_button_except_error() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_failure_login_master_data.get("email");
        String password = MasterData.test_failure_login_master_data.get("password");
        String error_message = MasterData.test_failure_login_master_data.get("error_message");
        try {
            boolean signin_box_click_login_button_except_error_succeed = Activities.signin_box_click_login_button_except_error(driver);
            System.out.println("signin_box_click_login_button_except_error_succeed " + signin_box_click_login_button_except_error_succeed);
            if (!signin_box_click_login_button_except_error_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public static void test_failure_login_uc_check_error() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_failure_login_master_data.get("email");
        String password = MasterData.test_failure_login_master_data.get("password");
        String error_message = MasterData.test_failure_login_master_data.get("error_message");
        try {
            boolean signin_box_check_error_succeed = Activities.signin_box_check_error(driver, error_message);
            System.out.println("signin_box_check_error_succeed " + signin_box_check_error_succeed);
            if (!signin_box_check_error_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }



    /**********************************************************************/
    @Test
    public static void test_success_login() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_success_login_master_data.get("email");
        String password = MasterData.test_success_login_master_data.get("password");
        try {
            boolean open_login_panel_succeed = Activities.open_login_panel(driver);
            System.out.println("open_login_panel_succeed " + open_login_panel_succeed);
            if (!open_login_panel_succeed) {
                testcase_status = false;
            }
            if (testcase_status) {
                boolean open_signin_box_succeed = Activities.open_signin_box(driver);
                System.out.println("open_signin_box_succeed " + open_signin_box_succeed);
                if (!open_signin_box_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_enter_email_succeed = Activities.signin_box_enter_email(driver, email);
                System.out.println("signin_box_enter_email_succeed " + signin_box_enter_email_succeed);
                if (!signin_box_enter_email_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_enter_password_succeed = Activities.signin_box_enter_password(driver, password);
                System.out.println("signin_box_enter_password_succeed " + signin_box_enter_password_succeed);
                if (!signin_box_enter_password_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_click_login_button_succeed = Activities.signin_box_click_login_button(driver);
                System.out.println("signin_box_click_login_button_succeed " + signin_box_click_login_button_succeed);
                if (!signin_box_click_login_button_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean check_logged_in_user_succeed = Activities.check_logged_in_user(driver, email);
                System.out.println("check_logged_in_user_succeed " + check_logged_in_user_succeed);
                if (!check_logged_in_user_succeed) {
                    testcase_status = false;
                }
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), false, businessTestFile);
        }
    }


    @Test
    public static void test_failure_login() throws IOException {
        boolean testcase_status = true;
        String email = MasterData.test_failure_login_master_data.get("email");
        String password = MasterData.test_failure_login_master_data.get("password");
        String error_message = MasterData.test_failure_login_master_data.get("error_message");
        try {
            boolean open_login_panel_succeed = Activities.open_login_panel(driver);
            System.out.println("open_login_panel_succeed " + open_login_panel_succeed);
            if (!open_login_panel_succeed) {
                testcase_status = false;
            }
            if (testcase_status) {
                boolean open_signin_box_succeed = Activities.open_signin_box(driver);
                System.out.println("open_signin_box_succeed " + open_signin_box_succeed);
                if (!open_signin_box_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_enter_email_succeed = Activities.signin_box_enter_email(driver, email);
                System.out.println("signin_box_enter_email_succeed " + signin_box_enter_email_succeed);
                if (!signin_box_enter_email_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_enter_password_succeed = Activities.signin_box_enter_password(driver, password);
                System.out.println("signin_box_enter_password_succeed " + signin_box_enter_password_succeed);
                if (!signin_box_enter_password_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_click_login_button_except_error_succeed = Activities.signin_box_click_login_button_except_error(driver);
                System.out.println("signin_box_click_login_button_except_error_succeed " + signin_box_click_login_button_except_error_succeed);
                if (!signin_box_click_login_button_except_error_succeed) {
                    testcase_status = false;
                }
            }
            if (testcase_status) {
                boolean signin_box_check_error_succeed = Activities.signin_box_check_error(driver, error_message);
                System.out.println("signin_box_check_error_succeed " + signin_box_check_error_succeed);
                if (!signin_box_check_error_succeed) {
                    testcase_status = false;
                }
            }
            System.out.println("testcase_status " + testcase_status);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//			yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }


}

