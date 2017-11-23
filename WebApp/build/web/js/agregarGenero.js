$(document).ready(function() {
	$('#agregarAlbumBtn').click(function() {
		$.ajax({
			url : 'AgregarGeneroAlAlbum',
			data : {
				mySelect : $('#mySelect').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
			
		});
	});
});