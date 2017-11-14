
var sighting;
$(document).ready(function () {
    $('#errorMessages').empty();

});
function searchSightings()
{
    var criteria = $('#searchSighting').val();
    if (criteria == 1)
    {
        retrieveAllSightings();

    } else if (criteria == 2)
    {
//        Search by super hero
        $('#sightingDisplayDiv').hide();
        $('#searchLocationForm').hide();
        $('#searchSuperHeroForm').show();
        retrieveSuperHeros();
    } else
    {
//        Search By location and date
        $('#sightingDisplayDiv').hide();
        $('#searchSuperHeroForm').hide();
        $('#searchLocationForm').show();
        retrieveLocations();
    }
}

function retrieveLocations()
{
    $('#errorMessages').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'locations/all',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, location) {
                content += '<option value=' + location.locationId + '>' + location.name + '</option>';
            });
            $('#search-location').append(content);
            $('#ae-sighting-location').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function retrieveSuperHeros()
{
    $('#errorMessages').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'superhero/heros',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, hero) {
                content += '<option value=' + hero.superHeroId + '>' + hero.superName + '</option>';
            });
            $('#search-superhero').append(content);
            $('#ae-sighting-super-heros').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createSighting()
{
    $('#errorMessages').empty();
    $('#sightingDisplayDiv').hide();
    $('#searchSuperHeroForm').hide();
    $('#searchLocationForm').hide();
    $('#searchCriteria').hide();
    $('#addEditFormDiv').show();
    
    $('#ae-sighting-super-heros').empty();
    $('#ae-sighting-location').empty();
    $('#ae-sighting-date').val('');
    $('#ae-sighting-image').val('');
    retrieveSuperHeros();
    retrieveLocations();
}

function saveSighting()
{
        var superheros = $('#ae-sighting-super-heros').val();
        $.ajax({
            type: 'POST',
            url: 'sighting/sighting',
            cache: false,
            data: JSON.stringify({
                sightingId: $('#ae-sighting-id').val(),
                location: $('#ae-sighting-location').val(),
                superHeros: superheros.toString(),
                dateSighted: $('#ae-sighting-date').val(),
                image: $('#ae-sighting-image').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                retrieveAllSightings();
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text('Error calling web service.  Please try again later.'));
            }
        });
    //}
}

function searchByLocationAndDate()
{
    $('#errorMessages').empty();
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').show();

    $.ajax({
        type: 'GET',
        url: 'sighting/search/location?location=' + $('#search-location').val() + '&date=' + $('#search-date').val(),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            showSightings(data);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
function searchBySuperHero()
{
    $('#errorMessages').empty();
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').show();

    $.ajax({
        type: 'GET',
        url: 'sighting/search/superhero/' + $('#search-superhero').val(),
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            showSightings(data);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
function retrieveAllSightings()
{
    $('#errorMessages').empty();
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').show();
    $('#addEditFormDiv').hide();

    $.ajax({
        type: 'GET',
        url: 'sighting/search',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            showSightings(data);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function showSightings(data)
{
    $('#sightingsListing').empty();

    var content;

    $.each(data, function (index, sighting) {
        content += '<tr>';
        //content += '<td hidden>' + sighting.sightingId + '</td>';
        content += '<td>' + sighting.location.name + '</td>';
        content += '<td>' + sighting.dateSighted.dayOfMonth + ' ' + sighting.dateSighted.month + ', ' + sighting.dateSighted.year + '</td>';
        content += '<td>';
        $.each(sighting.superHero, function (index, hero) {
            content += hero.superName;
            if (index !== (sighting.superHero.length - 1))
            {
                content += " , ";
            }
        });
        content += '</td>';
        content += '<td>';
        content += '<a title="Open image" href="' + sighting.image + '"><span class="glyphicon glyphicon-picture"></span></a>';
        content += '</td>';
        content += '<td>';
        content += '<button title="Edit" onClick="editSighting(' + sighting.sightingId + ')"><span class="glyphicon glyphicon-edit"></button>';
        content += '</td>';
        content += '<td>';
        content += '<button title="Delete" onclick="confirmDeleteSighting(' + sighting.sightingId + ')"><span class="glyphicon glyphicon-remove"></span></button>'
        content += '</td>';
        content += '</tr>';
    });

    $('#sightingsListing').append(content);
    initMap(data);
}

function editSighting(sightingId)
{
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').hide();
    $('#addEditFormDiv').show();

    $.ajax({
        type: 'GET',
        url: 'sighting/' + sightingId,
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (sighting) {
            $('#ae-sighting-id').val(sighting.sightingId);
            loadLocationForEdit(sighting);
            loadSuperHeroForEdit(sighting);
            //var d = new Date();
            var date =  sighting.dateSighted.year + '-' + sighting.dateSighted.monthValue + '-' + sighting.dateSighted.dayOfMonth;
            $('#ae-sighting-date').val(date);
            $('#ae-sighting-image').val(sighting.image);

        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });

}
function loadLocationForEdit(sighting)
{
    var content;
    $.ajax({
        type: 'GET',
        url: 'locations/all',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, location) {
                if (sighting.location.locationId == location.locationId)
                {
                    content += '<option selected value=' + location.locationId + '>' + location.name + '</option>';
                } else
                {
                    content += '<option value=' + location.locationId + '>' + location.name + '</option>';
                }
            });
            $('#ae-sighting-location').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });

}

function loadSuperHeroForEdit(sighting)
{
    var content;
    $.ajax({
        type: 'GET',
        url: 'superhero/heros',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            var heros = [];
            $.each(sighting.superHero, function (index, hero) {
                heros.push(hero.superHeroId);
            });
            $.each(data, function (index, superhero) {
                if ($.inArray(superhero.superHeroId, heros) != -1)
                {
                    content += '<option selected value=' + superhero.superHeroId + '>' + superhero.superName + '</option>';
                } else
                {
                    content += '<option value=' + superhero.superHeroId + '>' + superhero.superName + '</option>';
                }
            });
            $('#ae-sighting-super-heros').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
var sightingForDelete;
function confirmDeleteSighting(sightingId)
{
    sightingForDelete = sightingId;
    $('#confirmSightingDelete').show();
}

function deleteSighting()
{
    $('#confirmSightingDelete').hide();
    $.ajax({
        type: 'DELETE',
        url: 'sighting/' + sightingForDelete,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function () {
            window.location.reload();
        },
        error: function (response) {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function cancelDelete()
{
    $('#confirmSightingDelete').hide();
}

function hideAddEditForm()
{
    $('#addEditFormDiv').hide();
    $('#searchCriteria').show();
}

var map;
function initMap(data)
{
    var myLatlng = new google.maps.LatLng(data[0].location.address.latitude, data[0].location.address.longitude);
    var myOptions = {
        zoom: 4,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map"), myOptions);

    $.each(data, function (index, sighting) {
        var myLatlng = new google.maps.LatLng(sighting.location.address.latitude, sighting.location.address.longitude);
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title: sighting.location.name
        });
    });
}
google.maps.event.addDomListener(window, 'load', initialize);