$(document).ready(function () {
    $('#errorMessages').empty();

    fillCarouselItems();
});

function fillCarouselItems()
{
    var content;
    $.ajax({
        type: 'GET',
        url: 'sighting/topten',
        cache: false,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data) {
            $.each(data, function (index, sighting) {

                content += '<div class="item';
                if (index === 0)
                {
                    content += ' active';
                }
                content += '">';
                content += '<img src="' + sighting.image + '">';
                content += '<div class="carousel-caption">';
                content += '<h3>' + sighting.location.name + '</h3>';
                content += '<p> Sighting Date: ' + sighting.dateSighted.dayOfMonth + ' ' + sighting.dateSighted.month + ', ' + sighting.dateSighted.year + '</p>';
                content += '<p> Super Heros spotted: ';
                $.each(sighting.superHero, function (index, hero) {
                    content += hero.superName;
                    if (index !== (sighting.superHero.length - 1))
                    {
                        content += " , ";
                    }
                });
                content += '<br><br></p>';
                content += '</div>';
                content += '</div>';
            });
            $('#carousel-items').append(content);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });

}