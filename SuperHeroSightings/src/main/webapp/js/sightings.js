
var sighting;
$(document).ready(function () {
    $('#errorMessages').empty();

});
function searchSighings()
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
        url: 'locations/locations',
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
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').hide();
    $('#searchCriteria').hide();
    retrieveSuperHeros();
    retrieveLocations();
    $('#addEditFormDiv').show();
}

function saveSighting()
{
    if (isFinite(sighting))
    {
        alert('update sighting');
        //updare mode

    } else {
        //add mode
        var superheros = $('#ae-sighting-super-heros').val();
        alert('add sighting');
        $.ajax({
            type: 'POST',
            url: 'sighting/sighting',
            cache: false,
            data: JSON.stringify({
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

    }
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
        content += '<a href="" onClick="editSighting(' + sighting + ');">Edit</a>';
        content += '</td>';
        content += '<td>';
        //content += '<a href="" onClick="confirmDeleteSighting(' + sighting.sightingId + ');">Delete</a>';
        content += '<button onclick="confirmDeleteSighting(' +sighting.sightingId + ')">Delete</button>'
        content += '</td>';
        content += '</tr>';
    });

    $('#sightingsListing').append(content);
}

function editSighting(sighting)
{
    $('#searchLocationForm').hide();
    $('#searchSuperHeroForm').hide();
    $('#sightingDisplayDiv').hide();
    $('#addEditFormDiv').show();

    $('#ae-sighting-location').val() = sighting.location.name;
    //$('#ae-sighting-super-heros').val() = superheros.toString();
    var d = new Date();
    d.setFullYear(sighting.dateSighted.year, sighting.dateSighted.monthValue, sighting.dateSighted.dayOfMonth)
            $('#ae-sighting-date').val() = d;
}

var sightingForDelete;
function confirmDeleteSighting(sightingId)
{
    sightingForDelete = sightingId;
    alert(sightingForDelete);
    console.log(sightingForDelete);
    $('#confirmSightingDelete').show();
}

function deleteSighting()
{
    $('#confirmSightingDelete').hide();
    $.ajax({
        type: 'DELETE',
        url: 'sighting/sighting/' + sightingForDelete,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response) {
            alert("success");
            showSightings();
        },
        error: function (response) {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
function hideAddEditForm()
{
    $('#addEditFormDiv').hide();
//        s$('#sightingDisplayDiv').hide();
    $('#searchCriteria').show();
}