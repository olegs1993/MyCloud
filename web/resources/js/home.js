/**
 * Created by Oleg on 04.03.2017.
 */
$(document).ready(function () {
    
    $(".fpopup").magnificPopup();

});

jQuery("#firstform").on('click',function(e) {
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
            alert(result)
            $.magnificPopup.close();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
    return false;});