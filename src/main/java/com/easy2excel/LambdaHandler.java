package com.easy2excel;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LambdaHandler implements RequestHandler<S3Event,String> {
    private static final String REGION = "ap-south-1";
    //private static final String REGION = "us-east-1";
    AmazonS3 s3client = AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.fromName(REGION))
            .withCredentials(new DefaultAWSCredentialsProviderChain())
            .build();

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        LambdaLogger logger = context.getLogger();
        String bucketName = s3Event.getRecords().get(0).getS3().getBucket().getName();
        String fileName = s3Event.getRecords().get(0).getS3().getObject().getKey();
        logger.log("BucketName ::: " + bucketName + "\n");
        logger.log("FileName ::: " + fileName + "\n");
        try {
            InputStream inputStream = s3client.getObject(bucketName, fileName).getObjectContent();
            String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            logger.log("File content ::: " + content + "\n");
        }catch (IOException e){
            return "Error while reading file from S3 :::" + e.getMessage();
        }

        return "Successfully read file from s3 bucket...";
    }
}
