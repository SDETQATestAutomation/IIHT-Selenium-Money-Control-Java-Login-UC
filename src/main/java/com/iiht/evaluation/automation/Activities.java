package com.iiht.evaluation.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activities{

    public static boolean open_login_panel(WebDriver driver) {
        WebElement user_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_link"));
        if (user_link_element == null) {
            return false;
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(user_link_element).perform();
        WebElement login_signup_box_element = SubActivities.find_element_use_xpath(driver,
                locators.money_control_element.get("login_signup_box"));
        if (login_signup_box_element == null) {
            return false;
        }
        boolean login_signup_box_element_display = login_signup_box_element.isDisplayed();
        System.out.println("login_signup_box_element_display " + login_signup_box_element_display);
        if (!login_signup_box_element_display) {
            return false;
        }
        return true;
    }

    public static boolean switch_to_signin_iframe(WebDriver driver) {
        WebElement login_signin_iframe_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_signin_iframe"));
        if (login_signin_iframe_element == null) {
            return false;
        }
        driver.switchTo().frame(login_signin_iframe_element);
        return true;
    }

    public static boolean open_signin_box(WebDriver driver) {
        WebElement signup_box_login_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signup_box_login_link"));
        if (signup_box_login_link_element == null) {
            return false;
        }
        signup_box_login_link_element.click();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement login_signin_box_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_signin_box"));
        if (login_signin_box_element == null) {
            return false;
        }
        return true;
    }

    public static boolean signin_box_enter_email(WebDriver driver, String email) {
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_email_field_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_email_field"));
        if (signin_box_email_field_element == null) {
            return false;
        }
        signin_box_email_field_element.sendKeys(email);
        return true;
    }

    public static boolean signin_box_enter_password(WebDriver driver, String password) {
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_password_field_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_password_field"));
        if (signin_box_password_field_element == null) {
            return false;
        }
        signin_box_password_field_element.sendKeys(password);
        return true;
    }

    public static boolean signin_box_click_login_button(WebDriver driver) {
        boolean login_signin_box_not_present = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_login_button_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_login_button"));
        if (signin_box_login_button_element == null) {
            return false;
        }
        signin_box_login_button_element.click();

        try {
            login_signin_box_not_present = SubActivities.wait_for_element_not_present(driver, locators.money_control_element.get("login_signin_box"));
            System.out.println("login_signin_box_not_present " + login_signin_box_not_present);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.switchTo().defaultContent();
            return login_signin_box_not_present;
        }
    }

    public static boolean signin_box_click_login_button_except_error(WebDriver driver) {
        boolean login_signin_box_present = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_login_button_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_login_button"));
        if (signin_box_login_button_element == null) {
            return false;
        }
        signin_box_login_button_element.click();

        try {
            login_signin_box_present = SubActivities.wait_for_element_present(driver, locators.money_control_element.get("login_signin_box"));
            System.out.println("login_signin_box_present " + login_signin_box_present);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.switchTo().defaultContent();
            return login_signin_box_present;
        }
    }

    public static boolean signin_box_check_error(WebDriver driver, String error_message) {
        boolean is_error_message_checked = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_error_div_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_error_div"));
        if (signin_box_error_div_element == null) {
            return false;
        }
        String signin_box_error_div_element_text = signin_box_error_div_element.getText();
        System.out.println("signin_box_error_div_element_text " + signin_box_error_div_element_text);
        if (signin_box_error_div_element_text.equals(error_message)) {
            is_error_message_checked = true;
        }
        return is_error_message_checked;
    }

    public static boolean check_logged_in_user(WebDriver driver, String email) {
        boolean is_email_checked = false;
        WebElement logged_in_user_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("logged_in_user_link"));
        if (logged_in_user_link_element == null) {
            return false;
        }
        String logged_in_user_link_title_attribute = logged_in_user_link_element.getAttribute("title");
        System.out.println("logged_in_user_link_title_attribute " + logged_in_user_link_title_attribute);
        if (logged_in_user_link_title_attribute.trim().toLowerCase().equals(email)) {
            is_email_checked = true;
        }
        return is_email_checked;
    }



}


