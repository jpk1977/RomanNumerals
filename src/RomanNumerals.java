
public class RomanNumerals {
	
	
	public void convertToInteger(String romanNum) throws RomanException{
		//no emptystrings are allowed
		if(romanNum.length()==0) {
			throw new RomanException();
		}
		//if string only has one numeral, then jump to own method.
		if(romanNum.length()==1) {
			one_numeral(romanNum);
			}
		//String length more than one
		else {
			errorchecking(romanNum);
		}
	
			
		
		
	}
	public int one_numeral(String romanNum) throws RomanException{
		//conversion happens here
		switch(romanNum) {
			case "I":
				return 1;
			
			case "V":
				return 5;
				
			case "X":
				return 10;
			
			case "L":
				return 50;
				
			case "C":
				return 100;
			
			case "D":
				return 500;
				
			case "M":
				return 1000;
			
			default:
				throw new RomanException();
		}	
	}
	public void errorchecking(String romanNum) throws RomanException{
		int [] numarray = new int [romanNum.length()];
		int i=0; int v=0;int x=0;int l=0;int c=0;int d=0;int m=0; // counters for letters
		//put the whole string to the array. 
		for (int j=0; j<romanNum.length();j++) {
			numarray[j]=romanNum.charAt(j);
		}
		for (int k=0; k<numarray.length;k++) {
		switch(numarray[k]) {
			case 'I':
				v=0;x=0;l=0;c=0;d=0;m=0; //reset the counters for other letters
				i++;
				if(i>3) {
					throw new RomanException();
				}
				break;
			case 'V':
				i=0;x=0;l=0;c=0;d=0;m=0;
				v++;
				if(v>1) {
					throw new RomanException();
				}
				break;
			case 'X':
				i=0;v=0;l=0;c=0;d=0;m=0;
				x++;
				if(x>3) {
					throw new RomanException();
				}
				break;
			case 'L':
				i=0;v=0;x=0;c=0;d=0;m=0;
				l++;
				if(l>1) {
					throw new RomanException();
				}
				break;
			case 'C':
				i=0;v=0;x=0;l=0;d=0;m=0;
				c++;
				if(c>3) {
					throw new RomanException();
				}
				break;
			case 'D':
				i=0;v=0;x=0;l=0;c=0;m=0;
				d++;
				if(d>1) {
					throw new RomanException();
				}
				break;
			case 'M':
				i=0;v=0;x=0;l=0;c=0;d=0;
				m++;
				if(m>3) {
					throw new RomanException();
				}
				break;
			default:
				System.out.println("Not a RomanNumeral");
			}
		}
		countvalue(romanNum);
	
	}
	public int countvalue(String romanNum) throws RomanException {
		int [] a = new int [20];
		for (int j=0; j<romanNum.length();j++) {
			a[j]=romanNum.charAt(j);
		}
		
		int result=0;
		for(int i=0;i<a.length;i++) {
			switch(a[i]) {
			case 'I':
				result=result+1;
				break;
			case 'V':
				if(i>1) {
					if(a[i-1]=='I')  {
						if(a[i-2]=='I') {
							throw new RomanException();
						}
						else {
						result=result+3;
						break;
						}
						
					}
				}	
		
				else {
					result=result+5;
					break;
					}
					
				
				
			case 'X':
				if((a[i-1]=='V') || (a[i-1]=='L')|| (a[i-1]=='D')) {
					throw new RomanException();
				}
				result=result+10;
				break;
			case 'L':
				if((a[i-1]=='X') || (a[i-1]=='V')|| (a[i-1]=='I')) {
					throw new RomanException();
				}
				result=result+50;
				break;
			case 'C':
				if((a[i-1]=='L') || (a[i-1]=='V')|| (a[i-1]=='I')) {
					throw new RomanException();
				}
				if((a[i-1]=='X') && (a[i-2]=='X')) {
					throw new RomanException();
				}
				result=result+100;
				break;
			case 'D':
					if((a[i-1]=='L')|| (a[i-1]=='X')|| (a[i-1]=='V')|| (a[i-1]=='I')) {
						throw new RomanException();
					}
					if((a[i-1]=='C') && (a[i-2]=='C')) {
						throw new RomanException();
					}
					result=result+500;
					break;
			case 'M':
				if((a[i-1]=='D') || (a[i-1]=='L')|| (a[i-1]=='X')|| (a[i-1]=='V')|| (a[i-1]=='I')) {
					throw new RomanException();
				}
				if((a[i-1]=='C') && (a[i-2]=='C')) {
					throw new RomanException();
				}
				result=result+1000;
				break;
			}
		}
		return result;
	}
	
}
