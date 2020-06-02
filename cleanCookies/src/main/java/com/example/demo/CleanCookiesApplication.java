package com.example.demo;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

@SpringBootApplication
public class CleanCookiesApplication {

	 public static void main(String[] args) throws IOException {
	        Regions clientRegion = Regions.DEFAULT_REGION;
	        String bucketName = "s3-ec2-bucket-2107";
	        String keyName = "Devops_project_anu";

	        try {
	            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                    .withCredentials(new ProfileCredentialsProvider())
	                    .withRegion(clientRegion)
	                    .build();

	            s3Client.deleteObject(new DeleteObjectRequest(bucketName, keyName));
	        } catch (AmazonServiceException e) {
	            // The call was transmitted successfully, but Amazon S3 couldn't process 
	            // it, so it returned an error response.
	            e.printStackTrace();
	        } catch (SdkClientException e) {
	            // Amazon S3 couldn't be contacted for a response, or the client
	            // couldn't parse the response from Amazon S3.
	            e.printStackTrace();
	        }
	    }
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(CleanCookiesApplication.class, args); }
	 */

}





   

