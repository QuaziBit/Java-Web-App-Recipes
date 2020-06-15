//The page loads firs time
$(document).ready(function(){
    /*
    var action_type = "first_load";

    ajaxCallRecipesList(action_type);

    ajaxCallRecipesNum("page_num");
    */
});

$(document).ready(function(){
    $('#login').click(function(){
        var action_type = "user_login";
        ajaxCallLogin(action_type);
    });
});

function ajaxCallLogin(action_type)
{
    var user_name = "";
    var user_password = "";
    var user_email = "";

    if($("#user_name").val().length >= 1)
    {
        user_name = $("#user_name").val();
    }
    if($("#user_password").val().length >= 1)
    {
        user_password = $("#user_password").val();
    }
    if($("#user_email").val().length >= 1)
    {
        user_email = $("#user_email").val();
    }

    $.ajax({
        type: 'POST',
        url: 'LoginServlet',
        data: {
            action_name: action_type,
            user_name: user_name,
            user_password: user_password,
            user_email: user_email
        },
        dataType: 'text',
        success: function(result){

            if(result.length < 40)
            {
                var URL = result;
                window.location.href = URL;
            }
            else
            {
                showSuccess(result);
            }
        }
    });
}

function showSuccess(result)
{
    $(".message_container").html('');
    $(".message_container").append(result);
}