package com.movie.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie>{
	
	private double rating;
	private String name;
	private int year;
	
	public Movie(String name,double rating, int year) {
		super();
		this.rating = rating;
		this.name = name;
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
	
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	@Override
	public String toString() {
		return "Movie [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}
	
		
}
class Main_Movie_Ex {
	public static void main(String [] args) {
		List<Movie> list = new ArrayList<>();
	
		 list.add(new Movie("ABCD", 8.3, 2015)); 
	     list.add(new Movie("HOLIDAY", 8.7, 1977)); 
	     list.add(new Movie("KRISH", 8.8, 1980)); 
	     list.add(new Movie("Badlapur", 8.4, 1983)); 
	     list.add(new Movie("Badlapur-2", 8.4, 1985));
	     
	     
	     System.out.println("asc sorting with year with comapreTo");
	     Collections.sort(list);
	     System.out.println(list);

	     System.out.println();
	     System.out.println("asc sorting with rating ");
	     Collections.sort(list, (o1,o2)->Double.compare(o1.getRating(), o2.getRating()));

	     
	     System.out.println();
	     System.out.println("asc sorting with name ");
	     Comparator<Movie> movie_name = (o1,o2)->o1.getName().compareTo(o2.getName());
	     Collections.sort(list, movie_name);
	     System.out.println(list);
	     
	     
	     System.out.println();
	     System.out.println("descending sorting with name & using reverse fn");
	     // change the comparator logic
	     Comparator<Movie> movie_name_des =movie_name.reversed();
	     Collections.sort(list, movie_name_des);
	     System.out.println(list);
	     
	     
	     System.out.println();
	     System.out.println("first with rating if = then name");
	     Comparator<Movie> rating = (o1,o2)->Double.compare(o1.getRating(), o2.getRating());
	     Comparator<Movie> rating_name = rating.thenComparing(movie_name);
	     Collections.sort(list,rating_name);
	     System.out.println(list);
	     
		 list.add(null); 
	     
	     System.out.println();
	     System.out.println("if first null");
	     rating_name = Comparator.nullsLast(rating_name);
	     Collections.sort(list,rating_name);
	     System.out.println(list);
	     
	     System.out.println();
	     System.out.println("display using foreach");
	     for (Movie movie: list) {
				System.out.println(movie);
			}

	     System.out.println();
	     System.out.println("display using function ptr");
			list.forEach(item -> System.out.println(item));
			
		     System.out.println();
		     System.out.println("display using method reference");
			list.forEach(System.out::println);
	}
}
