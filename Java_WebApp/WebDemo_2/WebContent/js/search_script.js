//The page loads firs time
$(document).ready(function(){
    var action_type = "first_load";
    $("#entered_val").val(null);
    ajaxCallRecipesList(action_type, null);

    ajaxCallRecipesNum("page_num");
});

$(document).ready(function(){

    $('#search_recipe').click(function(){
        
        var action_type = "search_recipe";
        var val = $("#entered_val").val();
        $("#entered_val").val(null);
        ajaxCallRecipesList(action_type, val);
    });
    $('#next_recipes').click(function(){

        var action_type = "next_recipes";
        ajaxCallRecipesList(action_type, null);
    });
    $('#last_recipes').click(function(){

        var action_type = "last_recipes";
        ajaxCallRecipesList(action_type, null);
    });

});

function ajaxCallRecipesNum(action_type)
{
    $.ajax({
        type: 'GET',
        url: 'SearchServlet',
        data: {
            action_name: action_type
        },
        success: function(result){
            appentRecipesNum(result);
        }
    });
}

function ajaxCallRecipesList(action_type, val)
{
    $.ajax({
        type: 'GET',
        url: 'SearchServlet',
        data: {
            action_name: action_type,
            entered_val: val
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