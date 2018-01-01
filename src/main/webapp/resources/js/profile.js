
$(document).ready(function(){


    // $('#btnLike').click(function(e){
    //     e.preventDefault();
    //
    //     var isLiked = $('#btnLike').attr('liked');
    //     console.log(isLiked);
    //
    //     if(isLiked == true){
    //         var likedId = $('#btnLike').attr('likedId');
    //         deleteLike(likedId);
    //     }else{
    //         var userId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);
    //         addLike(userId);
    //     }
    //
    // });



})



function updateLikedStatus() {

    var isLiked = $('#btnLike').attr('liked');

    if(isLiked == true){
        $('#btnLike').removeClass();
        $('#btnLike').addClass("btn btn-danger btn-sm");
    }else{
        $('#btnLike').removeClass();
        $('#btnLike').addClass("btn btn-success btn-sm");
    }
}

function addLike(otherUserId) {

    $.ajax({
        type: "POST",
        url: "/rest/likes/",
        data: {
            "otherUserId": otherUserId
        },
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

function deleteLike(likeId){

    $.ajax({
        type: "DELETE",
        url: "/rest/likes/" + likeId,
        success: function (data) {
            $('#btnLike').attr('liked', false);
            updateLikedStatus();
        },
        error: function (e) {
            $('#btnLike').attr('liked', true);
            updateLikedStatus();
        }

    });
}