package com.comp1601.tipntax;
import java.util.Random;

public class MealPlan{
	Random rand = new Random();

	public MealPlan(){};

	public Recipe [] makeMealPlan(Cookbook recipes){
		Recipe [] plan = new Recipe[7];
		for (int i = 0; i < plan.length; i++){
			int num = rand.nextInt(recipes.getRecipes().length - 1);
			plan[i] = recipes.getRecipes()[num];
		}
		return plan;
	}
}