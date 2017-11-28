$(document).ready(function() {
	$('#dropdown1').on( "change", function() {
		$.ajax({
			url : 'getAlbumsByGenre',
			data : {
				dropdown1 : $('#dropdown1').val()
			},
			success : function(responseText) {
                            if(responseText=="")
                                $("#dropdown2").empty()
                            var albums = responseText.match(/\w+/g);
                            var arrayLength = albums.length;
                            $("#dropdown2").empty()
                            var x = document.getElementById("dropdown2"); 
                            var optionToAdd = [];
                            for (var i = 0; i < arrayLength; i++) {
                                optionToAdd[i] = document.createElement("option");
                                optionToAdd[i].text = albums[i];
                                x.add(optionToAdd[i]);
                            }  
                            
			}
		});
	});
});

$(document).ready(function() {
	$('#dropdown1').ready(function() {
		$.ajax({
			url : 'getAlbumsByGenre',
			data : {
				dropdown1 : $('#dropdown1').val()
			},
			success : function(responseText) {
                            if(responseText=="")
                                $("#dropdown2").empty()
                            var albums = responseText.match(/\w+/g);
                            var arrayLength = albums.length;
                            $("#dropdown2").empty()
                            var x = document.getElementById("dropdown2"); 
                            var optionToAdd = [];
                            for (var i = 0; i < arrayLength; i++) {
                                optionToAdd[i] = document.createElement("option");
                                optionToAdd[i].text = albums[i];
                                x.add(optionToAdd[i]);
                            }  
                            
			}
		});
	});
});