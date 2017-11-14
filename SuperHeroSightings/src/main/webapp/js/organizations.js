$(document).ready(function () {
    $('#errorMessages').empty();

    retrieveOrganizations();
});

function retrieveOrganizations()
{
    $('#errorMessages').empty();
    var content;
    $.ajax({
        type: 'GET',
        url: 'organizations/all',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, org) {
                content += '<tr>';
                content += '<td>' + org.name + '</td>';
                content += '<td>' + org.description + '</td>';
                content += '<td>' + org.address.street + '<br>'
                        + org.address.city + ', '
                        + org.address.state + '<br>'
                        + org.address.country + ' '
                        + org.address.postalCode + '</td>'
                content += '<td>';
                content += '<button onClick="editOrg( ' + org.orgId + ')">Edit</button>';
                content += '</td>';
                content += '<td>';
                content += '<button onClick="confirmDeleteOrg(' + org.orgId + ')">Delete</button>';
                content += '</td>';
                content += '</tr>';
            });
            $('#orgsTable').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function saveOrg()
{
    var org = JSON.stringify({
        orgId: $('#add-org-id').val(),
        name: $('#add-org').val(),
        description: $('#add-org-description').val(),
        street: $('#add-address-street').val(),
        city: $('#add-address-city').val(),
        state: $('#add-address-state').val(),
        country: $('#add-address-country').val(),
        postalCode: $('#add-address-postal').val()
    });
    $.ajax({
        type: 'PUT',
        url: 'organizations/org',
        data: org,
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

function editOrg(id)
{
    $.ajax({
        type: 'GET',
        url: 'organizations/' + id,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (org) {
            $('#add-org-id').val(org.orgId);
            $('#add-org').val(org.name);
            $('#add-description').val(org.description);
            $('#add-address-street').val(org.address.street);
            $('#add-address-city').val(org.address.city);
            $('#add-address-state').val(org.address.state);
            $('#add-address-country').val(org.address.country);
            $('#add-address-postal').val(org.address.postalCode);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}
var orgForDelete;
function confirmDeleteOrg(orgId)
{
    orgForDelete = orgId;
    $('#confirmOrgDelete').show();
}

function deleteOrg()
{
    $('#confirmOrgDelete').hide();
    $.ajax({
        type: 'DELETE',
        url: 'organizations/' + orgForDelete,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function () {
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

function cancelDelete()
{
    $('#confirmOrgDelete').hide();
}

function cancelSave()
{
    $('#add-org-id').val("");
    $('#add-org').val("");
    $('#add-description').val("");
    $('#add-address-street').val("");
    $('#add-address-city').val("");
    $('#add-address-state').val("");
    $('#add-address-country').val("");
    $('#add-address-postal').val("");
    $('#add-address-latitude').val("");
    $('#add-address-longitude').val("");
}
