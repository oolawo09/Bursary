package commandLineInterface;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import management.MainManager;
import storage.Reader;
import storage.Writer;

public class CommandLineInterface {
	private CommandLineParser parser; 
	private Options options;
	private CommandLine line; 
	private HelpFormatter formatter; 
	private MainManager manager; 
	private Reader reader; 
	private Writer writer; 



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
				, options); 
		reader = new Reader("db"); 
		writer = new Writer("db"); 
		
		manager = reader.read(); 
		if(manager == null ){ 
			manager = new MainManager();
		}
		 
		
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

		Option listDonors = new Option("listDonors", "list all donors");
		options.addOption(listDonors); 

		@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option getDonor = OptionBuilder.hasArgs()
		.withArgName("donorID")	
		.withDescription("get a donor's information by id")
		.create("getDonor"); 

		options.addOption(getDonor); 

		@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option donate = OptionBuilder.hasArgs(2)
		.withArgName("donorID> <donation")	
		.withDescription("Register a donor's donation by id")
		.create("donate"); 

		options.addOption(donate); 

		@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option addStudent = OptionBuilder.hasArgs()
		.withArgName("studentName> <need")	
		.withDescription("add a new student and their need")
		.create("addStudent"); 

		options.addOption(addStudent); 

		Option listStudents = new Option("listStudents", "list all students");
		options.addOption(listStudents); 

		@SuppressWarnings({ "unused", "deprecation", "static-access" })
		Option getStudent = OptionBuilder.hasArgs()
		.withArgName("studentID")	
		.withDescription("get a student's information by id")
		.create("getStudent"); 

		options.addOption(getStudent); 

		Option award = new Option("award", "award all students money equally"); 
		options.addOption(award); 

		Option getBalance = new Option("getBalance", "return current bursary balance"); 
		options.addOption(getBalance); 

		Option getDonationList = new Option("getDonationList", "get list off all donations"); 
		options.addOption(getDonationList); 

		Option getAwardList = new Option("getAwardList", "get list off all awards"); 
		options.addOption(getAwardList); 


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

		if(line.hasOption("quit")){
			System.out.println("Exiting system"); 
			System.exit(0);
		}

		if(line.hasOption("help")){ 
			formatter.printHelp("bur.sa.ry  \n"
					, options); 

		}

		if(line.hasOption("addDonor")){ 
			String [] arguments = line.getOptionValues("addDonor");  
			manager.accountant.donorManager.addDonor(arguments[0], Integer.parseInt(arguments[1])); 
		}

		if(line.hasOption("listDonors")){ 
			System.out.println("donors"); 
			System.out.println("-------------------------------"); 
			System.out.println(manager.accountant.donorManager.getDonors()); 
		}

		if(line.hasOption("getDonor")){ 
			String [] arguments = line.getOptionValues("getDonor"); 
			System.out.println("donors"); 
			System.out.println("-------------------------------"); 			
			System.out.println(manager.accountant.donorManager.getDonor(Integer.parseInt(arguments[0]))); 
		}

		if(line.hasOption("donate")){ 
			String [] arguments = line.getOptionValues("donate");  
			manager.accountant.donorManager.donateByID(Integer.parseInt(arguments[0]),Integer.parseInt(arguments[0])); 
		}

		if(line.hasOption("getDonationList")){ 
			System.out.println("donations"); 
			System.out.println("-------------------------------"); 
			System.out.println(manager.accountant.donorManager.getDonationList()); 
		}


		if(line.hasOption("addStudent")){ 
			String [] arguments = line.getOptionValues("addStudent");  
			manager.accountant.studentManager.addStudent(arguments[0], Integer.parseInt(arguments[1])); 
		}


		if(line.hasOption("getStudent")){ 
			String [] arguments = line.getOptionValues("getStudent");  
			System.out.println(manager.accountant.studentManager.getStudent(Integer.parseInt(arguments[0]))); 
		}

		if(line.hasOption("listStudents")){ 
			String [] arguments = line.getOptionValues("listStudents"); 
			System.out.println("students"); 
			System.out.println("-------------------------------"); 
			System.out.println(manager.accountant.studentManager.getStudents()); 
		}

		if(line.hasOption("getAwardList")){ 
			String [] arguments = line.getOptionValues("getAwardList"); 
			System.out.println("awards"); 
			System.out.println("-------------------------------"); 
			System.out.println(manager.accountant.studentManager.getAwardsList()); 
		}
		
		writer.write(manager);

	}





}
