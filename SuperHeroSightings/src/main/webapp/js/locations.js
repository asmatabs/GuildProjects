$(document).ready(function () {
    $('#errorMessages').empty();

    retrievelocations();
});

function retrievelocations()
{
    $('#errorMessages').empty();
    $('#locationsListing').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'locations/all',
        cache: false,
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
                content += '<td>' + location.address.street + '<br>' 
                        + location.address.city + ', ' 
                        + location.address.state + '<br>' 
                        + location.address.country + ' '
                        + location.address.postalCode + '<br>'
                        + 'Lat: ' + location.address.latitude + '<br>'
                        + 'Long: ' + location.address.longitude + '</td>';
                content += '<td>';
                content += '<button onClick="editlocation( ' + location.locationId + ')">Edit</button>';
                content += '</td>';
                content += '<td>';
                content += '<button onClick="confirmDeleteLocation(' + location.locationId + ')">Delete</button>';
                content += '</td>';

                content += '</tr>';
            });
            $('#locationsListing').append(content);
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
        locationId: $('#add-location_id').val(),
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
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });

}

function editlocation(id)
{
    $.ajax({
        type: 'GET',
        url: 'locations/' + id,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (location) {
            $('#add-location_id').val(location.locationId);
            $('#add-location').val(location.name);
            $('#add-description').val(location.description);
            $('#add-address-street').val(location.address.street);
            $('#add-address-city').val(location.address.city);
            $('#add-address-state').val(location.address.state);
            $('#add-address-country').val(location.address.country);
            $('#add-address-postal').val(location.address.postalCode);
            $('#add-address-latitude').val(location.address.latitude);
            $('#add-address-longitude').val(location.address.longitude);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

var locationForDelete;
function confirmDeleteLocation(locationId)
{
    locationForDelete = locationId;
    $('#confirmlocationDelete').show();
}

function deletelocation()
{
    $('#confirmlocationDelete').hide();
        $.ajax({
        type: 'DELETE',
        url: 'locations/' + locationForDelete,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function () {
            retrievelocations();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function cancelDelete()
{
    $('#confirmlocationDelete').hide();
}

function cancelSave()
{
    $('#add-location_id').val("");
    $('#add-location').val("");
    $('#add-description').val("");
    $('#add-address-street').val("");
    $('#add-address-city').val("");
    $('#add-address-state').val("");
    $('#add-address-country').val("");
    $('#add-address-postal').val("");
    $('#add-address-latitude').val("");
    $('#add-address-longitude').val("");
}