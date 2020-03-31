# A4---Movie-Genres

This project demonstrates how to read in a csv files of movie genres and parse that data into a linkedlist. With that data, we are required to answer three quesitons:
1. How many movies are classified under each genre?
2. How many for the whole data set versus the most recent 5 years?
3. How many movies of each genre came out each decade?

In this project, I've used Linked List, HashMap and Array.

I use linkedlist to read in the data in the file. The reason that I use linked list is that the operation with linked list is much easier and furthermore, it can grow and shrink during run time, which makes insertion and deletion much easier. Array were used to save the data of the movies that are in the range of the decades it came out.

The datas were saved into many linkedlist according to their header, which are the movieId, titles and genres. The release year of the movie was inside the movie title, therefore, a for loop in my program were extracted and save into the linkedlist of releaseYear and it would check if the data it receives is numeric. Then, the genres in the linkedlist were save into a HashMap as key and the amount of the movies under that genre would be save into the HashMap as value. This allows me to sort the hashmap by its value in descending order. From the genre that has the most movies classified under to the genre of the least movies classified under.

I've decided to change the file in the data folder. I discovered that for some movie titles, there might be a extra commas inside of it, therefore, I've decided to change the coma into a semi-colon to avoid error in reading in those datas. 

## Setup

These are the steps to compile `A4.java` and run the program `A4`. Source code is found in the src folder. These steps are for use with command line workflow such as with a terminal.

1. Sign up for a GitHub account if you don't have one. Set up your SSH keys with github.
2. Clone this repository `git clone git@github.com:victorliangzheng88/A4---Movie-Genres.git` to your machine to get a copy.
3. Move into the project's root directory with `cd A4---Movie-Genres` [^1]
4. Move again into the subdirectory `src` using the command `cd src`
5. Compile the java file using the java compiler command `javac A4.java`
6. Run the compiled java program with the java command `java A4`

Another way to run the program is to use the integrated development environment (IDE), eclipse.

1. Download and Install Java, and Eclipse if the programs are not yet installed.
2. Go to https://github.com/victorliangzheng88/A4---Movie-Genres.git using web browser.
3. Download the files in the folder called `data` and `src` and save them into the same folder in your computer.
4. Open eclipse after installed and click File on the left top corner and click Open File.
5. Choose the file name of `A4.java` and click Open.
6. Click Run.

You should see an output similar to the following:

```sh
List of Numbers of Movies Classified Under Each Genre:
Drama Movies: 4361
Comedy Movies: 3756
Thriller Movies: 1894
Action Movies: 1828
Romance Movies: 1596
Adventure Movies: 1263
Crime Movies: 1199
Sci-Fi Movies: 980
Horror Movies: 978
Fantasy Movies: 779
Children Movies: 664
Animation Movies: 611
Mystery Movies: 573
Documentary Movies: 440
War Movies: 382
Musical Movies: 334
Western Movies: 167
IMAX Movies: 158
Film-Noir Movies: 87
No Genre Listed Movies: 34

Movies in Most Recent 5 Years: 
Animation: 125 Movies -- %20.46 of Total 611 Animation Movies
Documentary: 55 Movies -- %12.50 of Total 440 Documentary Movies
Sci-Fi: 120 Movies -- %12.24 of Total 980 Sci-Fi Movies
Children: 81 Movies -- %12.20 of Total 664 Children Movies
Comedy: 404 Movies -- %10.76 of Total 3756 Comedy Movies
Action: 194 Movies -- %10.61 of Total 1828 Action Movies
Fantasy: 82 Movies -- %10.53 of Total 779 Fantasy Movies
Adventure: 128 Movies -- %10.13 of Total 1263 Adventure Movies
Horror: 94 Movies -- %9.61 of Total 978 Horror Movies
Mystery: 53 Movies -- %9.25 of Total 573 Mystery Movies
Thriller: 161 Movies -- %8.50 of Total 1894 Thriller Movies
Crime: 100 Movies -- %8.34 of Total 1199 Crime Movies
IMAX: 13 Movies -- %8.23 of Total 158 IMAX Movies
Drama: 310 Movies -- %7.11 of Total 4361 Drama Movies
Western: 8 Movies -- %4.79 of Total 167 Western Movies
Romance: 74 Movies -- %4.64 of Total 1596 Romance Movies
War: 16 Movies -- %4.19 of Total 382 War Movies
Musical: 7 Movies -- %2.10 of Total 334 Musical Movies
Film-Noir: 0 Movies -- %0.00 of Total 87 Film-Noir Movies

Genres/Decades:		[1911-1920, 1921-1930, 1931-1940, 1941-1950, 1951-1960, 1961-1970, 1971-1980, 1981-1990, 1991-2000, 2001-2010, 2011-2020]
Action Movies:		[1, 2, 10, 11, 26, 64, 99, 235, 396, 598, 379]
Adventure Movies:	[0, 6, 12, 18, 33, 67, 76, 175, 233, 401, 240]
Animation Movies:	[0, 4, 4, 7, 5, 13, 22, 47, 93, 192, 217]
Children Movies:	[0, 2, 11, 14, 11, 31, 36, 68, 179, 187, 125]
Comedy Movies:		[2, 17, 59, 50, 74, 137, 179, 518, 925, 1096, 687]
Crime Movies:		[4, 2, 17, 28, 34, 41, 59, 144, 291, 382, 195]
Documentary Movies:	[0, 2, 3, 3, 2, 11, 11, 34, 86, 181, 104]
Drama Movies:		[5, 20, 86, 113, 155, 192, 246, 482, 1140, 1328, 586]
Fantasy Movies:		[2, 5, 11, 13, 12, 20, 33, 110, 152, 271, 148]
Film-Noir Movies:	[0, 1, 5, 28, 14, 2, 3, 10, 12, 9, 3]
Horror Movies:		[4, 4, 10, 11, 37, 32, 84, 171, 170, 288, 166]
IMAX Movies:		[0, 1, 1, 1, 0, 0, 2, 2, 15, 68, 68]
Musical Movies:		[0, 4, 21, 21, 29, 32, 30, 36, 55, 84, 22]
Mystery Movies:		[0, 0, 10, 25, 14, 17, 39, 67, 118, 195, 88]
Romance Movies:		[0, 8, 54, 54, 64, 59, 60, 176, 465, 501, 153]
Sci-Fi Movies:		[0, 3, 8, 5, 39, 33, 72, 154, 172, 279, 211]
Thriller Movies:	[2, 2, 20, 35, 35, 59, 110, 213, 462, 638, 315]
War Movies:		[1, 4, 6, 14, 31, 45, 19, 47, 59, 127, 29]
Western Movies:		[0, 0, 4, 10, 17, 28, 14, 12, 33, 34, 15]

```

# Data Visualization

I've chose python to create my graph to answer the question: Under which genre that most movies are classified? The datas to answer this question were extracted from the first part of the `A4.java`. The answer for the question is that Drama is the genre that has the greatest number of movies classified under. The second genre that has the greatest number is Comedy.

## Setup for Data Visualization

For the Data Visualization, I've used Python to create the graph and using Window. These are the steps for use with Window and Command Line.

1. Download and Install Python from https://www.python.org/downloads/ if your devide doesn't have python.
2. Go to https://github.com/victorliangzheng88/A4---Movie-Genres.git using web browser.
3. Download the files in the folder called `DataVisualization` and the file name is `BarGraphExtraCredit.py` and save it in your computer.
4. Open the command line in your window by pressing `Window`+`R` and type `cmd`.
5. Type `pip install pandas` and `python -m pip install -U pip` and `python -m pip install -U matplotlib`
6. Open IDLE for python and select `File`, `Open` and chose the file `BarGraphExtraCredit.py` that you've just downloaded.
7. After the file was opened, Click `Run` and `Run Module`.
