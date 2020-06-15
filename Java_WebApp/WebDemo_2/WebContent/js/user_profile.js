//The page loads firs time
$(document).ready(function(){
    var action_type = "first_load";
    ajaxCallShowInfo(action_type);
});

/*
$(document).ready(function(){
    $('#user_registration').click(function(){
        var action_type = "user_registration";
        ajaxCallReg(action_type);
    });
});
*/

function ajaxCallShowInfo(action_type)
{
    $.ajax({
        type: 'POST',
        url: 'UserProfile',
        data: {
            action_name: action_type
        },
        dataType: 'text',
        success: function(result){
            showSuccess(result);
        }
    });
}

function showSuccess(result)
{
    
    $(".recipes_container").html('');
    $(".recipes_container").append(result);
    
}