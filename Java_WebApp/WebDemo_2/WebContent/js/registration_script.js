//The page loads firs time
$(document).ready(function(){
    /*
    var action_type = "first_load";

    ajaxCallRecipesList(action_type);

    ajaxCallRecipesNum("page_num");
    */
});

$(document).ready(function(){
    $('#user_registration').click(function(){
        var action_type = "user_registration";
        ajaxCallReg(action_type);
    });
});

function ajaxCallReg(action_type)
{
    var first_name = "";
    var last_name = "";
    var user_name = "";
    var user_password = "";
    var user_email = "";

    if($("#first_name").val().length >= 1)
    {
        first_name = $("#first_name").val();
    }
    if($("#last_name").val().length >= 1)
    {
        last_name = $("#last_name").val();
    }
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
        url: 'RegistrationServlet',
        data: {
            action_name: action_type,
            first_name: first_name,
            last_name: last_name,
            user_name: user_name,
            user_password: user_password,
            user_email: user_email
        },
        dataType: 'text',
        success: function(result){
            showSuccess(result);
        }
    });
}

function showSuccess(result)
{
    $(".login_container").html('');
    $(".login_container").append(result);
}