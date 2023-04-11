package miage.springboot.service;

import java.util.ArrayList;
import java.util.List;

import miage.springboot.model.Food;

public class FoodImpl implements FoodService{

private List<Food> foods;
	
	public FoodImpl() {
		this.foods = populateDummyFoods();
	}
	
	@Override
	public List<Food> findAllFoods(){
		return this.foods;
	}
	
	private static List<Food> populateDummyFoods() {
		List<Food> f = new ArrayList<Food>();
		Food f1 = new Food(0, "Pizza", 10f);
		Food f2 = new Food(1, "Hotdog", 5f);
		Food f3 = new Food(2, "Ramen", 8f);
		Food f4 = new Food(3, "Milk", 1f);
		Food f5 = new Food(4, "Soda", 3f);
		Food f6 = new Food(5, "Milkshake", 5f);
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		f.add(f5);
		f.add(f6);
		return f;
	}
	
	@Override
	public Food findById(Integer id) {
		for(Food f:this.foods) {
			if(f.getIdFood() == id) {
				return f;
			}
		}
		return null;
	}

	@Override
	public Food findByName(String name) {
		for(Food f:this.foods) {
			if(f.getNameFood().equals(name)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void saveFood(Food e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFood(Food e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFoodById(long id) {
		// TODO Auto-generated method stub
		
	}

}
