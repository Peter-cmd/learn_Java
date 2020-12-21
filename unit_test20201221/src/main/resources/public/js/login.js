$(function() {
    $("#login_form").submit(function () {
        $.ajax( {
            url: "data/login.json",
            type: "get",
            async: true,
            data: $("#login_form").serialize(),
            //dataType: "x-www-form-urlencoded",
            contentType: "json",
            success: function(resp) {
                console.log(resp);
                alert(JSON.stringify(resp));
            }
        })
        return false;
    })
})