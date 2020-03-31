/* Class: CISC 3130
 * Section: TY9
 * EmplId: 23731694
 * Name: Victor Liang Zheng
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A4 {
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void main(String[] args) throws Exception{
		//Read in the file
		FileReader fr = new FileReader("movies.csv");
		BufferedReader reader = new BufferedReader(fr);
		LinkedList<String> idList = new LinkedList<String>();
		LinkedList<String> titleList = new LinkedList<String>();
		LinkedList<String> genresList = new LinkedList<String>();
		LinkedList<String> releaseYearList = new LinkedList<String>();
		String row;
		//Inserting the data into the list created above
		while((row = reader.readLine()) != null) {
			String[] data = row.split(",");
			String movieId = data[0];
			idList.add(movieId);
			String title = data[1];
			titleList.add(title);
			String genres = data[2];
			genresList.add(genres);
			}
		
		//Variables created to store the data of calling the methods below to avoid excessive calculation
		//Variables to hold the amount of movies classified under each genre
		int actionC = actionCount(genresList);
		int adventureC = adventureCount(genresList);
		int animationC = animationCount(genresList);
		int childrenC = childrenCount(genresList);
		int dramaC = dramaCount(genresList);
		int comedyC = comedyCount(genresList);
		int fantasyC = fantasyCount(genresList);
		int romanceC = romanceCount(genresList);
		int crimeC = crimeCount(genresList);
		int thrillerC = thrillerCount(genresList);
		int horrorC = horrorCount(genresList);
		int mysteryC = mysteryCount(genresList);
		int sciFiC = sciFiCount(genresList);
		int warC = warCount(genresList);
		int musicalC = musicalCount(genresList);
		int documentaryC = documentaryCount(genresList);
		int westernC = westernCount(genresList);
		int filmNoirC = filmNoirCount(genresList);
		int imaxC = imaxCount(genresList);
		int noGC = noGenreCount(genresList);
		
		//HashMap to sort the numbers in descending order
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Action Movies", actionC);
		map.put("Adventure Movies", adventureC);
		map.put("Animation Movies", animationC);
		map.put("Children Movies", childrenC);
		map.put("Drama Movies", dramaC);
		map.put("Comedy Movies", comedyC);
		map.put("Fantasy Movies", fantasyC);
		map.put("Romance Movies", romanceC);
		map.put("Crime Movies", crimeC);
		map.put("Thriller Movies", thrillerC);
		map.put("Horror Movies", horrorC);
		map.put("Mystery Movies", mysteryC);
		map.put("Sci-Fi Movies", sciFiC);
		map.put("War Movies", warC);
		map.put("Musical Movies", musicalC);
		map.put("Documentary Movies", documentaryC);
		map.put("Western Movies", westernC);
		map.put("Film-Noir Movies", filmNoirC);
		map.put("IMAX Movies", imaxC);
		map.put("No Genre Listed Movies", noGC);
		
		//Override compare method for descending order for values in HashMap
		Object[] a = map.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue()
		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
		        }
		});
		System.out.println("List of Numbers of Movies Classified Under Each Genre:");
		//For loop to print the hashMap in descending order by its value
		for (Object e : a) {
		    System.out.println(((Map.Entry<String, Integer>) e).getKey() + ": "
		            + ((Map.Entry<String, Integer>) e).getValue());
		}

		//For loop to extract the releaseYear from the title and save it into the releaseYearList
		//Calling isNumeric method to make sure the data are numbers
		for (int i = 0; i < titleList.size(); i++) {
			String temp = titleList.get(i);
	        String year = temp.substring(temp.length()-5, temp.length()-1);
	        if(isNumeric(year)) {releaseYearList.add(year);}
	        }
		
		//Variables of percentage of movies released in most recent 5 years compared to the overall data set
		Double actionP =  ((double)actionIn5(genresList, releaseYearList))/((double)actionC)*100;
		Double adventureP =  ((double)adventureIn5(genresList, releaseYearList))/((double)adventureC)*100;
		Double animationP =  ((double)animationIn5(genresList, releaseYearList))/((double)animationC)*100;
		Double childrenP =  ((double)childrenIn5(genresList, releaseYearList))/((double)childrenC)*100;
		Double dramaP =  ((double)dramaIn5(genresList, releaseYearList))/((double)dramaC)*100;
		Double comedyP =  ((double)comedyIn5(genresList, releaseYearList))/((double)comedyC)*100;
		Double fantasyP =  ((double)fantasyIn5(genresList, releaseYearList))/((double)fantasyC)*100;
		Double romanceP =  ((double)romanceIn5(genresList, releaseYearList))/((double)romanceC)*100;
		Double crimeP =  ((double)crimeIn5(genresList, releaseYearList))/((double)crimeC)*100;
		Double thrillerP =  ((double)thrillerIn5(genresList, releaseYearList))/((double)thrillerC)*100;
		Double horrorP =  ((double)horrorIn5(genresList, releaseYearList))/((double)horrorC)*100;
		Double mysteryP =  ((double)mysteryIn5(genresList, releaseYearList))/((double)mysteryC)*100;
		Double sciFiP =  ((double)sciFiIn5(genresList, releaseYearList))/((double)sciFiC)*100;
		Double warP =  ((double)warIn5(genresList, releaseYearList))/((double)warC)*100;
		Double musicalP =  ((double)musicalIn5(genresList, releaseYearList))/((double)musicalC)*100;
		Double documentaryP =  ((double)documentaryIn5(genresList, releaseYearList))/((double)documentaryC)*100;
		Double westernP =  ((double)westernIn5(genresList, releaseYearList))/((double)westernC)*100;
		Double filmNoirP =  ((double)filmNoirIn5(genresList, releaseYearList))/((double)filmNoirC)*100;
		Double imaxP =  ((double)imaxIn5(genresList, releaseYearList))/((double)imaxC)*100;
		
		//Print the result to the console by the percentage in descending order
		System.out.println("\nMovies in Most Recent 5 Years: ");
		System.out.println("Animation: " + animationIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", animationP)+ " of Total " + animationC + " Animation Movies");
		System.out.println("Documentary: " + documentaryIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", documentaryP)+ " of Total " + documentaryC + " Documentary Movies");
		System.out.println("Sci-Fi: " + sciFiIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", sciFiP)+ " of Total " + sciFiC + " Sci-Fi Movies");
		System.out.println("Children: " + childrenIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", childrenP)+ " of Total " + childrenC + " Children Movies");
		System.out.println("Comedy: " + comedyIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", comedyP)+ " of Total " + comedyC + " Comedy Movies");
		System.out.println("Action: " + actionIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", actionP)+ " of Total " + actionC + " Action Movies");
		System.out.println("Fantasy: " + fantasyIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", fantasyP)+ " of Total " + fantasyC + " Fantasy Movies");
		System.out.println("Adventure: " + adventureIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", adventureP)+ " of Total " + adventureC + " Adventure Movies");
		System.out.println("Horror: " + horrorIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", horrorP)+ " of Total " + horrorC + " Horror Movies");
		System.out.println("Mystery: " + mysteryIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", mysteryP)+ " of Total " + mysteryC + " Mystery Movies");
		System.out.println("Thriller: " + thrillerIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", thrillerP)+ " of Total " + thrillerC + " Thriller Movies");
		System.out.println("Crime: " + crimeIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", crimeP)+ " of Total " + crimeC + " Crime Movies");
		System.out.println("IMAX: " + imaxIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", imaxP)+ " of Total " + imaxC + " IMAX Movies");
		System.out.println("Drama: " + dramaIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", dramaP)+ " of Total " + dramaC + " Drama Movies");
		System.out.println("Western: " + westernIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", westernP)+ " of Total " + westernC + " Western Movies");
		System.out.println("Romance: " + romanceIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", romanceP)+ " of Total " + romanceC + " Romance Movies");
		System.out.println("War: " + warIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", warP)+ " of Total " + warC + " War Movies");
		System.out.println("Musical: " + musicalIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", musicalP)+ " of Total " + musicalC + " Musical Movies");
		System.out.println("Film-Noir: " + filmNoirIn5(genresList, releaseYearList) + " Movies -- %" + String.format("%.2f", filmNoirP)+ " of Total " + filmNoirC + " Film-Noir Movies");
		
		//Array of string containing the decades
		String[] decades = {"1911-1920", "1921-1930", "1931-1940", "1941-1950", "1951-1960", "1961-1970", "1971-1980", "1981-1990", "1991-2000", "2001-2010", "2011-2020"};
		
		//Variable that stores the data of calling the methods to calculate the number of times movies came out of each genre
		int[] actionD = actionDecades(genresList, releaseYearList);
		int[] adventureD = adventureDecades(genresList, releaseYearList);
		int[] animationD = animationDecades(genresList, releaseYearList);
		int[] childrenD = childrenDecades(genresList, releaseYearList);
		int[] dramaD = dramaDecades(genresList, releaseYearList);
		int[] comedyD = comedyDecades(genresList, releaseYearList);
		int[] fantasyD = fantasyDecades(genresList, releaseYearList);
		int[] romanceD = romanceDecades(genresList, releaseYearList);
		int[] crimeD = crimeDecades(genresList, releaseYearList);
		int[] thrillerD = thrillerDecades(genresList, releaseYearList);
		int[] horrorD = horrorDecades(genresList, releaseYearList);
		int[] mysteryD = mysteryDecades(genresList, releaseYearList);
		int[] sciFiD = sciFiDecades(genresList, releaseYearList);
		int[] warD = warDecades(genresList, releaseYearList);
		int[] musicalD = musicalDecades(genresList, releaseYearList);
		int[] documentaryD = documentaryDecades(genresList, releaseYearList);
		int[] westernD = westernDecades(genresList, releaseYearList);
		int[] filmNoirD = filmNoirDecades(genresList, releaseYearList);
		int[] imaxD = imaxDecades(genresList, releaseYearList);
		
		//Printing the result to the console by the genre alphabetically
		System.out.println("\nGenres/Decades:\t\t" +Arrays.toString(decades));
		System.out.println("Action Movies:\t\t" + Arrays.toString(actionD));
		System.out.println("Adventure Movies:\t" + Arrays.toString(adventureD));
		System.out.println("Animation Movies:\t" + Arrays.toString(animationD));
		System.out.println("Children Movies:\t" + Arrays.toString(childrenD));
		System.out.println("Comedy Movies:\t\t" + Arrays.toString(comedyD));
		System.out.println("Crime Movies:\t\t" + Arrays.toString(crimeD));
		System.out.println("Documentary Movies:\t" + Arrays.toString(documentaryD));
		System.out.println("Drama Movies:\t\t" + Arrays.toString(dramaD));
		System.out.println("Fantasy Movies:\t\t" + Arrays.toString(fantasyD));
		System.out.println("Film-Noir Movies:\t" + Arrays.toString(filmNoirD));
		System.out.println("Horror Movies:\t\t" + Arrays.toString(horrorD));
		System.out.println("IMAX Movies:\t\t" + Arrays.toString(imaxD));
		System.out.println("Musical Movies:\t\t" + Arrays.toString(musicalD));
		System.out.println("Mystery Movies:\t\t" + Arrays.toString(mysteryD));
		System.out.println("Romance Movies:\t\t" + Arrays.toString(romanceD));
		System.out.println("Sci-Fi Movies:\t\t" + Arrays.toString(sciFiD));
		System.out.println("Thriller Movies:\t" + Arrays.toString(thrillerD));
		System.out.println("War Movies:\t\t" + Arrays.toString(warD));
		System.out.println("Western Movies:\t\t" + Arrays.toString(westernD));
		
		}
	
	//Method to check if the parameter it receive is a number
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
			}
		try {
			int i = Integer.parseInt(strNum);
			} catch (NumberFormatException nfe) {
				return false;
				}
		return true;
		}
	
	//Method to count movies that are classified under the genre of Action
	public static int actionCount(LinkedList<String> genresList){
		int actionCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Action")){
				actionCount++;
				}
			}
		return actionCount;
		}
	
	//Method to count movies that are classified under the genre of Adventure
	public static int adventureCount(LinkedList<String> genresList){
		int adventureCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Adventure")){
				adventureCount++;
				}
			}
		return adventureCount;
		}
	
	//Method to count movies that are classified under the genre of Animation
	public static int animationCount(LinkedList<String> genresList){
		int animationCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Animation")){
				animationCount++;
				}
			}
		return animationCount;
		}
	
	//Method to count movies that are classified under the genre of Children
	public static int childrenCount(LinkedList<String> genresList){
		int childrenCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Children")){
				childrenCount++;
				}
			}
		return childrenCount;
		}

	//Method to count movies that are classified under the genre of Drama
	public static int dramaCount(LinkedList<String> genresList){
		int dramaCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Drama")){
				dramaCount++;
				}
			}
		return dramaCount;
		}
	
	//Method to count movies that are classified under the genre of Comedy
	public static int comedyCount(LinkedList<String> genresList){
		int comedyCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Comedy")){
				comedyCount++;
				}
			}
		return comedyCount;
		}
	
	//Method to count movies that are classified under the genre of Fantasy
	public static int fantasyCount(LinkedList<String> genresList){
		int fantasyCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Fantasy")){
				fantasyCount++;
				}
			}
		return fantasyCount;
		}
	
	//Method to count movies that are classified under the genre of Romance
	public static int romanceCount(LinkedList<String> genresList){
		int romanceCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Romance")){
				romanceCount++;
				}
			}
		return romanceCount;
		}
	
	//Method to count movies that are classified under the genre of Crime
	public static int crimeCount(LinkedList<String> genresList){
		int crimeCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Crime")){
				crimeCount++;
				}
			}
		return crimeCount;
		}
	
	//Method to count movies that are classified under the genre of Thriller
	public static int thrillerCount(LinkedList<String> genresList){
		int thrillerCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Thriller")){
				thrillerCount++;
				}
			}
		return thrillerCount;
		}
	
	//Method to count movies that are classified under the genre of Horror
	public static int horrorCount(LinkedList<String> genresList){
		int horrorCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Horror")){
				horrorCount++;
				}
			}
		return horrorCount;
		}
	
	//Method to count movies that are classified under the genre of Mystery
	public static int mysteryCount(LinkedList<String> genresList){
		int mysteryCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Mystery")){
				mysteryCount++;
				}
			}
		return mysteryCount;
		}
	
	//Method to count movies that are classified under the genre of Sci-Fi
	public static int sciFiCount(LinkedList<String> genresList){
		int sciFiCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Sci-Fi")){
				sciFiCount++;
				}
			}
		return sciFiCount;
		}
	
	//Method to count movies that are classified under the genre of War
	public static int warCount(LinkedList<String> genresList){
		int warCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("War")){
				warCount++;
				}
			}
		return warCount;
		}
	
	//Method to count movies that are classified under the genre of Musical
	public static int musicalCount(LinkedList<String> genresList){
		int musicalCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Musical")){
				musicalCount++;
				}
			}
		return musicalCount;
		}
	
	//Method to count movies that are classified under the genre of Documentary
	public static int documentaryCount(LinkedList<String> genresList){
		int documentaryCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Documentary")){
				documentaryCount++;
				}
			}
		return documentaryCount;
		}
	
	//Method to count movies that are classified under the genre of Western
	public static int westernCount(LinkedList<String> genresList){
		int westernCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Western")){
				westernCount++;
				}
			}
		return westernCount;
		}
	
	//Method to count movies that are classified under the genre of Film-Noir
	public static int filmNoirCount(LinkedList<String> genresList){
		int filmNoirCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("Film-Noir")){
				filmNoirCount++;
				}
			}
		return filmNoirCount;
		}
	
	//Method to count movies that are classified under the genre of IMAX
	public static int imaxCount(LinkedList<String> genresList){
		int imaxCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("IMAX")){
				imaxCount++;
				}
			}
		return imaxCount;
		}
	
	//Method to count movies that have no genre listed
	public static int noGenreCount(LinkedList<String> genresList){
		int noGenreCount = 0;
		for (int i = 0; i < genresList.size(); i++) {
			String genre = genresList.get(i);
			if (genre.contains("no genres listed")){
				noGenreCount++;
				}
			}
		return noGenreCount;
		}
	
	//Method to count the amount of action movies that are released in the most recent 5 years
	public static int actionIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int actionIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Action") && year >= 2014){
				actionIn5++;
				}
			}
		return actionIn5;
		}
	
	//Method to count the amount of adventure movies that are released in the most recent 5 years
	public static int adventureIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int adventureIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Adventure") && year >= 2014){
				adventureIn5++;
				}
			}
		return adventureIn5;
		}
	
	//Method to count the amount of animation movies that are released in the most recent 5 years
	public static int animationIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int animationIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Animation") && year >= 2014){
				animationIn5++;
				}
			}
		return animationIn5;
		}
	
	//Method to count the amount of children movies that are released in the most recent 5 years
	public static int childrenIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int childrenIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Children") && year >= 2014){
				childrenIn5++;
				}
			}
		return childrenIn5;
		}
	
	//Method to count the amount of drama movies that are released in the most recent 5 years
	public static int dramaIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int dramaIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Drama") && year >= 2014){
				dramaIn5++;
				}
			}
		return dramaIn5;
		}

	//Method to count the amount of comedy movies that are released in the most recent 5 years
	public static int comedyIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int comedyIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Comedy") && year >= 2014){
				comedyIn5++;
				}
			}
		return comedyIn5;
		}
	
	//Method to count the amount of fantasy movies that are released in the most recent 5 years
	public static int fantasyIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int fantasyIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Fantasy") && year >= 2014){
				fantasyIn5++;
				}
			}
		return fantasyIn5;
		}
	
	//Method to count the amount of romance movies that are released in the most recent 5 years
	public static int romanceIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int romanceIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Romance") && year >= 2014){
				romanceIn5++;
				}
			}
		return romanceIn5;
		}
	
	//Method to count the amount of crime movies that are released in the most recent 5 years
	public static int crimeIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int crimeIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Crime") && year >= 2014){
				crimeIn5++;
				}
			}
		return crimeIn5;
		}
	
	//Method to count the amount of thriller movies that are released in the most recent 5 years
	public static int thrillerIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int thrillerIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Thriller") && year >= 2014){
				thrillerIn5++;
				}
			}
		return thrillerIn5;
		}
	
	//Method to count the amount of horror movies that are released in the most recent 5 years
	public static int horrorIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int horrorIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Horror") && year >= 2014){
				horrorIn5++;
				}
			}
		return horrorIn5;
		}
	
	//Method to count the amount of mystery movies that are released in the most recent 5 years
	public static int mysteryIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int mysteryIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Mystery") && year >= 2014){
				mysteryIn5++;
				}
			}
		return mysteryIn5;
		}
	
	//Method to count the amount of sci-fi movies that are released in the most recent 5 years
	public static int sciFiIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int sciFiIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Sci-Fi") && year >= 2014){
				sciFiIn5++;
				}
			}
		return sciFiIn5;
		}
	
	//Method to count the amount of war movies that are released in the most recent 5 years
	public static int warIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int warIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("War") && year >= 2014){
				warIn5++;
				}
			}
		return warIn5;
		}
	
	//Method to count the amount of musical movies that are released in the most recent 5 years
	public static int musicalIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int musicalIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Musical") && year >= 2014){
				musicalIn5++;
				}
			}
		return musicalIn5;
		}
	
	//Method to count the amount of documentary movies that are released in the most recent 5 years
	public static int documentaryIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int documentaryIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Documentary") && year >= 2014){
				documentaryIn5++;
				}
			}
		return documentaryIn5;
		}
	
	//Method to count the amount of western movies that are released in the most recent 5 years
	public static int westernIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int westernIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Western") && year >= 2014){
				westernIn5++;
				}
			}
		return westernIn5;
		}
	
	//Method to count the amount of film-noir movies that are released in the most recent 5 years
	public static int filmNoirIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int filmNoirIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Film-Noir") && year >= 2014){
				filmNoirIn5++;
				}
			}
		return filmNoirIn5;
		}
	
	//Method to count the amount of IMAX movies that are released in the most recent 5 years
	public static int imaxIn5(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int imaxIn5 = 0;
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("IMAX") && year >= 2014){
				imaxIn5++;
				}
			}
		return imaxIn5;
		}

	//Method to count the amount of action movies released in each decades
	public static int[] actionDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Action") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Action") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Action") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Action") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Action") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Action") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Action") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Action") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Action") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Action") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Action") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of adventure movies released in each decades
	public static int[] adventureDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Adventure") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Adventure") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Adventure") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Adventure") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Adventure") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Adventure") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Adventure") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Adventure") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Adventure") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Adventure") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Adventure") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of animation movies released in each decades
	public static int[] animationDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Animation") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Animation") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Animation") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Animation") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Animation") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Animation") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Animation") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Animation") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Animation") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Animation") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Animation") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of children movies released in each decades
	public static int[] childrenDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Children") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Children") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Children") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Children") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Children") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Children") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Children") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Children") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Children") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Children") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Children") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of drama movies released in each decades
	public static int[] dramaDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Drama") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Drama") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Drama") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Drama") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Drama") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Drama") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Drama") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Drama") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Drama") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Drama") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Drama") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of comedy movies released in each decades
	public static int[] comedyDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Comedy") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Comedy") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Comedy") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Comedy") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Comedy") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Comedy") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Comedy") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Comedy") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Comedy") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Comedy") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Comedy") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of fantasy movies released in each decades
	public static int[] fantasyDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Fantasy") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Fantasy") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Fantasy") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Fantasy") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Fantasy") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Fantasy") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Fantasy") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Fantasy") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Fantasy") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Fantasy") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Fantasy") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of romance movies released in each decades
	public static int[] romanceDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Romance") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Romance") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Romance") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Romance") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Romance") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Romance") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Romance") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Romance") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Romance") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Romance") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Romance") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of crime movies released in each decades
	public static int[] crimeDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Crime") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Crime") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Crime") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Crime") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Crime") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Crime") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Crime") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Crime") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Crime") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Crime") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Crime") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of thriller movies released in each decades
	public static int[] thrillerDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Thriller") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Thriller") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Thriller") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Thriller") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Thriller") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Thriller") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Thriller") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Thriller") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Thriller") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Thriller") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Thriller") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of horror movies released in each decades
	public static int[] horrorDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Horror") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Horror") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Horror") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Horror") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Horror") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Horror") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Horror") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Horror") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Horror") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Horror") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Horror") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of mystery movies released in each decades
	public static int[] mysteryDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Mystery") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Mystery") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Mystery") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Mystery") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Mystery") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Mystery") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Mystery") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Mystery") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Mystery") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Mystery") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Mystery") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of sci-fi movies released in each decades
	public static int[] sciFiDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Sci-Fi") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Sci-Fi") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Sci-Fi") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of war movies released in each decades
	public static int[] warDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("War") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("War") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("War") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("War") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("War") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("War") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("War") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("War") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("War") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("War") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("War") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of musical movies released in each decades
	public static int[] musicalDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Musical") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Musical") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Musical") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Musical") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Musical") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Musical") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Musical") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Musical") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Musical") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Musical") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Musical") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of documentary movies released in each decades
	public static int[] documentaryDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Documentary") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Documentary") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Documentary") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Documentary") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Documentary") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Documentary") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Documentary") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Documentary") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Documentary") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Documentary") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Documentary") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of western movies released in each decades
	public static int[] westernDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Western") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Western") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Western") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Western") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Western") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Western") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Western") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Western") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Western") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Western") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Western") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of film-noir movies released in each decades
	public static int[] filmNoirDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("Film-Noir") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("Film-Noir") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("Film-Noir") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("Film-Noir") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("Film-Noir") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
	//Method to count the amount of IMAX movies released in each decades
	public static int[] imaxDecades(LinkedList<String> genresList, LinkedList<String> releaseYearList){
		int[] decades = new int[11];
		for (int i = 0; i < genresList.size() && i<releaseYearList.size(); i++) {
			String genre = genresList.get(i);
			int year = Integer.parseInt(releaseYearList.get(i));
			if (genre.contains("IMAX") && year >= 1911 && year <= 1920){
				decades[0]++;
				}
			else if(genre.contains("IMAX") && year >= 1921 && year <= 1930){
				decades[1]++;
			}
			else if(genre.contains("IMAX") && year >= 1931 && year <= 1940){
				decades[2]++;
			}
			else if(genre.contains("IMAX") && year >= 1941 && year <= 1950){
				decades[3]++;
			}
			else if(genre.contains("IMAX") && year >= 1951 && year <= 1960){
				decades[4]++;
			}
			else if(genre.contains("IMAX") && year >= 1961 && year <= 1970){
				decades[5]++;
			}
			else if(genre.contains("IMAX") && year >= 1971 && year <= 1980){
				decades[6]++;
			}
			else if(genre.contains("IMAX") && year >= 1981 && year <= 1990){
				decades[7]++;
			}
			else if(genre.contains("IMAX") && year >= 1991 && year <= 2000){
				decades[8]++;
			}
			else if(genre.contains("IMAX") && year >= 2001 && year <= 2010){
				decades[9]++;
			}
			else if(genre.contains("IMAX") && year >= 2011 && year <= 2020){
				decades[10]++;
			}
			}
		return decades;	
	}
	
}