/**
 * Created by Oleg on 04.03.2017.
 */
$(document).ready(function () {
  $(".fpopups").magnificPopup();
  $(".fpopup").magnificPopup();
$(document).on('click','.clickers',function(e) {
     var foldername=$(this).text();
     var link=window.location.pathname+"/"+foldername.trim();
     history.pushState(null, null, link);
     $.ajax({
         url: link+"/test",
         type:"GET",
     success: function(result) {
     $('#list').empty();
     for(var i=0;i<result.foldersList.length;i++){
     $('#list').append("<a href='' class='clickers'>" +
     "<img src='/resources/img/folder.png'/>"
     +result.foldersList[i].name+"" +
     "</a></br>");
     }
         for(var i=0;i<result.filesList.length;i++){
             $('#list').append("<a href="+"'"+link+"/"+result.filesList[i].name.trim()+"/download"+"'"+ "class='fileclick'>" +
                 "<img src='/resources/img/file.png'/>"
                 +result.filesList[i].name.trim()+"" +
                 "</a></br>");
         }
     },
     error: function(jqXHR, textStatus, errorThrown) {
     alert(jqXHR.status + ' ' + jqXHR.responseText);
     }
     });
    return false;
});
$(document).on('click',"#firstform",function(e) {
    var form = $('#form'); // You need to use standart javascript object here
    var file = $('#file_v').get(0).files[0];
    var formData = new FormData(form);
    formData.append('file',file);
    $.ajax({
        url: window.location.pathname+"/addfile",
        type: "POST",
        cache:false,
        contentType: false,
        processData: false,
        data: formData,
        success: function(result) {
            alert("Success");
            $.magnificPopup.close();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
    return false;});
$(window).on('popstate',function(e) {
    $.ajax({
        url: window.location.pathname+ "/test",
        type: "GET",
        success: function(result) {
            $('#list').empty();
            for(var i=0;i<result.foldersList.length;i++){
                $('#list').append("<a href='' class='clickers'>" +
                    "<img src='/resources/img/folder.png'/>"
                    +result.foldersList[i].name+"" +
                    "</a></br>");
            }
            for(var i=0;i<result.filesList.length;i++){
                $('#list').append("<a href="+"'"+window.location.pathname+"/"+result.filesList[i].name.trim()+"/download"+"'"+ "class='fileclick'>" +
                    "<img src='/resources/img/file.png'/>"
                    +result.filesList[i].name.trim()+"" + "</a></br>");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
return false;
});
jQuery(document).on('click',"#folderform",function(e) {
    var file = $("#foldername").serialize();
    $.ajax({
        url: window.location.pathname+"/addfolder",
        type: "POST",
        data: file,
        success: function(result) {
            $('#list').empty();
            for(var i=0;i<result.foldersList.length;i++){
                $('#list').append("<a href='' class='clickers'>" +
                    "<img src='/resources/img/folder.png'/>"
                    +result.foldersList[i].name+"" +
                    "</a></br>");
            }
            for(var i=0;i<result.filesList.length;i++){
                $('#list').append("<a href="+"'"+window.location.pathname+"/"+result.filesList[i].name.trim()+"/download"+"'"+ "class='fileclick'>" +
                    "<img src='/resources/img/file.png'/>"
                    +result.filesList[i].name.trim()+"" + "</a></br>");
            }
            alert("Success");
            $.magnificPopup.close();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
    return false;});
});