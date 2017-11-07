$(document).ready(function () {
    $('#errorMessages').empty();

    retrievelocations();
});

function retrievelocations()
{
    $('#errorMessages').empty();
    //$('#locationsTable').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'locations/locations',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, location) {
                content += '<tr>';
                content += '<td>' + location.name + '</td>';
                content += '<td>' + location.description + '</td>';
                content += '<td>' + location.address.street + '<br>' + location.address.city + '<br>' + location.address.state + '<br>' + location.address.country + '</td>';
                content += '<td>';
                content += '<a href="#" onClick="editlocation(' + location + ');">Edit</a>';
                content += '</td>';
                content += '<td>';
                content += '<a href="#" onClick="deletelocation(' + location + ');">Delete</a>';
                content += '</td>';

                content += '</tr>';
            });
            $('#locationsTable').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function saveLocation()
{
    var location = JSON.stringify({
        name: $('#add-location').val(),
        description: $('#add-description').val(),
        street: $('#add-address-street').val(),
        city: $('#add-address-city').val(),
        state: $('#add-address-state').val(),
        country: $('#add-address-country').val(),
        postalCode: $('#add-address-postal').val(),
        latitude: $('#add-address-latitude').val(),
        longitude: $('#add-address-longitude').val()
    });
    $.ajax({
        type: 'PUT',
        url: 'locations/location',
        data: location,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {

            window.location.reload();

        },
        error: function () {
            alert("error");
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });

}