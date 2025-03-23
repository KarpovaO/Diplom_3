package Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PojoIngredients {
    public static List<String> ingredients;
    public static void setData()
    {
        System.out.println(ingredients);
    }
}
