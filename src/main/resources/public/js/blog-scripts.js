//jQuery and attaches event handlers to hide them
$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages li').fadeOut();
    }, 3000);
});