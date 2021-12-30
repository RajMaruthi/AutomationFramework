package org.honeywell.Trace.testcase_scripts;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.honeywell.Trace.common_methods.GenricApplicationMethods;
import org.honeywell.Trace.driver.DriverScript;
import org.honeywell.Trace.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Engineering_Anomaly_TestCases {

	// Assign of created IE driver browser object
	WebDriver obrowser = null;
	GenricApplicationMethods oGenericAppmethods = new GenricApplicationMethods();
	DriverScript oDriver = new DriverScript();
	Utility appInd = new Utility();
	String strTCID = oDriver.getTestcaseId();
	String strStatus = null;

	int count;
	long start;
	long end;
	long totalTime;
	String newTotalTime;



	
	/********************************
	 * Method Name : TC_Loginscreen Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */

	
	/********************************
	 * Method Name : TC_Loginscreen Purpose : This method will launch the home
	 * screen Author : Vijay k Reviewer : Date of Creation : 21-Nov-2018 Date of
	 * modification ******************************
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> Login() {	
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_Loginscreen:- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
						// ########################################################################
						// Set the username value
						strStatus += String.valueOf(
								appInd.clearAndSetObject(obrowser, "Login_txtbx_Username", oinpuTDtMap.get("Param_1")));
						// Set the Password value
						strStatus += String.valueOf(
								appInd.clearAndSetObject(obrowser, "Login_txtbx_Password", oinpuTDtMap.get("Param_2")));
						// click on the ok button
						By byclickOnLogin_btn_OK = appInd.createAndGetByObject("Login_btn_OK");
						WebElement element = obrowser.findElement(byclickOnLogin_btn_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
						boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 600);
						String ur=obrowser.getCurrentUrl();
	              		if (ur.contains("home")) {
							appInd.writeLog("Fail", "'TC_Loginscreen' script was failed");
							bolstatus = false;
							strStatus += false;
						}
						 else {
							 bolstatus = true;
								strStatus += true;	 
						 }
						
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Loginscreen_invalidCredential_Fail_snapshot.png");
							System.out.println("System.getProperty(\"user.dir\"):::" +System.getProperty("user.dir"));
							appInd.writeLog("Fail", "'TC_Loginscreen' script was failed");
							bolstatus = false;
							strStatus = null;
						} else if (strStatus.contains("true")) {
							appInd.writeLog("Pass", "'TC_Loginscreen' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
					}
				} else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					//oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					//oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					//oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					//oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
			
		} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_Loginscreen' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
		}
}

	/********************************
	 * Method Name : Logout Purpose : This method will logout the application screen
	 * Author : Vijay k Reviewer : Date of Creation : 30-Oct-2018 Date of
	 * modification :
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> Logout() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		try {
			appInd.writeLog("#", "****TC_Loginscreen:- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));
				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {

						By logout = appInd.createAndGetByObject("Logout");
						WebElement elementbylogout = obrowser.findElement(logout);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementbylogout);
						if (elementbylogout != null) {
							strStatus += "true";
						} else {

							strStatus += "false";
						}
						// strStatus += String.valueOf(appInd.clickObject(obrowser, "Logout"));
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser,
									System.getProperty("user.dir") + "\\Results\\snapshot\\Engineering_Anomaly\\Logout_Fail_snapshot.png");
							appInd.writeLog("Fail", "'TC_Logout' script was failed");
							bolstatus = false;
							strStatus = null;
						} else if (strStatus.contains("true")) {
							appInd.writeLog("Pass", "'TC_Logout' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
					}
				} else {
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
				} else {
					oinpuTDtMap.put("result", "Skip");
				}
				oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
		} catch (Exception e) {
			try {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Logout_Fail_dueTo_Exception_snapshot.png");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			appInd.writeLog("Exception", "Exception while executing 'TC_Logout' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			oinputMap.put("result", (HashMap) oinpuTDtMap);
			return oinputMap;
		}
	}

	/********************************
	 * Method Name : TC_EngineeringAnomaly_SaveFilter Purpose : This method will Save Filter
	 * in Engineering Anomaly Author : Rajashree Reviewer : Date of Creation : 24-Jan-2019
	 */

//==============Engineering Anamoly TestCases============

@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_EngineeringAnomaly_SaveFilter() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	Map<Integer, String> outputMap = new HashMap<Integer, String>();
	double pageLoadTime_Seconds=0;
	double totaltime;
	String strProjectName = null;
	String	strcommonCountvalue=null;
	String systemName = null;
	String strcurrentTD = null;
	try {
		System.out.println("**************Engineering_Anamoly***********");
		appInd.writeLog("#", "****TC_EngineeringAnomaly_SaveFilter:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		System.out.println("oinputMap.tostring::" +oinputMap.toString());
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));
			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################
								// click on menu bar and click on Query option
					
					By byClickOnMenuBar = appInd.createAndGetByObject("Menu_Bar");
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Dashboard")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Engineering Anomaly")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
					
					// ########################################################################
					  strProjectName  = oinpuTDtMap.get("Param_1"); 
					  System.out.println(strProjectName);
					  String param9= oinpuTDtMap.get("Param_9");
					  System.out.println("param9::" +param9);
					  
					    By select_DropDown = appInd.createAndGetByObject("E_Anamoly");
						WebElement select_System_DropDown = obrowser.findElement(select_DropDown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
						Thread.sleep(2000);
						
						By systems = appInd.createAndGetByObject("Change_Detection_SystemNames");
						List<WebElement> system_elements = obrowser.findElements(systems);
						
						for(int k=0;k<system_elements.size();k++) {
							try {
								//System.out.println("System : "+systemName);
								//system_elements.get(i).click();
								system_elements = obrowser.findElements(systems);
								systemName = system_elements.get(k).getText(); 
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",system_elements.get(k));
								Thread.sleep(4000);								
								By filter_image = appInd.createAndGetByObject("Anomaly_Filter_image");
								WebElement anomaly_Filter_image = obrowser.findElement(filter_image);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_Filter_image);
								Thread.sleep(5000);
								
								By checkBox_List = appInd.createAndGetByObject("AnomalyName_CheckBox_List");
								List<WebElement> anomalyName_CheckBox_List = obrowser.findElements(checkBox_List);
								
								for(int i=0;i<2;i++) {
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_CheckBox_List.get(i));
									Thread.sleep(5000);
								}
								
								appInd.clearAndSetObject(obrowser, "Anomaly_Filter_Name", oinpuTDtMap.get("Param_1"));
								
								appInd.clearAndSetObject(obrowser, "Anomaly_Filter_Description", oinpuTDtMap.get("Param_2"));
								
								By saveFilter_Button = appInd.createAndGetByObject("Anomaly_SaveFilter_Button");
								WebElement anomaly_SaveFilter_Button = obrowser.findElement(saveFilter_Button);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_SaveFilter_Button);
								Thread.sleep(10000);
								
								By savedFilter_image = appInd.createAndGetByObject("Anomaly_SavedFilter_image");
								WebElement anomaly_SavedFilter_image = obrowser.findElement(savedFilter_image);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_SavedFilter_image);
								Thread.sleep(8000);
								
								By filter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
								List<WebElement> savedFilter_Name_List = obrowser.findElements(filter_Name_List);
								String mapString= "";
								for(int j=0;j<savedFilter_Name_List.size();j++) {
									 mapString= systemName+"#"+oinpuTDtMap.get("Param_1")+"#";
									 System.out.println(savedFilter_Name_List.get(j).getText());
									 System.out.println("=====================");
									 System.out.println(oinpuTDtMap.get("Param_1"));
									 //if(savedFilter_Name_List.get(j).getText().trim().equalsIgnoreCase(oinpuTDtMap.get("Param_1"))) {
									 if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_1").trim())) {
										 strStatus = "true";
										 mapString+="Pass";
										 appInd.writeLog("Pass", "Fiter Saved Successfully");
										 System.out.println("Fiter Saved Successfully");
										 Thread.sleep(2000);
										 System.out.println("strStatus:::"+ strStatus);
										 //outputMap.put(outputMap.size()+1, mapString);  
										 Thread.sleep(5000);
										// ((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
										 Thread.sleep(5000);
										 break;
									 }
									 
									 strStatus = "false";
			    				     mapString+="Fail";	
			    				     //outputMap.put(outputMap.size()+1, mapString);
			    				     System.out.println("Fiter is not Saved Successfully");
			    				     			    				     			    				    
								}
								 outputMap.put(outputMap.size()+1, mapString);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
							}catch(Exception e) {
								//e.printStackTrace();
								//break;
								strStatus += false;
								appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\SaveFilter.png");
							}
						}
						
						
						
						
						
						
						/*System.out.println(system_elements.size());
						Iterator<WebElement> itr = system_elements.iterator();
						while(itr.hasNext()) {
							system_elements = obrowser.findElements(systems);
							//itr = system_elements.iterator();
							WebElement ele=itr.next();
						    System.out.println(ele.getText());
						
								try {
								systemName = ele.getText(); 
								System.out.println("System : "+systemName);
								//system_elements.get(i).click();
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",ele);
								Thread.sleep(4000);								
								By filter_image = appInd.createAndGetByObject("Anomaly_Filter_image");
								WebElement anomaly_Filter_image = obrowser.findElement(filter_image);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_Filter_image);
								Thread.sleep(5000);
								
								By checkBox_List = appInd.createAndGetByObject("AnomalyName_CheckBox_List");
								List<WebElement> anomalyName_CheckBox_List = obrowser.findElements(checkBox_List);
								
								for(int i=0;i<2;i++) {
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_CheckBox_List.get(i));
									Thread.sleep(5000);
								}
								
								appInd.clearAndSetObject(obrowser, "Anomaly_Filter_Name", oinpuTDtMap.get("Param_1"));
								
								appInd.clearAndSetObject(obrowser, "Anomaly_Filter_Description", oinpuTDtMap.get("Param_2"));
								
								By saveFilter_Button = appInd.createAndGetByObject("Anomaly_SaveFilter_Button");
								WebElement anomaly_SaveFilter_Button = obrowser.findElement(saveFilter_Button);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_SaveFilter_Button);
								Thread.sleep(10000);
								
								By savedFilter_image = appInd.createAndGetByObject("Anomaly_SavedFilter_image");
								WebElement anomaly_SavedFilter_image = obrowser.findElement(savedFilter_image);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_SavedFilter_image);
								Thread.sleep(8000);
								
								By filter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
								List<WebElement> savedFilter_Name_List = obrowser.findElements(filter_Name_List);
								String mapString= "";
								for(int j=0;j<savedFilter_Name_List.size();j++) {
									 mapString= systemName+"#"+oinpuTDtMap.get("Param_1")+"#";
									 System.out.println(savedFilter_Name_List.get(j).getText());
									 System.out.println("=====================");
									 System.out.println(oinpuTDtMap.get("Param_1"));
									 //if(savedFilter_Name_List.get(j).getText().trim().equalsIgnoreCase(oinpuTDtMap.get("Param_1"))) {
									 if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_1").trim())) {
										 strStatus = "true";
										 mapString+="Pass";
										 appInd.writeLog("Pass", "Fiter Saved Successfully");
										 System.out.println("Fiter Saved Successfully");
										 Thread.sleep(2000);
										 System.out.println("strStatus:::"+ strStatus);
										 //outputMap.put(outputMap.size()+1, mapString);  
										 Thread.sleep(5000);
										// ((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
										 Thread.sleep(5000);
										 break;
									 }
									 
									 strStatus = "false";
			    				     mapString+="Fail";	
			    				     //outputMap.put(outputMap.size()+1, mapString);
			    				     System.out.println("Fiter is not Saved Successfully");
			    				     			    				     			    				    
								}
								 outputMap.put(outputMap.size()+1, mapString);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
							}catch(Exception e) {
								e.printStackTrace();
								//break;
								strStatus += false;
								appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly_Failed_Snapshot\\SaveFilter.png");
							}
						}*/
						
						
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.writeLog("Fail", "'TC_EngineeringAnomaly_SaveFilter' script was failed");
						bolstatus = false;
						strStatus = null;
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\SaveFilter.png");
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_EngineeringAnomaly_SaveFilter' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			appInd.writeSavedFilterResult(outputMap, DriverScript.strTCID, DriverScript.strModulename);
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", newTotalTime);
			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", newTotalTime);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", newTotalTime);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", newTotalTime);
			}
			oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		System.out.println("oinputMap.toString :::::::::::" +oinputMap);
		return oinputMap;
	} catch (Exception e) {
		e.printStackTrace();
		appInd.writeLog("Exception",
				"Exception while executing 'TC_EngineeringAnomaly_SaveFilter' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put("result", (HashMap) oinpuTDtMap);
		return oinputMap;
	}	
	
}

/********************************
 * Method Name : TC_EngineeringAnomaly_csv_Download 
 * Purpose : This method will Download Engineering Anomaly
 * Author : Rajashree 
 * Reviewer : 
 * Date of Creation : 25-Jan-2019
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_EngineeringAnomaly_csv_Download() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	double pageLoadTime_Seconds=0;
	double totaltime;
	String strProjectName = null;
	try {
		System.out.println("**************EngineeringAnomaly***********");
		appInd.writeLog("#", "****TC_EngineeringAnomaly_csv_Download:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		System.out.println("oinputMap.tostring::" +oinputMap.toString());
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));
			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################
								// click on menu bar and click on spare option
					
					By byClickOnMenuBar = appInd.createAndGetByObject("Menu_Bar");
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Dashboard")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Engineering Anomaly")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
					
					// ########################################################################
					  strProjectName  = oinpuTDtMap.get("Param_1"); 
					  System.out.println(strProjectName);
					  String param9= oinpuTDtMap.get("Param_9");
					  System.out.println("param9::" +param9);
					  
					  try {
					  
					    By select_DropDown = appInd.createAndGetByObject("E_Anamoly");
						WebElement select_System_DropDown = obrowser.findElement(select_DropDown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
						Thread.sleep(4000);
						
						By systems = appInd.createAndGetByObject("Change_Detection_SystemNames");
						List<WebElement> system_elements = obrowser.findElements(systems);
						System.out.println(system_elements.size());
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",system_elements.get(0));
						Thread.sleep(3000);
						
						By export_Button = appInd.createAndGetByObject("Anomaly_Export_Button");
						WebElement anomaly_Export_Button = obrowser.findElement(export_Button);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_Export_Button);
						System.out.println("Clicked on Export Button");
						Thread.sleep(1000);
						By downloadFileNameEditBox = appInd.createAndGetByObject("Anomaly_OutputFile_Name_EditBox");
						List<WebElement> download_FileName_EditBox = obrowser.findElements(downloadFileNameEditBox);
						if(download_FileName_EditBox.size()>0) {
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",download_FileName_EditBox.get(0));
							System.out.println("Clicked");
							download_FileName_EditBox.get(0).clear();
							System.out.println("Cleared");
							download_FileName_EditBox.get(0).sendKeys(oinpuTDtMap.get("Param_1"));
							System.out.println("Set Values in Edit Box");
							//Thread.sleep(1000);
							By ok_Button = appInd.createAndGetByObject("Anomaly_Ok_button");
							WebElement click_Ok_Button = obrowser.findElement(ok_Button);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",click_Ok_Button);
							Thread.sleep(30000);
							//appInd.clickAndSaveFileIE_Test(click_Ok_Button);
							//appInd.clickAndSaveFileIE(click_Ok_Button);
							System.out.println("Clicked on Ok Button");
							File file = new File(oinpuTDtMap.get("Param_2")+oinpuTDtMap.get("Param_1")+".csv");

							  if(file.exists()){
								  strStatus += true;
								  System.out.println("File is downloaded successfully");
							  }else{
								  strStatus += false;
								  System.out.println("File is not downloaded successfully");
								  appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\DownloadAnomalyFile.png");
							  }
							
						}else {
							strStatus += false;
							System.out.println("Download file name edit box is not displayed");
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\DownloadAnomalyFile.png");
						}
						
					  }catch(Exception e){
						   // e.printStackTrace();
						    strStatus += false;
							appInd.writeLog("Fail", "File is not Saved Successfully");	
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\DownloadAnomalyFile.png");
					  }
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.writeLog("Fail", "'TC_EngineeringAnomaly_csv_Download' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_EngineeringAnomaly_csv_Download' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
			} else {
				oinpuTDtMap.put("result", "Skip");
			}
			oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		System.out.println("oinputMap.toString :::::::::::" +oinputMap);
		return oinputMap;
	} catch (Exception e) {
			appInd.writeLog("Exception",
				"Exception while executing 'TC_EngineeringAnomaly_csv_Download' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put("result", (HashMap) oinpuTDtMap);
		return oinputMap;
	}
}

/********************************
 * Method Name : TC_EngineeringAnomaly_PrintFile Purpose : This method will Print
 * Engineering Anomaly Author : Rajashree Reviewer : Date of Creation : 25-Jan-2019
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_EngineeringAnomaly_PrintFile()
{
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	double pageLoadTime_Seconds=0;
	double totaltime;
	String strProjectName = null;
	try {
		System.out.println("**************EngineeringAnomaly***********");
		appInd.writeLog("#", "****TC_EngineeringAnomaly_PrintFile:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		System.out.println("oinputMap.tostring::" +oinputMap.toString());
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));
			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################
								// click on menu bar and click on spare option
					
					By byClickOnMenuBar = appInd.createAndGetByObject("Menu_Bar");
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Dashboard")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Engineering Anomaly")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
					
					// ########################################################################
					  strProjectName  = oinpuTDtMap.get("Param_1"); 
					  System.out.println(strProjectName);
					  String param9= oinpuTDtMap.get("Param_9");
					  System.out.println("param9::" +param9);
					  
					  try { 
						  String filePath = System.getProperty("user.dir")+"\\AutoIT\\";
						 // boolean deleteFileStatus = appInd.deleteExistFile(oinpuTDtMap.get("Param_1"), "Anomaly_PrintFile", "pdf");
						  boolean deleteFileStatus = appInd.deleteExistFile(oinpuTDtMap.get("Param_1"), "Anomaly_PrintFile", "xps");
							if(deleteFileStatus==true) {
								strStatus = "true";
								//System.out.println("Files are deleted");
								appInd.writeLog("pass", "Files are deleted");
							}else {
								//System.out.println("Files are not deleted");
								appInd.writeLog("pass", "Files are not deleted");
							}
					  
					    By select_DropDown = appInd.createAndGetByObject("E_Anamoly");
						WebElement select_System_DropDown = obrowser.findElement(select_DropDown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
						Thread.sleep(4000);
						
						By systems = appInd.createAndGetByObject("Change_Detection_SystemNames");
						List<WebElement> system_elements = obrowser.findElements(systems);
						System.out.println(system_elements.size());
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",system_elements.get(0));
						Thread.sleep(3000);
						
						By print_Button = appInd.createAndGetByObject("Anomaly_Print_Button");
						WebElement anomaly_Print_Button = obrowser.findElement(print_Button);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomaly_Print_Button);
						System.out.println("Clicked on Print Button");
						Thread.sleep(3000);
						//appInd.printFileInIE_New();
						
						Runtime.getRuntime().exec(filePath+"EngineeringAnomaly_PrintFile.exe");
						//appInd.printFileInChrome();
						
						System.out.println("File Printed");
						Thread.sleep(15000);
						//File file = new File(oinpuTDtMap.get("Param_1")+"Anomaly_PrintFile"+".pdf");
						File file = new File(oinpuTDtMap.get("Param_1")+"Anomaly_PrintFile"+".xps");
						//File file = new File(oinpuTDtMap.get("Param_1")+"Anomaly_PrintFile");

						  if(file.exists()){
							  strStatus = "true";
							  System.out.println("File is printed successfully");
							  appInd.writeLog("pass", "File is printed Successfully");
						  }else{
							  strStatus = "false";
							  System.out.println("File is not printed successfully");
							  appInd.writeLog("Fail", "File is not printed Successfully");	
							  appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\PrintAnomalyFile.png");
						  }
						
					  }catch(Exception e) {
						 // e.printStackTrace();
						    strStatus += false;
							appInd.writeLog("Fail", "File is not Saved Successfully");	
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\PrintAnomalyFile.png");
					  }
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.writeLog("Fail", "'TC_EngineeringAnomaly_PrintFile' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_EngineeringAnomaly_PrintFile' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
			} else {
				oinpuTDtMap.put("result", "Skip");
			}
			oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		System.out.println("oinputMap.toString :::::::::::" +oinputMap);
		return oinputMap;
	} catch (Exception e) {
			appInd.writeLog("Exception",
				"Exception while executing 'TC_EngineeringAnomaly_PrintFile' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put("result", (HashMap) oinpuTDtMap);
		return oinputMap;
	}
}

/********************************
 * Method Name : TC_EngineeringAnomaly_CreateSwitchModel 
 * Purpose : This method will Create Switch Model
 * Author : Rajashree 
 * Reviewer : 
 * Date of Creation : 29-Jan-2019
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_EngineeringAnomaly_CreateSwitchModel() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	double pageLoadTime_Seconds=0;
	double totaltime;
	String strProjectName = null;
	try {
		System.out.println("**************EngineeringAnomaly***********");
		appInd.writeLog("#", "****TC_EngineeringAnomaly_CreateSwitchModel:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		System.out.println("oinputMap.tostring::" +oinputMap.toString());
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));
			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################
								// click on menu bar and click on spare option
					
					By byClickOnMenuBar = appInd.createAndGetByObject("Menu_Bar");
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Dashboard")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Engineering Anomaly")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
					
					// ########################################################################
					  strProjectName  = oinpuTDtMap.get("Param_1"); 
					  System.out.println(strProjectName);
					  String param9= oinpuTDtMap.get("Param_9");
					  System.out.println("param9::" +param9);
					  
					  try {
					  
					    By select_DropDown = appInd.createAndGetByObject("E_Anamoly");
						WebElement select_System_DropDown = obrowser.findElement(select_DropDown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
						Thread.sleep(4000);
						
						By systems = appInd.createAndGetByObject("Change_Detection_SystemNames");
						List<WebElement> system_elements = obrowser.findElements(systems);
						System.out.println(system_elements.size());
						
						for(int i=0;i<system_elements.size();i++) {
							if(system_elements.get(i).getText().trim().equalsIgnoreCase(oinpuTDtMap.get("Param_1").trim())) {
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",system_elements.get(i));
								strStatus = "true";
								Thread.sleep(3000);
								break;
							}
							strStatus = "false";
							
						}
						
						if(strStatus.contains("false")) {
							strStatus = "false";
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchModel.png");
						}else {
							By Custom_Anomaly_Button = appInd.createAndGetByObject("Custom_Anomaly_Button");
							WebElement custom_Anomaly_Button = obrowser.findElement(Custom_Anomaly_Button);
							if(custom_Anomaly_Button.isEnabled()) {
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",custom_Anomaly_Button);
								Thread.sleep(4000);
							}
							
							By Switch_Model_Tab = appInd.createAndGetByObject("Switch_Model_Tab");
							WebElement switch_Model_Tab = obrowser.findElement(Switch_Model_Tab);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switch_Model_Tab);
							Thread.sleep(4000);
							
							By Switch_Model_Add_Button = appInd.createAndGetByObject("Switch_Model_Add_Button");
							WebElement switch_Model_Add_Button = obrowser.findElement(Switch_Model_Add_Button);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switch_Model_Add_Button);
							Thread.sleep(4000);
							
							appInd.clearAndSetObject(obrowser, "SwitchModel_AnomalyName_EditBox", oinpuTDtMap.get("Param_2"));
							
							By SwitchModel_RadioButtonList = appInd.createAndGetByObject("SwitchModel_RadioButtonList");
							List<WebElement> switchModel_RadioButtonList = obrowser.findElements(SwitchModel_RadioButtonList);
							System.out.println(switchModel_RadioButtonList.size());
							
							for(int j=0;j<switchModel_RadioButtonList.size();j++) {
								if(switchModel_RadioButtonList.get(j).getAttribute("id").contains(oinpuTDtMap.get("Param_3").trim())) {
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchModel_RadioButtonList.get(j));
									Thread.sleep(3000);
									break;
								}
								
							}
							appInd.clearAndSetObject(obrowser, "SwitchModel_AnomalyDescription_EditBox", oinpuTDtMap.get("Param_4"));
							
							By ReleaseNumber_CheckBox = appInd.createAndGetByObject("ReleaseNumber_CheckBox");
							WebElement releaseNumber_CheckBox = obrowser.findElement(ReleaseNumber_CheckBox);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",releaseNumber_CheckBox);
							Thread.sleep(2000);
							
							appInd.selectDropdownvalue(obrowser, "ReleaseDropdown", oinpuTDtMap.get("Param_5").trim());
							
							appInd.clearAndSetObject(obrowser, "SwitchModel_Number_EditBox", oinpuTDtMap.get("Param_6"));
							
							By SwitchModel_Done_Button = appInd.createAndGetByObject("SwitchModel_Done_Button");
							WebElement switchModel_Done_Button = obrowser.findElement(SwitchModel_Done_Button);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchModel_Done_Button);
							Thread.sleep(5000);
							
							By Home_Icon = appInd.createAndGetByObject("Home_Icon");
							WebElement home_Icon = obrowser.findElement(Home_Icon);
							
							//boolean flag = appInd.ifElementsPresent(obrowser, "SwitchModel_AlreadyExist_Text");
							boolean flag = appInd.ifElementsPresent(obrowser, "AnomalyName_AlreadyExist_Ok_Button");
							System.out.println(flag);
							if(flag==true) {
								System.out.println("Anomaly name is already exist");
								strStatus = "false";
								appInd.writeLog("Fail", "Anomaly name is already exist");
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchModel.png");
															
								By AnomalyName_AlreadyExist_Ok_Button = appInd.createAndGetByObject("AnomalyName_AlreadyExist_Ok_Button");
								WebElement anomalyName_AlreadyExist_Ok_Button = obrowser.findElement(AnomalyName_AlreadyExist_Ok_Button);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_AlreadyExist_Ok_Button);
								
								System.out.println("clicked on okay button");
								Thread.sleep(3000);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",home_Icon);
								//obrowser.navigate().refresh();
								Thread.sleep(5000);	
							}else {
								By SwichModel_Anomaly_nameList = appInd.createAndGetByObject("SwichModel_Anomaly_nameList");
								List<WebElement> swichModel_Anomaly_nameList = obrowser.findElements(SwichModel_Anomaly_nameList);
								System.out.println(swichModel_Anomaly_nameList.size());
								
								for(int j=0;j<swichModel_Anomaly_nameList.size();j++) {
									if(swichModel_Anomaly_nameList.get(j).getText().equalsIgnoreCase(oinpuTDtMap.get("Param_2").trim())) {
										//((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",swichModel_Anomaly_nameList.get(j));
										strStatus = "true";
										appInd.writeLog("Pass", "Switch Model is created successfully");
										Thread.sleep(4000);	
										By SwitchModel_Close_Button = appInd.createAndGetByObject("SwitchModel_Close_Button");
										WebElement switchModel_Close_Button = obrowser.findElement(SwitchModel_Close_Button);
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchModel_Close_Button);
										Thread.sleep(3000);
										//obrowser.navigate().refresh();
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",home_Icon);
										Thread.sleep(5000);	
										break;
									}
									
								}
								
							}
						}
						
						
					  }catch(Exception e) {
						   // e.printStackTrace();
						    strStatus += false;
							appInd.writeLog("Fail", "Switch Model is not created successfully");	
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchModel.png");
					  }
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.writeLog("Fail", "'TC_EngineeringAnomaly_CreateSwitchModel' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_EngineeringAnomaly_CreateSwitchModel' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
			} else {
				oinpuTDtMap.put("result", "Skip");
			}
			oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		System.out.println("oinputMap.toString :::::::::::" +oinputMap);
		return oinputMap;
	} catch (Exception e) {
			appInd.writeLog("Exception",
				"Exception while executing 'TC_EngineeringAnomaly_CreateSwitchModel' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put("result", (HashMap) oinpuTDtMap);
		return oinputMap;
	}
}
/********************************
 * Method Name : TC_EngineeringAnomaly_CreateSwitchISOVersion 
 * Purpose : This method will Create Switch ISO Version
 * Author : Rajashree 
 * Reviewer : 
 * Date of Creation : 29-Jan-2019
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_EngineeringAnomaly_CreateSwitchIOSVersion() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	double pageLoadTime_Seconds=0;
	double totaltime;
	String strProjectName = null;
	try {
		System.out.println("**************EngineeringAnomaly***********");
		appInd.writeLog("#", "****TC_EngineeringAnomaly_CreateSwitchIOSVersion:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		System.out.println("oinputMap.tostring::" +oinputMap.toString());
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));
			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################
								// click on menu bar and click on spare option
					
					By byClickOnMenuBar = appInd.createAndGetByObject("Menu_Bar");
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Dashboard")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					obrowser.findElement(byClickOnMenuBar).sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					obrowser.findElement(By.linkText("Engineering Anomaly")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
					
					// ########################################################################
					  strProjectName  = oinpuTDtMap.get("Param_1"); 
					  System.out.println(strProjectName);
					  String param9= oinpuTDtMap.get("Param_9");
					  System.out.println("param9::" +param9);
					  
					  try {
						  
						    By select_DropDown = appInd.createAndGetByObject("E_Anamoly");
							WebElement select_System_DropDown = obrowser.findElement(select_DropDown);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",select_System_DropDown);
							Thread.sleep(4000);
							
							By systems = appInd.createAndGetByObject("Change_Detection_SystemNames");
							List<WebElement> system_elements = obrowser.findElements(systems);
							System.out.println(system_elements.size());
							
							for(int i=0;i<system_elements.size();i++) {
								if(system_elements.get(i).getText().trim().equalsIgnoreCase(oinpuTDtMap.get("Param_1").trim())) {
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",system_elements.get(i));
									strStatus = "true";
									Thread.sleep(3000);
									break;
								}
								strStatus = "false";
							}
							
							if(strStatus.contains("false")) {
								strStatus = "false";
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchISOVersion.png");
							}else {
								
								By Custom_Anomaly_Button = appInd.createAndGetByObject("Custom_Anomaly_Button");
								WebElement custom_Anomaly_Button = obrowser.findElement(Custom_Anomaly_Button);
								if(custom_Anomaly_Button.isEnabled()) {
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",custom_Anomaly_Button);
									Thread.sleep(4000);
								}
								
								By Switch_IOS_Version_Tab = appInd.createAndGetByObject("Switch_IOS_Version_Tab");
								WebElement switch_IOS_Version_Tab = obrowser.findElement(Switch_IOS_Version_Tab);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switch_IOS_Version_Tab);
								Thread.sleep(4000);
								
								By Switch_IOSVersion_Add_Button = appInd.createAndGetByObject("Switch_IOSVersion_Add_Button");
								WebElement switch_IOSVersion_Add_Button = obrowser.findElement(Switch_IOSVersion_Add_Button);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switch_IOSVersion_Add_Button);
								Thread.sleep(4000);
								
								appInd.clearAndSetObject(obrowser, "SwitchIOSVersion_AnomalyName_EditBox", oinpuTDtMap.get("Param_2"));
								
								By SwitchIOSVersion_RadioButtonList = appInd.createAndGetByObject("SwitchIOSVersion_RadioButtonList");
								List<WebElement> switchIOSVersion_RadioButtonList = obrowser.findElements(SwitchIOSVersion_RadioButtonList);
								System.out.println(switchIOSVersion_RadioButtonList.size());
								
								for(int j=0;j<switchIOSVersion_RadioButtonList.size();j++) {
									if(switchIOSVersion_RadioButtonList.get(j).getAttribute("id").contains(oinpuTDtMap.get("Param_3").trim())) {
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchIOSVersion_RadioButtonList.get(j));
										Thread.sleep(3000);
										break;
									}
									
								}
								appInd.clearAndSetObject(obrowser, "SwitchIOSVersion_AnomalyDescription_EditBox", oinpuTDtMap.get("Param_4"));
								
								By SwitchIOSVersion_VendorList = appInd.createAndGetByObject("SwitchIOSVersion_VendorList");
								List<WebElement> switchIOSVersion_VendorList = obrowser.findElements(SwitchIOSVersion_VendorList);
								System.out.println(switchIOSVersion_VendorList.size());
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchIOSVersion_VendorList.get(0));
								Thread.sleep(3000);
								
								By SwitchIOSVersion_ModelNumber_AddButtonList = appInd.createAndGetByObject("SwitchIOSVersion_ModelNumber_AddButtonList");
								List<WebElement> switchIOSVersion_ModelNumber_AddButtonList = obrowser.findElements(SwitchIOSVersion_ModelNumber_AddButtonList);
								System.out.println(switchIOSVersion_ModelNumber_AddButtonList.size());
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchIOSVersion_ModelNumber_AddButtonList.get(0));
								Thread.sleep(3000);
								
								By SwitchIOSVersion_IOS_List = appInd.createAndGetByObject("SwitchIOSVersion_IOS_List");
								List<WebElement> switchIOSVersion_IOS_List = obrowser.findElements(SwitchIOSVersion_IOS_List);
								System.out.println(switchIOSVersion_IOS_List.size());
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchIOSVersion_IOS_List.get(0));
								Thread.sleep(3000);
															
								appInd.clearAndSetObject(obrowser, "IOS_VersionName_EditBox", oinpuTDtMap.get("Param_5").trim());
															
								By SwitchIOSVersion_Done_Button = appInd.createAndGetByObject("SwitchIOSVersion_Done_Button");
								WebElement switchIOSVersion_Done_Button = obrowser.findElement(SwitchIOSVersion_Done_Button);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",switchIOSVersion_Done_Button);
								Thread.sleep(5000);
								
								By Home_Icon = appInd.createAndGetByObject("Home_Icon");
								WebElement home_Icon = obrowser.findElement(Home_Icon);
								
								//boolean flag = appInd.ifElementsPresent(obrowser, "SwitchModel_AlreadyExist_Text");
								boolean flag = appInd.ifElementsPresent(obrowser, "AnomalyName_AlreadyExist_Ok_Button");
								System.out.println(flag);
								if(flag==true) {
									System.out.println("Anomaly name is already exist");
									strStatus = "false";
									appInd.writeLog("Fail", "Anomaly name is already exist");
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchIOSVersion.png");
																
									By AnomalyName_AlreadyExist_Ok_Button = appInd.createAndGetByObject("AnomalyName_AlreadyExist_Ok_Button");
									WebElement anomalyName_AlreadyExist_Ok_Button = obrowser.findElement(AnomalyName_AlreadyExist_Ok_Button);
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_AlreadyExist_Ok_Button);
									
									System.out.println("clicked on okay button");
									Thread.sleep(3000);
									//obrowser.navigate().refresh();
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",home_Icon);
									Thread.sleep(5000);	
								}else {
									By SwichIOSVersion_Anomaly_nameList = appInd.createAndGetByObject("SwichIOSVersion_Anomaly_nameList");
									List<WebElement> swichIOSVersion_Anomaly_nameList = obrowser.findElements(SwichIOSVersion_Anomaly_nameList);
									System.out.println(swichIOSVersion_Anomaly_nameList.size());
									
									for(int j=0;j<swichIOSVersion_Anomaly_nameList.size();j++) {
										if(swichIOSVersion_Anomaly_nameList.get(j).getText().equalsIgnoreCase(oinpuTDtMap.get("Param_2").trim())) {
											//((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",swichIOSVersion_Anomaly_nameList.get(j));
											strStatus = "true";
											appInd.writeLog("Pass", "Switch IOS Version is created successfully");
											Thread.sleep(4000);	
											By SwichIOSVersion_Close_Button = appInd.createAndGetByObject("SwichIOSVersion_Close_Button");
											WebElement swichIOSVersion_Close_Button = obrowser.findElement(SwichIOSVersion_Close_Button);
											((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",swichIOSVersion_Close_Button);
											Thread.sleep(3000);
											//obrowser.navigate().refresh();
											((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",home_Icon);
											Thread.sleep(5000);	
											break;
										}
										
									}
									
								}
							}
							
							
							
						  }catch(Exception e) {
						   //e.printStackTrace();
						    strStatus += false;
							appInd.writeLog("Fail", "Switch ISO version is not created successfully");	
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")+ "\\Results\\snapshot\\Engineering_Anomaly\\CreateSwitchISOVersion.png");
					  }
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.writeLog("Fail", "'TC_EngineeringAnomaly_CreateSwitchIOSVersion' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_EngineeringAnomaly_CreateSwitchIOSVersion' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
			} else {
				oinpuTDtMap.put("result", "Skip");
			}
			oinputMap.put(String.valueOf(TD), (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		System.out.println("oinputMap.toString :::::::::::" +oinputMap);
		return oinputMap;
	} catch (Exception e) {
			appInd.writeLog("Exception",
				"Exception while executing 'TC_EngineeringAnomaly_CreateSwitchIOSVersion' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put("result", (HashMap) oinpuTDtMap);
		return oinputMap;
	}
}



/********************************
 * Method Name : TC_Filter_by_Acknowledged
 * Purpose : this will filter the Acknowledged anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 24-Jan-2019 
 * Date ofmodification :
 * ******************************
 */

	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Acknowledged() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Acknowledged:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"acknowledged","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Acknowledged_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Acknowledged' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Acknowledged' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Acknowledged' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Filter_by_UnAcknowledged
 * Purpose : this will filter the unAcknowledged anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 24-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_UnAcknowledged() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_UnAcknowledged:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"unacknowledged","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_UnAcknowledged_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_UnAcknowledged' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_UnAcknowledged' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_UnAcknowledged' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_Filter_by_Resolved
 * Purpose : this will filter the Resolved anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Resolved() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Resolved:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"resolved","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Resolved_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Resolved' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Resolved' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Resolved' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}




/********************************
 * Method Name : TC_Filter_by_Assigned
 * Purpose : this will filter the Assigned anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Assigned() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Assigned:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"assigned","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Assigned_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Assigned' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Assigned' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Assigned' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_Filter_by_UnAssigned
 * Purpose : this will filter the Unassigned anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_UnAssigned() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_UnAssigned:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"unassigned","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"unassigned") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_UnAssigned_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_UnAssigned' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_UnAssigned' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_UnAssigned' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Filter_by_Suppressed
 * Purpose : this will filter the suppressed anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Suppressed() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Suppressed:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"suppressed","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"suppressed") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Suppressed_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Suppressed' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Suppressed' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Suppressed' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Filter_by_UnSuppressed
 * Purpose : this will filter the Unsuppressed anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_UnSuppressed() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_UnSuppressed:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"unsuppressed","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_UnSuppressed_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_UnSuppressed' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_UnSuppressed' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_UnSuppressed' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Filter_by_High
 * Purpose : this will filter the High anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_High() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_High:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"high","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"high") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_High_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_High' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_High' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_High' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Filter_by_AnomalyName
 * Purpose : this will filter the High anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_AnomalyName() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_AnomalyName:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"anomalyname","default");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_AnomalyName_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_AnomalyName' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_AnomalyName' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_AnomalyName' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_Filter_by_Medium
 * Purpose : this will filter the Medium anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Medium() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Medium:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"medium","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Medium_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Medium' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Medium' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Medium' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Filter_by_Low
 * Purpose : this will filter the Low anomaly
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 28-Jan-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Low() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Low:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
					
					//Select the System by default "index value =1 "
					 appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					 
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"low","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Low_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Low' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Low' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Low' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Custom_Anamoly_enable_availablity
 * Purpose : this will set the availablity(enabled) and will verify 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Custom_Anamoly_enable_availablity() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	
	try {
		appInd.writeLog("#", "****TC_Custom_Anamoly_enable_availablity:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					 appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation of custom Anomaly
					 String retva=oGenericAppmethods.EA_anamoly_settings(obrowser,"set_availablity", "enable","default");
					 String spltval[] =retva.split(":");
					 strStatus +=spltval[0];
					 //get the anomaly Name					 
					 String stranomalyName=spltval[1];
					 
					//validation part
					 strStatus += oGenericAppmethods.EA_anamoly_settings_validation(obrowser,"set_availablity","enable",stranomalyName) ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Custom_Anamoly_enable_availablity_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Custom_Anamoly_enable_availablity' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Custom_Anamoly_enable_availablity' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\sFailed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Custom_Anamoly_enable_availablity' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Custom_Anamoly_disable_availablity
 * Purpose : this will set the availablity(enabled) and will verify 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Custom_Anamoly_disable_availablity() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	
	try {
		appInd.writeLog("#", "****TC_Custom_Anamoly_disable_availablity:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation of custom Anomaly
					 String retva=oGenericAppmethods.EA_anamoly_settings(obrowser,"set_availablity", "disable","default");
					 String spltval[] =retva.split(":");
					 strStatus +=spltval[0];
					 //get the anomaly Name					 
					 String stranomalyName=spltval[1];
					 
					//validation part
					 strStatus += oGenericAppmethods.EA_anamoly_settings_validation(obrowser,"set_availablity","disable",stranomalyName) ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Custom_Anamoly_disable_availablity_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Custom_Anamoly_disable_availablity' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Custom_Anamoly_disable_availablity' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Custom_Anamoly_disable_availablity' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Custom_Anamoly_High_Priority
 * Purpose : this will set the high Priority and will verify 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Custom_Anamoly_High_Priority() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Custom_Anamoly_High_Priority:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation of custom Anomaly
					 String retva=oGenericAppmethods.EA_anamoly_settings(obrowser,"set_priority", "high","default");
					 String spltval[] =retva.split(":");
					 strStatus +=spltval[0];
					 //get the anomaly Name					 
					 String stranomalyName=spltval[1];
					 
					//validation part
					 strStatus += oGenericAppmethods.EA_anamoly_settings_validation(obrowser,"set_priority","high",stranomalyName) ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Custom_Anamoly_High_Priority_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Custom_Anamoly_High_Priority' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Custom_Anamoly_High_Priority' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Custom_Anamoly_High_Priority' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_Custom_Anamoly_Medium_Priority
 * Purpose : this will set the medium Priority and will verify 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Custom_Anamoly_Medium_Priority() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Custom_Anamoly_Medium_Priority:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation of custom Anomaly
					 String retva=oGenericAppmethods.EA_anamoly_settings(obrowser,"set_priority", "medium","default");
					 String spltval[] =retva.split(":");
					 strStatus +=spltval[0];
					 //get the anomaly Name					 
					 String stranomalyName=spltval[1];
					 
					//validation part
					 strStatus += oGenericAppmethods.EA_anamoly_settings_validation(obrowser,"set_priority","medium",stranomalyName) ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Custom_Anamoly_Medium_Priority_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Custom_Anamoly_Medium_Priority' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Custom_Anamoly_Medium_Priority' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Custom_Anamoly_Medium_Priority' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_Custom_Anamoly_low_Priority
 * Purpose : this will set the low Priority and will verify 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Custom_Anamoly_low_Priority() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Custom_Anamoly_low_Priority:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation of custom Anomaly
					 String retva=oGenericAppmethods.EA_anamoly_settings(obrowser,"set_priority", "low","default");
					 String spltval[] =retva.split(":");
					 strStatus +=spltval[0];
					 //get the anomaly Name					 
					 String stranomalyName=spltval[1];
					 
					//validation part
					 strStatus += oGenericAppmethods.EA_anamoly_settings_validation(obrowser,"set_priority","low",stranomalyName) ;
					
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Custom_Anamoly_Low_Priority_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Custom_Anamoly_low_Priority' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Custom_Anamoly_low_Priority' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Custom_Anamoly_low_Priority' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}

/********************************
 * Method Name : TC_All_Defects_Decrease_Count
 * Purpose : this will verify the all_Defects_Decrease_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_All_Defects_Decrease_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_All_Defects_Decrease_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"decrease","all_defects") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_All_Defects_Decrease_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_All_Defects_Decrease_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_All_Defects_Decrease_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_All_Defects_Decrease_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_All_Defects_Increase_Count
 * Purpose : this will verify the all defects increase Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_All_Defects_Increase_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_All_Defects_Increase_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"increase","all_defects") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_All_Defects_Increase_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_All_Defects_Increase_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_All_Defects_Increase_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_All_Defects_Increase_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_High_Priority_Increase_Count
 * Purpose : this will verify the high priority increase Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_High_Priority_Increase_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_High_Priority_Increase_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"increase","high") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_High_Priority_Increase_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_High_Priority_Increase_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_High_Priority_Increase_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_High_Priority_Increase_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_High_Priority_Decrease_Count
 * Purpose : this will verify the high priority decrease Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_High_Priority_Decrease_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_High_Priority_Decrease_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"decrease","high") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_High_Priority_Decrease_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_High_Priority_Decrease_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_High_Priority_Decrease_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_High_Priority_Decrease_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Suppressed_Decrease_Count
 * Purpose : this will verify the suppressed_Decrease_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Suppressed_Decrease_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Suppressed_Decrease_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");	
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"decrease","suppressed") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Suppressed_Decrease_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Suppressed_Decrease_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Suppressed_Decrease_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Suppressed_Decrease_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Suppressed_Increase_Count
 * Purpose : this will verify the suppressed_increase_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Suppressed_Increase_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Suppressed_Increase_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");	
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"increase","suppressed") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Suppressed_Increase_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Suppressed_Increase_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Suppressed_Increase_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Suppressed_Increase_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Unassigned_Decrease_Count
 * Purpose : this will verify the unassigned_decrease_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Unassigned_Decrease_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Unassigned_Decrease_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"decrease","unassigned") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Unassigned_Decrease_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Unassigned_Decrease_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Unassigned_Decrease_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Unassigned_Decrease_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Unassigned_Increase_Count
 * Purpose : this will verify the unassigned_increase_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Unassigned_Increase_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Unassigned_Increase_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");		
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"increase","unassigned") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Unassigned_Increase_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Unassigned_Increase_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Unassigned_Increase_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Unassigned_Increase_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Unresolved_Decrease_Count
 * Purpose : this will verify the unresolved_decrease_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Unresolved_Decrease_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Unresolved_Decrease_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");	
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"decrease","unresolved") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Unresolved_Decrease_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Unresolved_Decrease_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Unresolved_Decrease_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Unresolved_Decrease_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Unresolved_Increase_Count
 * Purpose : this will verify the unresolved_increase_Count 
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 7-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Unresolved_Increase_Count() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Unresolved_Increase_Count:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");	
					
					//Defaulting the anomaly grid 
					oGenericAppmethods.Engr_default_filters(obrowser);
					
					//perform operation 
					strStatus +=oGenericAppmethods.Engr_StatisticsCount(obrowser,"increase","unresolved") ;
					
					//get the counts
					strcommonCountvalue=oGenericAppmethods.strcount;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Unresolved_Increase_Count_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Unresolved_Increase_Count' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Unresolved_Increase_Count' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Unresolved_Increase_Count' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}



/********************************
 * Method Name : TC_Statistics_Medium_Priority
 * Purpose : this will verify the medium priority count
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Statistics_Medium_Priority() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Statistics_Medium_Priority:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"medium","none");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"all") ;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Statistics_Medium_Priority_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Statistics_Medium_Priority' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Statistics_Medium_Priority' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Statistics_Medium_Priority' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}


/********************************
 * Method Name : TC_Filter_by_Anamoly_High
 * Purpose : this will verify the count by filtering anomaly name with priority High
 * Author : Mahesh TK 
 * Reviewer : 
 * Date of Creation : 5-Feb-2019 
 * Date ofmodification :
 * ******************************
 */
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<String, HashMap> TC_Filter_by_Anamoly_High() {
	Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
	Map<String, String> oinpuTDtMap = new HashMap<String, String>();
	String strcurrentTD = null;
	String strcommonCountvalue = null;
	String strcommonTime = null;
	try {
		appInd.writeLog("#", "****TC_Filter_by_Anamoly_High:- started*****");
		obrowser = oDriver.getWebDriver();
		boolean bolstatus = false;
		String strExecutionsts = null;
		oinputMap = appInd.getInputData(strTCID);
		for (int TD = 1; TD <= oinputMap.size(); TD++) {
			oinpuTDtMap = oinputMap.get(String.valueOf(TD));

			if ((obrowser != null)) {
				// Read the Execution Status
				strExecutionsts = oinpuTDtMap.get("Executestatus");
				if (strExecutionsts.equalsIgnoreCase("yes")) {
					// ########################################################################	
					
					//click on the Engineering Anomaly from the menu 
					strStatus +=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);			
					
					//Select the System by default "index value =1 "
					appInd.selectDropdownvalue(obrowser, "EngrAnomoly_Dropdwn_System","1","index");
					
					//perform operation in the filter popup
					 strStatus +=oGenericAppmethods.Engr_anomoly_filters(obrowser,"high","Disabled Alarms");
					 
					//validation part
					 strStatus += oGenericAppmethods.EngeeringAnomoly_filtervalidation_countbased(obrowser,"high") ;
					
					
					// ########################################################################
					if (strStatus.contains("false")) {
						String s=oinpuTDtMap.get("Param_1");
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_by_Anamoly_HighDisabledAlarms_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_by_Anamoly_High' script was failed");
						bolstatus = false;
						strStatus = null;
					} else if (strStatus.contains("true")) {
						appInd.writeLog("Pass", "'TC_Filter_by_Anamoly_High' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			} else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshot.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
			strcommonCountvalue = null;
		} // for loop
		return oinputMap;
		
		
	} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_by_Anamoly_High' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
	}
}
//**************************************Engineering anomaly test cases*********************************************************//	
						
	/********************************
	 * Method Name : TC_ToAcknowledgetheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_ToAcknowledgetheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_ToAcknowledgetheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToAcknowledgetheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TounassignedtheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						By bySelect_Unacknowledged = appInd.createAndGetByObject("Select_Unacknowledged");
						WebElement elementq = obrowser.findElement(bySelect_Unacknowledged);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
					
							
							//###################################################################################
							
							Thread.sleep(3000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement elementto = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementto);
							Thread.sleep(3000);
	
							By byClick_Acknowledged = appInd.createAndGetByObject("Click_Acknowledged");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(byClick_Acknowledged);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
													
						
							

							 By byComment_acknowledged = appInd.createAndGetByObject("Comment_acknowledged");
								Thread.sleep(3000);
								WebElement elementp = obrowser.findElement(byComment_acknowledged);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementp);
								
								appInd.setObject(obrowser, "Comment_acknowledged", "Acknwoledged");
							
								By bySelect_Acknowledged_Action = appInd.createAndGetByObject("Select_Acknowledged_Action");
								Thread.sleep(3000);
								WebElement elementh = obrowser.findElement(bySelect_Acknowledged_Action);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
						
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 600);	
							int count=0;
						
							
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,10, "" );
								System.out.println(text);		
													
								if(text.equalsIgnoreCase("Acknwoledged")) {
									count++;
									System.out.println(count);
									
								}
								else if(text==null)	
									break;
								Thread.sleep(5000);
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								strStatus = "false";
								System.out.println("Fail");
								
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToAcknowledgetheAnamoly.png");
							appInd.writeLog("Fail", "'TC_ToAcknowledgetheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_ToAcknowledgetheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_ToAcknowledgetheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	
	
	
	
	/********************************
	 * Method Name : TC_ToUnacknowledgetheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_ToUnacknowledgetheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_ToUnacknowledgetheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								// System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToUnacknowledgetheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_ToUnacknowledgetheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						By bySelect_Acknowledged = appInd.createAndGetByObject("Select_Acknowledged");
						WebElement elementq = obrowser.findElement(bySelect_Acknowledged);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
					
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement elementto = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementto);
							Thread.sleep(3000);
	
							By bySelect_Unacknowledged_Action = appInd.createAndGetByObject("Select_Unacknowledged_Action");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_Unacknowledged_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							
							

							 By byComment_Unacknowledged = appInd.createAndGetByObject("Comment_Unacknowledged");
								Thread.sleep(3000);
								WebElement elementp = obrowser.findElement(byComment_Unacknowledged);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementp);
								
								appInd.setObject(obrowser, "Comment_Unacknowledged", "Unacknwoledged");
							
								By byClick_Unacknowledged = appInd.createAndGetByObject("Click_Unacknowledged");
								Thread.sleep(3000);
								WebElement elementh = obrowser.findElement(byClick_Unacknowledged);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
							
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 600);	
							int count=0;
										
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,10, "" );
								System.out.println(text);		
													
								if(text.equalsIgnoreCase("Unacknwoledged")) {
									count++;
									System.out.println(count);
									Thread.sleep(3000);
									
								}
								else if(text==null)	
									break;
								Thread.sleep(3000);
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								strStatus = "false";
								System.out.println("Fail");
								
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToUnacknowledgetheAnamoly.png");
							appInd.writeLog("Fail", "'TC_ToUnacknowledgetheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_ToUnacknowledgetheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_ToUnacknowledgetheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	/********************************
	 * Method Name : TC_TosupresstheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_TosupresstheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_TosupresstheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						Thread.sleep(5000);
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TosupresstheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TosupresstheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						
						
						By bySelect_Unsuppressfilter = appInd.createAndGetByObject("Select_Unsuppressfilter");
						WebElement elementq = obrowser.findElement(bySelect_Unsuppressfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
					
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement element9 = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element9);
							Thread.sleep(3000);
	
							By bySelect_Suppress = appInd.createAndGetByObject("Select_Suppress");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_Suppress);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							
							

							By byComment_suppress = appInd.createAndGetByObject("Comment_suppress");
							Thread.sleep(3000);
							WebElement elementp = obrowser.findElement(byComment_suppress);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementp);
							
							appInd.setObject(obrowser, "Comment_suppress", "Suppress");
							
							By bySuppress_OK = appInd.createAndGetByObject("Suppress_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(bySuppress_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
						
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 600);	
							int count=0;
						Thread.sleep(5000);
							
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,4, "" );
								System.out.println(text);		
													Thread.sleep(3000);
								if(text.equalsIgnoreCase("Suppressed")) {
									count++;
									System.out.println(count);
									Thread.sleep(5000);
									
								}
								else if(text==null)	
									break;
								
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								
								strStatus = "false";
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TosupresstheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TosupresstheAnamoly' script was failed");
								System.out.println("Fail");
								
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TosupresstheAnamoly.png");
							appInd.writeLog("Fail", "'TC_TosupresstheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_TosupresstheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_TosupresstheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	

	/********************************
	 * Method Name : TC_TounsupresstheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_TounsupresstheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_TounsupresstheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						Thread.sleep(5000);
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounsupresstheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TounsupresstheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						
						By bySelect_Suppressfilter = appInd.createAndGetByObject("Select_Suppressfilter");
						WebElement elementq = obrowser.findElement(bySelect_Suppressfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
					
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement element9 = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element9);
							Thread.sleep(3000);
	
							By bySelect_Unsuppress = appInd.createAndGetByObject("Select_Unsuppress");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_Unsuppress);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							By byComment_Unsuppress = appInd.createAndGetByObject("Comment_Unsuppress");
							Thread.sleep(3000);
							WebElement elementp = obrowser.findElement(byComment_Unsuppress);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementp);
							
							appInd.setObject(obrowser, "Comment_Unsuppress", "Unsuppress");
							
							By byUnsuppress_OK = appInd.createAndGetByObject("Unsuppress_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(byUnsuppress_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
						/*	By byClick_filter2 = appInd.createAndGetByObject("Click_filter");
							WebElement elementcc = obrowser.findElement(byClick_filter2);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementcc);
							Thread.sleep(3000);
							
							By byClick_Reset2 = appInd.createAndGetByObject("Click_Reset");
							WebElement elementzz = obrowser.findElement(byClick_Reset2);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementzz);
							Thread.sleep(3000);
							
							By bySelect_Unsuppressfilter = appInd.createAndGetByObject("Select_Unsuppressfilter");
							WebElement elementqq = obrowser.findElement(bySelect_Unsuppressfilter);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementqq);
							Thread.sleep(3000);
							
							 byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
							WebElement elementff = obrowser.findElement(byClick_Filter_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementff);
							Thread.sleep(3000);
							
							 byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
							    elementb = obrowser.findElement(byClick_on_Allanomalies);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
								Thread.sleep(3000);*/
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 600);	
							int count=0;
					
							
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,4, "" );
								System.out.println(text);		
													
								if(text.equalsIgnoreCase("Unsuppressed")) {
									count++;
									System.out.println(count);
									Thread.sleep(3000);
									
								}
								else if(text==null)	
									break;
								Thread.sleep(3000);
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								strStatus = "false";
								System.out.println("Fail");
								
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounsupresstheAnamoly.png");
							appInd.writeLog("Fail", "'TC_TounsupresstheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_TounsupresstheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_TounsupresstheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************
	 * Method Name : TC_ToassignedtheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_ToassignedtheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		String user=null;
		try {
			appInd.writeLog("#", "****TC_ToassignedtheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToassignedtheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_ToassignedtheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						By bySelect_unassignfilter = appInd.createAndGetByObject("Select_unassignfilter");
						WebElement elementq = obrowser.findElement(bySelect_unassignfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
					/*	boolean jx=oGenericAppmethods.waitForJSandJQueryToLoad(obrowser);
						
						List<WebElement> elements = obrowser.findElements(By.xpath("//tbody[@id='defectMainTableRows']/descendant::input[@type='checkbox']"));
						System.out.println(elements.size());
						
							
							for(int k=0;k<2;k++) {
//								WebElement elementSelectbyDropdowng = obrowser.findElement(
//										By.xpath("//*[@id=\"defectMainTableRows\"]/tr[4]/td[1]]/tr["+k+"]/td[1]/div/label/span"));
//											((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
//												elementSelectbyDropdowng);	
								
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elements.get(k));	
							}*/
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement elementto = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementto);
							Thread.sleep(3000);
	
							By bySelect_Assign = appInd.createAndGetByObject("Select_Assign");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_Assign);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							 
							
							
							By bySelect_User = appInd.createAndGetByObject("Select_User");
							Thread.sleep(3000);
							WebElement element1=obrowser.findElement(bySelect_User);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element1);
							
							By bySelect_Username = appInd.createAndGetByObject("Select_Username");
							Thread.sleep(3000);
							WebElement element2= obrowser.findElement(bySelect_Username);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element2);
							user=element1.getText();
							System.out.println("getuser"+element1.getText());
							

							By byAssign_comment = appInd.createAndGetByObject("Assign_comment");
							Thread.sleep(3000);
							WebElement element3 = obrowser.findElement(byAssign_comment);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element3);
							
							appInd.setObject(obrowser, "Assign_comment", "Assign");
							
							By byAssign_OK = appInd.createAndGetByObject("Assign_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(byAssign_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
											
							
							
							result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
							
							/*List<WebElement> eles = obrowser.findElements(By.xpath("//div[contains(@id,'uiGrid-000E-cell')]/div"));
							System.out.println(eles.size());
							int count=0;
							for(int i=0;i<eles.size();i++) {
								if(eles.get(i).getText().trim().equals("Assign")) {
									count++;
									System.out.println(eles.get(i).getText().trim());
									
								}
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}*/
							try {
								for (int i=1 ;i<=2;i++) {
								String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,8, "" );
									System.out.println(text);		
														Thread.sleep(3000);
									if(text.equalsIgnoreCase(user)) {
										count++;
										System.out.println(count);
										Thread.sleep(5000);
										
									}
									else if(text==null)	
										break;
									
								}
								}
								catch(Exception e)
								{
									
								}
								if(count>=2)
								{
									strStatus = "true";
								System.out.println("pass");
								}
							else
							{
								strStatus = "false";
								System.out.println("fail");
								
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToassignedtheAnamoly.png");
							appInd.writeLog("Fail", "'TC_ToassignedtheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_ToassignedtheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_ToassignedtheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	
	/********************************
	 * Method Name : TC_TounassignedtheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_TounassignedtheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_TounassignedtheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounassignedtheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TounassignedtheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
						
	
						By byClick_filter = appInd.createAndGetByObject("Click_filter");
						WebElement elementc = obrowser.findElement(byClick_filter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
						Thread.sleep(3000);
						
						By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
						WebElement elementz = obrowser.findElement(byClick_Reset);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
						Thread.sleep(3000);
						
						By bySelect_assignfilter = appInd.createAndGetByObject("Select_assignfilter");
						WebElement elementq = obrowser.findElement(bySelect_assignfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

		                    // obrowser.navigate().refresh();
							
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
					
	
				
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement elementto = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementto);
							Thread.sleep(3000);
	
							By bySelect_Unassign = appInd.createAndGetByObject("Select_Unassign");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_Unassign);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							
							

							By byUnassign_comment = appInd.createAndGetByObject("Unassign_comment");
							Thread.sleep(3000);
							WebElement element3 = obrowser.findElement(byUnassign_comment);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element3);
							
							appInd.setObject(obrowser, "Unassign_comment", "Unassign");
							Thread.sleep(5000);
							By byUnassign_OK = appInd.createAndGetByObject("Unassign_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(byUnassign_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
							
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
							int count=0;
						
							
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,10, "" );
								System.out.println(text);		
													
								if(text.equalsIgnoreCase("Unassign")) {
									count++;
									System.out.println(count);
									
								}
								
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								strStatus = "false";
								System.out.println("Fail");
								/*By byclickOnLogout_btn_OK = appInd.createAndGetByObject("Logout_btn_OK");
								Thread.sleep(3000);
								WebElement elemento = obrowser.findElement(byclickOnLogout_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elemento);*/
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounassignedtheAnamoly.png");
							appInd.writeLog("Fail", "'TC_TounassignedtheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_TounassignedtheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_TounassignedtheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	/********************************
	 * Method Name : TC_ToreassignedtheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_ToreassignedtheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		String user=null;
		try {
			appInd.writeLog("#", "****TC_ToreassignedtheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToreassignedtheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_ToreassignedtheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
	
								By byClick_filter = appInd.createAndGetByObject("Click_filter");
								WebElement elementc = obrowser.findElement(byClick_filter);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
								Thread.sleep(3000);
								
								By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
								WebElement elementz = obrowser.findElement(byClick_Reset);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
								Thread.sleep(3000);
						
						By bySelect_assignfilter = appInd.createAndGetByObject("Select_assignfilter");
						WebElement elementq = obrowser.findElement(bySelect_assignfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

						// obrowser.navigate().refresh();
						
						//get the row count 
						int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
						// check the acknowledged
						if(nrowcount>2)
							nrowcount=2;
						for (int i=1 ;i<=nrowcount;i++) {
							oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
							System.out.println();		
							
						}
			
	
						
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement element = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
							Thread.sleep(3000);
	
							By bySelect_ReassignAction = appInd.createAndGetByObject("Select_ReassignAction");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_ReassignAction);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
								By bySelect_User = appInd.createAndGetByObject("Select_User");
								Thread.sleep(3000);
								WebElement element1=obrowser.findElement(bySelect_User);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element1);
							
							By bySelect_reassignusername = appInd.createAndGetByObject("Select_reassignusername");
							Thread.sleep(3000);
							WebElement element2= obrowser.findElement(bySelect_reassignusername);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element2);
							        user=element1.getText();
                                System.out.println("element2"+user);
							By byReassign_comment = appInd.createAndGetByObject("Reassign_comment");
							Thread.sleep(3000);
							WebElement element3 = obrowser.findElement(byReassign_comment);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element3);
							
							appInd.setObject(obrowser, "Reassign_comment", "Reassign");
							
							By byReassign_OK = appInd.createAndGetByObject("Reassign_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(byReassign_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
							
							
result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
							
	int count=0;

try {
for (int i=1 ;i<=2;i++) {
String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,8, "" );
	System.out.println(text);		
						
	if(text.equalsIgnoreCase(user)) {
		count++;
		System.out.println(count);
		
		
	}
	else if(text==null)	
		break;
	
}
}
catch(Exception e)
{
	
}
if(count>=2)
{
	strStatus = "true";
System.out.println("pass");
}
else
{
	strStatus = "false";
	System.out.println("Fail");
	
	
}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToreassignedtheAnamoly.png");
							appInd.writeLog("Fail", "'TC_ToreassignedtheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_ToreassignedtheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_ToreassignedtheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	
	/********************************
	 * Method Name : TC_ToreslovetheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_ToreslovetheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_ToreslovetheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToreslovetheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_ToreslovetheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
								
								By byClick_Unresolved= appInd.createAndGetByObject("Click_Unresolved");
								WebElement elementb = obrowser.findElement(byClick_Unresolved);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
								Thread.sleep(3000);
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

								// obrowser.navigate().refresh();
								
								//get the row count 
								int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
								// check the acknowledged
								if(nrowcount>2)
									nrowcount=2;
								for (int i=1 ;i<=nrowcount;i++) {
									oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
									System.out.println();		
									
								}
								Thread.sleep(2000);
								
								//Click on Actions
								By byClick_Action = appInd.createAndGetByObject("Click_Action");
								//Thread.sleep(3000);
								WebElement elementz = obrowser.findElement(byClick_Action);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
								Thread.sleep(3000);
		
								By bySelect_resolveaction = appInd.createAndGetByObject("Select_resolveaction");
								Thread.sleep(3000);
								WebElement elementd = obrowser.findElement(bySelect_resolveaction);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
								
								By byEnter_reslovecmnt = appInd.createAndGetByObject("Enter_reslovecmnt");
								Thread.sleep(3000);
								WebElement element3 = obrowser.findElement(byEnter_reslovecmnt);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element3);
								
								appInd.setObject(obrowser, "Enter_reslovecmnt", "Reslove");
								
								By byResolve_btnOK = appInd.createAndGetByObject("Resolve_btnOK");
								Thread.sleep(3000);
								WebElement elementh = obrowser.findElement(byResolve_btnOK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
								
								
									
								
								result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
								int count=0;
							
								
								try {
								for (int i=1 ;i<=2;i++) {
								String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,10, "" );
									System.out.println(text);		
														
									if(text.equalsIgnoreCase("Reslove")) {
										count++;
										System.out.println(count);
										
									}
									else if(text==null)	
										break;
								}
								}
								catch(Exception e)
								{
									
								}
								if(count>=2)
								{
									strStatus = "true";
								System.out.println("pass");
								}
								else
								{
									strStatus = "false";
									System.out.println("Fail");
									/*By byclickOnLogout_btn_OK = appInd.createAndGetByObject("Logout_btn_OK");
									Thread.sleep(3000);
									WebElement elemento = obrowser.findElement(byclickOnLogout_btn_OK);
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elemento);*/
									
								}
								//========================================================================
		                     }catch(Exception e){
		                    	 //strStatus = "false";
									//System.out.println("Fail");
		                    		
							}
							}
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_ToreslovetheAnamoly.png");
							appInd.writeLog("Fail", "'TC_ToreslovetheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_ToreslovetheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_ToreslovetheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	
	/********************************
	 * Method Name : TC_TounreslovetheAnamoly Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_TounreslovetheAnamoly() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_TounreslovetheAnamoly :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						//if(sysName.equals("")) {
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
						
						bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
						}
						
							catch(Exception e)
								{strStatus+=false;
								appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
										+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounreslovetheAnamoly_invalidCredential_Fail_snapshot.png");
								appInd.writeLog("Fail", "'TC_TounreslovetheAnamoly' script was failed");
								}
						}	
						if(row>system.size())
						{
							strStatus+=false;
						}
						else
						{
							try {
						
								boolean result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
								
								By byClick_filter = appInd.createAndGetByObject("Click_filter");
								WebElement elementc = obrowser.findElement(byClick_filter);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementc);
								Thread.sleep(3000);
								
								By byClick_Reset = appInd.createAndGetByObject("Click_Reset");
								WebElement elementz = obrowser.findElement(byClick_Reset);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementz);
								Thread.sleep(3000);
						
						By bySelect_Resolvedfilter = appInd.createAndGetByObject("Select_Resolvedfilter");
						WebElement elementq = obrowser.findElement(bySelect_Resolvedfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementq);
						Thread.sleep(3000);
						
						By byClick_Filter_OK = appInd.createAndGetByObject("Click_Filter_OK");
						WebElement elementf = obrowser.findElement(byClick_Filter_OK);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementf);
						Thread.sleep(3000);
						
						By byClick_on_Allanomalies= appInd.createAndGetByObject("Click_on_Allanomalies");
						WebElement elementb = obrowser.findElement(byClick_on_Allanomalies);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
						Thread.sleep(3000);
						
						

						result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	

						// obrowser.navigate().refresh();
						
						//get the row count 
						int nrowcount =Integer.parseInt(oGenericAppmethods.MainGrid_Operation(obrowser,"get_rowcount",0 ,0, "" ));
						// check the acknowledged
						if(nrowcount>2)
							nrowcount=2;
						for (int i=1 ;i<=nrowcount;i++) {
							oGenericAppmethods.MainGrid_Operation(obrowser,"click",i ,1, "" );
							System.out.println();		
							
						}
					
	
					
							
							//###################################################################################
							
							Thread.sleep(2000);
							
							//Click on Actions
							By byClick_Action = appInd.createAndGetByObject("Click_Action");
							//Thread.sleep(3000);
							WebElement element = obrowser.findElement(byClick_Action);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
							Thread.sleep(3000);
	
							By bySelect_unresolveaction = appInd.createAndGetByObject("Select_unresolveaction");
							Thread.sleep(3000);
							WebElement elementd = obrowser.findElement(bySelect_unresolveaction);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementd);
							
							
							
								
							
						

							By byEnter_Unresolvecmnt = appInd.createAndGetByObject("Enter_Unresolvecmnt");
							Thread.sleep(3000);
							WebElement element3 = obrowser.findElement(byEnter_Unresolvecmnt);
							((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element3);
							
							appInd.setObject(obrowser, "Enter_Unresolvecmnt", "Unresolve");
							
							By byUnresolve_OK = appInd.createAndGetByObject("Unresolve_OK");
							Thread.sleep(3000);
							WebElement elementh = obrowser.findElement(byUnresolve_OK);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementh);
							
							By byClick_Unresolved= appInd.createAndGetByObject("Click_Unresolved");
							WebElement elementa = obrowser.findElement(byClick_Unresolved);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementa);
							Thread.sleep(3000);
							
							result=	appInd.waitFor(obrowser, "ajax_loading", "invisible", "", 100);	
							int count=0;
						
							
							try {
							for (int i=1 ;i<=2;i++) {
							String text=	oGenericAppmethods.MainGrid_Operation(obrowser,"get_innertext",i ,10, "" );
								System.out.println(text);		
													
								if(text.equalsIgnoreCase("Unresolve")) {
									count++;
									System.out.println(count);
									
								}
								else if(text==null)	
									break;
							}
							}
							catch(Exception e)
							{
								
							}
							if(count>=2)
							{
								strStatus = "true";
							System.out.println("pass");
							}
							else
							{
								strStatus = "false";
								System.out.println("Fail");
								/*By byclickOnLogout_btn_OK = appInd.createAndGetByObject("Logout_btn_OK");
								Thread.sleep(3000);
								WebElement elemento = obrowser.findElement(byclickOnLogout_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elemento);*/
								
							}
							//========================================================================
	                     }catch(Exception e){
	                    	 //strStatus = "false";
								//System.out.println("Fail");
	                    		
						}
						}
							
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TounreslovetheAnamoly.png");
							appInd.writeLog("Fail", "'TC_TounreslovetheAnamoly' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_TounreslovetheAnamoly' script was Successful");
							bolstatus = true;
							strStatus = null;
						}
				
				}
			}
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_TounreslovetheAnamoly' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}
	
	
	//==============================================================================================================//
	//Testcases //
	/********************************
	 * Method Name : TC_Filter_Edit : This method will launch the home
	 * screen Author : Janhavi Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Filter_Edit() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_Filter_Edit :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
					//navigation of Engineering page
						Thread.sleep(8000);
						strStatus+=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
						
						
					//Selecting the system	
						
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
								"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
				System.out.println(system.size());
				
				String dropDown=null;
				int row;
				for (row = 1;row<=system.size(); row++) {
					try {
						By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbySelect_systemdropdown);
						 dropDown = obrowser
								.findElement(By.xpath(
										"\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
								.getText();
						 System.out.println("dropdowm"+dropDown);
				String sysName = oinpuTDtMap.get("Param_1");
				//if(sysName.equals("")) {
					if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

					{							WebElement element = obrowser.findElement(
							By.xpath("\r\n" + 
									"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
                    Thread.sleep(5000);
					strStatus+=true;
					break;
					}
//					strStatus+=false;
//					appInd.writeLog("Fail", "System can not be find");
//				}
				
				bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
				elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
				((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
				}
				
					catch(Exception e)
						{strStatus+=false;
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit_invalidCredential_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_Edit' script was failed");
						}
				}
				
				
				
				if(row>system.size())
				{
					strStatus+=false;
				}
				else
				{
				//==========================================================	
					try {
						//Filter based on the Acknowledged action
						By bySaved_Filterlist = appInd.createAndGetByObject("Saved_Filterlist");
						Thread.sleep(3000);
						WebElement element9 = obrowser.findElement(bySaved_Filterlist);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element9);
						
						if(appInd.isElementPresent(obrowser, "Filter_List_anomaly"))
						{
							
							
							By byClickon_Editfilter = appInd.createAndGetByObject("Clickon_Editfilter");
						Thread.sleep(3000);
						WebElement element4 = obrowser.findElement(byClickon_Editfilter);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element4);
						
						 //Enter filtername			
						By byEnter_filtername = appInd.createAndGetByObject("Enter_filtername");
						Thread.sleep(3000);
						WebElement elementk = obrowser.findElement(byEnter_filtername);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elementk);
						obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[2]/input")).clear();
						appInd.setObject(obrowser, "Enter_filtername", oinpuTDtMap.get("Param_2"));
						Thread.sleep(3000);
		        //#######################################################################################
		              //Enter Description				
						By byEnter_description = appInd.createAndGetByObject("Enter_description");
						Thread.sleep(3000);
						WebElement elements = obrowser.findElement(byEnter_description);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elements);
						obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[3]/input")).clear();
						appInd.setObject(obrowser, "Enter_description",  oinpuTDtMap.get("Param_3"));
						Thread.sleep(3000);
		       //##################################################################################
		             //Click Save Filter				
						By byClick_SaveFilter_Anomaly = appInd.createAndGetByObject("Click_SaveFilter_Anomaly");
						Thread.sleep(3000);
						WebElement element5 = obrowser.findElement(byClick_SaveFilter_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element5);
						Thread.sleep(3000);
	
						//#######################################################################################
						//Check the saved filter list
						By bySavedFilter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
						Thread.sleep(2000);
						List<WebElement> savedFilter_Name_List = obrowser.findElements(bySavedFilter_Name_List);
						for(int j=0;j<savedFilter_Name_List.size();j++) {
							if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_2"))) {
								strStatus = "false";
								 System.out.println("strStatus:::"+ strStatus);
								 break;
								 
								 
							 }
							strStatus = "true";
						}	}
						else {
							strStatus = "false";
						}
						}catch(Exception e) {
							e.printStackTrace();
							strStatus += false;
							appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
							//appInd.takeSnapShot(obrowser, System.getProperty("user.dir"));
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit.png");
						
						}
					
				
				
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit.png");
						appInd.writeLog("Fail", "'TC_Filter_Edit' script was failed");
						bolstatus = false;
						strStatus = null;
					} else  {
						appInd.writeLog("Pass", "'TC_Filter_Edit' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
			
			}
		}
				 else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		return oinputMap;
			
	
		} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Filter_Edit' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
		return oinputMap;
	}
	
	}	
	
	
	/********************************
	 * Method Name : TC_Filter_Delete : This method will launch the home
	 * screen Author : Janhavi Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Filter_Delete() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_Filter_Delete :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
					//navigation of Engineering page
						Thread.sleep(8000);
						strStatus+=oGenericAppmethods.menu_EngeeringAnomoly_Navigation(obrowser);
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
								"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
				System.out.println(system.size());
				
				String dropDown=null;
				int row;
				for (row = 1;row<=system.size(); row++) {
					try {
						By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbySelect_systemdropdown);
						 dropDown = obrowser
								.findElement(By.xpath(
										"\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
								.getText();
						 System.out.println("dropdowm"+dropDown);
				String sysName = oinpuTDtMap.get("Param_1");
				//if(sysName.equals("")) {
					if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

					{							WebElement element = obrowser.findElement(
							By.xpath("\r\n" + 
									"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
                    Thread.sleep(5000);
					strStatus+=true;
					break;
					}
//					strStatus+=false;
//					appInd.writeLog("Fail", "System can not be find");
//				}
				
				bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
				elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
				((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
				}
				
					catch(Exception e)
						{strStatus+=false;
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit_Systemnotfound_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_Edit' script was failed");
						}
				}
				
				
				
				if(row>system.size())
				{
					strStatus+=false;
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit_Systemnotfound_Fail_snapshot.png");
				}
				else
				{
				//==========================================================	
					try {
						//Filter based on the Acknowledged action
						By bySaved_Filterlist = appInd.createAndGetByObject("Saved_Filterlist");
						Thread.sleep(3000);
						WebElement element9 = obrowser.findElement(bySaved_Filterlist);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element9);
						
						if(appInd.isElementPresent(obrowser, "Project_List_anomaly"))
						{
							
							
					    By byDelete_FilterAnomaly = appInd.createAndGetByObject("Delete_FilterAnomaly");
						Thread.sleep(3000);
						WebElement element4 = obrowser.findElement(byDelete_FilterAnomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element4);
						Thread.sleep(5000);
						
						By byAnomalyFilterdelete_confirm = appInd.createAndGetByObject("AnomalyFilterdelete_confirm");
						Thread.sleep(3000);
						WebElement element2 = obrowser.findElement(byAnomalyFilterdelete_confirm);
						((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element2);
		                      Thread.sleep(5000);
	
						//#######################################################################################
						//Check the saved filter list
						//By bySavedFilter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
						//Thread.sleep(2000);
						//List<WebElement> savedFilter_Name_List = obrowser.findElements(bySavedFilter_Name_List);
						//for(int j=0;j<savedFilter_Name_List.size();j++) {
							//if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_2"))) {
								//strStatus = "false";
								 //System.out.println("strStatus:::"+ strStatus);
								// break;
							// }
							//strStatus = "true";
						//}
						}
						else {
							strStatus += false;
							Thread.sleep(3000);
							appInd.writeLog("Fail", "Fiter is not deleted");	
							//appInd.takeSnapShot(obrowser, System.getProperty("user.dir"));
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Delete.png");
						}
						}catch(Exception e) {
							
						
						}
					
				
						// ########################################################################
						if (strStatus.contains("false")) {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Delete.png");
							appInd.writeLog("Fail", "'TC_Filter_Delete' script was failed");
							bolstatus = false;
							strStatus = null;
						} else  {
							appInd.writeLog("Pass", "'TC_Filter_Delete' script was Successful");
							bolstatus = true;
							strStatus = null;
						
						}
							
					}
					
					}
			}
					
					 else {
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
					appInd.writeLog("Fail", "Failed to launch the IE browser");
					bolstatus = false;
				}
				// write the result into Map
				if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Fail");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);

				} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
					oinpuTDtMap.put("result", "Pass");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				} else {
					oinpuTDtMap.put("result", "Skip");
					oinpuTDtMap.put("countvalue", strcommonCountvalue);
				}
				strcurrentTD = String.valueOf(TD);
				oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
				oinpuTDtMap = null;
			} // for loop
			return oinputMap;
				
		
			} catch (Exception e) {
			appInd.writeLog("Exception", "Exception while executing 'TC_Filter_Delete' method. " + e.getMessage());
			oinpuTDtMap.put("result", "Fail");
			//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			return oinputMap;
		} finally {
			System.out.println("end");
			return oinputMap;
		}
		
		}		
	

	/********************************
	 * Method Name : TC_Tocreateprivatefilter Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Tocreateprivatefilter() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_Tocreateprivatefilter :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(8000);
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
					//#################################################################################
						//Selecting System
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
                             Thread.sleep(5000);
							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
							
							bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
							elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
							}
							
								catch(Exception e)
									{strStatus+=false;
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TC_Tocreateprivatefilter_systemnotfound_Fail_snapshot.png");
									appInd.writeLog("Fail", "'TC_Tocreateprivatefilter' script was failed");
									}
							}	
						
						
						if(row>system.size())
						{
							strStatus+=false;
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_TC_Tocreateprivatefilter_systemnotfound_Fail_snapshot.png");
						}
						else
						{
							try {
							//###########################################################################
								//Click on Filter
							By byClick_filter = appInd.createAndGetByObject("Click_filter");
							Thread.sleep(2000);
							WebElement element1 = obrowser.findElement(byClick_filter);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element1);
							Thread.sleep(3000);
							//###########################################################################
							//Select Anomaly name
							By checkBox_List = appInd.createAndGetByObject("AnomalyName_CheckBox_List");
							List<WebElement> anomalyName_CheckBox_List = obrowser.findElements(checkBox_List);
							
							for(int i=0;i<2;i++) {
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_CheckBox_List.get(i));
								Thread.sleep(5000);
							}
								
								By bySelect_Private = appInd.createAndGetByObject("Select_Private");
								Thread.sleep(3000);
								WebElement element2 = obrowser.findElement(bySelect_Private);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element2);
								Thread.sleep(3000);
							//##########################################################################
								//Enter Filter name
								By byEnter_filtername = appInd.createAndGetByObject("Enter_filtername");
								Thread.sleep(3000);
								WebElement elementk = obrowser.findElement(byEnter_filtername);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elementk);
								obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[2]/input")).clear();
								appInd.setObject(obrowser, "Enter_filtername", oinpuTDtMap.get("Param_2"));
								Thread.sleep(3000);
							//##############################################################################
								//Enter Description
								By byEnter_description = appInd.createAndGetByObject("Enter_description");
								Thread.sleep(3000);
								WebElement elements = obrowser.findElement(byEnter_description);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elements);
								obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[3]/input")).clear();
								appInd.setObject(obrowser, "Enter_description",  oinpuTDtMap.get("Param_3"));
								Thread.sleep(3000);
							//###############################################################################
								//Click on Save filter
								By byClick_SaveFilter_Anomaly = appInd.createAndGetByObject("Click_SaveFilter_Anomaly");
								Thread.sleep(3000);
								WebElement element5 = obrowser.findElement(byClick_SaveFilter_Anomaly);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element5);
								Thread.sleep(5000);
							//##################################################################################	
								//Logout
								By byclickOnLogout_btn_OK = appInd.createAndGetByObject("Logout_btn_OK");
								Thread.sleep(3000);
								WebElement elementb = obrowser.findElement(byclickOnLogout_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
								Thread.sleep(5000);
							//####################################################################################
								//Login with another user
								strStatus += String.valueOf(
										appInd.clearAndSetObject(obrowser, "Login_txtbx_Username", oinpuTDtMap.get("Param_4")));
								// Set the Password value
								strStatus += String.valueOf(
										appInd.clearAndSetObject(obrowser, "Login_txtbx_Password", oinpuTDtMap.get("Param_5")));
								// click on the ok button
								By byclickOnLogin_btn_OK = appInd.createAndGetByObject("Login_btn_OK");
								WebElement element = obrowser.findElement(byclickOnLogin_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
								Thread.sleep(8000);
								String ur=obrowser.getCurrentUrl();
			              		if (ur.contains("home")) {
									appInd.writeLog("Fail", "'TC_Loginscreen' script was failed");
									bolstatus = false;
									strStatus += false;
								}
								 else {
									 bolstatus = true;
										strStatus += true;	 
								 }
								
								Thread.sleep(5000);
								By clickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
								Thread.sleep(3000);
								WebElement element8 = obrowser.findElement(clickOnMenu_bar);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element8);
								Thread.sleep(5000);
								By Engineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
								Thread.sleep(3000);
								WebElement elementj = obrowser.findElement(Engineering_Anomaly);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementj);
							//###################################################################################
								//Select Sysyem 
                               Thread.sleep(5000);
								List <WebElement> system1= obrowser.findElements(By.xpath("\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
								System.out.println(system.size());
								
								String dropDown1=null;
								int row1;
								for (row = 1;row<=system.size(); row++) {
									try {
										By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
										WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
												elementbySelect_systemdropdown);
										 dropDown = obrowser
												.findElement(By.xpath(
														"\r\n" + 
														"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
												.getText();
										 System.out.println("dropdowm"+dropDown);
								String sysName = oinpuTDtMap.get("Param_1");
									if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

									{							WebElement elementm = obrowser.findElement(
											By.xpath("\r\n" + 
													"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementm);
                                        Thread.sleep(5000);
									strStatus+=true;
									break;
									}
//									strStatus+=false;
//									appInd.writeLog("Fail", "System can not be find");
//								}
									
									bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
									elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
									}
									
										catch(Exception e)
											{strStatus+=false;
											appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
													+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreateprivatefilter_system_Fail_snapshot.png");
											appInd.writeLog("Fail", "'TC_Tocreateprivatefilter' script was failed");
											}
									}
								//#############################################################################
								//Click on saved filter icon
								By byVerify_Filter = appInd.createAndGetByObject("Verify_Filter");
								Thread.sleep(3000);
								WebElement elementp = obrowser.findElement(byVerify_Filter);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elementp);
								Thread.sleep(3000);
							//#################################################################################
								//Verify saved filter list
								By bySavedFilter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
								Thread.sleep(2000);
								List<WebElement> savedFilter_Name_List = obrowser.findElements(bySavedFilter_Name_List);
								for(int j=0;j<savedFilter_Name_List.size();j++) {
									if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_2"))) {
										strStatus = "false";
										 System.out.println("strStatus:::"+ strStatus);
										 break;
									 }
									strStatus = "true";
								}}catch(Exception e) {
									e.printStackTrace();
									strStatus += false;
									appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
									//appInd.takeSnapShot(obrowser, System.getProperty("user.dir"));
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreateprivatefilter.png");
								}
							Thread.sleep(5000);
								// ########################################################################
								if (strStatus.contains("false")) {
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreateprivatefilter.png");
									appInd.writeLog("Fail", "'TC_Tocreateprivatefilter' script was failed");
									bolstatus = false;
									strStatus = null;
								} else  {
									appInd.writeLog("Pass", "'TC_Tocreateprivatefilter' script was Successful");
									bolstatus = true;
									strStatus = null;
								}
							}
						
						}
					}
							 else {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
							appInd.writeLog("Fail", "Failed to launch the IE browser");
							bolstatus = false;
						}
						// write the result into Map
						if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Fail");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);

						} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Skip");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Pass");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						} else {
							oinpuTDtMap.put("result", "Skip");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						}
						strcurrentTD = String.valueOf(TD);
						oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
						oinpuTDtMap = null;
					} // for loop
					return oinputMap;
						
				
					} catch (Exception e) {
					appInd.writeLog("Exception", "Exception while executing 'TC_Tocreateprivatefilter' method. " + e.getMessage());
					oinpuTDtMap.put("result", "Fail");
					//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
					return oinputMap;
				} finally {
					System.out.println("end");
					return oinputMap;
				}
				
				}	
	
	
		

	/********************************
	 * Method Name : TC_Tocreatepublicfilter Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Tocreatepublicfilter() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		try {
			appInd.writeLog("#", "****TC_Tocreatepublicfilter :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(8000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
				//###########################################################################################		
				//Selecting System		
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
						System.out.println(system.size());
						String dropDown=null;
						int row;
						for (row = 1;row<=system.size(); row++) {
							try {
								By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
								WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
										elementbySelect_systemdropdown);
								 dropDown = obrowser
										.findElement(By.xpath(
												"\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
										.getText();
								 System.out.println("dropdowm"+dropDown);
						String sysName = oinpuTDtMap.get("Param_1");
						
							if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

							{							WebElement element = obrowser.findElement(
									By.xpath("\r\n" + 
											"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
							Thread.sleep(5000);
							strStatus+=true;
							break;
							}
//							strStatus+=false;
//							appInd.writeLog("Fail", "System can not be find");
//						}
							bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
							elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
							}
								catch(Exception e)
									{strStatus+=false;
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreatepublicfilter_invalidCredential_Fail_snapshot.png");
									appInd.writeLog("Fail", "'TC_Tocreatepublicfilter' script was failed");
									}
							}	
						if(row>system.size())
						{
							strStatus+=false;
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreatepublicfilter_Systemnotfound_Fail_snapshot.png");
						}
						else
						{
							try {
					//##########################################################################
					    //Click on filter			
							By byClick_filter = appInd.createAndGetByObject("Click_filter");
							Thread.sleep(2000);
							WebElement element1 = obrowser.findElement(byClick_filter);
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element1);
							Thread.sleep(3000);
					//#############################################################################
					    //Select Anomaly name		
							By checkBox_List = appInd.createAndGetByObject("AnomalyName_CheckBox_List");
							List<WebElement> anomalyName_CheckBox_List = obrowser.findElements(checkBox_List);
							
							for(int i=0;i<2;i++) {
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",anomalyName_CheckBox_List.get(i));
								Thread.sleep(5000);
							}
					//##################################################################################
					   //Select public		
								By bySelect_Public = appInd.createAndGetByObject("Select_Public");
								Thread.sleep(3000);
								WebElement element2 = obrowser.findElement(bySelect_Public);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element2);
								Thread.sleep(3000);
					//#####################################################################################
					        //Enter filtername			
								By byEnter_filtername = appInd.createAndGetByObject("Enter_filtername");
								Thread.sleep(3000);
								WebElement elementk = obrowser.findElement(byEnter_filtername);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elementk);
								obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[2]/input")).clear();
								appInd.setObject(obrowser, "Enter_filtername", oinpuTDtMap.get("Param_2"));
								Thread.sleep(3000);
				        //#######################################################################################
				              //Enter Description				
								By byEnter_description = appInd.createAndGetByObject("Enter_description");
								Thread.sleep(3000);
								WebElement elements = obrowser.findElement(byEnter_description);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elements);
								obrowser.findElement(By.xpath("//*[@id=\"formDefectFilter\"]/div[2]/div[1]/div[2]/div[3]/input")).clear();
								appInd.setObject(obrowser, "Enter_description",  oinpuTDtMap.get("Param_3"));
								Thread.sleep(3000);
				       //##################################################################################
				             //Click Save Filter				
								By byClick_SaveFilter_Anomaly = appInd.createAndGetByObject("Click_SaveFilter_Anomaly");
								Thread.sleep(3000);
								WebElement element5 = obrowser.findElement(byClick_SaveFilter_Anomaly);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", element5);
								Thread.sleep(3000);
				         //#######################################################################################
						    //Logout		
								
								By byclickOnLogout_btn_OK = appInd.createAndGetByObject("Logout_btn_OK");
								Thread.sleep(3000);
								WebElement elementb = obrowser.findElement(byclickOnLogout_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementb);
								Thread.sleep(5000);
							//############################################################################################
								//Login with another user
								strStatus += String.valueOf(
										appInd.clearAndSetObject(obrowser, "Login_txtbx_Username", oinpuTDtMap.get("Param_4")));
								// Set the Password value
								strStatus += String.valueOf(
										appInd.clearAndSetObject(obrowser, "Login_txtbx_Password", oinpuTDtMap.get("Param_5")));
								// click on the ok button
								By byclickOnLogin_btn_OK = appInd.createAndGetByObject("Login_btn_OK");
								WebElement element = obrowser.findElement(byclickOnLogin_btn_OK);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
								Thread.sleep(8000);
								String ur=obrowser.getCurrentUrl();
			              		if (ur.contains("home")) {
									appInd.writeLog("Fail", "'TC_Loginscreen' script was failed");
									bolstatus = false;
									strStatus += false;
								}
								 else {
									 bolstatus = true;
										strStatus += true;	 
								 }
								
								Thread.sleep(5000);
								
								By clickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
								Thread.sleep(3000);
								WebElement element8 = obrowser.findElement(clickOnMenu_bar);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element8);
								Thread.sleep(5000);
								By Engineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
								Thread.sleep(3000);
								WebElement elementj = obrowser.findElement(Engineering_Anomaly);
								((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementj);
								Thread.sleep(8000);

								List <WebElement> system1= obrowser.findElements(By.xpath("\r\n" + 
												"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
								System.out.println(system.size());
								
								String dropDown1=null;
								int row1;
								for (row = 1;row<=system.size(); row++) {
									try {
										By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
										WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
												elementbySelect_systemdropdown);
										 dropDown = obrowser
												.findElement(By.xpath(
														"\r\n" + 
														"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
												.getText();
										 System.out.println("dropdowm"+dropDown);
								String sysName = oinpuTDtMap.get("Param_1");
								
									if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

									{							WebElement elementm = obrowser.findElement(
											By.xpath("\r\n" + 
													"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementm);
                                        Thread.sleep(5000);
									strStatus+=true;
									break;
									}
//									strStatus+=false;
//									appInd.writeLog("Fail", "System can not be find");
//								}
									
									bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
									elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
									((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
									}
									
										catch(Exception e)
											{strStatus+=false;
											appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
													+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreatepublicfilter_invalidCredential_Fail_snapshot.png");
											appInd.writeLog("Fail", "'TC_Tocreatepublicfilter' script was failed");
											}
									}	
								//######################################################################################
								//Click on saved filter icon
								By byVerify_Filter = appInd.createAndGetByObject("Verify_Filter");
								Thread.sleep(3000);
								WebElement elementp = obrowser.findElement(byVerify_Filter);
								((JavascriptExecutor) obrowser).executeScript("arguments[0]. click();", elementp);
								Thread.sleep(3000);
								//#######################################################################################
								//Check the saved filter list
								By bySavedFilter_Name_List = appInd.createAndGetByObject("SavedFilter_Name_List");
								Thread.sleep(2000);
								List<WebElement> savedFilter_Name_List = obrowser.findElements(bySavedFilter_Name_List);
								for(int j=0;j<savedFilter_Name_List.size();j++) {
									if(savedFilter_Name_List.get(j).getText().contains(oinpuTDtMap.get("Param_2"))) {
										strStatus = "true";
										 System.out.println("strStatus:::"+ strStatus);
										 break;
									 }
									strStatus = "false";
								}}catch(Exception e) {
									e.printStackTrace();
									strStatus += false;
									appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
									//appInd.takeSnapShot(obrowser, System.getProperty("user.dir"));
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreatepublicfilter.png");
								}
							Thread.sleep(5000);
								// ########################################################################
								if (strStatus.contains("false")) {
									appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
											+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Tocreatepublicfilter.png");
									appInd.writeLog("Fail", "'TC_Tocreatepublicfilter' script was failed");
									bolstatus = false;
									strStatus = null;
								} else  {
									appInd.writeLog("Pass", "'TC_Tocreatepublicfilter' script was Successful");
									bolstatus = true;
									strStatus = null;
								}
							}
						
						}
					}
							 else {
							appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
									+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
							appInd.writeLog("Fail", "Failed to launch the IE browser");
							bolstatus = false;
						}
						// write the result into Map
						if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Fail");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);

						} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Skip");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
							oinpuTDtMap.put("result", "Pass");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						} else {
							oinpuTDtMap.put("result", "Skip");
							oinpuTDtMap.put("countvalue", strcommonCountvalue);
						}
						strcurrentTD = String.valueOf(TD);
						oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
						oinpuTDtMap = null;
					} // for loop
					return oinputMap;
						
				
					} catch (Exception e) {
					appInd.writeLog("Exception", "Exception while executing 'TC_Tocreatepublicfilter' method. " + e.getMessage());
					oinpuTDtMap.put("result", "Fail");
					//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
					return oinputMap;
				} finally {
					System.out.println("end");
					return oinputMap;
				}
				
				}	
	
	
	/********************************
	 * Method Name : TC_Customanomalytagname Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Customanomalytagname() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		  String objarr[] = null;
		try {
			appInd.writeLog("#", "****TC_Customanomalytagname :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
				// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
								"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
				System.out.println(system.size());
				
				String dropDown=null;
				int row;
				for (row = 1;row<=system.size(); row++) {
					try {
						By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbySelect_systemdropdown);
						 dropDown = obrowser
								.findElement(By.xpath(
										"\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
								.getText();
						 System.out.println("dropdowm"+dropDown);
				String sysName = oinpuTDtMap.get("Param_1");
				//if(sysName.equals("")) {
					if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

					{							WebElement element = obrowser.findElement(
							By.xpath("\r\n" + 
									"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

					strStatus+=true;
					break;
					}
//					strStatus+=false;
//					appInd.writeLog("Fail", "System can not be find");
//				}
				
				bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
				elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
				((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
				}
				
					catch(Exception e)
						{strStatus+=false;
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit_invalidCredential_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Filter_Edit' script was failed");
						}
				}
				
				
				
				if(row>system.size())
				{
					strStatus+=false;
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Filter_Edit_Systemnotfound_Fail_snapshot.png");
				}
				else
				{
						
					By	byClick_Customanomaly = appInd.createAndGetByObject("Click_Customanomaly");
					WebElement element = obrowser.findElement(byClick_Customanomaly);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					
					By	byClick_addtags = appInd.createAndGetByObject("Click_addtags");
					 element = obrowser.findElement(byClick_addtags);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					
				By	byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(3000);
					
					By bySelect_Objects = appInd.createAndGetByObject("Select_Objects");
					List<WebElement> Object_nameList = obrowser.findElements(bySelect_Objects);
					
					By bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
					List<WebElement> ObjectNameList = obrowser.findElements(bySelect_objectschkbx);
					//Thread.sleep(2000);
					
					
					//List<WebElement> savedFilter_Name_List = obrowser.findElements("//div[@class='btn-group bootstrap-select lightbox pl10 open']/descendant::label[@class='ng-binding']");
					for(int j=0;j<Object_nameList.size();j++) {
						if(Object_nameList.get(j).getText().equals(oinpuTDtMap.get("Param_2"))) {
							
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", ObjectNameList.get(j));
						
//							bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
//							 element = obrowser.findElement(bySelect_objectschkbx);
//							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
							strStatus = "true";
								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
						
					}
					Thread.sleep(3000);
					
						byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
			
//					}catch(Exception e) {
//						e.printStackTrace();
//						strStatus += false;
//						appInd.writeLog("Fail", "Fiter is not Saved Successfully");	
//						appInd.takeSnapShot(obrowser, System.getProperty("user.dir"));
//					}
				/*	By	bySelect_Objects = appInd.createAndGetByObject("Select_Objects");
					 element = obrowser.findElement(bySelect_Objects);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
														
					appInd.selectDropdownvalue(obrowser, "Select_Objects", oinpuTDtMap.get("Param_2"));*/
					
					
					obrowser.findElement(By.xpath("//*[@id=\"no-of-tags\"]")).clear();
					appInd.setObject(obrowser, "Charactersfor_Tag", oinpuTDtMap.get("Param_3"));
					
					Thread.sleep(3000);
					
					String str= oinpuTDtMap.get("Param_4");
			
					  objarr=str.split(",");
					  for(int i=0;i<objarr.length;i++)
					  {
						  System.out.println(objarr[i]);
						  String xpath="//*[@id=\"tagPattern"+(i+1)+"\"]";
						  obrowser.findElement(By.xpath(xpath)).clear();
						  obrowser.findElement(By.xpath(xpath)).sendKeys(objarr[i]);
					  }
					  
					
					obrowser.findElement(By.xpath("//*[@id=\"txtTagConventionName\"]")).clear();
					appInd.setObject(obrowser, "Tagname_Convention", oinpuTDtMap.get("Param_5"));
					
					Thread.sleep(3000);
					
					By	byClick_Done = appInd.createAndGetByObject("Click_Done");
					WebElement elementi = obrowser.findElement(byClick_Done);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementi);
					
					
					try {
						
						By byClik_abortcollectionOK = appInd
						.createAndGetByObject("Clik_abortcollectionOK");
						WebElement elementbyClik_abortcollectionOK = obrowser
						.findElement(byClik_abortcollectionOK);

						if (elementbyClik_abortcollectionOK != null) {
						strStatus += "false";
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalytagname_Fail_systemalreadyExistsnapshot.png");
						Thread.sleep(5000);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbyClik_abortcollectionOK);
						
						Thread.sleep(3000);
						By	byClose_customanomaly = appInd.createAndGetByObject("Close_customanomaly");
				          element = obrowser.findElement(byClose_customanomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
						
						}
						} catch (Exception e) {
							
						
					
					By	byClose_customanomaly = appInd.createAndGetByObject("Close_customanomaly");
			          element = obrowser.findElement(byClose_customanomaly);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					
					//Click on filter			
					By byClick_filter = appInd.createAndGetByObject("Click_filter");
					Thread.sleep(2000);
					WebElement element1 = obrowser.findElement(byClick_filter);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element1);
					Thread.sleep(3000);
					
					
					//Select Anomaly name
					By checkBox_List = appInd.createAndGetByObject("Get_Anomalynamelist");
					List<WebElement> Get_Anomalynamelist = obrowser.findElements(checkBox_List);
					int j;
					for( j=0;j<Get_Anomalynamelist.size();j++) {
						 System.out.println("strStatus:::"+ Get_Anomalynamelist.get(j).getText());
						String name=Get_Anomalynamelist.get(j).getText();
                       if(name.equalsIgnoreCase(oinpuTDtMap.get("Param_5"))) {
                    	   strStatus = "true";
												
//							bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
//							 element = obrowser.findElement(bySelect_objectschkbx);
//							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
					//	strStatus = "true";
					}
						Thread.sleep(5000);
									
					if (j==Get_Anomalynamelist.size())
						strStatus = "false";
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalytagname.png");
						appInd.writeLog("Fail", "'TC_Customanomalytagname' script was failed");
						bolstatus = false;
						strStatus = null;
					} else  {
						appInd.writeLog("Pass", "'TC_Customanomalytagname' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
				}
				}
			}
		}
				 else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		return oinputMap;
			
	
		} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Customanomalytagname' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
		return oinputMap;
	}
	
	}

	
	
	/********************************
	 * Method Name : TC_Customanomalymorethanone_Rule Purpose : This method will launch the home
	 * screen Author : Janhavi TK Reviewer : Date of Creation : 29-Oct-2018 Date of
	 * modification : 21-Nov-2018 ******************************
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, HashMap> TC_Customanomalymorethanone_Rule() {
		Map<String, HashMap> oinputMap = new HashMap<String, HashMap>();
		Map<String, String> oinpuTDtMap = new HashMap<String, String>();
		String strcurrentTD = null;
		String strcommonCountvalue = null;
		String strcommonTime = null;
		  String objarr[] = null;
		try {
			appInd.writeLog("#", "****TC_Customanomalymorethanone_Rule :- started*****");
			obrowser = oDriver.getWebDriver();
			boolean bolstatus = false;
			String strExecutionsts = null;
 			oinputMap = appInd.getInputData(strTCID);
			for (int TD = 1; TD <= oinputMap.size(); TD++) {
				oinpuTDtMap = oinputMap.get(String.valueOf(TD));

				if ((obrowser != null)) {
					// Read the Execution Status
					strExecutionsts = oinpuTDtMap.get("Executestatus");
					if (strExecutionsts.equalsIgnoreCase("yes")) {
// ################################################################################
						
						Thread.sleep(5000);
						
						By byclickOnMenu_bar = appInd.createAndGetByObject("Menu_bar");
						Thread.sleep(3000);
						WebElement element7 = obrowser.findElement(byclickOnMenu_bar);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element7);
						Thread.sleep(5000);
						By byEngineering_Anomaly = appInd.createAndGetByObject("Engineering_Anomaly");
						Thread.sleep(3000);
						WebElement element6 = obrowser.findElement(byEngineering_Anomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element6);
						
						
						
						List <WebElement> system= obrowser.findElements(By.xpath("\r\n" + 
								"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li/a"));
				System.out.println(system.size());
				
				String dropDown=null;
				int row;
				for (row = 1;row<=system.size(); row++) {
					try {
						By bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
						WebElement elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbySelect_systemdropdown);
						 dropDown = obrowser
								.findElement(By.xpath(
										"\r\n" + 
										"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"))
								.getText();
						 System.out.println("dropdowm"+dropDown);
				String sysName = oinpuTDtMap.get("Param_1");
				//if(sysName.equals("")) {
					if(dropDown.equalsIgnoreCase(oinpuTDtMap.get("Param_1")))

					{							WebElement element = obrowser.findElement(
							By.xpath("\r\n" + 
									"//*[@id=\"frmMain\"]/div[2]/div/div/ul/li[" + row + "]/a"));
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);

					strStatus+=true;
					break;
					}
//					strStatus+=false;
//					appInd.writeLog("Fail", "System can not be find");
//				}
				
				bySelect_systemdropdown = appInd.createAndGetByObject("Select_systemdropdown");
				elementbySelect_systemdropdown = obrowser.findElement(bySelect_systemdropdown);
				((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",elementbySelect_systemdropdown);
				}
				
					catch(Exception e)
						{strStatus+=false;
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalymorethanone_Rule_Fail_snapshot.png");
						appInd.writeLog("Fail", "'TC_Customanomalymorethanone_Rule' script was failed");
						}
				}
				
				
				
				if(row>system.size())
				{
					strStatus+=false;
					appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
							+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalymorethanone_Rule_invalidCredential_Fail_snapshot.png");
				}
				else
				{
					//Click on customanomaly	
					By	byClick_Customanomaly = appInd.createAndGetByObject("Click_Customanomaly");
					WebElement element = obrowser.findElement(byClick_Customanomaly);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					//click on plus icon
					By	byClick_addtags = appInd.createAndGetByObject("Click_addtags");
					 element = obrowser.findElement(byClick_addtags);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					//select object 
				By	byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(3000);
					
					By bySelect_Objects = appInd.createAndGetByObject("Select_Objects");
					List<WebElement> Object_nameList = obrowser.findElements(bySelect_Objects);
					
					By bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
					List<WebElement> ObjectNameList = obrowser.findElements(bySelect_objectschkbx);
					//Thread.sleep(2000);
					
					
					//List<WebElement> savedFilter_Name_List = obrowser.findElements("//div[@class='btn-group bootstrap-select lightbox pl10 open']/descendant::label[@class='ng-binding']");
					for(int j=0;j<Object_nameList.size();j++) {
						if(Object_nameList.get(j).getText().equals(oinpuTDtMap.get("Param_2"))) {
							
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", ObjectNameList.get(j));
						
						
							strStatus = "true";
								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
						
					}
					Thread.sleep(3000);
					
						byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
			
                       //Enter number of characters for tag					
					
					
					obrowser.findElement(By.xpath("//*[@id=\"no-of-tags\"]")).clear();
					appInd.setObject(obrowser, "Charactersfor_Tag", oinpuTDtMap.get("Param_3"));
					
					Thread.sleep(3000);
					
					String str= oinpuTDtMap.get("Param_4");
			
					  objarr=str.split(",");
					  for(int i=0;i<objarr.length;i++)
					  {
						  System.out.println(objarr[i]);
						  String xpath="//*[@id=\"tagPattern"+(i+1)+"\"]";
						  obrowser.findElement(By.xpath(xpath)).clear();
						  obrowser.findElement(By.xpath(xpath)).sendKeys(objarr[i]);
					  }
					  
					//Enter tag name
					obrowser.findElement(By.xpath("//*[@id=\"txtTagConventionName\"]")).clear();
					appInd.setObject(obrowser, "Tagname_Convention", oinpuTDtMap.get("Param_5"));
					
					Thread.sleep(3000);
					
					By	byClick_Done = appInd.createAndGetByObject("Click_Done");
					WebElement elementi = obrowser.findElement(byClick_Done);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", elementi);
					Thread.sleep(5000);
            try {
						
						By byClik_abortcollectionOK = appInd
						.createAndGetByObject("Clik_abortcollectionOK");
						WebElement elementbyClik_abortcollectionOK = obrowser
						.findElement(byClik_abortcollectionOK);
						
						
						

						if (elementbyClik_abortcollectionOK != null) {
							strStatus += "false";
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalymorethanone_Rule_Fail_systemalreadyExistsnapshot.png");
						
						Thread.sleep(5000);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();",
								elementbyClik_abortcollectionOK);
						
						Thread.sleep(3000);
						By	byClose_customanomaly = appInd.createAndGetByObject("Close_customanomaly");
				          element = obrowser.findElement(byClose_customanomaly);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
						
						
						}
						
						} catch (Exception e) {
							
						

					//Click on tag name  
							
							By byRuleListClick = appInd.createAndGetByObject("RuleListClick");
							List<WebElement> RuleListClick = obrowser.findElements(byRuleListClick);								
								
								
								
								
								for(int j=0;j<RuleListClick.size();j++) {
									if(RuleListClick.get(j).getText().trim().equalsIgnoreCase(oinpuTDtMap.get("Param_5"))) {
										strStatus = "true";
										((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", RuleListClick.get(j));
										 System.out.println("strStatus:::"+ strStatus);
										 break;
									 }
									
								}
							
					/*By byClickListTagname = appInd.createAndGetByObject("ListTagname");
					 element = obrowser.findElement(byClickListTagname);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);*/
					//Click on Add rule
					By byAdd_Rule = appInd.createAndGetByObject("Add_Rule");
					 element = obrowser.findElement(byAdd_Rule);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
				//============================================================================================================//
						byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					Thread.sleep(3000);
					
					 bySelect_Objects = appInd.createAndGetByObject("Select_Objects");
					List<WebElement> Object_nameList1 = obrowser.findElements(bySelect_Objects);
					
					 bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
					List<WebElement> ObjectNameList2 = obrowser.findElements(bySelect_objectschkbx);
					//Thread.sleep(2000);
					
					
					//List<WebElement> savedFilter_Name_List = obrowser.findElements("//div[@class='btn-group bootstrap-select lightbox pl10 open']/descendant::label[@class='ng-binding']");
					for(int j=0;j<Object_nameList.size();j++) {
						if(Object_nameList.get(j).getText().equals(oinpuTDtMap.get("Param_2"))) {
							
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", ObjectNameList.get(j));
						
						
							strStatus = "true";
								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
						
					}
					Thread.sleep(3000);
			//================================================================================================================//		
					//Select objects
					
				 bySelect_Objects = appInd.createAndGetByObject("Select_Objects");
					List<WebElement> Object_nameListe = obrowser.findElements(bySelect_Objects);
					
				 bySelect_objectschkbx = appInd.createAndGetByObject("Select_objectschkbx");
					List<WebElement> ObjectNameListe = obrowser.findElements(bySelect_objectschkbx);
					//Thread.sleep(2000);
					
					
					//List<WebElement> savedFilter_Name_List = obrowser.findElements("//div[@class='btn-group bootstrap-select lightbox pl10 open']/descendant::label[@class='ng-binding']");
					for(int j=0;j<Object_nameList.size();j++) {
						if(Object_nameList.get(j).getText().equals(oinpuTDtMap.get("Param_6"))) {
							
							((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", ObjectNameList.get(j));
						
						
							strStatus = "true";
								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
						
					}
					Thread.sleep(3000);
					
						byClick_selectobjctdrpdwn = appInd.createAndGetByObject("Click_selectobjctdrpdwn");
					element = obrowser.findElement(byClick_selectobjctdrpdwn);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					
					
					obrowser.findElement(By.xpath("//*[@id=\"no-of-tags\"]")).clear();
					appInd.setObject(obrowser, "Charactersfor_Tag", oinpuTDtMap.get("Param_7"));
					
					Thread.sleep(3000);
					
					 str= oinpuTDtMap.get("Param_8");
			
					  objarr=str.split(",");
					  for(int i=0;i<objarr.length;i++)
					  {
						  System.out.println(objarr[i]);
						  String xpath="//*[@id=\"tagPattern"+(i+1)+"\"]";
						  obrowser.findElement(By.xpath(xpath)).clear();
						  obrowser.findElement(By.xpath(xpath)).sendKeys(objarr[i]);
					  }
					  
					  
					  String str1 = obrowser.findElement(By.xpath("//div[@id='details' and @class='tab-pane active']/descendant::ng-form[@id='frmTagConvention']/descendant::h6[@class='mt0 ng-binding']")).getText();
						
						
						
						
						
						List<WebElement> RuleList = obrowser.findElements(By.xpath("//div[@id='collapse191' and @aria-expanded='true']/descendant::div[@class='ng-binding']"));
						for(int j=0;j<RuleList.size();j++) {
							if(RuleList.get(j).getText().equalsIgnoreCase("str1")) {
								strStatus = "true";
								
								 System.out.println("strStatus:::"+ strStatus);
								 break;
							 }
							
						}
						
					
					  	byClick_Done = appInd.createAndGetByObject("Click_Done");
					    element = obrowser.findElement(byClick_Done);
						((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					
					
				
					
					By	byClose_customanomaly = appInd.createAndGetByObject("Close_customanomaly");
			          element = obrowser.findElement(byClose_customanomaly);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element);
					
					//Click on filter			
					By byClick_filter = appInd.createAndGetByObject("Click_filter");
					Thread.sleep(2000);
					WebElement element1 = obrowser.findElement(byClick_filter);
					((JavascriptExecutor) obrowser).executeScript("arguments[0].click();", element1);
					Thread.sleep(3000);
					
					
					//Select Anomaly name
					By checkBox_List = appInd.createAndGetByObject("Get_Anomalynamelist");
					List<WebElement> Get_Anomalynamelist = obrowser.findElements(checkBox_List);
					int j;
					for( j=0;j<Get_Anomalynamelist.size();j++) {
						 System.out.println("strStatus:::"+ Get_Anomalynamelist.get(j).getText());
						String name=Get_Anomalynamelist.get(j).getText();
                       if(name.equalsIgnoreCase(oinpuTDtMap.get("Param_5"))) {
                    	   strStatus = "true";
												
                           							
								
							 System.out.println("strStatus:::"+ strStatus);
							 break;
						 }
					//	strStatus = "true";
					}
						Thread.sleep(5000);
									
					if (j==Get_Anomalynamelist.size())
						strStatus = "false";
					
					// ########################################################################
					if (strStatus.contains("false")) {
						appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
								+ "\\Results\\snapshot\\Engineering_Anomaly\\TC_Customanomalymorethanone_Rule.png");
						appInd.writeLog("Fail", "'TC_Customanomalymorethanone_Rule' script was failed");
						bolstatus = false;
						strStatus = null;
					
					
					} else  {
						appInd.writeLog("Pass", "'TC_Customanomalymorethanone_Rule' script was Successful");
						bolstatus = true;
						strStatus = null;
					}
					
						}
				

            }  /* catch (Exception e) {
				}*/
				}
			}
		
		
	
		 else {
				appInd.takeSnapShot(obrowser, System.getProperty("user.dir")
						+ "\\Results\\snapshot\\Engineering_Anomaly\\Failed_to_launch_IE_browser_snapshort.png");
				appInd.writeLog("Fail", "Failed to launch the IE browser");
				bolstatus = false;
			}
			// write the result into Map
			if ((bolstatus == false) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Fail");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);

			} else if ((bolstatus == false) && !(strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else if ((bolstatus == true) && (strExecutionsts.equalsIgnoreCase("yes"))) {
				oinpuTDtMap.put("result", "Pass");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			} else {
				oinpuTDtMap.put("result", "Skip");
				oinpuTDtMap.put("countvalue", strcommonCountvalue);
			}
			strcurrentTD = String.valueOf(TD);
			oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
			oinpuTDtMap = null;
		} // for loop
		return oinputMap;
			
	
		} catch (Exception e) {
		appInd.writeLog("Exception", "Exception while executing 'TC_Customanomalymorethanone_Rule' method. " + e.getMessage());
		oinpuTDtMap.put("result", "Fail");
		//oinputMap.put(strcurrentTD, (HashMap) oinpuTDtMap);
		return oinputMap;
	} finally {
		System.out.println("end");
		return oinputMap;
	}
	
	}
		
	
	







	
}
