var currentPage = 0;

$(document).ready(function(){

    var slider = document.getElementById('slider');

    noUiSlider.create(slider, {
        start: [ 20, 40 ],
        connect: true, // Display a colored bar between the handles
        step: 1,
        tooltips: true,
        format: wNumb({
            decimals: 0
        }),
        range: {
            'min': 10,
            'max': 99
        },

    });

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