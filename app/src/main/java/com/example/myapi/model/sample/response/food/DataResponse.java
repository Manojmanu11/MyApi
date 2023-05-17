package com.example.myapi.model.sample.response.food;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataResponse{

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	@Override
 	public String toString(){
		return 
			"DataResponse{" + 
			"categories = '" + categories + '\'' + 
			"}";
		}
}