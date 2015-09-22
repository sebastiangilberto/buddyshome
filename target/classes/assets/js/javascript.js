<!--Datatable-->

$(document).ready(function() {
    $("table#table_experiencias").dataTable();      
});
  
<!--Logo Header-->

$(document).ready(function() {
	$("#logo-header").hover(function(){
		$(this).effect("bounce", {times:2}, 500 );	
	});  
});
  
<!--Logo Footer-->
  
$(document).ready(function(){
	$('#logo-footer').draggable(); 
});

$(document).ready(function(){
	$('#logo-footer').dblclick(function(){
		$(this).toggle("explode");
   }); 
});