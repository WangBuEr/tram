function confirmWindow(body,title){
	if(title){
		$("#confirmModalTitle").text("");
	}else{
		$("#confirmModalTitle").text("提示");
	}
	$("#confirmModalBody").text(body);
	$("#confirmModal").modal("show");
}