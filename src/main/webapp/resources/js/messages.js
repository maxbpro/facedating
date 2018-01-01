
$(document).ready(function(){


    // $('#btnLike').click(function(e){
    //     e.preventDefault();
    //
    //     var likedId = $('#btnLike').attr('chatId');
    //     console.log(chatId);
    //     showMessages(chatId);
    //
    // });

    //showMessages();

})



function showMessages(chatId) {

    var pageNumber = 0;

    $.ajax({
        type: "GET",
        url: "/messages/" + chatId + "/" + pageNumber,
        success: function (data) {

            $('#btnLike').attr('liked', true);
            $('#btnLike').attr('likedId', data.id);
            updateLikedStatus();
        },
        error: function (e) {
            $('#btnLike').attr('liked', false);
            updateLikedStatus();
        }

    });
}
