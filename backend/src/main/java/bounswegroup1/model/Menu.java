package bounswegroup1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import bounswegroup1.db.MenuDAO;


public class Menu {
    private Long id;
    private String name;
    private Long userId;
    private List<Long> recipeIds;
    private Date createdAt;
    private String period;
    private List<String> recipeNames;
    private String description;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Menu(Long id, String name, Long userId, List<Long> recipeIds, Date createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.recipeIds = recipeIds;
        this.createdAt = createdAt;
    }

    public Menu(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getRecipeIds() {
        return recipeIds;
    }

    public void setRecipeIds(List<Long> recipeIds) {
        this.recipeIds = recipeIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPeriod(){
        return period;
    }

    public void setPeriod(String period){
        this.period = period;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<String> getRecipeNames(){
        return recipeNames;
    }

    public void setRecipeNames(List<String> recipeNames){
        this.recipeNames = recipeNames;
    }

    public void addRecipe(Long id){
        recipeIds.add(id);
    }

    public void addRecipeName(String recipeName){
        recipeNames.add(recipeName);
    }

    public void createRecipes(MenuDAO dao){
        for (Long recipe : recipeIds) {
            dao.createRecipe(recipe, id);
        }
    }
}
