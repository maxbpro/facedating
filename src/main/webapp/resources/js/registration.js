


$(document).ready(function(){

    var date_input=$('input[name="birthdate"]');
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);

    $("#countryId").on("change", function (event) {

        var countryId = $("#countryId").val();

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/user/regions?countryId=" + countryId,
            cache: true,
            success: function (data) {

                $("#regionBlock").fadeIn();

                $('#regionId').empty()

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
            url: "http://localhost:8080/user/cities?countryId=" + countryId + "&regionId=" + regionId,
            cache: true,
            success: function (data) {

                $("#cityBlock").fadeIn();

                $('#cityId').empty()

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


})