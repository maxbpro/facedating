

var currentPage = 0;

$(document).ready(function(){

    getLikes(currentPage);

    $('#btnDislike1').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike1').data('likeId');
        deleteLike(likeId, '#btnDislike1', '#item1');
    });

    $('#btnDislike2').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike2').data('likeId');
        deleteLike(likeId, '#btnDislike2', '#item2');
    });

    $('#btnDislike3').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike3').data('likeId');
        deleteLike(likeId, '#btnDislike3', '#item3');
    });

    $('#btnDislike4').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike4').data('likeId');
        deleteLike(likeId, '#btnDislike4', '#item4');
    });

    $('#btnDislike5').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike5').data('likeId');
        deleteLike(likeId, '#btnDislike5', '#item5');
    });

    $('#btnDislike6').click(function(e){
        e.preventDefault();

        var likeId = $('#btnDislike6').data('likeId');
        deleteLike(likeId, '#btnDislike6', '#item6');
    });

    $('#item1').addClass("hidden");
    $('#item2').addClass("hidden");
    $('#item3').addClass("hidden");
    $('#item4').addClass("hidden");
    $('#item5').addClass("hidden");
    $('#item6').addClass("hidden");
})

function deleteLike(id, element, container){

    $.ajax({
        type: "DELETE",
        url: "/rest/likes/" + id,
        success: function (data) {
            getLikes(currentPage);
        },
        error: function (e) {
            // $(element).removeClass();
            // $(element).addClass("btn-sm btn-danger");
        }

    });
}

function getLikes(pageNumber){

    $.ajax({
        type: "GET",
        url: "/rest/likes/" + pageNumber,
        cache: true,
        success: function (data) {

            // $.each(data, function(key, item) {
            //     $('#userTitle1')
            //         .empty()
            //             .text(item.firstName)
            // );


            if(data.length > 0){

                $('#userTitle1').empty()
                $('#userTitle1').append(data[0].userFirstName + " " + data[0].userLastName);
                $("#userTitle1").attr("href",  "/profile/" + data[0].userId);
                $('#btnDislike1').data('likeId', data[0].id);

                $('#aboutTitle1').empty()
                $('#aboutTitle1').append(data[0].userAbout);

                $("#img1").attr("src", data[0].userPhotoUrl);

                $('#item1').removeClass("hidden");
            }else{
                $('#item1').addClass("hidden");
            }

            if(data.length > 1){

                $('#userTitle2').empty()
                $('#userTitle2').append(data[1].userFirstName + " " + data[1].userLastName);
                $("#userTitle2").attr("href",  "/profile/" + data[1].userId);
                $('#btnDislike2').data('likeId', data[1].id);

                $('#aboutTitle2').empty()
                $('#aboutTitle2').append(data[1].userAbout);

                $("#img2").attr("src", data[1].userPhotoUrl);
                $('#item2').removeClass("hidden");
            }else{
                $('#item2').addClass("hidden");
            }


            if(data.length > 2){

                $('#userTitle3').empty()
                $('#userTitle3').append(data[2].userFirstName + " " + data[2].userLastName);
                $("#userTitle3").attr("href",  "/profile/" + data[2].userId);
                $('#btnDislike3').data('likeId', data[2].id);

                $('#aboutTitle3').empty()
                $('#aboutTitle3').append(data[2].userAbout);

                $("#img3").attr("src", data[2].userPhotoUrl);
                $('#item3').removeClass("hidden");
            }else{
                $('#item3').addClass("hidden");
            }

            if(data.length > 3){

                $('#userTitle4').empty()
                $('#userTitle4').append(data[3].userFirstName + " " + data[3].userLastName);
                $("#userTitle4").attr("href",  "/profile/" + data[3].userId);
                $('#btnDislike4').data('likeId', data[3].id);

                $('#aboutTitle4').empty()
                $('#aboutTitle4').append(data[3].userAbout);

                $("#img4").attr("src", data[3].userPhotoUrl);
                $('#item4').removeClass("hidden");
            }else{
                $('#item4').addClass("hidden");
            }


            if(data.length > 4){

                $('#userTitle5').empty()
                $('#userTitle5').append(data[4].userFirstName + " " + data[4].userLastName);
                $("#userTitle5").attr("href",  "/profile/" + data[4].userId);
                $('#btnDislike5').data('likeId', data[4].id);

                $('#aboutTitle5').empty()
                $('#aboutTitle5').append(data[4].userAbout);

                $("#img5").attr("src", data[4].userPhotoUrl);
                $('#item5').removeClass("hidden");
            }else{
                $('#item5').addClass("hidden");
            }


            if(data.length > 5){

                $('#userTitle6').empty()
                $('#userTitle6').append(data[5].userFirstName + " " + data[5].userLastName);
                $("#userTitle6").attr("href",  "/profile/" + data[5].userId);
                $('#btnDislike6').data('likeId', data[5].id);

                $('#aboutTitle6').empty()
                $('#aboutTitle6').append(data[6].userAbout);

                $("#img6").attr("src", data[5].userPhotoUrl);
                $('#item6').removeClass("hidden");
            }else{
                $('#item6').addClass("hidden");
            }


        },
        error: function (e) {
            alert("Error Loading cities");
        }

    });
}