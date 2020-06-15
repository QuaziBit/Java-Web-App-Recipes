//The page loads firs time
$(document).ready(function(){
    var action_type = "first_load";

    ajaxCallRecipesList(action_type);

    ajaxCallRecipesNum("page_num");
});

$(document).ready(function(){
    $('#next_recipes').click(function(){
        var action_type = "next_recipes";
        ajaxCallRecipesList(action_type);
    });
    $('#last_recipes').click(function(){
        var action_type = "last_recipes";
        ajaxCallRecipesList(action_type);
    });
});

function ajaxCallRecipesNum(action_type)
{
    $.ajax({
        type: 'GET',
        url: 'UserRecipes',
        data: {
            action_name: action_type
        },
        success: function(result){
            appentRecipesNum(result);
        }
    });
}

function ajaxCallRecipesList(action_type)
{
    $.ajax({
        type: 'GET',
        url: 'UserRecipes',
        data: {
            action_name: action_type
        },
        success: function(result){
            appendHTMLOutput(result);
        }
    });
}

function appentRecipesNum(result)
{
    $('#num_pages').html('');
    $('#num_pages').append(result);
}

function appendHTMLOutput(result)
{
    if(result.length > 100)
    {
        $('#recipes').html('');
        $('#recipes').append(result);
    }
    else
    {
        alert("result is empty");
    }

    ajaxCallRecipesNum("page_num");
}