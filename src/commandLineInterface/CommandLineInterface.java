package commandLineInterface;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineInterface {
	private CommandLineParser parser; 
	private Options options;
	private CommandLine line; 
	private HelpFormatter formatter; 

	
	
	public CommandLineInterface(){ 
		init(); 
		
		//parsing 
		
	}
	
	public void init (){ 
		parser = new DefaultParser(); 
		options = new Options(); 
		createOptions(); 
		formatter = new HelpFormatter(); 
		formatter.printHelp("bur.sa.ry  \n"
				+ "noun \n"
				+ " 1. a scholarship to attend a college or university \n"
				+ " 2. the treasury of an institution, especially a religious one \n"
				+ "Erudito et religio \n"
				+ "============================================ \n"
				+ "for you, a few commands, enjoy. \n"
				+ "============================================", options); 
	}
	
	
	private void createOptions(){ 
		Option help = new Option("help", "print this message"); 
		options.addOption(help); 

		Option quit = new Option("quit", "quitting the program"); 
		options.addOption(quit); 
		
		@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option addDonor = OptionBuilder.hasArgs(2)
				.withArgName("donorName> <donation")	
				.withDescription("add a new donor and their donation")
				.create("addDonor"); 
		
		options.addOption(addDonor); 
		
		
		
		/*@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option addStudent = OptionBuilder.hasArgs(2)
				.withArgName("studentName> <donation")	
				.withDescription("add a new donor and their donation")
				.create("addDonor"); 
		
		options.addOption(addStudent); */
		
		

	}
	
	public void parse(String [] args){ 
		try {
			line = parser.parse(options, args);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		/*while(!line.hasOption("quit")){ 
			
			
		}*/
	}
	
	
	
	
	
}
