


$(document).ready(function(){


    $("#phoneNumber").mask("(999) 999-9999", {placeholder:"(XXX) XXX-XXXX"});
    $("#birthdate").mask("99-99-9999", {placeholder:"DD-MM-YYYY"});

    $("#countryId").on("change", function (event) {

        var countryId = $("#countryId").val();

        $.ajax({
            type: "GET",
            url: "/user/regions?countryId=" + countryId,
            cache: true,
            success: function (data) {

                $("#regionBlock").fadeIn();

                $('#regionId').empty();

                $('#regionId')
                    .append($("<option></option>")
                        .attr("value",0)
                        .text("---select---"));

                $.each(data, function(key, item) {
                    $('#regionId')
                        .append($("<option></option>")
                            .attr("value",item.id)
                            .text(item.title));
                });



            },
            error: function (e) {
                alert("Error Loading cities");
            }

        });

    });

    $("#regionId").on("change", function (event) {

        var countryId = $("#countryId").val();
        var regionId = $("#regionId").val();

        $.ajax({
            type: "GET",
            url: "/user/cities?countryId=" + countryId + "&regionId=" + regionId,
            cache: true,
            success: function (data) {

                $("#cityBlock").fadeIn();

                $('#cityId').empty();

                $('#cityId')
                    .append($("<option></option>")
                        .attr("value",0)
                        .text("---select---"));

                $.each(data, function(key, item) {
                    $('#cityId')
                        .append($("<option></option>")
                            .attr("value",item.id)
                            .text(item.title));
                });



            },
            error: function (e) {
                alert("Error Loading cities");
            }

        });

    });


    $("#inputFile").on('change', function() {
        readURL(this);
    });

    function readURL(input) {

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $('#img').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }
})
