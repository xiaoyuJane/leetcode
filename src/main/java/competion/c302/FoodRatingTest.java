package competion.c302;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 6126. 设计食物评分系统
 */
public class FoodRatingTest {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FoodRatings{

        FoodRating[] foodRatings;
        HashMap<String,FoodRating> foodRate; //食物及其评分
        HashMap<String, LinkedList<FoodRating>> HighRate; //烹饪方式和食物

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodRatings = new FoodRating[foods.length];
            HashMap<String,FoodRating> foodRate = new HashMap<>();
            HashMap<String, LinkedList<FoodRating>> HighRate = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                //1.初始化对象
                foodRatings[i] = new FoodRating(foods[i],cuisines[i],ratings[i]);
                //2。维护食物和评分映射表，food唯一
                foodRate.put(foods[i],foodRatings[i]);

                //3. 维护烹饪方式最高表
                if (HighRate.containsKey(cuisines[i])){
                    LinkedList<FoodRating> f = HighRate.get(cuisines[i]);
                    f.add(foodRatings[i]);
//                    Arrays.sort(f.toArray());
//                    HighRate.put(cuisines[i], f);

                }else {
                    LinkedList<FoodRating> f = new LinkedList<>();
                    f.add(foodRatings[i]);
                    HighRate.put(cuisines[i], f);
                }
            }
        }



        public void changeRating(String food, int newRating) {
            FoodRating foodRating = foodRate.get(food);
            foodRating.rating = newRating;
            String cus = foodRating.cuisines;
//            Arrays.sort(HighRate.get(cus).toArray());


        }
        public String highestRated(String cuisine) {
            FoodRating[] array = (FoodRating[]) HighRate.get(cuisine).toArray();
            Arrays.sort(array);
            return array[0].food;
        }



        class FoodRating implements Comparable<FoodRating>{
            public String food;
            public String cuisines;
            public int rating;

            public FoodRating( String food, String cuisines,int rating) {
                this.rating = rating;
                this.food = food;
                this.cuisines = cuisines;
            }

            public FoodRating() {
            }

            @Override
            public int compareTo(FoodRating o) {
                if (rating == o.rating){
                    return food.compareTo(o.food);
                }else return o.rating-rating;
            }
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
