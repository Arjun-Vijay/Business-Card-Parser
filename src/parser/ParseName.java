package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class ParseName {
	final String ALPHABET_REGEX = "[a-zA-Z ]+";
	String name;
	
	/**
	 * Identify if proper names exist in a given String
	 * 
	 * @param String input: String to be evaluated as a name 
	 */
	protected void checkIfName(String input) throws IOException {
		
		//If input contains non-Alphabets exit
		if(containsNonAlphabets(input)) {
			return;
		}
		 	
		//Train the tokenizer and token the input string
		InputStream tokenInputStream = new FileInputStream("en-token.bin");
		TokenizerModel tokenModel = new TokenizerModel(tokenInputStream);
		
		TokenizerME tokenizer = new TokenizerME(tokenModel);
		String inputArray[] = tokenizer.tokenize(input);
	
		//Train the NameFinder
		InputStream nameFinderInputStream = new FileInputStream("en-ner-person.bin");
		TokenNameFinderModel TNModel = new TokenNameFinderModel(nameFinderInputStream);
		NameFinderME nameFinder = new NameFinderME(TNModel);	
		
		//Find the names and corresponding likelihoods
		Span nameSpan[] = nameFinder.find(inputArray);
		double probabilities[] = nameFinder.probs();
		
		if(nameSpan.length > 0) {
			name = input;
		}
               
	}
	
	/**
	 * Function to used calculate the probability of an entire string being a name. Used for testing purposes
	 * 
	 * @param probabilities: Array representing the probability of each word in the input string being an array
	 * @return average: Double representing probability of the entire string being a name
	 */
	protected double averageProbability(double[] probabilities) {
		double average = 0.0;
		for(int i = 0; i < probabilities.length; i++) {
			average += probabilities[i];
		}
		
		average = average/probabilities.length;
		return average;
	}
	
	protected String returnName() {
		return this.name;
	}
	
	protected boolean containsNonAlphabets(String input) {
		if(Pattern.matches(ALPHABET_REGEX, input)) {
			return false;
		} else {
			return true;
		}
		
	}

}
