var currentPage = 0;

$(document).ready(function(){

    getPerson(currentPage);


    $("#btnNext").click(function(e){
        e.preventDefault();

        currentPage++;
        getPerson(currentPage);
    })

})

function getPerson(pageNumber){

    $.ajax({
        type: "GET",
        url: "/rest/compares/" + pageNumber,
        cache: true,
        success: function (data) {


            $('#userTitle').empty()
            $('#userTitle').append(data.userFirstName + " " + data.userLastName);

            $('#professionTitle').empty()
            $('#professionTitle').append(data.userProfession);

            $('#descText').empty()
            $('#descText').append(data.userAbout);

            $("#userTitle").attr("href",  "/profile/" + data.userId);

            $("#btnOpen").click(function(e){
                e.preventDefault();
                window.open("/profile/" + data.userId);
            });

            $("#img").attr("src", data.userPhotoUrl);

            //descText
        },
        error: function (e) {
            alert("Error Loading cities");
        }

    });
}