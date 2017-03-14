package com.aeris.piDay.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.iot.client.sample.pubSub.PublishSubscribeSample;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;


public class Initiator {
	
	static Logger logger = LoggerFactory.getLogger(Initiator.class);
	
	//0 for Serial mode
	//1 for HiLink mode
	final static String serialMode = "0";
	final static String hilinkMode = "1";
	 
	
	public static void main(String[] args2) {
		
		try{
			
			//connect to cloud and publish state and data 
			//pending: move the args out of the code and pass from the shell script
			
			logger.debug("--- initiated ---");
			String[] args = new String[9];
			args[0] = "-clientEndpoint";
			args[1] = "a26y5ns1489swl.iot.us-west-2.amazonaws.com";
			args[2] = "-clientId";
			args[3] = "sdk-java";
			args[4] = "-certificateFile";
			args[5] = "myPie.cert.pem";
			args[6] = "-privateKeyFile";
			args[7] = "myPie.private.key";
			//device will publish for X seconds and then disconenct
			args[8] = "10";
			
			logger.debug("--- start: publishing data to Cloud ---");
			
			PublishSubscribeSample.publishDatatoCloud(args);

			
			logger.debug("data sent complete...");

				Thread.currentThread().sleep(3000);
			
			logger.debug("device now going to sleep...");
			
			Thread.currentThread().sleep(3000);
			
			//usb-modeswitch to serial mode
			performUsbModeSwitch(serialMode);
			
			//call shell script to reboot
			//the mode switch is happening either by hotplugging or by rebooting
			//hotplugging command is not yet working so temporarily doing rebooting
			performReboot();
			
		}catch(Exception e){
			
			//if device is in Serial Mode then it will not be able to connect to cloud 
			//so nothing to do in java
			//sms will come and wake up device
			
		}
	
	}


	private static void performReboot() {
		 Runtime rt = Runtime.getRuntime();
         try {
			Process proc = rt.exec("reboot");
			int result;
			try {
				result = proc.waitFor();
				logger.debug("result: " + result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//       	 
       	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void performUsbModeSwitch(String targetMode) {
		if(targetMode.equalsIgnoreCase(serialMode)){
			//change to serialMode

			 String source = "./12d1:1f01_serial";
//	        //directory where file will be copied
	        String target ="/etc/usb_modeswitch.d/12d1:1f01";
	      
			copyfile(source, target);
		}
		
		
	}


	private static void copyfile(String source, String target) {
		
        //name of source file
        File sourceFile = new File(source);
        String name = sourceFile.getName();
      
        File targetFile = new File(target);
        logger.debug("Copying file : " + sourceFile.getName() +" from Java Program");
      
        //copy file from one location to other
        try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        logger.debug("copying of file from Java program is completed");


	}

}
