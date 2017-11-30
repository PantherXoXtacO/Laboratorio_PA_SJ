$(document).ready(function() {
	$('#cambiar_img').click(function() {
		$.ajax({
			url : 'CambiarImagenAlbum',
			data : {
				pic : $('#pic').text()
			},
			success : function(responseText) {
                            $("#ruta").val(responseText);                          
			}
		});
	});
});