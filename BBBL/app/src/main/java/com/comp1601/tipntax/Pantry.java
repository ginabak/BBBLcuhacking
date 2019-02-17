package com.comp1601.tipntax;

public class Pantry{
	public Pantry(){};

	private Ingredient[] ingredients = new Ingredient[0];

	public void addNewIngredient(String ingredient, double qty){
		boolean ingredientExists = false;
		for(int i=0; i < this.ingredients.length; i+=1){
			if(this.ingredients[i].getName().equals(ingredient)){
				ingredientExists = true;
				this.ingredients[i].setQty(this.ingredients[i].getQty()+qty);
			}
		}
		if(ingredientExists == false){
			Ingredient[] newIngredients = new Ingredient[ingredients.length+1];
			for(int i = 0; i < this.ingredients.length; i+=1){
				newIngredients[i] = this.ingredients[i];				
			}

			newIngredients[newIngredients.length-1] = new Ingredient(ingredient, qty);
			this.ingredients = newIngredients;
		}
	}

	public boolean deleteIngredient(Ingredient ingredient){
		if(this.ingredients.length > 0){
		int removedIndex = 0; //keep track of the index position of the removed item
			boolean removed = false; //keep track of whether we've successfully removed an item
			for(int i = 0; i < this.ingredients.length; i+=1){ //look through every item
				if(this.ingredients[i].getName().equalsIgnoreCase(ingredient.getName())){ //if the name of the current item matches, we will 'target it for removal'
					removedIndex = i;
					removed = true;
				}
			}
			//copy array with 'removed' index into new array of appropriate size if we have found an item to remove
			if(removed == true){
				if(removedIndex+1 != this.ingredients.length){ //if the removed item wasn't at the end of the list, we will rearrange our recipe array to 'mend' the break. this makes the last index contain a duplicate object.
					for(int i = removedIndex; i < this.ingredients.length-1; i+=1){
						this.ingredients[i] = this.ingredients[i+1];
					}
				}
				Ingredient[] newIngredients = new Ingredient[this.ingredients.length-1];
				for(int i =0; i < newIngredients.length; i+=1){
					newIngredients[i] = this.ingredients[i];
				}
				this.ingredients = newIngredients;
				return removed;
			}else{
				return false;
			}
		} else{
			return false;
		}
	}

	public void removeIngredientByQty(Ingredient ingredient, double qty){
		for(int i =0; i < this.ingredients.length; i+=1){
			if(this.ingredients[i].getName().equalsIgnoreCase(ingredient.getName())){
				this.ingredients[i].setQty(this.ingredients[i].getQty()-qty);
				if(this.ingredients[i].getQty()<=0){
					this.deleteIngredient(ingredient);
				}
			}
		}
	}

	public void setIngredientQty(Ingredient ingredient, double qty){
		for(int i=0; i<this.ingredients.length; i+=1){
			if(this.ingredients[i].getName().equalsIgnoreCase(ingredient.getName())){
				this.ingredients[i].setQty(qty);
				if(this.ingredients[i].getQty()<=0){
					this.deleteIngredient(ingredient);
				}
			}
		}
	}
}