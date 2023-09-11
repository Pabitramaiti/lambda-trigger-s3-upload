# lambda-trigger-s3-upload
Trigger Lambda on S3 Upload | AWS S3 File Upload + Lambda Trigger - Step by Step Tutorial in JAVA

https://www.youtube.com/watch?v=wk8Lk8R7Pck&list=PL0CyZKPJn9TOucmpAiMLvMtSkAFnkyrZM
https://github.com/daisy-world/lambda-trigger-s3-upload



{
  "Records": [
    {
      "eventVersion": "2.0",
      "eventSource": "aws:s3",
      "awsRegion": "ap-south-1",						//Region
      "eventTime": "1970-01-01T00:00:00.000Z",
      "eventName": "ObjectCreated:Put",
      "userIdentity": {
        "principalId": "EXAMPLE"
      },
      "requestParameters": {
        "sourceIPAddress": "127.0.0.1"
      },
      "responseElements": {
        "x-amz-request-id": "EXAMPLE123456789",
        "x-amz-id-2": "EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH"
      },
      "s3": {
        "s3SchemaVersion": "1.0",
        "configurationId": "testConfigRule",
        "bucket": {
          "name": "pabis3bucket",						//S3 bucket name
          "ownerIdentity": {
            "principalId": "EXAMPLE"
          },
          "arn": "arn:aws:s3:::pabis3bucket"   			//S3 bucket's ARN name
        },
        "object": {
          "key": "s3upload.txt",						//Uploaded file name in the S3 bucket
          "size": 1024,
          "eTag": "0123456789abcdef0123456789abcdef",
          "sequencer": "0A1B2C3D4E5F678901"
        }
      }
    }
  ]
}