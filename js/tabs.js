// Project Codename: Papertree
// Codding By Anjali Verma
// Version 1.0
// (In Development Phase)



$(function(){
    $('.tab-section').hide();
    $('#tabs a').bind('click', function(e){
        $('#tabs a.current').removeClass('current');
        $('.tab-section:visible').hide();
        $(this.hash).show();
        $(this).addClass('current');
        e.preventDefault();
    }).filter(':first').click();
});
