$(document).ready(function() {
	$('#buttonTestAjax').click(function() {
		$.ajax({
			url : 'getAlbumsByGenre',
			data : {
				dropdown1 : $('#dropdown1').val()
                                
			},
			success : function(responseText) {
				$('#generost').text(responseText);
			}
		});
	});
});