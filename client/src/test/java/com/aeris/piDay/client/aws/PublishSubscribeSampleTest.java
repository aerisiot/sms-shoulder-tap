package com.aeris.piDay.client.aws;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aeris.piDay.client.Initiator;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotTimeoutException;
import com.amazonaws.services.iot.client.sample.pubSub.PublishSubscribeSample;

public class PublishSubscribeSampleTest {
	
	static Logger logger = LoggerFactory.getLogger(PublishSubscribeSampleTest.class);

	@Test
	public void testExceptionWithWrongPrivateKey() {
		
		boolean exceptionOccurred = false;
		
		String[] args = new String[9];
		args[0] = "-clientEndpoint";
		args[1] = "a26y5ns1489swl.iot.us-west-2.amazonaws.com";
		args[2] = "-clientId";
		args[3] = "sdk-java";
		args[4] = "-certificateFile";
		args[5] = "myPie.cert.pem";
		//passing wrong private key
		args[6] = "-privateKeyFile";
//		args[7] = "myPie.private.key";
		args[7] = "src/test/resources/wrong.private.key";
		//device will publish for X seconds and then disconenct
		args[8] = "10";
		
		
		try{
			PublishSubscribeSample.publishDatatoCloud(args);
			
		}catch(Exception e){
			logger.debug("exception: " + e);
			exceptionOccurred = true;
			
		}
		
		  Assert.assertTrue(exceptionOccurred);
		
	}

}
