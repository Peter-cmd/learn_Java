$(function() {
    $("#login_form").submit(function () {
        $.ajax( {
            //url: "../data/login.json",
            url: "../data/login2.json",
            type: "get",
            async: true,
            data: $("#login_form").serialize(),
            //dataType: "x-www-form-urlencoded",
            contentType: "json",
            success: function(resp) {
                //若 success=true, 跳转到 main.html
                // 若 success=false, 打印code和message
                if (resp.success) {
                    window.location.href = "main.html";
                }else {
                    alert(resp.code + " " + resp.message);
                }
                //alert(JSON.stringify(resp));
            },
            error: function (req, textStatus, err) {
                alert(req.status);
            }
        });
        return false;
    })
});