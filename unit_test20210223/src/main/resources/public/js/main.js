$(function() {
   $.ajax({
       url: "../data/login2.json",
       type: "get",
       contentType: "json",
       success: function(resp) {
           let content = "";
           if (resp.success) {
               for (let i = 0; i < resp.data.length; i++) {
                   content += "<li>";
                   content += resp.data[i].name;
                   content += "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button>";
                   content += "删除";
                   content += "</button>";
                   content += "</li>";

               }
               $("#book_list").html(content);
           }else {
               alert("状态码:" + resp.code + " " + "状态描述:" + resp.message);
           }
       }
   });
});