$(document).ready(function () {
    var main = $('#mainInfoDiv');

    showOnlyMain();

    $('#mainButton').click(function () {
        showOnlyMain();
        main.show();
    });

//    $('#akronButton').click(function () {
//        cityShowHide('akron');
//    });
//
//    $('#minneapolisButton').click(function () {
//        cityShowHide('minneapolis');
//    });
//
//    $('#louisvilleButton').click(function () {
//        cityShowHide('louisville');
//    });

    $('#akronButton,#minneapolisButton,#louisvilleButton').click(function () {
        var btnId = (this).id.substr(0, this.id.length -6);
        cityShowHide(btnId);
    });

    $('#akronWeatherButton').click(function(){
        $('#akronWeather').toggle();
    });
    
    $('#minneapolisWeatherButton').click(function() {
       $('#minneapolisWeather').toggle(); 
    });
    
    $('#louisvilleWeatherButton').click(function(){
       $('#louisvilleWeather').toggle();
    });
    
    function showOnlyMain(){
        $('#pageContent').children().not(main).hide();
    }

    function cityShowHide(city) {

        $("#mainInfoDiv").hide();
        $('#pageContent').children().not("#" + city + "InfoDiv").hide();
        $("#" + city + "InfoDiv").show();
        $("#" + city + "Weather").hide();
    }
});