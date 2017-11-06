/* global hero */
var hero;
$(document).ready(function () {
    $('#errorMessages').empty();



    showSuperHeros();
});

function showSuperHeros()
{
    $('#heroDiv').hide();
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
            $('#createHero').show();
            $('#heros-listing').show();
            fillSuperHeros(data);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
function createSuperHero()
{
    $('#createHero').hide();
    $('#heros-listing').hide();
    $('#heroDiv').hide();
    $('#addEditHeroDivTitle').append('<p>Spotted a new super hero lurking around?<p>'
            + '<h2> Add Super Hero</h2>');
    $('#addEditHeroDiv').show();

    //Retrieve Org list 
    retrieveOrgList();

    //Retrieve super power list 
    retrievePowerList();
}

function retrieveOrgList()
{
    $('#superhero-org-div').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'organizations/orgs',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, org) {
                content += '<option value="' + org.orgId + '">' + org.name + '</option>';
            });
            $('#superhero-org-div').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function retrievePowerList()
{
    $('#powerDiv').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'superpowers/powers',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, power) {
                content = '<input type="checkbox" name="' + power.superPowerId + '">  ';
                content += power.power + '</input><br>';
                $('#powerDiv').append(content);
            });
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
function editSuperHero()
{
    $('#createHero').hide();
    $('#heros-listing').hide();
    $('#heroDiv').hide();
    $('#addEditHeroDivTitle').empty();
    $('#addEditHeroDivTitle').append('<p>Want to edit information for super hero?<p>'
            + '<h2> Edit Super Hero</h2>');
    $('#super-hero-name').val(hero.superName);
    $('#super-hero-desc').val(hero.description);
    $('#super-hero-gender').val(hero.gender);
    $('#addEditHeroDiv').show();

    retrieveOrgList();
    retrievePowerList();
    var dataarray = '[';

    $.each(hero.superHeroOrgs, function (index, org) {
        //$('#superhero-org-div').filter('[value=org.orgId').prop('selected', true)
        //dataarray.push(org.orgId); 
        dataarray += '"' + org.orgId + '"';
        if (index !== (hero.superHeroOrgs.length - 1))
        {
            dataarray += ",";
        }
    });
    dataarray += ']';
    alert(dataarray);
    $('#superhero-org-div').val(dataarray);
    // $('#superhero-org-div').multiselect("refresh");

//    $("#orgDiv:checkbox[name=hero.superHeroOrgs[].orgId]").each(function () {
//        alert(2);
//        $(this).prop("checked", "checked");
//    });
//    alert(hero.superHeroOrgs[1].orgId);
//    $('#orgDiv').children('name=hero.superHeroOrgs[].orgId').each(function(){
//        $(this).prop("checked", "checked");
//    });
}
function confirmDeleteSuperHero()
{
    $('#confirmDelete').show();
}
function deleteSuperHero()
{
    $('#confirmDelete').hide();
    $.ajax({
        type: 'DELETE',
        url: 'superhero/hero/' + hero.superHeroId,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response) {
            showSuperHeros();
        },
        error: function (response) {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function saveHero()
{
    if (isFinite(hero))
    {
        $.ajax({
            type: 'PUT',
            url: 'superhero/hero/' + hero.superHeroId,
            cache: false,
            data: JSON.stringify({
                superName: $('#super-hero-name').val(),
                description: $('#super-hero-desc').val(),
                gender: $('#super-hero-gender').val(),
                image: $('#super-hero-image').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                fillSuperHeros(data);
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text('Error calling web service.  Please try again later.'));
            }
        });
    } else
    {
        var orgs = [];
        $('#orgDiv').children("input:checked").map(function () {
            orgs.push(this.name);
        });

        var powers = [];
        $('#powerDiv').children("input:checked").map(function () {
            powers.push(this.name);
        });

        $.ajax({
            type: 'POST',
            url: 'superhero/addhero',
            cache: false,
            data: JSON.stringify({
                superName: $('#super-hero-name').val(),
                description: $('#super-hero-desc').val(),
                gender: $('#super-hero-gender').val(),
                orgs: orgs.toString(),
                powers: powers.toString()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                hideAddForm();
                showSuperHeros();
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

function hideAddForm()
{
    $('#createHero').show();
    $('#heros-listing').show();
    $('#addEditHeroDiv').hide();
}

function fillSuperHeros(data) {
    var contentGrid = $('#heros-listing');

    contentGrid.empty();
    $.each(data, function (index, hero) {
        var name = hero.superName;
        var row = '';
        if ((index + 1) % 3 === 0)
        {
            row += '<div class="row">';
        }
        if (hero.image === null)
        {
            hero.image = "http://evanweppler.com/wp-content/uploads/2011/10/super.jpg";
        }
        row += '<div class="col-lg-4" id="hero">';
        row += '<img class="img-circle" src="' + hero.image + '"><br><br>';
        row += '<a href="#" onclick="gethero(' + (hero.superHeroId) + ')">' + name + '</a';
        row += name;
        row += '</div>';
        if ((index + 1) % 3 === 0)
        {
            row += '</div>';
        }
        contentGrid.append(row);
    });
}

function gethero(num)
{
    $.ajax({
        type: 'GET',
        url: 'superhero/hero/' + num,
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            hero = data;
            $('#heros-listing').hide();
            $('#heroDiv').show();
            $('#showhero').show();
            $('#showhero').empty();

            if (hero.image === null)
            {
                hero.image = "http://evanweppler.com/wp-content/uploads/2011/10/super.jpg";
            }


            var content = '<div class="row">';
            content += '<div class="col-md-6">';
            content += '<img class="img" src="' + data.image + '">';
            content += '</div>';
            content += '<div class="col-md-6">';
            content += '<h2>' + data.superName + '</h2>';
            content += '<p>' + data.description + '</p><br>';
            content += '<p> Gender: ' + data.gender + '</p>';
            content += '<p> Organizations: ';
            $.each(data.superHeroOrgs, function (index, heroOrg) {
                content += heroOrg.name;
                if (index !== (data.superHeroOrgs.length - 1))
                {
                    content += " , ";
                }
            });
            content += '<p> Powers: ';
            $.each(data.superHeroPowers, function (index, heroPower) {
                content += heroPower.power;
                if (index !== (data.superHeroPowers.length - 1))
                {
                    content += " , ";
                }
            });
            content += '</div></div>';
            $('#showhero').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}