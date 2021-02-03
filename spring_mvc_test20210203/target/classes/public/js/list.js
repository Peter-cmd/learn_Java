$(function() {
    $("button").click(function() {
        $.ajax({
            url: "../data/library.json",
            type: "head",
            sync: true,
            contentType: "json",
            success: function (resp) {
                    let content = "";
                    for (let i = 0; i < resp.data.length; i++) {
                        content += "<li>";
                        content += resp.data[i].name;
                        content += " 具象化为: "
                        content += resp.data[i].role;
                        content += "</li>";
                    }
                    $("#book_list").html(content);
            }
        })
    })
});