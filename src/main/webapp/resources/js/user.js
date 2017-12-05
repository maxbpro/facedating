


$(document).ready(function(){


    $("#phoneNumber").mask("(999) 999-9999", {placeholder:"(XXX) XXX-XXXX"});

    var date_input=$('input[name="birthdate"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);

    date_input.css('cursor','pointer');

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
