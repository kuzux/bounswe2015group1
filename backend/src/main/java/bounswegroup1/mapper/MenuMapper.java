package bounswegroup1.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import bounswegroup1.model.Menu;

public class MenuMapper implements ResultSetMapper<Menu> {
    private Menu result;

    @Override
    public Menu map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
        if(result == null){
            List<Long> recipeIds = new ArrayList<Long>();
            List<String> recipeNames = new ArrayList<String>();
            result = new Menu(rs.getLong("id"), rs.getString("name"), rs.getLong("user_id"), recipeIds, rs.getDate("created_at"));
            result.setDescription(rs.getString("description"));
            result.setPeriod(rs.getString("period"));
            result.setRecipeNames(recipeNames);
        }
        
        result.addRecipe(rs.getLong("recipe_id"));
        result.addRecipeName(rs.getString("recipe_name"));
        return result;
    }
    

}
