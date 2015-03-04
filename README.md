#SendGrid

##Sendgrid Email as a Service

Sendgrid is the world's largest email infrastructure as a service provider focused on deliverability, scalability, and reliability. 

**If you are going to use Java**

To try the sample Sendgrid application, change directory to ```bluemix-sendgrid-java-sample``` and compile the application by executing the following

```
ant
```

Make sure that the ant build completes successfully and deploy to Bluemix by executing the following commands:

```
cf login
cf create-service sendgrid free mySendgrid
cf push
```

After the commands complete successfully, look for the console output specifying the application URL. It should look something like: 

```
usage: 128M x 1 instances
urls: sendgrid-random-word.mybluemix.net
```

Next execute the following commands from your console, to specify custom to/from email addresses using Bluemix environment variables. 

```
cf set-env sendgrid TO_EMAIL bluemix@mailinator.com
cf set-env sendgrid FROM_EMAIL bluemix@ibm.com
cf restage sendgrid
```

Open your favorite browser using the URL ending with mybluemix.net (such as sendgrid-random-word.mybluemix.net in the example above) from the console output to access the application. 
