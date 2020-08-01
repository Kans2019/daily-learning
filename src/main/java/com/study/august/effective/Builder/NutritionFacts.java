package com.study.august.effective.Builder;

import javafx.util.Builder;

/**
 * @description: NutritionFacts
 * @date: 2020/8/2
 * @author: likanghai
 */
public class NutritionFacts implements Builder<NutritionFacts> {

    private final int servingSize;

    private final int servings;

    private final int calories;

    private final int fat;

    private final int sodium;

    private final int carbohydrate;

    @Override
    public NutritionFacts build() {
        return null;
    }

    public static class Builder implements javafx.util.Builder<NutritionFacts> {

        private final int servingSize;

        private final int servings;

        private int calories = 0;

        private  int carbohydrate = 0;

        private int fat = 0;

        private int sodium = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }

        public Builder fat(int val){
            this.fat = val;
            return this;
        }

        public Builder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }

        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }

        @Override
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }


    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        carbohydrate = builder.carbohydrate;
        fat = builder.fat;
        sodium = builder.sodium;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new Builder(1,2).calories(1).build();
    }


}
