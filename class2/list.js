
$(document).ready(function() {
   dataToView(disks);
 });
 
 function dataToView(disks) {
   $("#container").empty();
   var diskDivs = _.map(disks, function(disk) {
     return diskDiv(disk);
   });
   _.each(diskDivs, function(div) {
     $("#container").append(div);
   });
   //console.log(diskDivs);
 }

function diskDiv(disk) {
     return $("<div>")
    .attr("class", "disk1")
    .append(diskTitle(disk.name))
    .append(diskImg(disk.img))
    .append(diskDesc(disk.desc))
	.append(diskDelete())
	.append(diskEdit(disk));
	//.append(diskSave());
} 
  function diskTitle(title) {
  return $("<h3>").html(title);
}

function diskImg(img) {
  return $("<img>").attr("src", img);
}

function diskDesc(desc) {
  return $("<p>").html(desc);
}

function diskDelete(){
  return $("<button>").html("删除").click(function(){$(this).parent().hide();});
}


function diskEdit(disk){
  return $("<button>").html("编辑").click(function(){
  if ($(this).html() == "编辑")
	 { $(this).html("保存");
	   edit($(this),disk);   //其实可以不用加disk，因为edit里面没用到disk
	 }
  else
	 { $(this).html("编辑");
	  save($(this),disk);	 
	 }
   });
}

function edit(editButton,disk){
	 editToSave(editButton,"1px solid",true,disk);
}

function editToSave(editToSaveButton,boderStyle,flag,disk){
  var  titleOfDisk = editToSaveButton.siblings("h3");
       titleOfDisk.css("border",boderStyle).attr("contenteditable",flag);
  var descOfDisk = editToSaveButton.siblings("p");
      descOfDisk.css("border",boderStyle).attr("contenteditable",flag);
	   return [titleOfDisk,descOfDisk];
}

function save(saveButton,disk){
   var newInfo = editToSave(saveButton,"",false,disk);
   var newTitleOfDisk = newInfo[0];
   var newDescOfDisk = newInfo[1];  
		disk.name = newTitleOfDisk;
		disk.desc = newDescOfDisk;	  
}

function add() {
  var newProduct = {
    name: $("#productName").val(),
    img: $("#productImg").val(),
    desc: $("#productDesc").val()
  };
  disks.push(newProduct);
  dataToView(disks);
   console.log(newProduct);
}

function search(){
	 //console.log("keyup");
	 var keyWord = $("#search").val();
	 var result = _.filter(disks,function(disk){
	  return disk.name.indexOf(keyWord) != -1; 
	 });
	  console.log(result[0]);
	  dataToView(result);
}
