# Install Jenkins and Run Jenkins Job in local
<h2>Mac</h2>

**1.Install Jenkins by homebrew** <br> 
`$ brew install jenkins-lts` <br>
**2. Go to terminal execute to launch Jenkins Server** <br>
`jenkins-lts` <br>
Jenkins server should be up and reunning <br>
<h2>Windows</h2>

**1. Go to https://jenkins.io/download/ and download windows zip file and unzip and install** <br>
![image](https://user-images.githubusercontent.com/34196568/50379810-39ce8000-0622-11e9-90b0-533f9934cdf1.png)

**2. It will ask for a passowrd same as mac and it will tell you where is that password. It will be a hidden file in that location. Find it and open it in text editor, copy the password**  <br>


**3. Go to localhost:8080 Get the address execute by cat. Copy the password from terminal and use**
`$ cat /Users/administrator/.jenkins/secrets/initialAdminPassword` <br>
`fff69c0883fb4cdb9aa85bbd72dd2fd8`

![image](https://user-images.githubusercontent.com/34196568/50379465-844aff00-0618-11e9-8dd7-371498224cba.png)
<br>

**4. Change port number to 8081**
![image](https://user-images.githubusercontent.com/34196568/50379578-2f5cb800-061b-11e9-982d-430671390678.png)
 

**5. Click Install suggested plugins.** <br>
![image](https://user-images.githubusercontent.com/34196568/50379582-70ed6300-061b-11e9-98c2-aa569d017833.png)
![image](https://user-images.githubusercontent.com/34196568/50379601-b90c8580-061b-11e9-9e57-3d66fbb7c39f.png)

**6. Create an admin user and Save and Continue:** 

![image](https://user-images.githubusercontent.com/34196568/50379602-c164c080-061b-11e9-8a1a-8a744971583d.png)

![image](https://user-images.githubusercontent.com/34196568/50379615-21f3fd80-061c-11e9-84d0-b1bb3efd22e6.png)
<br>
<br>
<h1>How to make Global Tool Configurations of Jenkins </h1>

**1. Go to  Manage Jenkins > Global Tool Configurations**  <br>
<br>
![image](https://user-images.githubusercontent.com/34196568/50379325-48626a80-0615-11e9-9d08-d020e733aa3b.png)

**2. Set JAVA_HOME. To get JAVA_HOME Path execute below command in terminal** <br>
`$ /usr/libexec/java_home` <br>
<br>
![image](https://user-images.githubusercontent.com/34196568/50379364-5ebcf600-0616-11e9-91d9-1c6913cb903b.png)
**Get the JAVA_HOME and set**<br>
![image](https://user-images.githubusercontent.com/34196568/50379375-814f0f00-0616-11e9-8546-8d529a8c7cc8.png)

**3. Set MAVEN_HOME . Apply and Save** <br>
![image](https://user-images.githubusercontent.com/34196568/50379662-6a5feb00-061d-11e9-902d-b48518b63968.png)
**Your local machine is set to run Jenkins Job.** <br>
**Let's Create Jenkins Job**

**1. Click on New Item**<br>
![image](https://user-images.githubusercontent.com/34196568/50379686-04279800-061e-11e9-9762-eca060166826.png)

**2.Name your job, click Freestyle Project, save and continue** 

![image](https://user-images.githubusercontent.com/34196568/50379692-25888400-061e-11e9-9ab4-9545ccdc10f2.png)

**3. Mark Github project, provide project url, Source Code management Git and provide Repository URL** 

![image](https://user-images.githubusercontent.com/34196568/50379707-92038300-061e-11e9-80fb-56b61c648ac9.png)

 

**4. Select maven and set goal as test, Apply and save**<br> 
![image](https://user-images.githubusercontent.com/34196568/50379731-2837a900-061f-11e9-94f8-434d44980b85.png)

**5. Its time to run the Job Now. Go to home page by clicking Jenkins on top left. Click on Job name, from the drop down select "Build". Job will run, to see the console output again click on Job Name and select console** 
![image](https://user-images.githubusercontent.com/34196568/50379734-777dd980-061f-11e9-84dd-adb963fe41bd.png)
![image](https://user-images.githubusercontent.com/34196568/50379738-ad22c280-061f-11e9-9c85-1747f80b12c4.png)
![image](https://user-images.githubusercontent.com/34196568/50379751-13a7e080-0620-11e9-9fd2-608ae7b22c79.png)
![image](https://user-images.githubusercontent.com/34196568/50379753-26221a00-0620-11e9-932f-461a6f5407fb.png)
