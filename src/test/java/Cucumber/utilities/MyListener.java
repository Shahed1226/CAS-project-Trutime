package Cucumber.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Cucumber.factory.*;


public class MyListener implements ITestListener
{
		
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("on test success.........");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("on test failure.........");
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("on test skipped.........");
	}
	
	public void onFinish(ITestContext context) 
	{
		System.out.println("on test finish.........");
	}
	
}
