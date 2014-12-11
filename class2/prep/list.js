/*$(document).ready(function(){	
	 //console.log(diskDiv(disks[0]));


  var diskDivs = _.map(disks, function(disk) { //function是迭代器吗？
   //console.log(disks);			//map是从后台“假数据”里去数据给一个变量，然后each是读变量显示
	 // console.log(disk);
	  //console.log(diskDivs );
    return diskDiv(disk); //返回值是返回给map，而不是function，参数disk是disks的元素，也就是单个对象
							// diskDiv(disk)是什么意思？调用的下面的函数
  });

  _.each(diskDivs, function(div) {
     //console.log(div);
    $("#container").append(div);
});
}); */

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
 }

function diskDiv(disk) {
     return $("<div>")
    .attr("class", "disk1")
    .append(diskTitle(disk.name))
    .append(diskImg(disk.img))
    .append(diskDesc(disk.desc));
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
 console.log("keyup");
 var keyWord = $("#search").val();
 var result = _.filter(disks,function(disk){
 
  return disk.name.indexOf(keyWord) != -1; 
 });
  console.log(result[0]);
 dataToView(result);
}
// div > 代表儿子辈，且包含儿子兄弟，>p:firstChild代表p父亲辈包含的第一个p？
//console.log(result[0]);  //按退格键为什么会显示小清新光盘
//_.each({one : 1, two : 2, three : 3}, function(num, key){ console.log(num); });