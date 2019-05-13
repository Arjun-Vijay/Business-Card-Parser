# Business-Card-Parser
NLP tool used to extract the name, email, and phone number from an input document 

<b>Project Description</b><br>
This project extracts the name, email, and phone from an inputted file. It uses the ApacheOpenNLP library 
to preform NER(Name Entity Recognition) and email regex expression in accordance with the RFC & SMTP standard

<h1>Execute Pre-Built Tests</h1>
<ol>
  <li>To execute the program first clone the repository and navigate to the location of clone using the below commands</li>
     
     
      git clone https://github.com/Arjun-Vijay/Business-Card-Parser.git
      cd /pathToClone
   
  <li>Upon doing so, execute the runnable jar file with the below command</li> 
  
      java -jar BusinessCardParser.jar 
      
   <li>Follow the instructions presented with through the user interface. Example input/output below</li>
   
   
      Welcome to the Business Card Parser
      Please Enter Either 'Test X' to run tests 1-3, 'Self Test' to run a new test, or 'Exit' to quit
      Enter: Test 1
      
      
      Name: John Doe
      Email: john.doe@entegrasystems.com
      Number: 4105551234
      
   <i>Note, The commands must be entered as presented by the user interface. Any trailing whitespace will result in invalid input</i>
 </ol>
 
 <h1>Execute New Tests</h1> 
 <ol>
   <li>To execute new tests first add the test file to the root directory of the cloned repository. You can make sure the file exists 
   listing the directory contents.</li>

        Arjuns-MBP:Business-Card-Parser arjunvijay$ ls
        BusinessCardParser.jar	en-ner-person.bin	selfTest.txt		test1.txt		test3.txt
        bin			        en-token.bin		src			test2.txt


   <li>You may then run the appropriate command during execution as seen below</li>
        Enter: Self Test
        Enter the name of your .txt file: selfTest.txt               


        Name: Bill Gates
        Email: Billgates@outlook.com
        Number: 1112223333
  </ol>
  
  
  <h1>Language Dependencies</h1> 
  The NameFinder model was trained using an English-based model. Therefore, when performing NER the model  
  identifies names commonly seen in the English language.
  

   
   
