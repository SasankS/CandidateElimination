# CandidateElimination
Implementation of Candidate Elimination algorithm in Java

##Input Format
  First line contains N and M.  
  Where N = number records to be read as training data, and M = Number of attributes.  
  The next M lines will contain attribute names and the values it can take.  
  Next N lines give values of M attributes.  
  Last attribute will be target attribute. Its values will be either “Yes” or “No”.  
  
##Output 
   Specific Boundary(S)  
   Generic Boundary(G)  
   Version Space(VS)  
   
##Example
  ###Input
        4 7  
		Sky Sunny Rainy Cloudy  
		AirTemp Warm Cold  
		Humidity Normal High  
		Wind Strong Weak  
		Water Warm Cool  
		Forecast Same Change  
		EnjoySport Yes No  
		Sunny Warm Normal Strong Warm Same Yes  
		Sunny Warm High Strong Warm Same Yes  
		Rainy Cold High Strong Warm Change No  
		Sunny Warm High Strong Cool Change Yes  
  ###Output
    S  : {<Sunny, Warm, ?, Strong, ?, ?>}
	G :  {<Sunny, ?, ?, ?, ?, ?, ?>, <?, Warm, ?, ?, ?, ?>}
   VS :{<Sunny, Warm, ?, ?, ?, ?>, <Sunny, ?, ?, Strong, ?, ?>, <?, Warm, ?, Strong, ?, ?>}  
		
