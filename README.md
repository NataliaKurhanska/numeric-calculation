## 💻 NumericCalculation

### 📄 Project description 
This is a simple API that allows to work with a large sequence of numeric values packed in compressed .bz2 files.
If you do not pass a custom compressed .bz2 file, the API uses the default file for calculations located at src/main/resources/10m.txt.bz2.

### 📄 Features
API finds
* **Maximum** numeric value of the sequence of numbers;
* **Minimum** numeric value of the sequence of numbers;
* **Average** numeric value of the sequence of numbers;
* **Median** of the sequence of numbers;
* **Longest increasing sequence** of numbers;
* **Longest decreasing sequence** of numbers.

### 📄 Getting Started:
To work with API you should
* install Java Development Kit (JDK) 17 or later
* clone the project from the GitHub repository.

If you only want to run the API, use the Java Runtime Environment (JRE) 17 

Running executable JAR file (numeric-calculation.jar) from command line:  
> $ java -jar PathToFile\numeric-calculation.jar  

Running executable JAR file (numeric-calculation.jar) with custom .bz2 file:    
> $ java -jar PathToFile\numeric-calculation.jar PathToCustomFile
