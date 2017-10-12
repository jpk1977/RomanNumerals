import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	

	@Test(expected = RomanException.class) 
	public void test_emptystring() throws RomanException{
		RomanNumerals result = new RomanNumerals();
		
		 result.convertToInteger("");	 
		
	}
	
	 @Test
	 	public void test_1numeral() throws Exception{
		 RomanNumerals result = new RomanNumerals();

		 int number = result.one_numeral("C");

		 assertEquals(100, number);

	 	} 
	 @Test(expected = RomanException.class) 
		public void test_one_wrong_character() throws RomanException{
			RomanNumerals result = new RomanNumerals();
			
			result.one_numeral("a");	
	 }
	 @Test(expected = RomanException.class) 
	 	public void test_concecutive_letters() throws RomanException {
		 RomanNumerals result = new RomanNumerals();
		 
		 result.errorchecking("XXXX");
	 }
	 @Test
	 	public void test_conversion_to_numbers() throws Exception{
		 RomanNumerals result = new RomanNumerals();

		 int number =result.countvalue("IV");

		 assertEquals(4, number);
	 }
}