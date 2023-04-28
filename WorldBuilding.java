/* 
 * Final Assignment
 * Andrew Webster
 * 04/21/23
 */

import java.util.ArrayList;
import java.util.List;

public class World {
    private double spawnCreature;
    private int foodCount;
    private int waterCount;
    private int floodingChance;
    private int tornadoChance;
    private int heatWaveChance;
    private boolean isDay;
    private List<Food> foods;
    private List<Creature> creatures;

    public World() {
        this.foods = new ArrayList<>();
        this.creatures = new ArrayList<>();
    }

    public void createCreature(String name, int health, int attackPower, int foodLevel, int waterLevel) {
        Creature creature = new Creature(name, health, attackPower, foodLevel, waterLevel, this);
        creatures.add(creature);
    }

    public void spawnFood(int nutritionValue, int spawnChance) {
        Food food = new Food(nutritionValue, spawnChance);
        foods.add(food);
    }

    public boolean isDaytime() {
        return isDay;
    }

    // Getters and Setters for the attributes
    public double getSpawnCreature() {
        return spawnCreature;
    }

    public void setSpawnCreature(double spawnCreature) {
        this.spawnCreature = spawnCreature;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public int getFloodingChance() {
        return floodingChance;
    }

    public void setFloodingChance(int floodingChance) {
        this.floodingChance = floodingChance;
    }

    public int getTornadoChance() {
        return tornadoChance;
    }

    public void setTornadoChance(int tornadoChance) {
        this.tornadoChance = tornadoChance;
    }

    public int getHeatWaveChance() {
        return heatWaveChance;
    }

    public void setHeatWaveChance(int heatWaveChance) {
        this.heatWaveChance = heatWaveChance;
    }

    public boolean getIsDay() {
        return isDay;
    }

    public void setIsDay(boolean isDay) {
        this.isDay = isDay;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
}

public class Food {
    private int nutritionValue;
    private boolean isRotten;
    private int spawnChance;

    private List<Creature> creatures;

    public Food(int nutritionValue, int spawnChance) {
        this.nutritionValue = nutritionValue;
        this.spawnChance = spawnChance;
        this.creatures = new ArrayList<>();
    }

    public boolean isSpoiled() {
        // Logic to check if the food is spoiled
        return isRotten;
    }

    public int getNutritionalValue() {
        return nutritionValue;
    }

    public int getSpawnChance() {
        return spawnChance;
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
}

public class Creature {
    private String name;
    private int health;
    private int attackPower;
    private int foodLevel;
    private int waterLevel;
    private double chanceOfDying;

    private World world;
    private List<Food> consumedFoods;

    public Creature(String name, int health, int attackPower, int foodLevel, int waterLevel, World world) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.foodLevel = foodLevel;
        this.waterLevel = waterLevel;
        this.world = world;
        this.consumedFoods = new ArrayList<>();
    }

    public List<String> assignNamesFromFile(String fileName) {

    }

    public void die() {

    }

    public void reproduce() {

    }

    public void drink(Water water) {
        setWaterLevel(getWaterLevel() + water.getHydrationValue());
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getFoodLevel() {
        return this.foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public int getWaterLevel() {
        return this.waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public double getChanceOfDying() {
        return this.chanceOfDying;
    }

    public void setDefensePower(int defensePower) {
    }

    public int getDefensePower() {
    }

    public void eat(Food food) {
        if (world.getFoods().contains(food) && !food.isSpoiled()) {
            food.addCreature(this);
            consumedFoods.add(food);
            setFoodLevel(getFoodLevel() + food.getNutritionalValue());
        }
    }

    public class Water {
        private int hydrationValue;

        public Water(int hydrationValue) {
            this.hydrationValue = hydrationValue;
        }

        public int getHydrationValue() {
            return hydrationValue;
        }

        public void setHydrationValue(int hydrationValue) {
            this.hydrationValue = hydrationValue;
        }
    }

    public List<Food> getConsumedFoods() {
        return consumedFoods;
    }
}