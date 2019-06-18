package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class lib {
		public static <T> List<T> filter(List<T> list, Predicate <T> predicate){
			
			List<T> out = new ArrayList<>();
			for(T e: list) {
				if(predicate.test(e))
					out.add(e);
			}
			return out;	
		}
		
		public static<T,R>List<R> map(List<T> list, Function<T, R> func){
					
				List<R> out = new ArrayList<>();
				for(T e:list) {
					out.add(func.apply(e));
				}
				return out;
					
		};
		
		public static <T> void forEach(List<T> list,Consumer<T> consume) {
			for(T e: list)
				consume.accept(e);
			
		}
}
