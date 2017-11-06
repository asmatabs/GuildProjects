

$(document).ready(function () {
    $('#errorMessages').empty();

});
function searchSighings()
{
    var criteria = $('#searchSighting').val();
    if (criteria == 1)
    {

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
        content += '</tr>';
    });

    $('#sightingsListing').append(content);
}
function hideAddEditForm()
{
    alert(1);
    $('#addEditFormDiv').hide();
//        s$('#sightingDisplayDiv').hide();
        $('#searchCriteria').show();
}