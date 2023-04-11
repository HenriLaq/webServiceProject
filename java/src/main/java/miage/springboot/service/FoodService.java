package miage.springboot.service;

import java.util.List;

import miage.springboot.model.Food;

public interface FoodService {
	Food findById(Integer id);
	Food findByName(String name);
	List<Food>findAllFoods();
	void saveFood(Food e);
	void updateFood(Food e);
	void deleteFoodById(long id);
}
